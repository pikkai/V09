/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package v09;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 ** V09 - Array Manipulations.
 *
 * @author LinhTTMCE181161
 */
public class ArrayManipulations {

    private ArrayList<Integer> elementList; // List to store the elements
    Scanner sc = new Scanner(System.in); // Scanner for user input
    private int count = 0; // Counter for the number of elements

    /**
     * Constructor initializes the elementList
     */
    public ArrayManipulations() {
        this.elementList = new ArrayList<>();
    }

    /**
     * Method to validate and return a user input integer element
     *
     * @param erroPromt The prompt message to display in case of error
     * @return The validated input integer element
     */
    public int checkElement(String erroPromt) {
        int number;
        while (true) {
            try {
                String input = sc.nextLine().trim();// Read and trim the input
                if (input.isEmpty()) {// Check if the input is empty
                    System.out.println("Please enter a non-empty value.");
                    System.out.print(erroPromt);
                    continue;
                }
                number = Integer.parseInt(input);// Parse the input to an integer              
                break;// Exit the loop if the input is valid
            } catch (NumberFormatException e) {
                System.out.println("The number entered must be an integer!");// Display error message if input is not an integer
                System.out.print(erroPromt);

            }
        }
        return number;// Return the valid input
    }

    /**
     * Method to validate input within a specified range
     *
     * @param min The minimum acceptable value
     * @param max The maximum acceptable value
     * @param erroPromt The prompt message to display in case of error
     * @param promt The initial prompt message
     * @return The validated input integer within the specified range
     */
    public int checkInput(int min, int max, String erroPromt, String promt) {
        int number;
        System.out.print(promt);
        while (true) {
            try {
                String input = sc.nextLine().trim();// Read and trim the input
                if (input.isEmpty()) {// Check if the input is empty
                    System.out.println("Please enter a non-empty value.");
                    System.out.print(erroPromt);
                    continue;
                }
                number = Integer.parseInt(input);// Parse the input to an integer
                if (number < min || number > max) {// Validate the input range
                    System.out.println("Please enter a number greater than or equal " + min + " and less than or equal " + max + "!");
                    System.out.print(erroPromt);
                    continue;
                }
                break;// Exit the loop if the input is valid
            } catch (NumberFormatException e) {
                System.out.println("The number entered must be an integer!");// Display error message if input is not an integer
                System.out.print(erroPromt);
            }
        }
        return number;// Return the valid input
    }

    /**
     * Method to input the elements of the array
     */
    public void input() {

        int n = this.checkInput(1, 100, "Please re-enter size of array: ", "Please enter size of array: ");
        for (int i = 0; i < n; i++) {
            int element;
            element = this.checkElement("Element[ " + i + " ]  =  ");
            elementList.add(element);
            count++;
        }
        System.out.print("Add elements section successfully!");
    }

    /**
     * Method to search for an element in the array
     */
    public void searchElement() {
        int elementSearch;
        int countSearch = 0;
        boolean result;
        System.out.print("Enter the value to find: ");
        elementSearch = this.checkElement("Please re-enter the value to find: ");
        for (int element : elementList) {
            if (elementSearch == element) {
                countSearch++;
            }
        }
        if (countSearch > 0) {
            System.out.println(elementSearch + " Appears in the array and appears " + countSearch + " times.");
        } else {
            System.out.println("Value not found in array!");
        }

    }

    /**
     * Method to delete the first occurrence of an element in the array
     */
    public void deleteFirts() {
        ArrayList<Integer> deleteFirtsList = new ArrayList<>();
        int elementDelete;
        boolean ok = true;
        boolean have = false;
        System.out.print("Enter the value to be deleted as its first existence in the array: ");
        elementDelete = this.checkElement("Please re-enter the value: ");

        for (int element : elementList) {
            if (elementDelete == element && ok == true) {
                have = true;
                ok = false;

            } else {
                deleteFirtsList.add(element);
            }
        }
        if (have == true) {
            System.out.println("The first existence of " + elementDelete + " has been successfully deleted!");
        } else {
            System.out.println("Element " + elementDelete + " does not exist in the saved array!");
        }
        this.elementList.clear();
        for (int element : deleteFirtsList) {
            this.elementList.add(element);
        }
    }

    /**
     * Method to delete all occurrences of an element in the array
     */
    public void deleteAll() {
        ArrayList<Integer> deleteAllList = new ArrayList<>();
        boolean have = true;
        int elementDeleteAll;
        System.out.print("Enter the value to delete all existence in the array: ");
        elementDeleteAll = this.checkElement("Please re-enter the value: ");
        for (int element : elementList) {
            if (elementDeleteAll == element) {
            } else {
                deleteAllList.add(element);
            }
        }
        if (have == true) {
            System.out.println("successfully removed all elements with value " + elementDeleteAll + " from the array!");
        } else {
            System.out.println("Element " + elementDeleteAll + " does not exist in the saved array!");
        }

        this.elementList.clear();
        for (int element : deleteAllList) {
            this.elementList.add(element);
        }
    }

    /**
     * Method to print the array after manipulations
     */
    public void printArrayAfter() {
        System.out.print("\nTarray includes elements: ");
        for (int element : this.elementList) {
            System.out.print(element + "  ");
        }
        System.out.println();
    }

    /**
     * Method to sort the array in ascending order using bubble sort
     */
    public void bubbleSortAscending() {
        ArrayList<Integer> listSortAscending = new ArrayList<>();
        for (int element : elementList) {
            listSortAscending.add(element);
        }
        int n = listSortAscending.size(); // Get the size of the list
        for (int i = 0; i < listSortAscending.size() - 1; i++) {// Outer loop for each pass through the list
            for (int j = 0; j < n - i - 1; j++) {// Inner loop for comparing adjacent elements
                if (listSortAscending.get(j) > listSortAscending.get(j + 1)) { // If the current element is greater than the next element
                    int temp = listSortAscending.get(j);    // Swap elementList[j] and elementList[j + 1]
                    listSortAscending.set(j, listSortAscending.get(j + 1)); // Set the current position to the next element
                    listSortAscending.set(j + 1, temp); // Set the next position to the temporarily stored element

                }
            }
        }
        for (int i = 0; i < listSortAscending.size() - 1; i++) {
            System.out.print(" [" + listSortAscending.get(i) + "] " + "->");
        }
        System.out.println(" [" + listSortAscending.get(listSortAscending.size() - 1) + "] ");
    }

    /**
     * Method to sort the array in descending order using bubble sort
     */
    public void bubbleSortDescending() {
        ArrayList<Integer> listSortDescending = new ArrayList<>();
        for (int element : elementList) {
            listSortDescending.add(element);
        }
        int n = listSortDescending.size(); // Get the size of the list
        for (int i = 0; i < listSortDescending.size() - 1; i++) {// Outer loop for each pass through the list
            for (int j = 0; j < n - i - 1; j++) {// Inner loop for comparing adjacent elements
                if (listSortDescending.get(j) < listSortDescending.get(j + 1)) { // If the current element is less  than the next element
                    int temp = listSortDescending.get(j);    // Swap elementList[j] and elementList[j + 1]
                    listSortDescending.set(j, listSortDescending.get(j + 1)); // Set the current position to the next element
                    listSortDescending.set(j + 1, temp); // Set the next position to the temporarily stored element
                }
            }
        }
        for (int i = 0; i < listSortDescending.size() - 1; i++) {
            System.out.print(" [" + listSortDescending.get(i) + "] " + "->");
        }
        System.out.println(" [" + listSortDescending.get(listSortDescending.size() - 1) + "] ");
    }

    /**
     * Method to ask the user if they want to run the program Method to ask the
     * user if they want to run the program again
     */
    public void reselect() {
        String newString;
        Scanner sc = new Scanner(System.in);
        boolean result;
        do {
            System.out.print("\nDo you want to continue the program? (choose 'y' or 'n'): ");
            newString = sc.nextLine();
            if (newString.matches("[yY]")) {
                this.elementList.clear();// Clear the lists               
                this.input();
                result = true;
            } else if (newString.matches("[nN]")) {
                this.input();
                result = true;
            } else {
                System.out.println("Please enter either 'y' or 'n'.");
                result = false;
            }
        } while (!result); // Loop until a valid response is given
    }

    /**
     * Method to display the input, original, and modified lists
     */
    public void display() {
        int choice;
        boolean result;
        boolean ok = false;
        boolean reset = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n========= Array Manipulations =========");
            System.out.println("1- Add a value.\n"
                    + "2- Search a value.\n"
                    + "3- Remove the first existence of a value.\n"
                    + "4- Remove all existences of a value.\n"
                    + "5- Print out the array.\n"
                    + "6- Sort the array in ascending order.\n"
                    + "7- Sort the array in descending orde.\n"
                    + "8- Quit.");
            choice = this.checkInput(1, 8, "Please re-enter your choice: ", "Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println("\n--- Feature 1 ---");
                    if (reset == true) {
                        this.input();// Input information
                        reset = false;
                    } else if (reset == false) {
                        this.reselect();
                    }
                    ok = true;
                    result = false;
                    break;
                case 2:
                    System.out.println("\n--- Feature 2 ---");

                    if (ok == true) {
                        this.searchElement();
                    } else {
                        System.out.println("You must enter array to sort!\n"
                                + "Please select 1 to enter array to sort!");
                    }
                    result = false;
                    break;
                case 3:
                    System.out.println("\n--- Feature 3 ---");
                    if (ok == true) {
                        this.deleteFirts();
                    } else {
                        System.out.println("You must enter array to sort!\n"
                                + "Please select 1 to enter array to sort!");
                    }
                    result = false;
                    break;
                case 4:
                    System.out.println("\n--- Feature 4 ---");
                    if (ok == true) {
                        this.deleteAll();
                    } else {
                        System.out.println("You must enter array to sort!\n"
                                + "Please select 1 to enter array to sort!");
                    }
                    result = false;
                    break;
                case 5:
                    System.out.println("\n--- Feature 5 ---");

                    if (ok == true) {
                        this.printArrayAfter();
                    } else {
                        System.out.println("You must enter array to sort!\n"
                                + "Please select 1 to enter array to sort!");
                    }
                    result = false;
                    break;
                case 6:
                    System.out.println("\n--- Feature 6 ---");
                    if (ok == true) {
                        this.bubbleSortAscending();
                    } else {
                        System.out.println("You must enter array to sort!\n"
                                + "Please select 1 to enter array to sort!");
                    }
                    result = false;
                    break;
                case 7:
                    System.out.println("\n--- Feature 7 ---");
                    if (ok == true) {
                        this.bubbleSortDescending();
                    } else {
                        System.out.println("You must enter array to sort!\n"
                                + "Please select 1 to enter array to sort!");
                    }
                    result = false;
                    break;
                case 8:
                    System.out.println("Exit program!");
                    result = true;
                    break;
                default:
                    System.out.println("The input value must be an integer and have a value between 1 and 8!");
                    result = false;
                    break;
            }
        } while (!result);// Loop until the user chooses to exit
    }

}
