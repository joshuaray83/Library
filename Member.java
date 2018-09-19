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
// A simple representation of a library member.

public class Member implements hasKey {

    private String name;
    private final int MAX_BOOKS = 3;
    private ArrayList<Book> checkedOut;
    private int memberId;

// Method Name      : Member
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Sets key member to 0, name to "", and checkedOut to 
// and unsized ArrayList<Book>.
    public Member () {

        memberId = 0;
        name = "";
        checkedOut = new ArrayList<Book>(Book.class);
    }

// Method Name      : Member
// Parameters       : n:String, i:int
// Return value(s)  : None
// Partners         : N/A
// Description      : Name to n and checkedOut to an ArrayList<Book> of 3.
    public Member (String n, int i) {

        name = n;
        memberId = i;
        try {
            checkedOut = new ArrayList<Book>(Book.class, 3);
        }
        catch (Exception c) {
            System.out.println ("Error creating Member ArrayList");
        }
    }

// Method Name      : checkOut
// Parameters       : b:Book
// Return value(s)  : Boolean
// Partners         : N/A
// Description      : Adds the passed book to the checkedOutArrayList if 
// possible (not alread 3 books checked out). Returns true if successful.
    public Boolean checkOut (Book b) {

        if (checkedOut.lengthIs() < MAX_BOOKS) {
            checkedOut.addItem(b);
            System.out.printf ("\n%s\nhas checked out\n%s\n\n", toString(), b.toString());
            return true;
        }
        else {
            return false;
        }
    }

// Method Name      : returnBook
// Parameters       : b:Book
// Return value(s)  : Boolean
// Partners         : N/A
// Description      : Attempts to remove passed book from checkedOut.
// Returns true if successful.
    public Boolean returnBook (Book b) {

        if (this.equals(b)) {
            return true;
        }
        else {
            return false;
        }
    }

// Method Name      : equals
// Parameters       : m:Object
// Return value(s)  : boolean
// Partners         : N/A
// Description      : Based upon the key member, determines if the passed
// Member is the same as the calling Member. Returns true if equal.
    public boolean equals (Object m) {

        if (this.memberId == ((Member)m).memberId) {
            return true;
        }
        else {
            return false;
        }
    }

// Method Name      : printCheckedOut
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Outputs all currently checked out books.
    public void printCheckedOut () {

        System.out.printf ("%s\n", checkedOut.toString());
    }

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : N/A
// Description      : Returns String format of MemberName and MemberID (key).
    @Override
    public String toString () {

        return String.format ("%s\n%d", name, memberId);
    }

// Method Name      : getKey
// Parameters       : None
// Return value(s)  : int
// Partners         : N/A
// Description      : Returns the key value, memberId.
    public int getKey () {

        return memberId;
    }
}
