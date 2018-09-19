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
// A simple representation of a book (provided, don't change).

public class Book implements hasKey
{
    private String title;
    private String author;
    private int ISBN;

    public Book()
    {
        ISBN = 0;
        title = "";
        author = "";
    }

    public Book(int i, String t, String a)
    {
        ISBN = i;
        title = t;
        author = a;
    }

    public String getTitle()
    {
    return title;
    }

    public String getAuthor()
    {
    return author;
    }

    public boolean equals(Object b)
    {
        if(this.ISBN == ((Book)b).ISBN)
            return true;
        else
            return false;
    }

    public String toString()
    {
        return String.format("%s\n%s\n%d", title, author, ISBN);
    }

    public int getKey()
    {
        return ISBN;
    }
}

