package edu.orangecoastcollege.sbadajoz.ic23;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
Badajoz, Seve
CS A170
November 23, 2016

IC23
*/
public class HabermansSurvival {
    public static void main(String[] args) {
        int nodes, maxS = Integer.MIN_VALUE, minNS = Integer.MAX_VALUE, countS = 0, countNS = 0;
        double avgS, avgNS, sumS = 0.0, sumNS = 0.0;
        DecimalFormat twoDP = new DecimalFormat("0.##");

        try
        {
            Scanner file = new Scanner(new File("Haberman.csv"));
            while(file.hasNextLine()) {
                String line = file.nextLine();
                String[] parts = line.split(",");
                nodes = Integer.valueOf(parts[2]);
                if(parts[3].equals("1")) {
                    countS++;
                    sumS += nodes;
                    if (maxS < nodes) maxS = nodes;
                }
                else {
                    countNS++;
                    sumNS += nodes;
                    if (minNS > nodes) minNS = nodes;
                }
            }
            avgS = sumS / countS;
            avgNS = sumNS / countNS;
            System.out.print("The surviving patient with the most nodes had " + maxS + " detected nodes" +
                    "\nThe non-surviving patient with the least nodes had " + minNS + " detected nodes" +
                    "\nThe average amount of nodes for a surviving patient was: " + twoDP.format(avgS )+ " nodes" +
                    "\nThe average amount of nodes for a deceased patient was: " + twoDP.format(avgNS)+ " nodes");
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
