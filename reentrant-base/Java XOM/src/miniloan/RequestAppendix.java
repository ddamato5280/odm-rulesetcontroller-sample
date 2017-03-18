package miniloan;

import java.util.Vector;


public class RequestAppendix {
	private Vector<Borrower> goodBorrowerList = new Vector<Borrower>();
	private Vector<Borrower> badBorrowerList = new Vector<Borrower>();
	
	
	public RequestAppendix(){
		this.goodBorrowerList = new Vector<Borrower>();
		this.badBorrowerList = new Vector<Borrower>();
	}
	
	public RequestAppendix(Vector<Borrower> goodBorrowerList, Vector<Borrower> badBorrowerList){
		this.goodBorrowerList = goodBorrowerList;
		this.badBorrowerList = badBorrowerList;
	}
	
	
	public Vector<Borrower> getGoodBorrowerList() {
		return goodBorrowerList;
	}
	public void addGoodBorrowerToList(Borrower goodBorrower) {
		this.goodBorrowerList.add(goodBorrower);
	}
	public void removeGoodBorrowerFromList(Borrower goodBorrower) {
		for (Borrower borrower : goodBorrowerList) {
			if(borrower.getName() != null && goodBorrower.getName()  != null  &&
					borrower.getName().equals(goodBorrower.getName())){
				
				this.goodBorrowerList.remove(borrower);
			}
		}
		
	}
	
	public Vector<Borrower> getBadBorrowerList() {
		return badBorrowerList;
	}
	public void addBadBorrowerToList(Borrower badBorrower) {
		this.badBorrowerList.add(badBorrower);
	}
	public void removeBadBorrowerFromList(Borrower badBorrower) {
		for (Borrower borrower : badBorrowerList) {
			if(borrower.getName() != null && badBorrower.getName()  != null  &&
					borrower.getName().equals(badBorrower.getName())){
				
				this.badBorrowerList.remove(borrower);
			}
		}
		
	}

}
