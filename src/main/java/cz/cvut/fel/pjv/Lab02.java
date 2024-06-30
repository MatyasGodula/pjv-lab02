/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */

package cz.cvut.fel.pjv;

import java.util.Scanner;
import java.util.ArrayList;

public class Lab02 {
    static int counter = 0;
    static boolean finished_reading = false;

    public void start(String[] args) {
        homework();
    }

    public void homework() {
        TextIO textIO = new TextIO();
        while (true) {
            ArrayList<Double> current_list = read_file(textIO);
            int list_size = current_list.size();
            //System.out.println(current_list);
            if (!finished_reading) {
                double mean = mean(current_list, list_size);
                double standard_deviation = standard_deviation(current_list, list_size, mean);
                System.out.printf("%d %.3f %.3f\n", list_size, mean, standard_deviation);
            } else if (finished_reading && list_size > 1) {
                double mean = mean(current_list, list_size);
                double standard_deviation = standard_deviation(current_list, list_size, mean);
                System.out.printf(" %d %.3f %.3f\n", list_size, mean, standard_deviation);
                break;
            } else { 
                break; 
            }
        }
    }

    public ArrayList<Double> read_file(TextIO textIO) {
        int inner_counter = 0;
        String current_line;
        ArrayList<Double> number_list = new ArrayList<Double>();
        while (inner_counter < 10) {
            current_line = textIO.getLine();
            if (current_line == "") {
                finished_reading = true;
                break;
            }
            counter += 1;
            //System.out.println(current_line);
            if (textIO.isDouble(current_line)) {
                inner_counter += 1;
                double current_number = Double.parseDouble(current_line);
                number_list.add(current_number);
            } else {
                System.out.printf("A number has not been parsed from line %d\n", counter);
            }
        }
        return number_list;
    }

    public double mean(ArrayList<Double> list, int list_size) {
        double sum = 0.0;
        for (double num : list) {
            sum += num;
        }
        return sum / list_size;
    }

    public double standard_deviation(ArrayList<Double> list, int list_size, double mean) {
        double sum_of_deviations_squares = 0.0;
        for (double num : list) {
            sum_of_deviations_squares += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sum_of_deviations_squares / list_size);
    }
}
