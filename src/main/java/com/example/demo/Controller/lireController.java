package com.example.demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ReadSingleEventExample;
import com.example.demo.Model.WriteEventExample;

import eventstore.Content;
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping("/Event")
public class lireController {
	ReadSingleEventExample wr =new ReadSingleEventExample();
	@GetMapping("/lire/{id}")
	 public String authenticateUser(@PathVariable int id) {  
		 return wr.lire(id);
	}
	@GetMapping("/lire/all")
	 public void authenticateUser0() {
		for(int i=9;i<24;i++) {
			 wr.lire(i);
		}
		 
	}

}