import java.util.ArrayList;
import java.util.List;

public class SortingTester {
    public static void main(String[] args) {
        // Create an instance of CustomSort
        SortingInterface customSort = new CustomSort();

        // Test Case 1: Empty list
        customSort.setValues(new ArrayList<>());
        System.out.println("Sorted List with an empty list:");
        printSortedValues((CustomSort) customSort);

        // Test Case 2: List with one element
        customSort.setValues(new ArrayList<>(List.of(5.0)));
        System.out.println("\nSorted List with one element:");
        printSortedValues((CustomSort) customSort);

        // Test Case 3: List with repeated elements
        customSort.setValues(new ArrayList<>(List.of(3.0, 2.5, 3.0, 1.0, 2.5, 3.0)));
        System.out.println("\nSorted List with repeated elements:");
        printSortedValues((CustomSort) customSort);

        // Test Case 4: List with negative values
        customSort.setValues(new ArrayList<>(List.of(-5.0, -2.5, -8.0, -1.0, -3.5)));
        System.out.println("\nSorted List with negative values:");
        printSortedValues((CustomSort) customSort);

        // Test Case 5: List with large values
        customSort.setValues(new ArrayList<>(List.of(1000000.0, 999999.9, 100000.5, 1000000000.0, 99999.0)));
        System.out.println("\nSorted List with large values:");
        printSortedValues((CustomSort) customSort);

        // Test Case 6: Add a value and sort
        customSort.add(-4.0);
        System.out.println("\nSorted List after adding a value:");
        printSortedValues((CustomSort) customSort);

        // Test Case 7: Remove a value and sort
        customSort.remove(2); // Remove the value at index 2
        System.out.println("\nSorted List after removing a value:");
        printSortedValues((CustomSort) customSort);

        // Test Case 8: Set values to null
        customSort.setValues(null);
        System.out.println("\nSorted List with null values:");
        printSortedValues((CustomSort) customSort);

        // Test Case 9: List with duplicate values
        customSort.setValues(new ArrayList<>(List.of(3.0, 2.5, 3.0, 1.0, 2.5, 3.0, 1.0, 2.5)));
        System.out.println("\nSorted List with duplicate values:");
        printSortedValues((CustomSort) customSort);

        // Test Case 10: Random values
        customSort.setValues(new ArrayList<>(List.of(5.0, 3.5, 8.0, 2.0, 7.5, 1.5, 4.0, 6.5, 9.0, 0.5)));
        System.out.println("\nSorted List with random values:");
        printSortedValues((CustomSort) customSort);
    }

    private static void printSortedValues(CustomSort sorter) {
        // Use the getter method to access the values
        List<Double> sortedValues = sorter.getValues();
        System.out.println("Sorted Values: " + sortedValues);
    }
}

