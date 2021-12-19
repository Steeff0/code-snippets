package com.example.adventofcode;

import com.example.utilities.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;

public class Day05 {

    private URL inputFile = getClass().getClassLoader().getResource("adventofcode/day05-input.dat");

    public int getGetAmountOfUnsafeStraitLocations() {
        try(BufferedReader br = FileReader.getBufferedReader(inputFile)) {
            List<Vector> vectors = new ArrayList();
            int highestX = 0, highestY = 0;
            for (String line; (line = br.readLine()) != null; ) {
                Vector vector = new Vector(line);

                if (highestX < vector.getHighestX()) {
                    highestX = vector.getHighestX();
                }

                if (highestY < vector.getHighestY()) {
                    highestY = vector.getHighestY();
                }

                vectors.add(vector);
            }

            vectors.removeAll(getDiagonalVectors(vectors));
            Playboard playboard = new Playboard(highestX, highestY);
            for (Vector vector: vectors) {
                playboard.applyVector(vector);
            }

            Coordinate playboardSize = playboard.getSize();
            int numbersAboveTwo = 0;
            for (int x = 0; x < playboardSize.getX(); x++) {
                for (int y = 0; y < playboardSize.getY(); y++){
                    if (playboard.getNumberAtCoordinate(new Coordinate(x, y)) >= 2) {
                        numbersAboveTwo++;
                    }
                }
            }

            return numbersAboveTwo;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getGetAmountOfUnsafeLocations() {
        try(BufferedReader br = FileReader.getBufferedReader(inputFile)) {
            List<Vector> vectors = new ArrayList();
            int highestX = 0, highestY = 0;
            for (String line; (line = br.readLine()) != null; ) {
                Vector vector = new Vector(line);

                if (highestX < vector.getHighestX()) {
                    highestX = vector.getHighestX();
                }

                if (highestY < vector.getHighestY()) {
                    highestY = vector.getHighestY();
                }

                vectors.add(vector);
            }

            Playboard playboard = new Playboard(highestX, highestY);
            for (Vector vector: vectors) {
                playboard.applyVector(vector);
            }

            Coordinate playboardSize = playboard.getSize();
            int numbersAboveTwo = 0;
            for (int x = 0; x < playboardSize.getX(); x++) {
                for (int y = 0; y < playboardSize.getY(); y++){
                    if (playboard.getNumberAtCoordinate(new Coordinate(x, y)) >= 2) {
                        numbersAboveTwo++;
                    }
                }
            }

            return numbersAboveTwo;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private List<Vector> getDiagonalVectors(List<Vector> vectors) {
        List<Vector> diagonalVectors = new ArrayList<>();
        for (Vector vector: vectors) {
            if(vector.isDiagonal()) {
                diagonalVectors.add(vector);
            }
        }
        return diagonalVectors;
    }

    class Playboard{
        int[][] playboard;

        public Playboard(int highestX, int highestY) {
            playboard = new int[highestX][highestY];
        }

        public void applyVector(Vector vector){
            Coordinate startCoordinate = vector.startCoordinate;
            Coordinate endCoordinate = vector.endCoordinate;

            if (startCoordinate.getX() == endCoordinate.getX()){
                for (int y = 0; y <= vector.getYLength(); y++) {
                    int yCoordinate = startCoordinate.getY() + (y * vector.getYDirection());
                    playboard[startCoordinate.getX() - 1][yCoordinate - 1]++;
                }
            } else if (startCoordinate.getY() == endCoordinate.getY()){
                for (int x = 0; x <= vector.getXLength(); x++) {
                    int xCoordinate = startCoordinate.getX() + (x * vector.getXDirection());
                    playboard[xCoordinate - 1][startCoordinate.getY() - 1]++;
                }
            } else {
                for (int x = 0, y = 0; x <= vector.getXLength() && y <= vector.getYLength(); x = ++y) {
                    int xCoordinate = startCoordinate.getX() + (x * vector.getXDirection());
                    int yCoordinate = startCoordinate.getY() + (y * vector.getYDirection());
                    playboard[xCoordinate - 1][yCoordinate - 1]++;
                }
            }
        }

        public Coordinate getSize() {
            return new Coordinate(playboard.length, playboard[0].length);
        }

        public int getNumberAtCoordinate(Coordinate coordinate){
            return playboard[coordinate.getX()][coordinate.getY()];
        }
    }

    class Vector {

        private Coordinate startCoordinate;
        private Coordinate endCoordinate;

        public Vector (String vectorString) {
            String[] coordinates = vectorString.trim().split("\\s+->\\s+" );
            startCoordinate = new Coordinate(coordinates[0]);
            endCoordinate = new Coordinate(coordinates[1]);
        }

        public boolean isDiagonal() {
            return startCoordinate.getX() != endCoordinate.getX()
                && startCoordinate.getY() != endCoordinate.getY();
        }

        public int getHighestX() {
            return Math.max(startCoordinate.getX(), endCoordinate.getX());
        }

        public int getHighestY() {
            return Math.max(startCoordinate.getY(), endCoordinate.getY());
        }

        public int getXDirection(){
            int difference = (endCoordinate.getX() - startCoordinate.getX());
            if (difference == 0){
                return 1;
            }
            return difference / getXLength();
        }

        public int getYDirection(){
            int difference = (endCoordinate.getY() - startCoordinate.getY());
            if (difference == 0) {
                return 1;
            }
            return difference / getYLength();
        }

        public int getXLength(){
            return Math.abs(endCoordinate.getX() - startCoordinate.getX());
        }

        public int getYLength(){
            return Math.abs(endCoordinate.getY() - startCoordinate.getY());
        }
    }

    class Coordinate {

        private int[] coordinate = new int[2];

        public Coordinate(String coordinateString) {
            String[] locations = coordinateString.trim().split("," );
            coordinate = new int[]{Integer.parseInt(locations[0]), Integer.parseInt(locations[1])};
        }

        public Coordinate(int x, int y) {
            coordinate[0] = x;
            coordinate[1] = y;
        }

        public int getX(){
            return coordinate[0];
        }

        public int getY(){
            return coordinate[1];
        }
    }

}
