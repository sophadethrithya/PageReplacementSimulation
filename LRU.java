package com.company;

import java.util.*;

public class LRU {
    // HashSet to keep track of page frame
    private HashSet<Integer> checkExistingPage;

    // Track the Page Frame that are the least recently use
    private HashMap<Integer,Integer> trackLRU;
    private int[] referenceString;
    private int sizeOfReferenceString;
    private int NumberOfPageFrame;
    private int pageFault;

    //Constructor to initialize LRU
    public LRU(int[] referenceString, int sizeOfReferenceString, int NumberOfPageFrame) {
        this.referenceString = referenceString;
        this.NumberOfPageFrame = NumberOfPageFrame;
        this.sizeOfReferenceString = sizeOfReferenceString;
        this.pageFault = 0 ;
        checkExistingPage = new HashSet<>(NumberOfPageFrame);
        trackLRU = new HashMap<>();
    }
    //Get data from the HashMap for display purposes
    public String getDataFromHashMap(HashMap<Integer, Integer> data)
    {
        HashMap<Integer, Integer> temp = new HashMap<>(data);
        StringBuilder newString = new StringBuilder();
        for (Map.Entry mapElement : temp.entrySet()) {
            Integer key = (Integer)mapElement.getKey();

            newString.append(key + " ");
        }

        return  newString.toString();
    }

    //Main functionality part
    public int findPageFault()
    {
        System.out.println("LRU :");
        // This boolean is for replacement process display purposes
        boolean fault = false;
        boolean hit = false;

        //Loop all the reference strings
        for (int i = 0; i < sizeOfReferenceString; i++) {
            System.out.print("Reference String " + referenceString[i] + ": ");

            // check if the page frame is still not filled up yet
            if(checkExistingPage.size() < NumberOfPageFrame)
            {
                //check if the page frame contain the reference string of index i
                if(!checkExistingPage.contains(referenceString[i])) {
                    //if not contain, add to the hashset and increment page fault
                    checkExistingPage.add(referenceString[i]);
                    pageFault++;
                    fault = true;

                }
                //Page hit
                else {
                    hit = true;

                }
                //Put the reference string to hashmap for tracking the least recently use
                trackLRU.put(referenceString[i],i);
                // From here it is for display purposes
                if(fault == true)
                {
                    fault = false;
                    System.out.print(getDataFromHashMap(trackLRU) + " (Page Fault)");

                }
                if (hit == true)
                {
                    hit = false;
                    System.out.print(getDataFromHashMap(trackLRU) + " (Page hit)");
                }
                System.out.println();

            }
            //If the page frames fill up with reference String
            else
            {
                //check if reference string of index i contain in the page frame or not
                if(!checkExistingPage.contains(referenceString[i]))
                {
                    // Find the leastRecently used in the page frame
                    int leastRecentlyUsed = Integer.MAX_VALUE;
                    int value = Integer.MIN_VALUE;
                    Iterator<Integer> iterator = checkExistingPage.iterator();
                    while (iterator.hasNext())
                    {
                        int temp = iterator.next();
                        if(trackLRU.get(temp) < leastRecentlyUsed)
                        {
                            leastRecentlyUsed = trackLRU.get(temp);
                            value = temp;
                        }
                    }
                    checkExistingPage.remove(value);
                    trackLRU.remove(value);
                    checkExistingPage.add(referenceString[i]);
                    pageFault++;
                    fault = true;
                }
                else
                {
                    hit = true;
                }
                trackLRU.put(referenceString[i],i);
                if(fault == true)
                {
                    fault = false;
                    System.out.print(getDataFromHashMap(trackLRU) + " (Page Fault)");

                }
                if (hit == true)
                {
                    hit = false;
                    System.out.print(getDataFromHashMap(trackLRU) + " (Page hit)");
                }
                System.out.println();
            }
        }
        return pageFault;

    }
}
