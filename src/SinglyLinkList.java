public class SinglyLinkList<T> {
    private Node<T> head;// is only accessible in this class
    private Node<T> tail;
    private int size;
    public SinglyLinkList(Node<T> h, Node<T> t, int s){
        head = h;// instantiates it within the class
        tail= t;// instantiates tails within the class
       size= s;// instantiates size within the size;

    }
    public SinglyLinkList(){// declaring method for the class

    }
    public void enqueueAtTail(T e){// adding a node at the end of the sll
        addLast(e);// calling the addlast method and inputting the element as the property within the method
    }
    public T removeFirst(){// remove the first node
    if(isEmpty()) {return null;}// returning null if the list is empty
    T answer = head.getElement(); // calling the first node and initialzing it in the method
    head = head.getNext();// calling the get next method and initializng it to the original node
    size--;// making the list smaller
    return answer;
    }
    public T popFromTail(){// removing one node at a time from tail
        T tailpop = removeLast();// initializing the removelast method within the method
        return tailpop;// returning the value that has popped
    }
    public T dequeueAtHead(){// removing the first node at a time
       T dequeue= removeFirst(); // initializing the remove first in the method
        return dequeue;// calling the node that was removed
    }
    public int SearchStack(T element){
        Node find = head;
        int i = 1;
        //Checks whether list is empty
        if(head == null) {// if empty returns null
            System.out.println("List is empty");
        }
        else {
            while(find != null) {// if not it looks for the element
                if(find.getElement() == element) {
                    break;
                }
                i++;
                find = find.getNext();
            }
            if (find==null){// if it cant find it it returns a value of 0
                i=0;
            }
        } return i;

    }
    public void addFirst(T e){// adding an element to the front of the list
head = new Node<>(e,head);// making a new node
if(size == 0) {
    tail = head;
}
size++;
    }
public Boolean isEmpty(){// checks if the SLL is empty and if it is it will return it
        boolean empty= false;
        if(size== 0) {
            empty = true;
        }
    return empty;
}
public int getSize(){//returns the size
        return size;
}
public T removeLast() {

    if(head == null || head.getNext() == null) {// checks if head or head.next is null to see how big the SLL is
        return null;
    }
    // Find the second last node
 Node <T>current = head;// creates a node with the initial value of head
Node<T>previous= null;// used for the value previous to last of tail

    while(current.getNext() != null) {// will run till it reaches tail value
        previous= current;// represents the value before tail
        current = current.getNext();
    }
    // change the second last node next pointer to null
previous.setNext(null);// makes tail null
    tail = previous;// makes the value before tail the new tail
    T currentvalue = current.getElement();// finds the value stored for tail
size--;// makes it smaller
    return currentvalue;
}


public String toString(){
        String result = "[";// initializing the string
        Node<T> current = head;
        if(head==null) {// finds whether the stack is empty
            result+= "]";
            return result;//returns an empty stack if it is
        }
        while(current.getNext() != null){// runs till the node equals null
            result += current.getElement();
            if(current.getNext() != null){
                result += ", ";// adds a comma inbetween
            }
            current = current.getNext();// makes the current value change to the next node
        }
        result +=  current.getElement();// adds all the data to the string
    result+= "]";
        return result;// returns the string
    }

    public void pushAtHead(T element){
addFirst(element);// pushing the value of the node to the front of the stack
    }
    public void pushAtTail(T element){
addLast(element);// pushes the value of the node to the back of the stack
    }

    public void addLast(T e){
Node<T> newest = new Node<>(e,null);// makes a new node
if(isEmpty())
    head = newest;// checks whether the stack is empty
else
    tail.setNext(newest);// sets the value for the stack
tail = newest;
size++;// increases the size
    }
    public T popFromHead(){
       T poph = removeFirst();// removes the first element of the stack but initialized into T
        return poph;
    }

}
