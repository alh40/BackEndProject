package com.example.MovieApp;

import com.example.MovieApp.controller.MovieController;
import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Timetable;

import java.io.*;
import java.util.*;

public class BookingMovie {

    public static void writeToFile() {
        try {
            BookingMovie.writeFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Integer> setUniqueId() {
        LinkedHashSet<Integer> uniqueIdSet = new LinkedHashSet<>();
        Random uniqueId = new Random();

        while (uniqueIdSet.size() < 1000) {
            uniqueIdSet.add(uniqueId.nextInt(1000 - 0 + 1));
        }
        ArrayList<Integer> uniqueIdList = new ArrayList<>();
        uniqueIdList.addAll(uniqueIdSet);
        return uniqueIdList;
    }

    public static ArrayList<Integer> uniqueId() {
        ArrayList<Integer> userIdList = setUniqueId();
        return userIdList;
    }

    public static ArrayList<Integer> uniqueIdUser = uniqueId();
    public static List<Timetable> timetable = new ArrayList<>();
    public static List<Movie> movieBooking = new ArrayList<>();
    public static ArrayList<Timetable> newBooking = new ArrayList<>();
    public static List<String> newList = new ArrayList<>();

    public static void writeFile() throws IOException {



        File bookings = new File("/Users/Alex/Documents/MovieBookings.txt");

        bookings.createNewFile();

        BufferedWriter writeBookings = new BufferedWriter(new FileWriter(bookings));


        for(int i = 0; i < newList.size(); i++){
            writeBookings.write(newList.get(i).toString());
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
