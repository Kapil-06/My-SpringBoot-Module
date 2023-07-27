package com.restapi.demorestapi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demorestapi.entities.Account;
import com.restapi.demorestapi.services.AccountServices;

@RestController
@RequestMapping("/api")
public class BankController {

	@Autowired
	AccountServices as;
	
	@GetMapping("/acc/static")
	public Account getAccountDetail() {
		
		//return a JSON object
		Account obj=new Account(456,"Arjun","fixed",654200);
		return obj;
	}
	
	@GetMapping("/acc/multi")
	public ArrayList<Account> showMulti(){
		
		ArrayList<Account> list=new ArrayList<>();
		Account a1,a2,a3,a4;
		a1=new Account(123,"Amir","Current",845415);
		a2=new Account(543,"Vijay","PF",468000);
		a3=new Account(875,"Ram","Saving",289500);
		a4=new Account(675,"Akshay","fixed",134865);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		return list;
	}
	
	// 'To retrieve all account's data from the account table'
	@GetMapping("/acc/db/all")
	public ArrayList<Account> getAccReport(){
		ArrayList<Account> list=null;
		list=as.getAllAccData();
		return list;
	}
	
	//To retrieve a single account's data from the account table, provided a account number as input
	// http://localhost:8080/api/acc/db/search/1026
	@GetMapping("acc/db/search/{ano}")
	public Account getAccByNo(@PathVariable int ano){
		Account acc=as.getAccOnNum(ano);
		return acc;
	}
	
	//To retrieve a specific account's data from the account table, provided a account type as input
	// http://localhost:8080/api/acc/db/search/all/fixed
	@GetMapping("acc/db/search/all/{acctype}")
	public ArrayList<Account> getAccByType(@PathVariable String acctype) {
		ArrayList<Account> list=as.getAccData(acctype);
		return list;
	}
}
