package com.example.adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;

public class Day01 {

    public int getAmountIncreaseGrouped() {
        int a = 0, b = 0, c = 0, amountIncrease = 0, index = 0, previous = 0;

        try(BufferedReader br = getBufferedReader(numbersfile)) {
            for (String line; (line = br.readLine()) != null; ) {
                index++;
                int current = Integer.parseInt(line.trim());
                a += current;
                if (index > 1) {
                    b += current;
                }
                if (index > 2) {
                    c += current;
                }

                if (index % 3 == 0) {
                    if (a > previous && previous != 0 ) {
                        amountIncrease++;
                    }
                    previous = a;
                    a = 0;
                }

                if (index > 3 && (index - 1) % 3 == 0) {
                    if (b > previous && previous != 0) {
                        amountIncrease++;
                    }
                    previous = b;
                    b = 0;
                }

                if (index > 3 && (index - 2) % 3 == 0) {
                    if (c > previous && previous != 0) {
                        amountIncrease++;
                    }
                    previous = c;
                    c = 0;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return amountIncrease;
    }

    public int getAmountIncrease() {
        int current = 0, previous = 0, amountIncrease = 0;

        try(BufferedReader br = getBufferedReader(numbersfile)) {
            for (String line; (line = br.readLine()) != null; ) {
                previous = current;
                current = Integer.parseInt(line.trim());
                if (current > previous && previous != 0) {
                    amountIncrease++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return amountIncrease;
    }

    private URL numbersfile = getClass().getClassLoader().getResource("adventofcode/day01-numbers.dat");

    private BufferedReader getBufferedReader(URL resource) throws FileNotFoundException, URISyntaxException {
        File weatherFile = new File(resource.toURI());
        return new BufferedReader(new FileReader(weatherFile));
    }
}
