package com.gcit.lms.domain;

public class Borrower {

	//data fields
	private int cardNo;
	private String name;
	private String address;
	private String phone;
	private int noOfBorrower;
	
	/**
	 * @return the cardNo
	 */
	public int getCardNo() {
		return cardNo;
	}
	
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the noOfBorrower
	 */
	public int getNoOfBorrower() {
		return noOfBorrower;
	}
	
	/**
	 * @param noOfBorrower the noOfBorrower to set
	 */
	public void setNoOfBorrower(int noOfBorrower) {
		this.noOfBorrower = noOfBorrower;
	}
	
}
