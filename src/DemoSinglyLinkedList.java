import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoSinglyLinkedList {

    static Scanner input = new Scanner(System.in);


    public static void queueDemo(SinglyLinkList list) {
        System.out.println("Queue demo with the String linked list ...\n");
        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear\n");
        System.out.println("Let's enqueue Joelle and Lukas in the queue in sequence .... \n");
        System.out.printf("The current Queue: %s\n", list.toString());
        list.enqueueAtTail("Joelle, ");
        System.out.printf("After Joelle is enqueued, the revised Queue: %s\n", list.toString());
        list.enqueueAtTail("Lukas");
        System.out.printf("After Lukas is enqueued, the revised Queue: %s\n", list.toString());
        System.out.println("Let's dequeue first three elements from the queue in sequence....\n");
        System.out.printf("The current Queue: %s\n",list.toString());
        while(list.getSize()!=4){
            System.out.printf("%s has been dequeued! The revised queue: %s\n",list.dequeueAtHead().toString(), list.toString());
            /*
            Printing out the queue method with an SLL parameter, first by printing out the initial framework of the method
                        then printing the current queue using the system. printf statement
                        then calling the string list of names and then calling the enqueue method to add the string names Joelle and Lukas to the list
                         and then showing the revised code by calling the toString method to the list.
                         after this, using a while loop to remove one name at a time by using the dequeue method and stopping when there
                         are four names left in the list*/
        }
    }

    public static void header(int number, int question, String name, int SD, String explanation) {
        System.out.println("===================================================================");
        System.out.printf(" Lab Exercise %d,Q%d \n Prepared By: %s \n Student Number: %d \n Goal of this Exercise: %s\n", number,question, name, SD, explanation);
        System.out.println("===================================================================\n");
     /*
        Printing the header method by using the print statement, printf and calling it in the main method class
         */
    }

    public static void footer(int SD, String name) {
        System.out.println("===================================================================");
        System.out.printf("Completion of Lab Exercise %d is successful\n Signing Off  %s\n", SD, name);
        System.out.println("===================================================================");
        /*
        Printing the footer method by using the print statement, printf and calling it in the main method class
         */
    }

    public static void main(String[] args) {
        header(1,1,"Aahash Srikumar",251225561,"To Demonstrate our understanding of Singly Linked List");
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(56, -22, 34, 57, 98));// listing the values
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));//listing the names
        SinglyLinkList<Integer>[] numbers = new SinglyLinkList[values.size()];//matching the array size to the size of the values list
        SinglyLinkList<String>[] letters = new SinglyLinkList[names.size()];//matching the array size to the size of the names list
        System.out.printf("The given Integer array: %s\n", values);//printing the array
        System.out.printf("The given String array: %s\n", names);//printing the string array
             SinglyLinkList<Integer> inputs = new SinglyLinkList<>();// making a SLL to fit the new lists

        for (int i = 0; i < 3; i++) {// moving the nodes in the array,
            // first by using a for loop to add the values
            // to the input SLL, and by adding the previous node goes down the queue by 1 each time
            inputs.addFirst(values.get(i));
        }
        for (int i = values.size() - 1; i > values.size() - 3; i--) {
            inputs.addLast(values.get(i));
//then this adds the values to the end of the list by doing the add last method
            // but only two values are added and each time its added the previous node goes up in queue by 1
        }

        SinglyLinkList<String> queue = new SinglyLinkList<>();

        for (int i = 2; i >= 0; i--) {//the same purpose of the input SLL but for the names
            queue.enqueueAtTail(names.get(i));

        }
        for (int i = values.size() - 1; i > values.size() - 3; i--) {
            queue.enqueueAtTail(names.get(i));

        }
        System.out.printf("Your Integer List : %s\n", inputs.toString());
        System.out.printf("Your String List : %s\n", queue.toString());
        System.out.println("Stack demo with the Integer linked list\n ");
        stackDemo(inputs);// calling stack demo and using inputs as the parameter
queueDemo(queue);//calling queuedemo and using queue as the parameter

        boolean find = false;
        while(find == false){
            System.out.println("Let's search the Stack...\n");
            System.out.printf("The current stack: %s\n",inputs.toString());
            System.out.println("Enter the value you are searching for: \n");
           try {
               int user = input.nextInt();
               int search = inputs.SearchStack(user);
               if (search == 0) {
                   System.out.println("The value is not found!\n");
               } else {
                   System.out.printf("The value %d is found in location %d from the top of the stack\n", user, search);
               }
           }catch(InputMismatchException z){
               System.out.println("The value is not found!\n");
String text = input.next();
               if(text.equalsIgnoreCase("y")){
                   find = false;
               }
               else{
                   find = true;
               }
           }
            System.out.println("Do you want to continue?(enter 'y' for yes or enter any other key to discontinue):\n");
String text = input.next();
if(text.equalsIgnoreCase("y")){
    find = false;
}
else{
    find = true;
}
/*
searches through the SLL to find the node its looking for by using the searchstack method
each time it finds the value it will tell the location of the value by calling the method initializing it
"search" and `whether` its not found or is, it will give the user the option to try to search again or not
if it chooses not too it will end the loop and then the footer will print
 */
        }
        footer(1,"Aahash Srikumar");
    }

    public static void stackDemo(SinglyLinkList<Integer> list) {

        System.out.println("Which end of the linked List you would like to use as the stack top?\n");
        System.out.println("Enter 1 for head or 2 for tail:\n");// asking the question
        boolean options = false;// making it false
        int choice = 0;
        while (options == false) {

            try {// tries to determine whether the value is 1 or 2 if not it will make the user input again
                choice = input.nextInt();
                if (choice == 1 || choice == 2) {
                    options = true;// if true the loop will break
                } else {
                    System.out.println("Invalid Input! Enter 1 or 2: \n");
                    choice = input.nextInt();
                }
            } catch (InputMismatchException e) {// catches whether the user inputs a non integer value
                System.out.println("Invalid Input! Enter 1 or 2: \n");
                input.next();
            }

            if (choice == 1) {// initializes the choice
                System.out.println("Stack Top: Head of the linked list\n");
                System.out.println("Lets pop all the elements from the stack in sequence\n");// pops the element one by one
                System.out.printf("The current stack: %s\n", list.toString());// shows the intial SLL
                while (list.getSize() != 0) {// wont stop till it reaches an empty list
                    System.out.printf("%s has been popped! The Revised stack: %s\n", list.popFromHead().toString(), list.toString());// pops the nodes one by one till its empty
                }
                System.out.println("Let's push 39 and -58 in the stack\n");// pushes elements 39 and -58 using the pushatHead method
                System.out.printf("The current stack: %s \n" ,list.toString());
                list.pushAtHead(39);// pushes nodes at the front
                System.out.printf("After 39 is pushed, the revised stack: %s\n", list.toString());
                list.pushAtHead(-58);
                System.out.printf("After -58 is pushed, the revised stack: %s\n", list.toString());// shows the revised stack
            }

            if (choice == 2) {// if choice 2 is chosen
                System.out.println("Stack Top: Tail of the linked list\n");
                while (list.getSize() != 2) {// pops from tail till list size is equal to 2
                    System.out.printf("%s has been popped! The Revised stack: %s\n", list.popFromTail().toString(), list.toString());// calls the pop tail method and converting the array using the tostring method
                }
                System.out.println("Let's push 39 and -58 in the stack .....\n");//pushes 39 and -58 to the back of the list
                list.pushAtTail(39);
                System.out.printf("After 39 is pushed, the revised stack: %s\n", list.toString());
                list.pushAtTail(-58);
                System.out.printf("After -58 is pushed, the revised stack: %s\n", list.toString());// prints the stack out after being revised


            }
        }
    }
}