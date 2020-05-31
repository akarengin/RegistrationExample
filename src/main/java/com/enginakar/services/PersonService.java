package com.enginakar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enginakar.models.Person;
import com.enginakar.repos.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repo;
	
	public Person addPerson(Person person) {
		repo.save(person);
		return person;
	}
	
	public List<Person> getPerson(){
		return repo.findAll();
	}
}
