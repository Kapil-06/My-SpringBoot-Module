package com.restapi.demorestapi.services;

import java.util.ArrayList;
import java.sql.*;
import org.springframework.stereotype.Service;

import com.restapi.demorestapi.entities.Account;

//A class for proving a services to the controller
@Service
public class AccountServices {
	
	//Function 1 (To retrieve a single account's data from the account table) 
	public ArrayList<Account> getAllAccData(){
		
		ArrayList<Account> list=new ArrayList<>();
		Connection con;
		Statement st;
		ResultSet rs;
		Account obj;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			st=con.createStatement();
			rs=st.executeQuery("Select * from accounts");
			
			while(rs.next()) {
				obj=new Account();
				obj.setAccno(rs.getInt(1));
				obj.setAccnm(rs.getString("accnm"));
				obj.setAcctype(rs.getString("acctype"));
				obj.setBalance(rs.getDouble(4));
				list.add(obj);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	//Function 2 (To retrieve a single account's data from the account table, provide the account number as input.)
	public Account getAccOnNum(int no) {
		
		Account obj=new Account();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("Select * from accounts where accno=?");
			pst.setInt(1, no);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				obj.setAccno(rs.getInt(1));
				obj.setAccnm(rs.getString("accnm"));
				obj.setAcctype(rs.getString("acctype"));
				obj.setBalance(rs.getDouble(4));
			}
			else {
				obj.setAccno(no);
				obj.setAccnm("Not Found");
				obj.setAcctype("Not Found");
				obj.setBalance(0);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return obj;
	}
	
	//Function 3 (To retrieve a all specific account's data from the account table, provided the account type as a input)
	public ArrayList<Account> getAccData(String type) {
		
		ArrayList<Account> list=new ArrayList<>();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		Account obj;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("Select * from accounts where acctype=?");
			pst.setString(1, type);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				obj=new Account();
				obj.setAccno(rs.getInt(1));
				obj.setAccnm(rs.getString("accnm"));
				obj.setAcctype(rs.getString("acctype"));
				obj.setBalance(rs.getDouble(4));
				list.add(obj);
			}
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
