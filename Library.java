    /*****************************************************************
     * Devansh Chandgothia and Govind Brahmanyapurya                 *
     * 3243                and 3138                                  *
     * Program for CSC 207                                           *
     *   Library Example                                             *
     * Assignment for Wednesday, October 3                           *
     *****************************************************************/


    /* ***************************************************************
     * Academic honesty certification:                               *
     *   Written/online sources used:                                *
     *     http://www.cs.grinnell.edu/~walker/courses/207.fa18/      *
     *     labs/lab-library-books.shtml                              *
     *     http://www.cs.grinnell.edu/~walker/courses/207.fa18/      *
     *     labs/lab-generalization.shtml                             *
     *   Help obtained                                               *
     *     None                                                      *
     *   My signature below confirms that the above list of sources  *
     *   is complete AND that I have not talked to anyone else       *
     *   [e.g., CSC 161 students] about the solution to this problem *
     *                                                               *
     *   Signature: Devansh Chandgothia and Govind Brahmanyapura     *
     *****************************************************************/


package library;

import java.util.ArrayList;
import java.util.Collections;

public class Library {
	ArrayList<LibraryBook> bookList;
	
	Library () {
		bookList = new ArrayList<LibraryBook> ();
	}
	
	/**
	 * adds the given book to the library
	 * @param book
	 */
	public void addBook (LibraryBook book) {
		bookList.add(book);
	}
	
	/**
	 * prints all books in the library
	 */
	public void printLibrary () {
		System.out.println ("\nListing of books in the library\n");
		for (LibraryBook book: bookList)
			System.out.println (book);
		System.out.println ("End of book listing\n");
	}
	
	/**
	 * locates a book in the library
	 * @param book book being search in the library
	 * @return book object if book is found
	 *         null otherwise
	 */
	public LibraryBook findBook (LibraryBook book) {
		int index = Collections.binarySearch(bookList, book);
		if (index >= 0)
			return bookList.get(index);
		else
			return null;
	}
	
	/**
	 * sort books in the library by call number
	 */
	public void sortLibrary () {
		Collections.sort(bookList);
	}
	
	/**
	 * performs processing for checking a book out of the library
	 * @param patron  person checking out book
	 * @param dueDate date book is due to be returned
	 * @param callNum call number of book
	 */
	public void checkout (String patron, String dueDate, String callNum) {
		LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
		LibraryBook book = findBook(searchItem);
		if (book == null)
				System.out.println ("Book " + callNum + " not found -- checkout impossible\n");
		else
				book.checkout (patron, dueDate);
	}
	
	/**
	 * processes checked-out book that is being returned
	 * @param callNum call number of book being returned
	 */
	public void returned (String callNum) {
		LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
		LibraryBook book = findBook(searchItem);
		if (book == null)
			System.out.println ("Book " + callNum + " not found -- return impossible\n");
		else
			book.returned ();
	}
	
	/**
	 * main testing program
	 * @param args  not used
	 */
	public static void main (String args[]) {

		Library lib = new Library ();
		
		// set up library
		lib.addBook(new ReferenceBook ("Henry M. Walker", 
					"Problems for Computer Solution using BASIC",
					"0-87626-717-7", "QA76.73.B3W335", "Iowa Room"));
		lib.addBook(new ReferenceBook ("Samuel A. Rebelsky",
				"Experiments in Java", 
				"0201612674", "64.2 R25ex", "Iowa Room"));
		lib.addBook(new CirculatingBook ("John David Stone",
				"Algorithms for functional programming",
				"in process", "forthcoming"));
		lib.addBook(new CirculatingBook ("Henry M. Walker",
				"Computer Science 2:  Principles of Software Engineering, Data Types, and Algorithms",
				"0-673-39829-3", "QA76.758.W35"));

		lib.addBook(new CirculatingBook ("Henry M. Walker", 
				"Problems for Computer Solution using FORTRAN",
				"0-87626-654-5", "QA43.W34"));
		lib.addBook(new CirculatingBook ("Henry M. Walker",
				"Introduction to Computing and Computer Science with Pascal",
				"0-316-91841-5", "QA76.6.W3275"));
		lib.addBook(new CirculatingBook ("Samuel A. Rebelsky and Philip Barker", 
				"ED-MEDIA 2002 : World Conference on Educational Multimedia, Hypermedia & Telecommunications",
				"14. 1-880094-45-2", "64.2 25e"));
		lib.addBook(new CirculatingBook ("Henry M. Walker",
				"Pascal:  Problem Solving and Structured Program Design",
				"0-316-91848-2", "QA76.73.P2W35"));
		lib.addBook(new CirculatingBook ("Henry M. Walker",
			    "The Limits of Computing",
			    "0-7637-2552-8", "QA76.W185"));
		lib.addBook(new CirculatingBook ("Henry M. Walker",
			    "The Tao of Computing",
			    "0-86720-206-8", "QA76.W1855"));
	
		// sort books by call number
		lib.sortLibrary();
		
		// print library
		lib.printLibrary();
		
		// some users check out and return books
		lib.checkout("Donald Duck", "March 1, 2012", "QA43.W34");
		lib.checkout("Donald Duck", "March 12, 2012", "QA76.6.W3275");
		lib.checkout("Donald Duck", "March 6, 2012", "64.2 R25ex");
		lib.checkout("Minnie Mouse", "April 1, 2012", "64.2 25e");
		lib.checkout("Goofy", "February 28, 2012", "12345"); // should fail
		lib.printLibrary();	
		
		lib.returned("QA76.6.W3275");
		lib.returned("64.2 R25ex");
		
		// initialize new book
		CirculatingBook A = new CirculatingBook  ("Rick Riordan", "The Lightning Thief",
						                     "9783551356932", "QA43.W125");
				
		//try to find book before adding it 
		System.out.println("Looking for non-existing book in library returns: " + lib.findBook(A));

		// add A to library
		lib.addBook(A);
		
		//Sorting the array again so that binary search is possible
		lib.sortLibrary();
		
		//Finding book that exists
		System.out.println("Trying to find Book A: " + lib.findBook(A));
		
		lib.checkout("Goofy", "March 28, 2012", "QA76.6.W3275");
		
		//checking out a few more books
		lib.checkout("Devansh", "December 22, 2018", "QA76.73.P2W35");
		lib.checkout("Govind", "December 22, 2018", "QA76.W185");
		
		//printing current status of library
		lib.printLibrary();	
		
		//returning a few more books
		lib.returned("QA76.73.P2W35");
		lib.returned("QA76.W185");
		lib.returned("QA43.W34");
		
		
		// print final status of library
		lib.printLibrary();			
	}
}