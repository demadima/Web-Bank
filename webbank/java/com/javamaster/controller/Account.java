package com.javamaster.controller;

public class Account {
	private int id;
    private String mail;
    private String password;
    private double price;

     
    public Account(){ }
    public Account(int id, double price){
    	  this.id = id;       
        this.price = price;
   
           
    }    
    
    public Account(String mail,String password , double price){
         
        this.mail = mail;
        this.password = password;
        this.price = price;
   
           
    }
    public Account(int id, String mail,String password , double price){
         
        this.id = id;        
        this.mail = mail;
        this.password = password;
        this.price = price;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
