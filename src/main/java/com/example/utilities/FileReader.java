package com.example.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

public class FileReader {

    public static BufferedReader getBufferedReader(URL resource) throws FileNotFoundException, URISyntaxException {
        File weatherFile = new File(resource.toURI());
        return new BufferedReader(new java.io.FileReader(weatherFile));
    }
}
