package library;

public class ReferenceBook extends LibraryBook{
	protected String collection;
	
	/**
	 * Constructor for ReferenceBook with all input fields
	 * @param au: author of the ReferenceBook
	 * @param ti: title of the ReferenceBook
	 * @param num: ISBN of the ReferenceBook
	 * @param callNum: call number of the ReferenceBook
	 * @param coll: collection of the ReferenceBook
	 */
	ReferenceBook (String au,  String ti, String num, String callNum, String coll) {
        super(au, ti, num, callNum);
        collection=coll;
    }

	/**
	 * Returns the collection to which the ReferenceBook belongs to
	 * @return collection of the ReferenceBook
	 */
	public String getCollection() {
		return collection;
	}
	
	/**
	 * Sets the collection to which the ReferenceBook belongs to
	 * @param collection the new collection of the ReferenceBook
	 */
	public void setCollection(String collection) {
		this.collection = collection;
	}
	
	/**
	 * Prints a message to say that a ReferenceBook cannot be checked out
	 */
	public void checkout(java.lang.String patron,
            java.lang.String dueDate) {
		System.out.println("Cannot check out a reference book");
	}
	
	/**
	 * Prints a message to say that a ReferenceBook cannot be in circulation
	 */
	public java.lang.String circulationStatus() {
		return "non-circulating reference book";
	}
	
	/**
	 * Prints a message to say that a ReferenceBook cannot be returned
	 */
	public void returned() {
		System.out.println("Reference book could not have been checked out -- return impossible");
	}
	
	/**
	 * @return title, author, ISBN, call number, collection as a String for printing
	 */
	public String toString () {
		return super.toString() +  "   Collection:  " + collection  + "\n";
	}
	
	public static void main (String[] args) 
	        throws Exception {

	        // create two courses, using the two constructors
			ReferenceBook A= new ReferenceBook ( "Rick Riordan", "The Lightning Thief",
					                            "9783551356932", "1", "Teen Fiction");
			ReferenceBook B = new ReferenceBook ("F. Scott Fitzgerald", "The Great Gatsby", 
					                             "97881471229015", "2", "Historical Fiction");
			ReferenceBook C = new ReferenceBook ("Donald Trump", "Trump: The Art of the Deal", 
					                             "9781299011298", "3", "Business" );
		
	        // print results of initialization
	        /* first use toString, then use extractors */
	        System.out.println ("Initialization");
	        System.out.println ("Book A is ");
	        System.out.println (A.toString());
	        System.out.println ("Book B is ");
	        System.out.println ("\nTitle:  " + B.getTitle());
	        System.out.println ("   Author:  " + B.getAuthor()); 
	        System.out.println ("   ISBN:  " + B.getISBN());
	        System.out.println ("   Call Number:  " + B.getCallNumber());
	        System.out.println ("   Collection:  " + B.getCollection()  + "\n");
	        System.out.println ("Book C is ");
	        System.out.println (C.toString());
	        
	        C.checkout("Govind", "09/30/2018");
	        C.returned();
	        System.out.println("Circulation status of \"" + C.title + "\" : " + C.circulationStatus());
	       
	        
	        // set other fields of the Book C
	        C.setTitle ("Of Thee I Sing");
	        C.setAuthor ("Barack Obama");
	        C.setISBN("9780307917218");
	        C.setCallNumber("4");
	        C.setCollection("Children's book");

	        // print results of modifications
	        System.out.println ("\nAfter modification");
	        System.out.println ("Book C is \n" + C);
	    }

}
