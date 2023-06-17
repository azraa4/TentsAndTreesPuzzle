package src;
/**
 *This class implements a LinkedList.
 * @param <T> the type of data stored in the LinkedList
 * @author Azra Acil
 * @version 17.0
 * @since 2023-04-13
 */

public class LinkedList <T> {

    /**
     * @param head the first Node's address
     */
    protected Node <T> head;

    /**
     * @param tail the last Node's address
     */
    protected Node <T> tail;

    /**
     * This constructs a Node with a specified
     * data and next.
     *
     * Constructs an empty linked list.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Creates a new Node with the given data and null next reference.
     *
     * @param data the data to be stored in the Node
     *
     * @return a new Node object
     */
    private Node<T> createNode(T data){
        return new Node<>( data, null);
    }

    /**
     * Determines the LinkedList is empty or not.
     *
     * @return if the LinkedList is empty,turns true
     * if false, turns otherwise
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * Returns the first Node in the LinkedList.
     *
     * @return head
     */
    public Node getHead(){
        return head;
    }

    /**
     * Inserts a new node into the first of the linked list
     *
     * @param newNode the node to be added to the LinkedList
     */
    public void insertFirst(T newNode) {
        Node<T> newNode1 = createNode(newNode);

        if (head == null){
            head = newNode1;
        }else {
            newNode1.setNext(head);
            head = newNode1;
        }
    }

    /**
     * Inserts a new node into the middle of the linked list.
     *
     * @param newNode the new node to be inserted
     * @param previous the node after which the new node will be inserted
     */
    public void insertMiddle(T newNode, T previous){
        Node<T> newNode1 = createNode(newNode);
        Node<T> previous1 = createNode(previous);
        newNode1.setNext(previous1.next);
        previous1.setNext(newNode1);
    }

    /**
     * Inserts a new node at the end of the linked list.
     *
     * @param newNode the new node to be inserted
     */
    public void insertLast(T newNode) {
        Node<T> newNode1 = createNode(newNode);

        if (tail == null){
            tail = newNode1;
        }else {
            tail.setNext(newNode1);
            tail = newNode1;
        }
    }


    /**
     * Returns the node in the linked list that comes before the given node.
     *
     * @param node the node to get the previous node of.
     *
     * @return the node that comes before the given node or null if not found.
     */
    public Node<T> getPrevious(T node){
        Node<T> newNode1 = createNode(node);
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null){
            if(current == newNode1){
                return previous;
            }else {
                previous = current;
                current = current.getNext();
            }
        }
        return null;
    }

    /**
     * Removes the first node from the LinkedList.
     */
    public void removeFirst() {
        head = head.getNext();
        if(head == null){
            tail = null;
        }
    }

    /**
     * Removes the given node from the linked list.
     *
     * @param deletedNode the node to be removed
     */
    public void removeMiddle(T deletedNode) {
        Node<T> deletedNode1 = createNode(deletedNode);
        Node<T> previous;
        previous = getPrevious(deletedNode);
        previous.setNext(deletedNode1.getNext());
    }

    /**
     * Removes the last node from the linked list.
     */
    public void removeLast(){
        tail = getPrevious((T) tail);
        if(tail != null){
            tail.setNext(null);
        }else{
            head = null;
        }
    }

    /**
     * Searches the LinkedList for the specified value.
     *
     * @param value the value to search for in the LinkedList
     *
     * @return null if the value is not found
     */
    public Node<T> search(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(value)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }


    /**
     * Returns the Node which is specified index in the LinkedList.
     *
     * @param i the index of the Node
     *
     * @return the Node at the specified index, or null if the index is not suitable
     */
    public Node<T> getNodeI(int i) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (index == i) {
                return current;
            }
            index++;
            current = current.getNext();
        }
        return null;
    }

    /**
     * Returns the number of elements in the LinkedList.
     *
     * @return the number of elements in the LinkedList
     */
    public int numberOfElements(){
        Node current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }


    /**
     * The string representation of the linked list is returned.
     *
     * @return a string representation of the linked list.
     */
    public String toString() {
        String result = "";
        Node<T> current = head;
        while (current != null) {
            result += current + " ";
            current = current.getNext();
        }
        return result.trim();
    }
}
