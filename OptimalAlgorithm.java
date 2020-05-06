package com.company;

public class OptimalAlgorithm {
    private int[] referenceString;
    private int NumberOfPageFrame =0;
    private int sizeOfReferenceString;
    private int pageFault ;
    private int[] pageFrame;
    //To keep track of how many page frame have filled up
    private int frameCount =0;

    //Constructor for Optimal Algorithm
    public OptimalAlgorithm(int[] referenceString, int sizeOfReferenceString, int NumberOfPageFrame) {
        this.referenceString = referenceString;
        this.sizeOfReferenceString = sizeOfReferenceString;
        this.NumberOfPageFrame = NumberOfPageFrame;
        this.pageFault = 0;
        this.pageFrame = new int[NumberOfPageFrame];
    }

    //Get data fro display purposes
    public String getDataFromFrame(int[] data, int count)
    {
        int[] temp = data.clone();
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i <count  ; i++) {
            newString.append(temp[i] + " ");
        }
        return  newString.toString();
    }

    // search the page frame to see if the reference string of index i  contain in the page frame or not
    public boolean searchExistingPage(int num){
        for(int i = 0; i< frameCount; i++){
            if(pageFrame[i] ==num){
                return true;
            }
        }
        return false;
    }

    //Do the prediction to find the reference string that will not be occurred in the future
    public int checkLeftOverReferenceString(int oneReferenceString, int position){
        int result= referenceString.length+1;
        for(int i = position+1; i< referenceString.length; i++){
            int temp= referenceString[i];
            if(temp== oneReferenceString){
                if(i<result){
                    result=i;
                }
            }
        }
        return result;

    }

    public int findPageFault(){

        System.out.println("Optimal Algorithm :");
        //Loop all the reference string
        for(int i = 0; i < referenceString.length; i++){
            System.out.print("Reference String " + referenceString[i] + ": ");
            //Do the searching  if exist in the page frame it is a hit
            if(searchExistingPage(referenceString[i])){
                System.out.print(getDataFromFrame(pageFrame, frameCount) + " (Page hit)");
                System.out.println();
                continue;

            }
            //if does not exist
            else{
                // page fault increment
                pageFault++;

                // if page frame has not filled up yet
                if(frameCount < NumberOfPageFrame){
                    //assign the pageFrame and increment frameCount to ensure how many frame has been filled
                    pageFrame[frameCount] = referenceString[i];
                    frameCount++;
                    System.out.print(getDataFromFrame(pageFrame, frameCount) + " (Page Fault)");
                }
                //if the page frame has filled up
                else{
                    //Do the prediction process

                    int optimal[]=new int[NumberOfPageFrame];

                    for(int j = 0; j< NumberOfPageFrame; j++){
                        optimal[j]=checkLeftOverReferenceString(pageFrame[j],i);
                    }
                    // to find the page to be replaced
                    int index=0;
                    int max=optimal[0];
                    for(int j = 1; j< NumberOfPageFrame; j++){
                        if(optimal[j]>max){
                            max=optimal[j];
                            index=j;
                        }
                    }

                    System.out.print(getDataFromFrame(pageFrame, frameCount) +  " (Page Fault)");
                    // replace reference string of index i with the page frame that will not be likely to occurred in the future
                    pageFrame[index]= referenceString[i];

                }
                System.out.println();
            }
        }
        System.out.println();
        return pageFault;
    }

}
