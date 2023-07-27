package com.spring.SecondWeb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.SecondWeb.Services.AccountServices;
import com.spring.SecondWeb.Services.UserService;
import com.spring.SecondWeb.entities.Accounts;

import jakarta.servlet.http.HttpSession;

@Controller
public class DemoController {
	
	@Autowired
	UserService us;
	
	@Autowired
	AccountServices as;
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public String userLogin(String userid, String pass, HttpSession ses) {
		String stat="";
		stat=us.checkUsers(userid, pass);
		ses.setAttribute("uid", userid);
		return stat;
	}
	
	@GetMapping("/accountreport")
	public ModelAndView showAccReport() {
		ArrayList<Accounts> list;
		list=as.accReport();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AccountReport.jsp");
		mv.addObject("acclist", list);
		return mv;
	}
}
