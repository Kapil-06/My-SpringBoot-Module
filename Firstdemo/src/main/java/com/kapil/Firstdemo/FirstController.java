package com.kapil.Firstdemo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kapil.Firstdemo.entities.Car;
import com.kapil.Firstdemo.entities.User;
import com.kapil.Firstdemo.services.CarServices;
import com.kapil.Firstdemo.services.UserServices;

@Controller
public class FirstController {
	
	@Autowired
	UserServices us;
	
	@Autowired
	CarServices cs;
	
	@GetMapping("/")
	public String home(){
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public String login(String userid, String pass) {	
		String status="";
		us=new UserServices();
		status=us.checkUser(userid, pass);
		return status;
	}
	
	@GetMapping("/newuser")
	public String newUser() {
		return "newuser.jsp";
	}
	
	@PostMapping("/register")
	public String userRegister(User u) {
		String status=us.addNewUser(u);
		if(status.equals("success"))
			return "userRegisterSuccess.jsp";
		else
			return "userRegisterFailed.jsp";
	}
	
	@GetMapping("/newcar")
	public String addNewCar() {
		return "newCarEntry.jsp";
	}
	
	@PostMapping("/addcar")
	public String addCar(Car c) {
		String status=cs.newCar(c);
		if(status.equals("success"))
			return "CarAddedSuccess.jsp";
		else
			return "CarAddedFailed.jsp";
	}
	
	@GetMapping("/cardetail")
	public ModelAndView ShowCarReport() {
		ModelAndView mv=new ModelAndView();
		ArrayList<Car> list=cs.showCarReport();
		mv.setViewName("carreport.jsp");
		mv.addObject("carlist", list);
		return mv;
	}
}
