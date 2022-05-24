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

    public static void readFile() throws FileNotFoundException {


        File bookings = new File("/Users/Alex/Documents/MovieBookings.txt");

        Scanner scanner = new Scanner(bookings);

        while(scanner.hasNextLine()){

            System.out.println(scanner.nextLine());
        }
    }

}
