package library;

public abstract class LibraryBook  extends Book implements Comparable<LibraryBook> {
	protected String callNumber;
	
	/**
	 * Constructor for LibraryBook with all input fields
	 * @param au: author of the LibraryBook
	 * @param ti: title of the LibraryBook
	 * @param num: ISBN of the LibraryBook
	 * @param callNum: ISBN of the LibraryBook
	 */
	LibraryBook (String au,  String ti, String num, String callNum) {
        author = au;
        title = ti;
        ISBN= num;
        callNumber = callNum;
    }
	
	/**
	 * @return the call number of the LibraryBook
	 */
	public String getCallNumber() {
		return callNumber;
	}
	
	/**
	 * the new call number of the LibraryBook
	 * @param callNumber
	 */
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
}
