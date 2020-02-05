package com.javamaster.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/")) {
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		} else if (path.equals("/welcome")) {
			try {
			int id = Integer.parseInt(request.getParameter("id"));
			Account product = PropertiesDB.selectOne(id);
				if (product != null) {
					request.setAttribute("product", product);
					getServletContext().getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(request, response);
				} else {
					getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
				}
			} catch (Exception ex) {
				getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
			}
			
		} else if (path.equals("/deposit")) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Account product = PropertiesDB.selectOne(id);
				if (product != null) {
					request.setAttribute("product", product);
					getServletContext().getRequestDispatcher("/WEB-INF/view/deposit.jsp").forward(request, response);
				} else {
					getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
				}
			} catch (Exception ex) {
				getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
			}
		} else if (path.equals("/withdraw")) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Account product = PropertiesDB.selectOne(id);
				if (product != null) {
					request.setAttribute("product", product);
					getServletContext().getRequestDispatcher("/WEB-INF/view/withdraw.jsp").forward(request, response);
				} else {
					getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
				}
			} catch (Exception ex) {
				getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
			}
		}else {
			getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
	
		if (path.equals("/deposit")) {
			try {
		
	            int id = Integer.parseInt(request.getParameter("id"));	    
	    		double priceOld = Double.parseDouble(request.getParameter("priceOld"));
				double priceNew = Double.parseDouble(request.getParameter("priceNew"));	            
				double price = priceOld+priceNew;
				
	            Account product = new Account(id ,price);
	            PropertiesDB.update(product);
	       
	            response.sendRedirect(request.getContextPath()+"/welcome?id="+id);
	            
	        }
	        catch(Exception ex) {
	             
	            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);   
	        }
			
		}else if (path.equals("/withdraw")) {
			try {
		
	            int id = Integer.parseInt(request.getParameter("id"));	    
	    		double priceOld = Double.parseDouble(request.getParameter("priceOld"));
				double priceNew = Double.parseDouble(request.getParameter("priceNew"));	            
				double price = priceOld-priceNew;
				if (price >= 0) {
		            Account product = new Account(id ,price);
		            PropertiesDB.update(product);
		            response.sendRedirect(request.getContextPath()+"/welcome?id="+id);
				}else  {
					getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);   
				}
				
	        }
	        catch(Exception ex) {
	             
	            getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);   
	        }
			
		}else if (path.equals("/")) {
			try {
				ArrayList<Account> products = PropertiesDB.select();
				Account product_by_id = null;
				boolean key = false;// ключ , позволяющий узнать, правильный был введен ли пароль  и mail
				String mail = request.getParameter("mail"); 
				String password = request.getParameter("password"); 
				// Проверка на совпадение mail и password
				for(Account product : products) {					
					if(product.getMail().equals(mail) && product.getPassword().equals(password)) {
						key= true;
						product_by_id = product;
					}
				}
				if(key) {
					request.setAttribute("product", product_by_id);
					getServletContext().getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(request, response); 
					
				}else {
					getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);  
				}
			
				
	        }
	        catch(Exception ex) {
	             
	            getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);   
	        }
			
		}else {
			getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);   
		}
		
	
		
		
	}

}
