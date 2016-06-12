package com.election.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.election.domain.Person;
import com.election.repositories.PersonRepository;

@Service
public class PersonService {
	
	private Logger log = LoggerFactory.getLogger(PersonService.class);

	
	@Autowired
	private PersonRepository personRepository;
	
	public Person findById(Integer id)
	{
		Person person  = personRepository.findById(id);
		return person;
	}
	
	
	public void saveTestObject(Person person)
	{
		log.info("saving person: " + person.toString());
		personRepository.save(person);
	}
	
}
