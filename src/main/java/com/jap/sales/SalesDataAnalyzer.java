package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SalesDataAnalyzer {
    // This method reads a file and adds each line of the file into the corresponding SalesRecord object
    public SalesRecord[] readFile(String fileName) {
        int countLines = 0;
        SalesRecord[] salesRecords = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while((line = bufferedReader.readLine() )!= null){
                countLines++;
            }
            salesRecords = new SalesRecord[countLines];
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String [] split= line.split(",");
                String date = split[0];
                int costomerId = Integer.parseInt(split[1]);
                int productCatagory = Integer.parseInt(split[2]);
                String paymentMethod = split[3];
                double amount =Double.parseDouble(split[4]);
                double timeOnSite = Double.parseDouble(split[5]);
                int clicksOnSite = Integer.parseInt(split[6]);
                salesRecords[index] = new SalesRecord(date, costomerId, productCatagory, paymentMethod, amount, timeOnSite, clicksOnSite);
                index++;
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return salesRecords;
    }



}
