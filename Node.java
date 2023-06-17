package src;

/**
 *This class implements a Node that can be used in the LinkedList.
 * @param <T> the type of data stored in the Node
 * @author Azra Acil
 * @version 17.0
 * @since 2023-04-11
 */
public class Node <T> {
    /**
     * @param data the value to be stored in the Node
     */
    protected T data;

    /**
     * @param next the next Node in the LinkedList
     */
    protected Node next;

    /**
     * This constructs a Node with a specified
     * data and next.
     *
     * @param data the value to be stored in the Node
     *
     * @param next the next Node in the LinkedList
     */
    public Node(T data, Node next){
        this.data = data;
        this.next = null;
    }

    /**
     * Sets the next Node in the LinkedList.
     *
     * @param next the next Node to be set
     */
    public void setNext(Node next){
        this.next = next;
    }

    /**
     * Returns the next Node in the LinkedList.
     *
     * @return the next Node
     */
    public Node getNext(){
        return next;
    }

    /**
     * Sets the data in the LinkedList.
     *
     * @param data the new data value to be set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the value of stored in the Node.
     *
     * @return the value stored in the Node
     */
    public T getData(){
        return data;
    }



}



