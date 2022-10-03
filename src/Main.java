/*

   Part 1. Create bubble sort algorithm (4 pts.)

   Keep your program decomposed. Implement methods for such tasks:
       Array output +
       Creation of an array of given length with random values +
       Creation of an array of given length with values from user input +
       Bubble sort method +
   Create main method with such flow:
       Ask user to input number of elements. +
       Ask if user wants to generate values or input by himself/herself. +
       Create an array in a chosen way. +
       Output given array. +
       Sort the array. +
       Output sorted array. +
       Ask if user wants to repeat (from #1). +



    */

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random rn = new Random();
    private static final Scanner sc = new Scanner(System.in);

    //Array output
    public static void printArray(int[] arr) {
        for (int item : arr)
            System.out.print(String.format("%4d", item) + " ");
        System.out.println();
    }

    //  Creation of an array of given length with random values
    public static int[] generateArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++)
            result[i] = (rn.nextInt(100) - 50);
        return result;
    }

    //Creation of an array of given length with values from user input
    public static int[] generateUserArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print(i + 1 + ". Enter value: ");
            result[i] = Integer.parseInt(sc.nextLine());
        }
        return result;
    }

    //Bubble sort method
    public static void bubbleSort(int[] arr) {
        int temp;
        //First optimization
        //arr.length - 1 -> At first iteration we're pushing the biggest element to the end,
        //So we don't need to check it again

        for (int i = 0; i < arr.length - 1; i++) {
            //Second optimization is in this boolean isSwapped,
            //If we didn't change anything, that means that array is already sorted, so we are breaking our loop
            boolean isSwapped = false;
            for (int x = 0; x < arr.length - 1; x++) {
                if (arr[x] > arr[x + 1]) {
                    //Swapping
                    temp = arr[x];
                    arr[x] = arr[x + 1];
                    arr[x + 1] = temp;

                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
    }

    public static int[] userChoiceArrayGenerator(int length, String output) {

        System.out.print(output);
        if (sc.nextLine().equalsIgnoreCase("y"))
            return generateArray(length);
        else
            return generateUserArray(length);

    }

    public static boolean getUserBool(String output) {
        System.out.print(output);
        return sc.nextLine().equalsIgnoreCase("y");
    }

    public static void main(String[] args) {

        do {
            //Ask user to input number of elements.
            System.out.print(">Enter array length: ");
            int length = Integer.parseInt(sc.nextLine());
            int[] array;

            //Ask if user wants to generate values or input by himself/herself.
            array = userChoiceArrayGenerator(length, "Do you want to generate array? (Y/N): ");

            //Output given array
            printArray(array);

            //Sort the array.
            bubbleSort(array);

            //Output sorted array.
            printArray(array);

            //Ask if user wants to repeat (from #1).
        } while (getUserBool("Do you want to continue? (Y/N): "));
    }
}