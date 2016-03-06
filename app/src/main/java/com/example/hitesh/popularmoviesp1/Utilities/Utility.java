package com.example.hitesh.popularmoviesp1.Utilities;

/**
 * Created by hitesh on 05-03-2016.
 */
public class Utility {

    public static String buildImageUrl(int width, String fileName) {
        return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
    }
}
