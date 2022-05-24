package com.example.MovieApp;

import com.example.MovieApp.controller.MovieController;
import com.example.MovieApp.model.Movie;

import java.io.*;
import java.util.Scanner;

public class BookingMovie {

    public static void writeFile() throws IOException {



        File bookings = new File("/Users/Alex/Documents/MovieBookings.txt");

        bookings.createNewFile();

        BufferedWriter writeBookings = new BufferedWriter(new FileWriter(bookings));


        for(int i = 0; i < MovieController.newList.size(); i++){
            writeBookings.write(MovieController.newList.get(i).toString());
            writeBookings.newLine();
            writeBookings.newLine();
        }


        writeBookings.close();
    }

    public static void deleteLineBasedOnId() throws FileNotFoundException{

    }

    public static void readFile() throws IOException {


        File bookingsInput = new File("/Users/Alex/Documents/MovieBookings.txt");
        File bookingsOutput = new File("/Users/Alex/Documents/DeletingBookings.txt");

        BufferedReader inputReader = new BufferedReader(new FileReader(bookingsInput));
        BufferedWriter inputWriter = new BufferedWriter(new FileWriter(bookingsOutput));

        String removeBooking = "";
        String currentLine;

        while((currentLine = inputReader.readLine()) != null){
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(removeBooking)) continue;
            inputWriter.write(currentLine + System.getProperty("line.seperator"));
            }
        inputWriter.close();
        inputReader.close();
        boolean succesful = bookingsOutput.renameTo(bookingsInput);
        }

}
