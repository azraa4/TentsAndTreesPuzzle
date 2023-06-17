package src;
/**
 * This class implements the Queue data structure using a LinkedList.
 * @param <T> the type of elements stored in the Queue.
 * @author Azra Acil
 * @version 17.0
 * @since 2023-04-11
 */
public class Queue<T> {

    /**
     * @param first is the first Node in the Queue.
     */
    protected Node first;

    /**
     * @param last is the last Node in the Queue.
     */
    protected Node last;

    /**
     * This constructs a Node with a specified
     * data and next.
     *
     * Constructs an empty queue.
     */
    public Queue() {
        first = null;
        last = null;
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
     * Checks if the Queue is empty.
     *
     * @return true if the Queue is empty, false otherwise.
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Adds a new Node containing the specified element to the end of the Queue.
     *
     * @param data the element to be added to the Queue.
     */
    public void enqueue(T data) {
        Node<T> newNode = createNode(data);
        if (first == null) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }
    
    public Node<T> getFirst(){
        return first;
    }

    /**
     * Removes and returns the first element in the Queue.
     *
     * @return the first element in the Queue, or null if the Queue is empty.
     */
    public Node<T> dequeue(){
        Node result = first;
        if (!isEmpty()){
            first = first.getNext();
            if (first == null){
                last = null;
            }
        }
        return result;
    }

    public int size() {
        int size = 0;

        Node<T> current = first;
        while (current != null) {
            size++;
            current = current.getNext();
        }

        return size;
    }
}
