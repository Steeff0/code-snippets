package com.example.adventofcode;

import com.example.utilities.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Day04 {

    private URL inputFile = getClass().getClassLoader().getResource("adventofcode/day04-input.dat");

    public int getWinningBingoScore() {
        try(BufferedReader br = FileReader.getBufferedReader(inputFile)) {

            // Get rolled numbers
            String numbersLine = br.readLine();
            int[] rollingNumbers = getRollingNumbers(numbersLine);

            // Create boards
            List<BingoBoard> boards = getBoards(br);

            for (int rollingNumber: rollingNumbers) {
                for (BingoBoard board: boards) {
                    board.activateNumber(rollingNumber);
                    if (board.isWinner()){
                        return board.getValueOtherNumbers() * rollingNumber;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getUltimateLooserScore() {

        try(BufferedReader br = FileReader.getBufferedReader(inputFile)) {

            // Get rolled numbers
            String numbersLine = br.readLine();
            int[] rollingNumbers = getRollingNumbers(numbersLine);

            // Create boards
            List<BingoBoard> boards = getBoards(br);

            //Logic...
            int valueOtherNumbersLooserBoard;
            List<BingoBoard> winningBoards = new ArrayList<>();
            for (int rollingNumber: rollingNumbers) {
                for (BingoBoard board: boards) {
                    board.activateNumber(rollingNumber);
                    if (board.isWinner() && !winningBoards.contains(board)){
                        winningBoards.add(board);

                        if (winningBoards.size() == boards.size()) {
                            return board.getValueOtherNumbers() * rollingNumber;
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private int[] getRollingNumbers(String numbersLine) {
        // Get rolled numbers
        String[] allNumbers = numbersLine.trim().split("," );
        int[] rollingNumbers = new int[allNumbers.length];

        for (int i = 0; i < allNumbers.length; i++) {
            rollingNumbers[i] = Integer.parseInt(allNumbers[i]);
        }
        return rollingNumbers;
    }

    private List<BingoBoard> getBoards(BufferedReader br) throws IOException {
        List<BingoBoard> boards = new ArrayList<>();
        BingoBoard boardCreation = new BingoBoard();
        int row = 0;
        for (String line; (line = br.readLine()) != null; ) {
            if(line.isEmpty()){
                if(row != 0) {
                    boards.add(boardCreation);
                }
                boardCreation = new BingoBoard();
                row = 0;
                continue;
            }

            String[] boardRowString = line.trim().split("\\s+" );
            int[] boardRowInt = new int[boardRowString.length];
            for (int i = 0; i < boardRowString.length; i++){
                boardRowInt[i] = Integer.parseInt(boardRowString[i]);
            }

            boardCreation.addNumberRow(row, boardRowInt);
            row++;
        }
        return boards;
    }

    class BingoBoard {
        private BingoNumber[][] bingoNumbers = new BingoNumber[5][5];

        public void addNumberRow(int row, int[] numbers) {
            for(int i = 0; i < numbers.length; i++){
                bingoNumbers[row][i] = new BingoNumber(numbers[i]);
            }
        }

        public void activateNumber(int rollingNumber){
            for(int x = 0; x < 5; x++){
                for(int y = 0; y < 5; y++) {
                    if(bingoNumbers[x][y].getNumber() == rollingNumber) {
                        bingoNumbers[x][y].setTaken();
                    }
                }
            }
        }

        public boolean isWinner() {
            for(int i = 0; i < 5; i++){
                if(isColumnWinner(i) || isRowWinner(i)){
                    return true;
                }
            }
            return false;
        }

        private boolean isColumnWinner(int index) {
            for(int i = 0; i < 5; i++) {
                if(!bingoNumbers[i][index].isTaken()){
                    return false;
                }
            }
            return true;
        }

        private boolean isRowWinner(int index) {
            for(int i = 0; i < 5; i++) {
                if(!bingoNumbers[index][i].isTaken()){
                    return false;
                }
            }
            return true;
        }

        public int getValueOtherNumbers() {
            int value = 0;
            for(int x = 0; x < 5; x++){
                for(int y = 0; y < 5; y++) {
                    if(!bingoNumbers[x][y].isTaken()) {
                        value += bingoNumbers[x][y].getNumber();
                    }
                }
            }
            return value;
        }
    }

    class BingoNumber{
        int number;
        boolean taken = false;

        public BingoNumber(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setTaken() {
            this.taken = true;
        }

        public boolean isTaken() {
            return taken;
        }
    }
}
