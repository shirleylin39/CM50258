public class SortedLinkedList implements SortedList {
    private Node headNode;
    private Node tailNode;
    private int size;
    private boolean ascendingOrder;

    public SortedLinkedList() {
        this(true);
    }

    public SortedLinkedList(boolean ascendingOrder) {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
        this.ascendingOrder = ascendingOrder;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(String string) {
        if (string == null || string.isEmpty()) {
            return;
        }
        Node currentNode = headNode;

        while (currentNode != null) {
            if (string.compareToIgnoreCase(currentNode.getString()) == 0) {
                return;
            }
            currentNode = currentNode.getNext();
        }

        Node newNode = new Node(string);

        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
        }
        else {
            currentNode = headNode;
            Node prev = null;
            while (currentNode != null &&
                    ((ascendingOrder && string.compareToIgnoreCase(currentNode.getString()) > 0) ||
                            (!ascendingOrder && string.compareToIgnoreCase(currentNode.getString()) < 0))) {
                prev = currentNode;
                currentNode = currentNode.getNext();
            }

            if (prev == null) {
                newNode.setNext(headNode);
                headNode.setPrev(newNode);
                headNode = newNode;
            }
            else if (currentNode == null) {
                prev.setNext(newNode);
                newNode.setPrev(prev);
                tailNode = newNode;
            }
            else {
                prev.setNext(newNode);
                newNode.setPrev(prev);
                newNode.setNext(currentNode);
                currentNode.setPrev(newNode);
            }
        }
        size++;
    }

    @Override
    public void add(Node node) {
        if (node == null || node.getString() == null || node.getString().isEmpty()) {
            return;
        }
        add(node.getString());
    }

    @Override
    public Node getFirst() {
        return headNode;
    }

    @Override
    public Node getLast() {
        return tailNode;
    }

    @Override
    public Node get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node currentNode = headNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    @Override
    public boolean isPresent(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }

        string = string.toLowerCase();

        Node currentNode = headNode;
        while (currentNode != null) {
            if (string.equals(currentNode.getString().toLowerCase())) {
                return true;
            }
            currentNode = currentNode.getNext();
        }

        return false;
    }

    @Override
    public boolean removeFirst() {
        if (headNode == null) {
            return false;
        }

        headNode = headNode.getNext();
        if (headNode != null) {
            headNode.setPrev(null);
        } else {
            tailNode = null;
        }
        size--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if (tailNode == null) {
            return false;
        }

        if (tailNode.getPrev() != null) {
            tailNode.getPrev().setNext(null);
            tailNode = tailNode.getPrev();
        }
        else {
            headNode = null;
            tailNode = null;
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node currentNode = get(index);
            Node prev = currentNode.getPrev();
            Node next = currentNode.getNext();

            prev.setNext(next);
            next.setPrev(prev);

            size--;
            return true;
        }
    }

    @Override
    public boolean remove(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }

        string = string.toLowerCase();

        Node currentNode = headNode;
        while (currentNode != null) {
            if (string.equals(currentNode.getString().toLowerCase())) {
                Node prev = currentNode.getPrev();
                Node next = currentNode.getNext();

                if (prev != null) {
                    prev.setNext(next);
                } else {
                    headNode = next;
                }

                if (next != null) {
                    next.setPrev(prev);
                } else {
                    tailNode = prev;
                }

                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public void orderAscending() {
        if (!ascendingOrder) {
            Node currentNode = headNode;
            while (currentNode != null) {
                Node temp = currentNode.getNext();
                currentNode.setNext(currentNode.getPrev());
                currentNode.setPrev(temp);
                currentNode = currentNode.getPrev();
            }

            Node temp = headNode;
            headNode = tailNode;
            tailNode = temp;
            ascendingOrder = true;
        }
    }

    @Override
    public void orderDescending() {
        if (ascendingOrder) {
            Node currentNode = headNode;
            while (currentNode != null) {
                Node temp = currentNode.getNext();
                currentNode.setNext(currentNode.getPrev());
                currentNode.setPrev(temp);
                currentNode = currentNode.getPrev();
            }

            Node temp = headNode;
            headNode = tailNode;
            tailNode = temp;
            ascendingOrder = false;
        }
    }

    @Override
    public void print() {
        Node currentNode = headNode;
        while (currentNode != null) {
            System.out.println(currentNode.getString());
            currentNode = currentNode.getNext();
        }
    }
}
