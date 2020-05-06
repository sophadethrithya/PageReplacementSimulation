package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class fifo {
    //To check the existing page frame
    private HashSet<Integer> checkExistingPage;

    //Queue for storing the page frame
    private Queue<Integer> pageInFifo ;

    //page fault counter
    private int pageFault;
    private int sizeOfReferenceString;
    private int NumberOfPageFrame;
    private int[] referenceString;



    // For display purpose : output all reference strings exist in the page frame for every page replacement process
    public String getDataFromQueue(Queue<Integer> data)
    {
        Queue<Integer> temp = new LinkedList<>(data);
        StringBuilder newString = new StringBuilder();
        for (Integer a : temp)
        {
            newString.append(a + " ");
        }
        return  newString.toString();
    }

    //Contructor to initialize the algorithm
    public fifo(int[] referenceString, int sizeOfReferenceString, int NumberOfPageFrame) {
        this.referenceString = referenceString;
        this.NumberOfPageFrame = NumberOfPageFrame;
        this.sizeOfReferenceString = sizeOfReferenceString;
        this.pageFault = 0 ;
        checkExistingPage = new HashSet<>(NumberOfPageFrame);
        pageInFifo = new LinkedList<>();

    }

    //The main functionality part
    public int findPageFault()
    {

        System.out.println("FIFO :");

        //Loop the whole reference string
        for(int i = 0 ; i < sizeOfReferenceString; i++)
        {
            System.out.print("Reference String " + referenceString[i] + ": ");
            //check if the existing page filled up with reference string yet
            if (checkExistingPage.size() < NumberOfPageFrame)
            {
                //check if the current reference string of index i exist in the current page frame or not
                if (!checkExistingPage.contains(referenceString[i]))
                {
                    //if not add to the HashSet ; increment the page fault counter and add to the queue
                    checkExistingPage.add(referenceString[i]);
                    pageFault++;
                    pageInFifo.add(referenceString[i]);
                    System.out.print(getDataFromQueue(pageInFifo) + " (Page Fault)");
                }
                //Page hit
                else
                    System.out.print(getDataFromQueue(pageInFifo)+ " (page hit)");
                System.out.println();
            }
            //enter this 'else' if the page frame are filled up with reference string
            else
            {
                //check if the page frame contain the reference string of index i or not
                if(!checkExistingPage.contains(referenceString[i]))
                {
                    // if not remove the first number of the queue and replace with the new reference string of index i
                    // and increment the page fault ; add new RS to the queue and hashset
                    int temp = pageInFifo.poll();
                    checkExistingPage.remove(temp);
                    checkExistingPage.add(referenceString[i]);
                    pageInFifo.add(referenceString[i]);
                    pageFault++;
                    System.out.print(getDataFromQueue(pageInFifo) + " (Page Fault)");
                }
                //Page hit
                else
                    System.out.print(getDataFromQueue(pageInFifo) + " (page hit)");
                System.out.println();
            }
        }
        return getPageFault();
    }

    public HashSet<Integer> getCheckExistingPage() {
        return checkExistingPage;
    }

    public void setCheckExistingPage(HashSet<Integer> checkExistingPage) {
        this.checkExistingPage = checkExistingPage;
    }

    public Queue<Integer> getPageInFifo() {
        return pageInFifo;
    }

    public void setPageInFifo(Queue<Integer> pageInFifo) {
        this.pageInFifo = pageInFifo;
    }
    public int getPageFault() {
        return pageFault;
    }

    public void setPageFault(int pageFault) {
        this.pageFault = pageFault;
    }
}
