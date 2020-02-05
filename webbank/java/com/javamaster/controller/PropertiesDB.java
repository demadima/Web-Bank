package com.javamaster.controller;
import java.sql.*;
import java.util.ArrayList;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertiesDB {
	 private static String url = "jdbc:postgresql://localhost:5432/Bank";
	    private static String username = "postgres";
	    
	    private static String password = "d121212d";
	    
	    public static ArrayList<Account> select() {

	         
	        ArrayList<Account> products = new ArrayList<Account>();
	        try{
	            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
	            try (Connection conn = DriverManager.getConnection(url, username, password)){
	                  
	                Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
	                while(resultSet.next()){
	                      
	                    int id = resultSet.getInt(1);
	                    String mail = resultSet.getString(2);
	                    String password = resultSet.getString(3);
	                    double price = resultSet.getDouble(4);
   
	                    Account product = new Account(id,mail, password,price);
	                    products.add(product);
	                }
	            }
	        }
	        catch(Exception ex){
	            System.out.println(ex);
	        }
	        return products;
	    }
	    
	    public static Account selectOne(int id) {
	         
	    	Account product = null;
	        try{
	            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
	            try (Connection conn = DriverManager.getConnection(url, username, password)){
	                  
	                String sql = "SELECT * FROM account WHERE id=?";
	                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
	                    preparedStatement.setInt(1, id);
	                    ResultSet resultSet = preparedStatement.executeQuery();
	                    if(resultSet.next()){
	 
	                    	int prodid = resultSet.getInt(1);
	 	                    String mail = resultSet.getString(2);
	 	                    String password = resultSet.getString(3);
	 	                    double price = resultSet.getDouble(4);
	                    
	                        product = new Account(prodid,mail, password,price );
	                    }
	                }
	            }
	        }
	        catch(Exception ex){
	            System.out.println(ex);
	        }
	        return product;
	    }
	    
	    public static int update(Account product) {
	         
	        try{
	            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
	            try (Connection conn = DriverManager.getConnection(url, username, password)){
	                  
	                String sql = "UPDATE account SET price = ? WHERE id = ?";
	                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
	                    preparedStatement.setDouble(1, product.getPrice());	              
	                    preparedStatement.setInt(2, product.getId());
	                      
	                    return  preparedStatement.executeUpdate();
	                }
	            }
	        }
	        catch(Exception ex){
	            System.out.println(ex);
	        }
	        return 0;
	    }
	    
	    
}
