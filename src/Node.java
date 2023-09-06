public class Node<T> {
    private T element;// initializing the element using private
    private Node<T> next;// unable to be reached in other classes

    public Node(){

    }
    public Node(T e, Node<T> n){
element= e;// initializes element and node within the method
next= n;
    }

    public Node<T> getNext() {
        return next;
    }// returns next

    public T getElement() {
        return element;
    }// returns the element

    public void setNext(Node<T> next) {
        this.next = next;
    }// sets the next value

}
