package com.enginakar.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginakar.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	
}
