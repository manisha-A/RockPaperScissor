package com;

public class PrintUtilities {
    /**
     * Utility method to print horizontal line on command line
     *
     * @param number
     * @throws NegativeArraySizeException
     */
    public void printHorizontal(int number) throws NegativeArraySizeException {
        int[] array = new int[number];

        for (int i = 0; i < array.length; i++) {
            System.out.print("-");
        }
    }
}
