/*
 * In the class below, write three methods:
 * 
 * First, method resize() to expand the existing array data by doubling its size.
 *
 * Second, method contains(String string) that returns true if String string already
 * exists in array data and false otherwise.
 *
 * Last, method int countOf(String string) that returns the number of times
 * the String string appears in the underlying array of the object.
 * If String string does not appear in the array, the method should return 0.
 * 
 * Your code must have comments explaining what is done and why it is done in the
 * way you do it.
 *
 * DO NOT USE any tools that require to be imported, ie, do not use the import command.
 *
 * To save this assignment, make sure you commit your changes to your GitHub repository,
 * following the instructions in Sakai. IF YOU DO NOT COMMIT THE CHANGES, IT IS POSSIBLE THAT
 * YOUR WORK MAY BE LOST AND YOU MAY HAVE TO START ALL OVER AGAIN.
 */
public class DynamicArray {

    /** The underlying array for this object */
    private String[] data;

    /** Currently available position in array data */
    private int position;

    /** Constant with default size */
    private static final int DEFAULT_SIZE = 10;

    /**
     * Basic constructor for the object
     * @param size initial size of array data
     */
    public DynamicArray(int size) {
        this.data = new String[size];
        this.position = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Adds a new item to array data after ensurig there is 
     * sufficient room by resizing the array if necessary.
     * @param string new item to add to array
     */
    public void add(String string) {
        // Make sure there is room in array data
        if (this.position == this.data.length) {
            resize();
        }
        // Now array has room for more elements.
        this.data[this.position] = string;
        this.position++;
    } // method add
    
    /**
     * Extends the existing array data by doubling its size.
     */
    private void resize() {
        // Get current size of existing array data.
        int currDataSize = this.data.length;
        // Create new array with size twice that of existing array.
        int longerSize = 2 * currDataSize;
        String[] longerArr = new String[longerSize];

        // Populate new array with all data from existing array.
        for(int i = 0; i < this.data.length; i = i+1){
            longerArr[i] = this.data[i];
        }

        // In effect, lengthen existing array by reassigning it
        // to newly created and populated array.
        this.data = longerArr;
    } // method resize

    /**
     * Returns true if specified item already exists in array data and false otherwise.
     * @param string specified item to search for
     */
    private boolean contains(String string) {
        // variable to track whether item was found
        boolean itemWasFound = false;
  
        // search through array data for existence of item
        // note: only need to search until first occurrence of item,
        int i = 0;
        while(i < this.data.length && !itemWasFound){
            itemWasFound = this.data[i].equals(string);
            i = i+1;
        }
    
        // return result from search
        return itemWasFound;
    } // method contains

    /**
     * Returns the number of times the specified item appears
     * in the underlying array of the object.
     * If item does not appear in the array, the method should return 0.
     * @param string specified item to search for occurrence(s) of
     */
    private int countOf(String string) {
        // variable to track number of occurrences of item
        int numOfOccurs = 0;

        // search through entirety of array data in order to count occurrences of item
        for(int i = 0; i < this.data.length; i = i+1){
            if(this.data[i].equals(string)){
                numOfOccurs = numOfOccurs + 1;
            }
        }

        // return item's number of occurrences
        return numOfOccurs;
    } // method countOf

} // class DynamicArray
