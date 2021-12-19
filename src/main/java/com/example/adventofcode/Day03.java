package com.example.adventofcode;

import com.example.utilities.FileReader;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Day03 {

    private URL inputFile = getClass().getClassLoader().getResource("adventofcode/day03-input.dat");

    public int getSubmarinePowerUsage() {
        StringBuilder gamma = new StringBuilder(), epsilon = new StringBuilder();
        int[][] bitcount = new int[12][2];
        try(BufferedReader br = FileReader.getBufferedReader(inputFile)) {
            for (String line; (line = br.readLine()) != null; ) {
                String[] bits = line.trim().split("(?!^)" );
                int index = 0;
                for (String bit: bits) {
                   int i = Integer.parseInt(bit.trim());
                   if (i == 0){
                       bitcount[index][0]++;
                   } else {
                       bitcount[index][1]++;
                   }
                   index++;
                }
            }

            for (int[] bits: bitcount) {
                if(bits[0] > bits[1]) {
                    gamma.append(0);
                    epsilon.append(1);
                } else {
                    gamma.append(1);
                    epsilon.append(0);

                }
            }

            return Integer.parseInt(gamma.toString(),2) * Integer.parseInt(epsilon.toString(), 2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getSubmarineOxygen() {
        List bits = new ArrayList();
        try(BufferedReader br = FileReader.getBufferedReader(inputFile)) {
            for (String line; (line = br.readLine()) != null; ) {
                bits.add(line.trim());
            }
            int oxygenGenerator = calculateOxygenNumber(List.copyOf(bits), 1, true);
            int CO2Scrubber = calculateOxygenNumber(List.copyOf(bits), 0, false);
            return oxygenGenerator * CO2Scrubber;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    private int calculateOxygenNumber(List<String> bits, int favorite, boolean highestWins) {
        int bitsLength = bits.get(0).length();
        for (int i = 0; i < bitsLength; i++) {
            int highest = getHighestBitOnIndex(bits, i);
            if(!highestWins){
                highest = (highest + 1) % 2;
            }
            highest = (highest != -1)? highest : favorite;
            bits = removeIncorrectFromIndex(bits, i, highest);
            if(bits.size() == 1){
                return Integer.parseInt(bits.get(0),2);
            }
        }
        return -1;
    }

    private int getHighestBitOnIndex(List<String> bits, int index) {
        int[] bitAmount = new int[2];
        for (String code: bits) {
            String[] allBits = code.trim().split("(?!^)" );
            if(Integer.parseInt(allBits[index]) == 1){
                bitAmount[1]++;
            }else{
                bitAmount[0]++;
            }
        }
        if(bitAmount[0] > bitAmount[1]){
            return 0;
        } else if(bitAmount[1] > bitAmount[0]){
            return 1;
        }
        return -1;
    }

    private List<String> removeIncorrectFromIndex(List<String> bits, int index, int keepBit) {
        List<String> ret = new ArrayList<>(bits);
        for (String bit: bits) {
            String[] allBits = bit.trim().split("(?!^)" );
            if(Integer.parseInt(allBits[index]) != keepBit){
                ret.remove(bit);
            }
        }
        return ret;
    }
}
