package com.spring5.practice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/index")
	public String hello() {
		return "index";
	}

	@GetMapping("index2")
	public String hello(@RequestParam("name") String name, Model model) {
		model.addAttribute("username", name);
		return "index";
	}

}
