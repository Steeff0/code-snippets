package com.example.adventofcode;

import com.example.utilities.FileReader;

import java.io.BufferedReader;
import java.net.URL;

public class Day02 {

    private URL inputFile = getClass().getClassLoader().getResource("adventofcode/day02-input.dat");

    public int getSubmarineLocation() {
        int[] location = new int[2];
        try(BufferedReader br = FileReader.getBufferedReader(inputFile)) {
            for (String line; (line = br.readLine()) != null; ) {
                String [] movement = line.trim().split(" ");
                int distance = Integer.parseInt(movement[1].trim());
                switch (movement[0]) {
                    case "forward":
                        location[0] += distance;
                        break;
                    case "up":
                        location[1] -= distance;
                        break;
                    case "down":
                        location[1] += distance;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return location[0] * location[1];
    }

    public int getSubmarineLocationWithAim() {
        int[] location = new int[2];
        int aim = 0;
        try(BufferedReader br = FileReader.getBufferedReader(inputFile)) {
            for (String line; (line = br.readLine()) != null; ) {
                String [] movement = line.trim().split(" ");
                int distance = Integer.parseInt(movement[1].trim());
                switch (movement[0]) {
                    case "forward":
                        location[0] += distance;
                        location[1] += (aim * distance);
                        break;
                    case "up":
                        aim -= distance;
                        break;
                    case "down":
                        aim += distance;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return location[0] * location[1];
    }
}
