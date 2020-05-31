package com.enginakar.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.enginakar.models.Person;
import com.enginakar.repos.PersonRepository;
import com.enginakar.services.PersonService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RegistrationExampleTest {
	@Mock
	private PersonRepository repo;
	
	@InjectMocks
	private PersonService service;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Order(1)
	public void addPerson() {
		Person person = new Person(1, "Frank", "frank@mail.com");
		Person testPerson = service.addPerson(person);
		assertThat(testPerson, is(person));
		assertThat(testPerson).extracting(Person::getId).isEqualTo(1);
		assertThat(testPerson).extracting(Person::getName).isEqualTo("Frank");
		assertThat(testPerson).extracting(Person::getEmail).isEqualTo("frank@mail.com");
		verify(repo, times(1)).save(person);
	}
	
	@Test
	@Order(2)
	public void getPerson() {
		Person person1 = new Person(1, "Jack", "jack@mail.com");
		Person person2 = new Person(2, "Emily", "emily@mail.com");
		when(repo.findAll()).thenReturn(Arrays.asList(person1, person2));
		assertThat(service.getPerson().size(), is(2));
		assertThat(service.getPerson().get(0), is(person1));
		assertThat(service.getPerson().get(1), is(person2));
		verify(repo, times(3)).findAll();
	}

	
}