package com.web.film_review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.film_review.entities.FilmsInfo;
import com.web.film_review.services.AddFilmData;
import com.web.film_review.services.AdminServices;

@Controller
public class adminController {
	
	@Autowired
	AdminServices as;
	
	@Autowired
	AddFilmData afd;
	
	@GetMapping("/admin")
	public String adminLogin() {
		return "adminlogin.jsp";
	}
	
	@PostMapping("/login")
	public String adminCheck(String userid, String password) {
		String status="";
		status=as.checkAdmin(userid, password);
		return status;
	}
	
	@GetMapping("/addfilm")
	public String addFilm() {
		return "AddNewFilms.jsp";
	}
	
	@PostMapping("/addfilmdata")
	public String addFilmData(FilmsInfo f) {
		System.out.println("link : "+f.getLink());
		String status=afd.newFilm(f);
		if(status.equals("success"))
			return "filmsAddSuccess.jsp";
		else
			return "failed.jsp";
	}
	
	@GetMapping("/modify")
	public String modifyFilm() {
		return "modify.jsp";
	}
	
	@PostMapping("/updatefilmdata")
	public String modifyData(FilmsInfo f) {
		System.out.println(f.getCollection());
		System.out.println(f.getPlatform());
		String status=afd.updateFilmData(f);
		if(status.equals("success"))
			return "filmsAddSuccess.jsp";
		else
			return "failed.jsp";
	}
}
