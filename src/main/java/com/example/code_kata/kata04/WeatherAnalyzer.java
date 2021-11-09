package com.example.code_kata.kata04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;

public class WeatherAnalyzer {

    URL weatherResource = getClass().getClassLoader().getResource("kata04/weather.dat");

    public BufferedReader getBufferedReader(URL resource) throws FileNotFoundException, URISyntaxException {
        File weatherFile = new File(resource.toURI());
        return new BufferedReader(new FileReader(weatherFile));
    }

    public int getMaxTempDifferenceDay(){
        int maxDifferenceDay = -1;
        int maxDifference = -1;
        try(BufferedReader br = getBufferedReader(weatherResource)) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] lineData = line.trim().split("\\s+");

                if (lineData.length == 0 || lineData[0].isEmpty()) {
                    continue;
                }

                try {
                    int day = Integer.parseInt(lineData[0]);
                    int max = Integer.parseInt(lineData[1]);
                    int min = Integer.parseInt(lineData[2]);
                    int difference = max - min;

                    if (difference > maxDifference) {
                        maxDifferenceDay = day;
                        maxDifference = difference;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("No integer");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return maxDifferenceDay;
    }
}
