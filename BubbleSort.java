import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* This program uses a bubble sort.
*
* @author  Alexander Matheson
* @version 1.0
* @since   2023-04-24
*/

public final class BubbleSort {
    /**
    * For style checker.
    *
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private BubbleSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // Declare list and variable.
        final ArrayList<String> inputList = new ArrayList<String>();
        String sortStr = "";
        final String sp = " ";

        try {
            // Choose a file to get input from.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // Choose (or create) a file to print output to.
            final FileWriter output = new FileWriter("output.txt");

            // Loop to read each line of input file.
            while (scanInput.hasNextLine()) {
                // Add the next line.
                inputList.add(scanInput.nextLine());
            }

            // Create an array with all elements in the input list.
            final String[] inputArr = new String[inputList.size()];
            for (int location = 0; location < inputArr.length; location++) {
                inputArr[location] = inputList.get(location);
            }

            // Loop to send each array to function.
            for (int counter = 0; counter < inputArr.length; counter++) {
                try {
                    // Convert inputArr to int.
                    final int size = inputArr[counter].split(sp).length;
                    final int[] arrInt = new int[size];
                    for (int location = 0; location < size; location++) {
                        arrInt[location] = Integer.parseInt(
                            inputArr[counter].split(sp)[location]);
                    }

                    // Call function.
                    final int[] sorted = sort(arrInt, arrInt.length);
                    sortStr = sortStr + Arrays.toString(sorted) + "\n";
                } catch (NumberFormatException err) {
                    sortStr = sortStr + "Line cannot be converted to int.\n";
                }
            }

            // Write to output file.
            output.write(sortStr);
            System.out.println(sortStr);

            // Close writer.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function uses a recursive bubble sort.
    *
    * @param listOfNum from file
    * @param length of array
    * @return sorted array
    */
    public static int[] sort(int[] listOfNum, int length) {
        // Base case: end of array.
        if (length == 1) {
            return listOfNum;
        }

        // One pass through.
        for (int element = 0; element < length - 1; element++) {
            // Check two adjacent elements.
            if (listOfNum[element] > listOfNum[element + 1]) {
                final int temp = listOfNum[element];
                listOfNum[element] = listOfNum[element + 1];
                listOfNum[element + 1] = temp;
            }
        }

        return sort(listOfNum, length - 1);
    }
}
