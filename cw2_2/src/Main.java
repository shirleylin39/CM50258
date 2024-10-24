public class Main {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();

        // Add nodes in random order
        list.add(new Node("Charlie"));
        list.add(new Node("Alpha"));
        list.add(new Node("Bravo"));
        list.print();

        // Get nodes
        Node nFirst = list.getFirst();
        Node nLast = list.getLast();
        Node nMiddle = list.get(1);

        // Check if the nodes are in the correct order
        if (nFirst.getString().equals("Alpha") && nMiddle.getString().equals("Bravo") && nLast.getString().equals("Charlie")) {
            System.out.println("Well done! Nodes are in the correct order.");
        } else {
            System.out.println("Adding a node has not been successful.");
        }

        // Print the list
        System.out.println("List contains " + list.size() + " items:");
        list.print();


        // Add elements in random order
        list.add("Banana");
        list.add("Apple");
        list.add("Grapes");
        list.add("Kiwi");
        list.add("Orange");
        list.add("Mango");
        list.add("pear");
        list.add("watermelon");
        list.add("Cherry");
        list.add("Blueberry");
        list.add("Avocado");

        System.out.println("Original List:");
        list.print();

        System.out.println("\nSize of the list: " + list.size());

        // Check if a string is present
        System.out.println("\nIs 'Banana' present? " + list.isPresent("Banana")); // Should be true
        System.out.println("Is 'Cherry' present? " + list.isPresent("Cherry")); // Should be true
        System.out.println("Is 'Grapes' present? " + list.isPresent("Grapes")); // Should be true
        System.out.println("Is 'Pear' present? " + list.isPresent("Pear")); // Should be false
        System.out.println("Is 'Watermelon' present? " + list.isPresent("Watermelon")); // Should be true

        // Remove elements by string
        System.out.println("\nRemoving 'Cherry': " + list.remove("Cherry")); // Should be true
        System.out.println("Removing 'Pear': " + list.remove("Pear")); // Should be false

        // Print the list after removal by string
        System.out.println("\nList after removals:");
        list.print();
        System.out.println("\nSize of the list: " + list.size());

        // Order in descending order
        list.orderDescending();
        System.out.println("\nSize of the list: " + list.size());

        // Print the list in descending order
        System.out.println("\nList in descending order:");
        list.print();
        System.out.println("\nSize of the list: " + list.size());

        // Order in ascending order again
        list.orderAscending();
        System.out.println("\nSize of the list: " + list.size());

        // Print the list in ascending order
        System.out.println("\nList in ascending order after ordering again:");
        list.print();

        // Test remove by string
        System.out.println("\nRemoving 'Grapes': " + list.remove("Grapes")); // Should be true
        System.out.println("Removing 'Pear': " + list.remove("Pear")); // Should be false

        // Print the list after removal by string
        System.out.println("\nList after removals:");
        list.print();
        System.out.println("\nSize of the list: " + list.size());

        // Add similar words
        list.add("Grape");
        list.add("Appl");
        list.add("ManGo");
        list.add("WATERMELON");
        list.add("cheRRy");

        // Print the list after adding similar words
        System.out.println("\nList after adding similar words:");
        list.print();

        // Order in descending order
        list.orderDescending();
        System.out.println("\nSize of the list: " + list.size());

        // Print the list in descending order
        System.out.println("\nList in descending order:");
        list.print();

        // Order in ascending order again
        list.orderAscending();
        System.out.println("\nSize of the list: " + list.size());

        // Print the list in ascending order again
        System.out.println("\nList in ascending order after ordering again:");
        list.print();

        System.out.println("\nTrying to get nodes out of range after modification:");
        Node nodeOutOfRange3 = list.get(-1);
        Node nodeOutOfRange4 = list.get(list.size());
        System.out.println("Node at index -1: " + (nodeOutOfRange3 == null ? "null" : nodeOutOfRange3.getString()));
        System.out.println("Node at index " + list.size() + ": " + (nodeOutOfRange4 == null ? "null" : nodeOutOfRange4.getString()));

        // Test get methods
        System.out.println("\nElement at index 1: " + (list.get(1) == null ? "null" : list.get(1).getString())); // Should be 'Grapes'
        System.out.println("First element: " + (list.getFirst() == null ? "null" : list.getFirst().getString())); // Should be 'mango'
        System.out.println("Last element: " + (list.getLast() == null ? "null" : list.getLast().getString())); // Should be 'banana'
        System.out.println("\nSize of the list: " + list.size());

        // Order in descending order again
        list.orderDescending();
        System.out.println("\nSize of the list: " + list.size());

        // Print the list in descending order again
        System.out.println("\nList in descending order after ordering again:");
        list.print();



        // Test remove at specific index
        list.remove(2); // Remove element at index 2
        System.out.println("\nList after removing element at index 2:");
        list.print();
        System.out.println("\nSize of the list: " + list.size());

        System.out.println("Is null present? " + list.isPresent(null)); // Should be false

        // Print the final size of the list
        System.out.println("\nSize of the list: " + list.size());

        System.out.println("\nAdding similar spelling words:");
        list.add("apple");
        list.add("Apples");
        list.add("APPLES");

        // Print the list after adding similar spelling words
        System.out.println("\nList after adding similar spelling words:");
        list.print();

        // Check size
        System.out.println("\nSize of the list: " + list.size());

        //Order in ascending order
        list.orderAscending();
        System.out.println("\nSize of the list: " + list.size());

        // Print the list in ascending order
       System.out.println("\nList in ascending order:");
       list.print();

        // Remove elements
        list.removeFirst();
        System.out.println("\nRemove First:" );
        list.print();

        list.removeLast();
        System.out.println("\nRemove Last:" );
        list.print();

        list.remove("Kiwi");
        System.out.println("\nRemove Kiwi" );
        list.print();

        // Print the list after removal
        System.out.println("\nList after removals:");
        list.print();
        System.out.println("\nSize of the list: " + list.size());

        // Order in descending order
        list.orderDescending();
        System.out.println("\nSize of the list: " + list.size());



        // Print the list in descending order
        System.out.println("\nList in descending order:");
        list.print();
        System.out.println("\nSize of the list: " + list.size());

        // Order in ascending order again
        list.orderAscending();
        System.out.println("\nSize of the list: " + list.size());

        // Print the list in ascending order again
        System.out.println("\nList in ascending order after ordering again:");
        list.print();

        // Test remove at specific index
        list.remove(2); // Remove element at index 2
        System.out.println("\nList after removing element at index 2:");
        list.print();
        System.out.println("\nSize of the list: " + list.size());

        System.out.println("Is null present? " + list.isPresent(null)); // Should be false

        // Print the final size of the list
        System.out.println("\nSize of the list: " + list.size());
    }
}

