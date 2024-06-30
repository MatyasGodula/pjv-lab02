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
            System.out.println(current_list);
            if (!finished_reading) {
                // calculate and print but dont break
            } else if (finished_reading && list_size > 1) {
                // calculate and print then break
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
}
