package library;

public abstract class LibraryBook  extends Book implements Comparable<LibraryBook> {
	protected String callNumber;
	
	/**
	 * Constructor for LibraryBook with all input fields
	 * @param au: author of the ReferenceBook
	 * @param ti: title of the ReferenceBook
	 * @param num: ISBN of the ReferenceBook
	 * @param callNum: ISBN of the ReferenceBook
	 */
	LibraryBook (String au,  String ti, String num, String callNum) {
        author = au;
        title = ti;
        ISBN= num;
        callNumber = callNum;
    }
	
	public String getCallNumber() {
		return callNumber;
	}
	
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	
	abstract String circulationStatus();
	
	abstract void checkout (String patron, String dueDate);
	
	abstract void returned ();
	
	/** 
	 * implementation of Comparable's compareTo method
	 * @param lib:  Library object being compared
	 * @return 0 if call numbers of this and lib match
	 *         < 0 if call number of this comes before call number of lib
	 *         > 0 otherwise
	 */
	public int compareTo (LibraryBook lib) {
		return this.callNumber.compareTo(lib.callNumber);
	}
	
	/**
	 * @return title, author, ISBN, call number as a String for printing
	 */
	public String toString () {
		return ("\nTitle:  " + title
                + "\n   Author:  " + author 
                + "\n   ISBN:  " + ISBN
                + "\n   Call Number:  " + callNumber + "\n"); 
	}
	
	// method for testing
    public static void main (String[] args) 
        throws Exception {

        // create two courses, using the two constructors
        Book A = new Book ( "Rick Riordan", "The Lightning Thief", "9783551356932");
        Book B = new Book ("F. Scott Fitzgerald", "The Great Gatsby", "97881471229015");
        Book C = new Book ( "Donald Trump", "Trump: The Art of the Deal", "9781299011298");

        // print results of initialization
        /* first use toString, then use extractors */
        System.out.println ("Initialization");
        System.out.println ("Book A is ");
        System.out.println (A.toString());
        System.out.println ("Book B is ");
        System.out.println ("\nTitle:  " + B.getTitle());
        System.out.println ("   Author:  " + B.getAuthor()); 
        System.out.println ("   ISBN:  " + B.getISBN() + "\n"); 
        System.out.println ("Book C is ");
        System.out.println (C.toString());
        
        // set other fields of yourCourse
        C.setTitle ("Of Thee I Sing");
        C.setAuthor ("Barack Obama");
        C.setISBN("9780307917218");

        // print results of modifications
        System.out.println ("\nAfter modification");
        System.out.println ("Book C is \n" + C);
    }
}
