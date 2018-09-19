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
// This class is an implementation of the ArrayList data structure.
// May contain elements of any type.
import java.lang.reflect.Array;

public class ArrayList <E extends hasKey> {

    private final int DEFCAP = 50;
    private int origCap;
    private int numElements;
    private E[] list;
    private Class<E> elementType;

// Method Name      : ArrayList
// Parameters       : et:Class<E>
// Return value(s)  : None
// Partners         : N/A
// Description      : Creates array of specified type, setting origCap to DEFCAP
    public ArrayList (Class<E> et) {

        numElements = 0;
        origCap = DEFCAP;
        elementType = et;
        list = (E[]) Array.newInstance(elementType, origCap);
    }

// Method Name      : ArrayList
// Parameters       : et:Class<E>, size:int
// Return value(s)  : None
// Partners         : N/A
// Description      : Creates array of specified type and size.
    public ArrayList (Class<E> et, int size) throws Exception {

        numElements = 0;
        elementType = et;
        try {
            if (size > 0 && size < DEFCAP) {
            origCap = size;
            list = (E[]) Array.newInstance(elementType, origCap);
            }
            else {
                Exception arraySize = new Exception();
                throw arraySize;
            }
        }
        catch (Exception range) {
            System.out.println ("Given size is larger than maximum.");
        }
    }

// Method Name      : addItem
// Parameters       : item:E
// Return value(s)  : Boolean
// Partners         : N/A
// Description      : Adds item to ArrayList. Returns true if added.
    public Boolean addItem (E item) {

        if (numElements < list.length) {
            list[numElements] = item;
            numElements += 1;
            return true;
        }
        if (numElements == list.length && list.length < DEFCAP) {
            try {
                enlarge();
            }
            catch (Exception c) {
                System.out.println ("Item not added");
            }
            list[numElements] = item;
            numElements += 1;
            return true;
        }
        else {
            return false;
        }
    }

// Method Name      : removeItem
// Parameters       : item:E
// Return value(s)  : Boolean
// Partners         : N/A
// Description      : Removed item from ArrayList. Returns true if removed.
    public Boolean removeItem (E item) {

        int pos = findItem(item);
        if (pos != -1) {
            list[pos] = list[numElements];
            numElements--;;
            return true;
        }
        else {
            return false;
        }

    }

// Method Name      : findItem
// Parameters       : item:E
// Return value(s)  : int
// Partners         : N/A
// Description      : Finds item in Array list. Returns item position in array.
    public int findItem (E item) {

        int pos = -1;
        try {
            for (int x = 0; x < numElements; x++) {
                if (get(x).equals(item)) {
                    pos = x;
                }
            }
        }
        catch (Exception z) {
            System.out.println ("findItem failed.\n");
        }
        return pos;
    }

// Method Name      : findItemByKey
// Parameters       : key:int
// Return value(s)  : int
// Partners         : N/A
// Description      : Finds position of item within the list that shares the key
// that was passed. Since the ArrayList is defined to only accept Generics that
// extend hasKey, we know that the Generic does in fact have a key data member.
// If there is no element that has this key, return -1.
    public int findItemByKey (int key) {

        int pos = -1;
        for (int x = 0; x < list.length; x++) {
            try{
                if (key == get(x).getKey()) {
                    pos = x;
                }
            }
            catch (Exception y) {
            }
        }
        return pos;
    }

// Method Name      : isEmpty
// Parameters       : None
// Return value(s)  : Boolean
// Partners         : N/A
// Description      : Checks array to see if it is empty. Returns true if it is.
    public Boolean isEmpty () {

        if (numElements == 0) {
            return true;
        }
        else {
            return false;
        }
    }

// Method Name      : lengthIs
// Parameters       : None
// Return value(s)  : int
// Partners         : N/A
// Description      : Returns the lenth of the list.
    public int lengthIs () {

        return numElements;
    }

// Method Name      : clear
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Clears selection.
    public void clear () {

        numElements = 0;
        E[] clearedList = (E[]) Array.newInstance(elementType, origCap);
        list = clearedList;
    }

// Method Name      : get
// Parameters       : index:int
// Return value(s)  : E
// Partners         : N/A
// Description      : Retrieves item in the list given an index into the Array List.
// If that index does not exist, throws exception with message, "Index out of Range."
    public E get (int index) throws Exception {

        if (index < 0 || index > list.length) {
            Exception y = new Exception();
            System.out.println ("Index out of Range.");
            throw y;
        }
        else {;
            return list[index];
        }
    }

// Method Name      : toString
// Parameters       : None
// Return value(s)  : String
// Partners         : N/A
// Description      : Overrides Object toString method.
    public String toString () {

        String listString = "";
        for (int x = 0; x < numElements; x++) {
            listString += "\n" + list[x].toString() + "\n";
        }
        return listString;
    }

// Method Name      : enlarge
// Parameters       : None
// Return value(s)  : None
// Partners         : N/A
// Description      : Attempts to enlarge ArrayList by origCap value. If this would
// pass DEFCAP, enlarge to DEFCAP. If already at size of DEFCAP, throw Exception.
    private void enlarge () throws Exception {
        
        E[] larger;
        if (origCap + list.length < DEFCAP) {
            larger = (E[]) Array.newInstance(elementType, origCap + list.length);
            for (int x = 0; x < list.length; x++) {
                larger[x] = list[x];
            }
            list = larger;
        }
        else if (origCap + list.length > DEFCAP) {
            larger = (E[]) Array.newInstance(elementType, DEFCAP);
            for (int x = 0; x < list.length; x++) {
                larger[x] = list[x];
            }
            list = larger;
        }
        else {
            Exception tooLarge = new Exception();
            throw tooLarge;
        }
    }
}
