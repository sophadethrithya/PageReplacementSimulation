package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int NumberOfPageFrame;


    public static void main(String[] args) throws FileNotFoundException {

        // These are the directory to the file that are needed to be test for part 1b
        final String testCase1 = "/Users/sophadethrithya/Documents/Operating System/PageReplacement/ReferenceString1.txt";
        final String testCase2 = "/Users/sophadethrithya/Documents/Operating System/PageReplacement/ReferenceString2.txt";
        final String testCase3 = "/Users/sophadethrithya/Documents/Operating System/PageReplacement/ReferenceString3.txt";
        final String testCase4 = "/Users/sophadethrithya/Documents/Operating System/PageReplacement/ReferenceString4.txt";


        //Part 1b
        fifo algo1a = new fifo(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 1: ");
        System.out.println("FIFO Page Fault: " + algo1a.findPageFault());
        System.out.println();
        fifo algo1b = new fifo(parseFile(testCase2) ,30,NumberOfPageFrame);
        System.out.println("Test case 2: ");
        System.out.println("FIFO Page Fault: " + algo1b.findPageFault());
        System.out.println();
        fifo algo1c = new fifo(parseFile(testCase3) ,30,NumberOfPageFrame);
        System.out.println("Test case 3: ");
        System.out.println("FIFO Page Fault: " + algo1c.findPageFault());
        System.out.println();
        fifo algo1d = new fifo(parseFile(testCase4) ,30,NumberOfPageFrame);
        System.out.println("Test case 4: ");
        System.out.println("FIFO Page Fault: " + algo1d.findPageFault());
        System.out.println();

        LRU algo2a = new LRU(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 1: ");
        System.out.println("LRU Page Fault: " + algo2a.findPageFault());
        System.out.println();
        LRU algo2b = new LRU(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 2: ");
        System.out.println("LRU Page Fault: " + algo2b.findPageFault());
        System.out.println();
        LRU algo2c = new LRU(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 3: ");
        System.out.println("LRU Page Fault: " + algo2c.findPageFault());
        System.out.println();
        LRU algo2d = new LRU(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 4: ");
        System.out.println("LRU Page Fault: " + algo2d.findPageFault());
        System.out.println();

        OptimalAlgorithm algo3a = new OptimalAlgorithm(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 1: ");
        System.out.println("Optimal Algorithm Page Fault: " + algo3a.findPageFault());
        OptimalAlgorithm algo3b = new OptimalAlgorithm(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 2: ");
        System.out.println("Optimal Algorithm Page Fault: " + algo3b.findPageFault());
        OptimalAlgorithm algo3c = new OptimalAlgorithm(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 3: ");
        System.out.println("Optimal Algorithm Page Fault: " + algo3c.findPageFault());
        OptimalAlgorithm algo3d = new OptimalAlgorithm(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 4: ");
        System.out.println("Optimal Algorithm Page Fault: " + algo3d.findPageFault());
        System.out.println();






        //Part 2d
        //Algorithm 1 : FIFO
        fifo algo1 = new fifo(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 1: ");
        System.out.println("FIFO Page Fault: " + algo1.findPageFault());
        System.out.println();

        //Algorithm 2 : LRU

        LRU algo2 = new LRU(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 1: ");
        System.out.println("LRU Page Fault: " + algo2.findPageFault());
        System.out.println();

        //Algorithm 3 : Optimal Algorithm

        OptimalAlgorithm algo3 = new OptimalAlgorithm(parseFile(testCase1) ,30,NumberOfPageFrame);
        System.out.println("Test case 1: ");
        System.out.println("Optimal Algorithm Page Fault: " + algo3.findPageFault());
        System.out.println();


        // PART 3
        //Generating random input

        ArrayList<int[]> dataset1ForFrameSizeOf3 = new ArrayList<>();
        ArrayList<int[]> dataset2ForFrameSizeOf4 = new ArrayList<>();
        ArrayList<int[]> dataset3ForFrameSizeOf5 = new ArrayList<>();
        ArrayList<int[]> dataset4ForFrameSizeOf6 = new ArrayList<>();
        int[] temp = new int[30];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 30; j++) {
                temp[j] = new Random().nextInt(10);
            }
            dataset1ForFrameSizeOf3.add(temp);
        }
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 30; j++) {
                temp[j] = new Random().nextInt(10);
            }
            dataset2ForFrameSizeOf4.add(temp);
        }
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 30; j++) {
                temp[j] = new Random().nextInt(10);
            }
            dataset3ForFrameSizeOf5.add(temp);
        }
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 30; j++) {
                temp[j] = new Random().nextInt(10);
            }
            dataset4ForFrameSizeOf6.add(temp);
        }

        // 3 Page Frame
        System.out.println("3 Page Frame: \n");
        int totalResultFIFO3PageFrame =0;
        int totalResultLRU3PageFrame = 0;
        int totalResultOptimal3PageFrame = 0;
        for (int i = 0; i < 50; i++) {
            fifo FIFO3PageFrame = new fifo(dataset1ForFrameSizeOf3.get(i),30,3);
            totalResultFIFO3PageFrame += FIFO3PageFrame.findPageFault();

            LRU lru3PageFrame = new LRU(dataset1ForFrameSizeOf3.get(i),30,3);
            totalResultLRU3PageFrame += lru3PageFrame.findPageFault();

            OptimalAlgorithm optimalAlgorithm3PageFrame = new OptimalAlgorithm(dataset1ForFrameSizeOf3.get(i),30,3);
            totalResultOptimal3PageFrame += optimalAlgorithm3PageFrame.findPageFault();


        }
        double averageFIFO3PageFrame = totalResultFIFO3PageFrame/50.0;
        double averageLRU3PageFrame = totalResultLRU3PageFrame/50.0;
        double averageOptimal3PageFrame = totalResultOptimal3PageFrame/ 50.0;

        System.out.println("Average Time for FIFO 3 Page Frame : " + averageFIFO3PageFrame);
        System.out.println("Average Time for LRU 3 Page Frame : " + averageLRU3PageFrame);
        System.out.println("Average Time for Optimal Algorithm 3 Page Frame : " + averageOptimal3PageFrame);

        //4 Page Frame
        System.out.println("4 Page Frame: \n");
        int totalResultFIFO4PageFrame =0;
        int totalResultLRU4PageFrame = 0;
        int totalResultOptimal4PageFrame = 0;
        for (int i = 0; i < 50; i++) {
            fifo FIFO4PageFrame = new fifo(dataset2ForFrameSizeOf4.get(i),30,4);
            totalResultFIFO4PageFrame += FIFO4PageFrame.findPageFault();

            LRU lru4PageFrame = new LRU(dataset2ForFrameSizeOf4.get(i),30,4);
            totalResultLRU4PageFrame += lru4PageFrame.findPageFault();

            OptimalAlgorithm optimalAlgorithm4PageFrame = new OptimalAlgorithm(dataset2ForFrameSizeOf4.get(i),30,4);
            totalResultOptimal4PageFrame += optimalAlgorithm4PageFrame.findPageFault();


        }
        double averageFIFO4PageFrame = totalResultFIFO4PageFrame/50.0;
        double averageLRU4PageFrame = totalResultLRU4PageFrame/50.0;
        double averageOptimal4PageFrame = totalResultOptimal4PageFrame/ 50.0;

        System.out.println("Average Time for FIFO 4 Page Frame : " + averageFIFO4PageFrame);
        System.out.println("Average Time for LRU 4 Page Frame : " + averageLRU4PageFrame);
        System.out.println("Average Time for Optimal Algorithm 4 Page Frame : " + averageOptimal4PageFrame);

        //5 Page Frame
        System.out.println("5 Page Frame: \n");
        int totalResultFIFO5PageFrame =0;
        int totalResultLRU5PageFrame = 0;
        int totalResultOptimal5PageFrame = 0;
        for (int i = 0; i < 50; i++) {
            fifo FIFO5PageFrame = new fifo(dataset3ForFrameSizeOf5.get(i),30,5);
            totalResultFIFO5PageFrame += FIFO5PageFrame.findPageFault();

            LRU lru5PageFrame = new LRU(dataset3ForFrameSizeOf5.get(i),30,5);
            totalResultLRU5PageFrame += lru5PageFrame.findPageFault();

            OptimalAlgorithm optimalAlgorithm5PageFrame = new OptimalAlgorithm(dataset3ForFrameSizeOf5.get(i),30,5);
            totalResultOptimal5PageFrame += optimalAlgorithm5PageFrame.findPageFault();


        }
        double averageFIFO5PageFrame = totalResultFIFO5PageFrame/50.0;
        double averageLRU5PageFrame = totalResultLRU5PageFrame/50.0;
        double averageOptimal5PageFrame = totalResultOptimal5PageFrame/ 50.0;

        System.out.println("Average Time for FIFO 5 Page Frame : " + averageFIFO5PageFrame);
        System.out.println("Average Time for LRU 5 Page Frame : " + averageLRU5PageFrame);
        System.out.println("Average Time for Optimal Algorithm 5 Page Frame : " + averageOptimal5PageFrame);

        //6 Page Frame
        System.out.println("6 Page Frame: \n");
        int totalResultFIFO6PageFrame =0;
        int totalResultLRU6PageFrame = 0;
        int totalResultOptimal6PageFrame = 0;
        for (int i = 0; i < 50; i++) {
            fifo FIFO6PageFrame = new fifo(dataset4ForFrameSizeOf6.get(i),30,6);
            totalResultFIFO6PageFrame += FIFO6PageFrame.findPageFault();

            LRU lru6PageFrame = new LRU(dataset4ForFrameSizeOf6.get(i),30,6);
            totalResultLRU6PageFrame += lru6PageFrame.findPageFault();

            OptimalAlgorithm optimalAlgorithm6PageFrame = new OptimalAlgorithm(dataset4ForFrameSizeOf6.get(i),30,6);
            totalResultOptimal6PageFrame += optimalAlgorithm6PageFrame.findPageFault();


        }
        double averageFIFO6PageFrame = totalResultFIFO6PageFrame/50.0;
        double averageLRU6PageFrame = totalResultLRU6PageFrame/50.0;
        double averageOptimal6PageFrame = totalResultOptimal6PageFrame/ 50.0;

        System.out.println("Average Time for FIFO 6 Page Frame : " + averageFIFO6PageFrame);
        System.out.println("Average Time for LRU 6 Page Frame : " + averageLRU6PageFrame);
        System.out.println("Average Time for Optimal Algorithm 6 Page Frame : " + averageOptimal6PageFrame);

    }

    //This is used to parse the file of specific format as stated in the homework assignment
    public static int[] parseFile(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        Scanner filedata = new Scanner(file);
        filedata.nextLine();
        NumberOfPageFrame = Integer.parseInt(filedata.nextLine());
        filedata.nextLine();
        String referenceString  = filedata.nextLine().replaceAll("\\s","");
        int[] temp = new int[30];
        int i = 0 ;
        for (char a : referenceString.toCharArray())
        {
            temp[i] = Character.getNumericValue(a);
            i++;
        }
        return temp;
    }
}
