// Name         : Josh Heyer
// Class        : CSCI 1620-301
// Program #    : 4
// Due Date     : 7/5/2016
//
// Honor Pledge : On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// Name         : Josh Heyer
// NUID         : 59530380
// Email        : jheyer@unomaha.edu
// Partners     : None
//
// Implementation of a book check out system (starter code provided).
import java.util.Scanner;

public class Library
{
    public static void main(String[] args)
    {
        ArrayList<Book> books;
        ArrayList<Book> stock;
        ArrayList<Member> members;

//Declare other variables to be used

//Create new ArrayLists for books, stock, and members
//Remember, the constructor for ArrayList that
//takes a size throws an Exception!
        books = new ArrayList<Book>(Book.class);
        members = new ArrayList<Member>(Member.class);
        stock = new ArrayList<Book>(Book.class);

//Populate books ArrayList
        books.addItem(new Book(812550706, "Ender's Game", "Card, Orson Scott"));
        books.addItem(new Book(385334206, "Breakfast of Champions", "Vonnegut, Kurt"));
        books.addItem(new Book(80652720, "The Alphabet of Manliness", "Maddox"));
        books.addItem(new Book(141182865, "A Condeferacy of Dunces", "Toole, John Kennedy"));
        books.addItem(new Book(441013597, "Dune", "Herbert, Frank"));
        books.addItem(new Book(415325056, "History of Western Philosophy", "Russell, Bertrand"));
        books.addItem(new Book(307388921, "Choke", "Palahniuk, Chuck"));
        books.addItem(new Book(316776963, "Me Talk Pretty One Day", "Sedaris, David"));
        books.addItem(new Book(375703768, "House of Leaves", "Danielewski, Mark"));
        books.addItem(new Book(1592402038, "Eats, Shoots, & Leaves", "Truss, Lynne"));

//Populate members ArrayList
    members.addItem(new Member("Parker, Peter", 56754));
    members.addItem(new Member("Spector, Marc", 74686));
    members.addItem(new Member("Curry, Arthur", 71245));
    members.addItem(new Member("Stark, Tony", 96785));
    members.addItem(new Member("Queen, Oliver", 45267));

//Copy books into stock
        for(int x = 0; x < books.lengthIs(); x++)
        {
            try
            {
                stock.addItem(books.get(x));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

//Implement Library User Menu
    int selection;
    Scanner in = new Scanner(System.in);
    do {
    do {
        System.out.println ("Library Manager");
        System.out.println ("1. Check Out");
        System.out.println ("2. Return");
        System.out.println ("3. List Stock");
        System.out.println ("4. List Checked Out");
        System.out.println ("5. Exit");
        System.out.print ("Selection: ");
        selection = in.nextInt();
        if (selection < 1 || selection > 5) {
            System.out.println ("Invalid selection. Enter 1 through 5.");
        }
    } while (selection < 1 || selection > 5);

    switch (selection) {
        
        case 1:
            System.out.printf ("%s", members.toString());
            int found; int found1;
            do {
                System.out.print ("\nMember ID: ");
                int subselection = in.nextInt();
                found = members.findItemByKey(subselection);
                if (found == -1) {
                    System.out.print ("Invalid Member ID.");
                }
            } while (found == -1);
            System.out.printf ("%s", books.toString());
            do {
                System.out.print ("\nBook ISBN: ");
                int IBSN = in.nextInt();
                found1 = books.findItemByKey(IBSN);
                if (found1 == -1) {
                    System.out.print ("Invalid ISBN.");
                }
            } while (found1 == -1);
            try {
                if (members.get(found).checkOut(books.get(found1))) {
                    stock.removeItem(stock.get(found1));
                }
            }
            catch (Exception z) {
                System.out.println ("\nCould not remove item.");
            }
            break;

        case 2:
            System.out.printf ("%s", members.toString());
            int found2; int found3;
            do {
                System.out.print ("\nMember ID: ");
                int subselection = in.nextInt();
                found2 = members.findItemByKey(subselection);
                if (found2 == -1) {
                    System.out.print ("Invalid Member ID.");
                }
            } while (found2 == -1);
            System.out.printf ("%s", books.toString());
            do {
                System.out.print ("\nBook ISBN: ");
                int IBSN = in.nextInt();
                found3 = books.findItemByKey(IBSN);
                if (found3 == -1) {
                    System.out.print ("Invalid ISBN.");
                }
            } while (found3 == -1);
            break;

        case 3:
            System.out.printf ("%s\n", stock.toString());
            break;

        case 4:
            System.out.printf ("%s", members.toString());
            int found4; int found5;
            do {
                System.out.print ("\nMember ID: ");
                int subselection = in.nextInt();
                found4 = members.findItemByKey(subselection);
                if (found4 == -1) {
                    System.out.print ("Invalid Member ID.");
                }
            } while (found4 == -1);
            try {
                members.get(found4).printCheckedOut();
            }
            catch (Exception y) {
            }
            break;

        case 5:
            System.out.println ("\n\nExiting Library");
            break;
    }
    } while (selection != 5);
    
    }//end main
}//end class
