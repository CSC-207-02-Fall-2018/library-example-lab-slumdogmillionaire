package library;

/**
 * Descriptive information of a course
 * Intended as an example of a simple class
 */

public class Book {
    // Fields:  Listing of private data
	protected String author;     // the name of the author
	protected String title;     // the title of the book
	protected String ISBN;    // the ISBN of the book

    // Methods
    // Constructors

    /**
     * Default constructor of Book
     */
    Book () {
    	author = "";
        title = "";
        ISBN = "";
    }

    /**
     * Constructor for Book with all input fields
	 * @param au: author of the reference book
	 * @param ti: title of the reference book
	 * @param num: ISBN of the reference book
     */
    Book (String au,  String ti, String num) {
        author = au;
        title = ti;
        ISBN= num;
    }
        
    // Extractors
    /**
     * @return the author of the Book
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * @return the title of the Book
     */
    public String getTitle () {
        return title;
    }
    
    /**
     * @return the ISBN of the Book
     */
    public String getISBN () {
        return ISBN;
    }

    // Modifiers
    /**
     * set the author of the specified Book
     * @param auth 
     */
    public void setAuthor (String auth) {
    	author = auth;
    }
    
    /**
     * set the name of the specified Book
     * @param name 
     */
    public void setTitle (String name) {
        title = name;
    }

    /**
     * set the ISBN of the specified Book
     * @param num
     */
    /* Specify number of credits for the course
     */
    public void setISBN (String num) {
    	ISBN= num;
    }

    /**
	 * @return title, author, ISBN as a String for printing
	 */
    public String toString () {
        return ("\nTitle:  " + title
                + "\n   Author:  " + author 
                + "\n   ISBN:  " + ISBN + "\n"); 
    }

    // method for testing
    public static void main (String[] args) 
        throws Exception {

        // create two courses, using the two constructors
        Book A = new Book ( "Rick Riordan", "The Lightning Thief", "9783551356932");
        Book B = new Book ("F. Scott Fitzgerald", "The Great Gatsby", "97881471229015");
        Book C = new Book ( "Donald Trump", "Trump: The Art of the Deal", "9781299011298");

        // print results of first three books
        /* first use toString, then use extractors */
        System.out.println ("Book A is ");
        System.out.println (A.toString());
        System.out.println ("Book B is ");
        System.out.println ("\nTitle:  " + B.getTitle());
        System.out.println ("   Author:  " + B.getAuthor()); 
        System.out.println ("   ISBN:  " + B.getISBN() + "\n"); 
        System.out.println ("Book C is ");
        System.out.println (C.toString());
        
        
        Book D = new Book();
        // set other fields of yourCourse
        D.setTitle ("Of Thee I Sing");
        D.setAuthor ("Barack Obama");
        D.setISBN("9780307917218");

        // print results of Book D
        System.out.println ("Book D is \n" + D);
    }

} // class Book
