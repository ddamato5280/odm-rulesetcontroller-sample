/*
* Licensed Materials - Property of IBM
* 5725-B69 5655-Y17 5655-Y31 5724-X98 5724-Y15 5655-V82 
* Copyright IBM Corp. 1987, 2013. All Rights Reserved.
*
* Note to U.S. Government Users Restricted Rights: 
* Use, duplication or disclosure restricted by GSA ADP Schedule 
* Contract with IBM Corp.
*/

package miniloan;

import java.util.Date;
import java.util.HashMap;

/**
 * This class models a borrower.
 * A borrower is created with a name, a credit score, and a yearly income.
 */
public class Borrower {
	private String name;
    private int creditScore;
    private int yearlyIncome;
    private Date dateOfBirth;
    private String category;
    private HashMap<String, String> attributes = new HashMap<String, String>();
    
	public Borrower() {
	}

	/**
	 * Builds a borrower.
	 * The parameters names to be used in the BOM are given with the annotation BusinessName
	 * @param name The name of the borrower.
	 * @param creditScore The credit score of the borrower.
	 * @param yearlyIncome The yearly income of the borrower.
	 */
	public Borrower(String name, int creditScore, int yearlyIncome, Date dateOfBirth) {
	    this();
		this.name = name;
		this.creditScore = creditScore;
		this.yearlyIncome = yearlyIncome;
		this.setDateOfBirth(dateOfBirth);
	}

	/**
	 * @return The name of the borrower.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the borrower.
	 * @param name The name to set.
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * @return The credit score of the borrower.
	 */
	public int getCreditScore() {
		return creditScore;
	}
	/**
	 * Sets the credit score of the borrower.
	 * @param creditScore The credit score to set.
	 */
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	/**
	 * @return The yearly income of the borrower.
	 */
	public int getYearlyIncome() {
		return yearlyIncome;
	}
	/**
	 * Sets the yearly income of the borrower.
	 * @param yearlyIncome The yearly income to set.
	 */
	public void setYearlyIncome(int yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String[] getAttributes() {
		String[] array = ((String[])attributes.keySet().toArray());
		return array;
	}
	public void setAttribute(String key, String value) {
		this.attributes.put(key, value);
	}
	public String getAttribute(String key) {
		return this.attributes.get(key);
	}
}
