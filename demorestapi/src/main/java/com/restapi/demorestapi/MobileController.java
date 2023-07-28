package com.restapi.demorestapi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demorestapi.entities.Mobile;
import com.restapi.demorestapi.services.MobileServices;

@RestController
@RequestMapping("/api")
public class MobileController {
	
	@Autowired
	MobileServices ms;
	
	@GetMapping("/mob/data/static")
	public Mobile mobDetail() {
		Mobile obj=new Mobile(72,"vivo Y20","Vivo","4G","3GB","64GB","Nebula Blue","IPS LED", 5000, "Qualcomm Snapdragon 439", 10999,4.0);
		return obj;
	}
	
	@GetMapping("/mob/data/all")
	public ArrayList<Mobile> showMobList(){
		
		ArrayList<Mobile> list=new ArrayList<>();
		list=ms.getMobList();
		return list;
	}
	
	// http://localhost:8080/api/mob/search/company/vivo
	@GetMapping("/mob/search/company/{company}")
	public ArrayList<Mobile> showMobByCompany(@PathVariable String company){
		ArrayList<Mobile> list=ms.getMobileByComp(company);
		return list;
	}
	
	
	// http://localhost:8080/api/mob/search/company/vivo/6GB
	@GetMapping("/mob/search/company/{company}/{ram}")
	public ArrayList<Mobile> showMobByCompAndRam(@PathVariable String company,@PathVariable String ram){
		
		ArrayList<Mobile> list=ms.getMobByCompAndRam(company,ram);
		return list;
	}
	
}
