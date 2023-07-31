package com.restapi.demorestapi.services;

import java.util.ArrayList;
import java.sql.*;
import org.springframework.stereotype.Service;

import com.restapi.demorestapi.entities.Mobile;

@Service
public class MobileServices {
	
	//Function 1 to retrieve all mobile data from database
	public ArrayList<Mobile> getMobList(){
		
		ArrayList<Mobile> list=new ArrayList<>();
		Connection con;
		Statement st;
		ResultSet rs;
		Mobile mob;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			st=con.createStatement();
			rs=st.executeQuery("Select * from mobiles");
			
			while(rs.next()) {
				mob=new Mobile();
				mob.setProdid(rs.getInt(1));
				mob.setModelname(rs.getString(2));
				mob.setCompany(rs.getString("company"));
				mob.setConnectivity(rs.getString(4));
				mob.setRam(rs.getString(5));
				mob.setRom(rs.getString("rom"));
				mob.setColor(rs.getString("color"));
				mob.setScreen(rs.getString("screen"));
				mob.setBattery(rs.getInt("battery"));
				mob.setProcessor(rs.getString("processor"));
				mob.setPrice(rs.getFloat("price"));
				mob.setRating(rs.getDouble("rating"));
				list.add(mob);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	//Function 2 to retrieve specific mob data , providing company name as input
	public ArrayList<Mobile> getMobileByComp(String company){
		
		ArrayList<Mobile> list=new ArrayList<>();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		Mobile mob;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("Select * from mobiles where company=?");
			pst.setString(1, company);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				mob=new Mobile();
				mob.setProdid(rs.getInt(1));
				mob.setModelname(rs.getString(2));
				mob.setCompany(rs.getString("company"));
				mob.setConnectivity(rs.getString(4));
				mob.setRam(rs.getString(5));
				mob.setRom(rs.getString("rom"));
				mob.setColor(rs.getString("color"));
				mob.setScreen(rs.getString("screen"));
				mob.setBattery(rs.getInt("battery"));
				mob.setProcessor(rs.getString("processor"));
				mob.setPrice(rs.getFloat("price"));
				mob.setRating(rs.getDouble("rating"));
				list.add(mob);
			}
			
			// Check if the list is empty, and if so, add a "not found" message or handle it accordingly.
	        if (list.isEmpty()) {
	            mob = new Mobile();
	            mob.setCompany("Not Found");
	            list.add(mob);
	        }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}

	//Function 3 to retrieve mobile details by providing company and ram
	public ArrayList<Mobile> getMobByCompAndRam(String company, String ram){
		
		ArrayList<Mobile> list=new ArrayList<>();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		Mobile mob;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("Select * from mobiles where company=? and ram=?");
			pst.setString(1, company);
			pst.setString(2, ram);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				mob=new Mobile();
				mob.setProdid(rs.getInt(1));
				mob.setModelname(rs.getString(2));
				mob.setCompany(rs.getString("company"));
				mob.setConnectivity(rs.getString(4));
				mob.setRam(rs.getString(5));
				mob.setRom(rs.getString("rom"));
				mob.setColor(rs.getString("color"));
				mob.setScreen(rs.getString("screen"));
				mob.setBattery(rs.getInt("battery"));
				mob.setProcessor(rs.getString("processor"));
				mob.setPrice(rs.getFloat("price"));
				mob.setRating(rs.getDouble("rating"));
				list.add(mob);
			}
			
			// Check if the list is empty, and if so, add a "not found" message or handle it accordingly.
	        if (list.isEmpty()) {
	            mob = new Mobile();
	            mob.setCompany("Not Found");
	            mob.setRam("Not Found");
	            list.add(mob);
	        }
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return list;
	}
	
	
	//Function 4 to retrieve mobile details by providing connectivity
	public ArrayList<Mobile> getMobDataByConnectivity(String cntvt){
		
		ArrayList<Mobile> list=new ArrayList<>();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		Mobile mob;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			 
			pst=con.prepareStatement("Select * from mobiles where connectivity=?");
			pst.setString(1, cntvt);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				mob=new Mobile();
				mob.setProdid(rs.getInt(1));
				mob.setModelname(rs.getString(2));
				mob.setCompany(rs.getString("company"));
				mob.setConnectivity(rs.getString(4));
				mob.setRam(rs.getString(5));
				mob.setRom(rs.getString("rom"));
				mob.setColor(rs.getString("color"));
				mob.setScreen(rs.getString("screen"));
				mob.setBattery(rs.getInt("battery"));
				mob.setProcessor(rs.getString("processor"));
				mob.setPrice(rs.getFloat("price"));
				mob.setRating(rs.getDouble("rating"));
				list.add(mob);
			}
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	// Function 5 to retrieve mobile details in ascending order by providing a price range 
	public ArrayList<Mobile> getMobByPriceRange(float price1, float price2){
		
		ArrayList<Mobile> list=new ArrayList<>();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		Mobile mob;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			 
			pst=con.prepareStatement("Select * from mobiles where price between ? and ? order by price ASC");
			pst.setFloat(1, price1);
			pst.setFloat(2, price2);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				mob=new Mobile();
				mob.setProdid(rs.getInt(1));
				mob.setModelname(rs.getString(2));
				mob.setCompany(rs.getString("company"));
				mob.setConnectivity(rs.getString(4));
				mob.setRam(rs.getString(5));
				mob.setRom(rs.getString("rom"));
				mob.setColor(rs.getString("color"));
				mob.setScreen(rs.getString("screen"));
				mob.setBattery(rs.getInt("battery"));
				mob.setProcessor(rs.getString("processor"));
				mob.setPrice(rs.getFloat("price"));
				mob.setRating(rs.getDouble("rating"));
				list.add(mob);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
} // class bracket
