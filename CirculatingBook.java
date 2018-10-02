package library;

public class CirculatingBook extends LibraryBook{
	protected String currentHolder;
	protected String dueDate;
	
	CirculatingBook (String au,  String ti, String num, String callNum) {
        super(au, ti, num, callNum);
        currentHolder = "";
    	dueDate = "";
    }

	public String getCurrentHolder() {
		return currentHolder;
	}

	public void setCurrentHolder(String currentHolder) {
		this.currentHolder = currentHolder;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public void checkout(java.lang.String patron,
            java.lang.String due) {
		currentHolder = patron;
    	dueDate = due;
	}
	
	public void returned() {
		currentHolder = "";
    	dueDate = "";
	}
	
	public java.lang.String circulationStatus() {
		String status= "";
		if(this.dueDate.compareTo("")==0) {
			status = "Book available on shelves";
		}
		else {
			status = this.currentHolder +  " " + this.dueDate;
		}
		return status;
	}
	
	public String toString () {
		return super.toString() +  "   Current Holder:  " + currentHolder  
					+ "\n   Due Date:  " + dueDate + "\n";
	}
	
	public static void main (String[] args) 
	        throws Exception {

	        // create two courses, using the two constructors
			CirculatingBook A= new CirculatingBook ("Rick Riordan", "The Lightning Thief",
					                            	"9783551356932", "1");
			CirculatingBook B = new CirculatingBook ("F. Scott Fitzgerald", "The Great Gatsby", 
					                             	 "97881471229015", "2");
			CirculatingBook C = new CirculatingBook ("Donald Trump", "Trump: The Art of the Deal", 
					                             	 "9781299011298", "3");
		
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
	        System.out.println ("   Current Holder:  " + B.getCurrentHolder());
	        System.out.println ("   Due Date:  " + B.getDueDate() + "\n");
	        System.out.println ("Book C is ");
	        System.out.println (C.toString());
	        
	        C.checkout("Govind", "09/30/2018");
	        System.out.println("Circulation status of \"" + C.title + "\" : " + C.circulationStatus());
	        System.out.println ("Book C is ");
	        System.out.println (C.toString());
	        C.returned();
	        System.out.println("Circulation status of \"" + C.title + "\" : " + C.circulationStatus());
	        
	        // set other fields of the Book C
	        C.setTitle ("Of Thee I Sing");
	        C.setAuthor ("Barack Obama");
	        C.setISBN("9780307917218");
	        C.setCallNumber("4");
	        C.setCurrentHolder("");
	        C.setDueDate("");

	        // print results of modifications
	        System.out.println ("\nAfter modification");
	        System.out.println ("Book C is \n" + C);
	    }

}

