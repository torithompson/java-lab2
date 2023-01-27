package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(new File("res/grades.csv"));
            String headerLine = fileScanner.nextLine();
            headerLine = headerLine.replaceAll("\"", "");// replace quotes with empty string
            String[] headers = headerLine.split(",");// split the line into an array of strings
            FileWriter fileWriter = new FileWriter("res/grades.html");
            StringBuilder builder = new StringBuilder();
            builder.append("<table style='border-collapse: collapse;'>").append("\n");
            builder.append("<tr >");
            for (int i = 0; i < headers.length; i++) {
                builder.append("<th style ='border:1px solid black;'>").append(headers[i]).append("</th>");
            }
            builder.append("</tr>").append("\n");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                line = line.replaceAll("\"", "");
                String[] data = line.split(",");
                builder.append("<tr>");
                if (data.length == headers.length) {
                    for (int i = 0; i < data.length; i++) {
                        builder.append("<td style ='border:1px solid black;'>").append(data[i]).append("</td>");
                    }
                    builder.append("</tr>").append("\n");
                }
            }
            builder.append("</table>");
            fileWriter.write(builder.toString());
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
