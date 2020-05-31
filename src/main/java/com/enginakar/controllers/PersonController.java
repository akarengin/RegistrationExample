package com.enginakar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.enginakar.models.Person;
import com.enginakar.services.PersonService;

@Controller
public class PersonController {
	@Autowired
	PersonService service;

	@GetMapping("/registration")
	public String homePage() {
		return "welcome";
	}

	@GetMapping("/enroll")
	public String login() {
		return "form";
	}

	@PostMapping(path = "/People", consumes = { "application/x-www-form-urlencoded" })
	public String addPerson(Person person) {
		service.addPerson(person);
		return "feedBack";
	}
	@GetMapping("/People")
	public ModelAndView findPeople() {
		List<Person> list = service.getPerson();
		ModelAndView mv = new ModelAndView("retrieve");
		mv.addObject("list", list);
		return mv;
	}
}
