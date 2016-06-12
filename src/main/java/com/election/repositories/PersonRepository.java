package com.election.repositories;
import org.springframework.data.repository.CrudRepository;

import com.election.domain.Person;


public interface PersonRepository  extends CrudRepository<Person, Integer>{
	
	Person findById(Integer id);
	
}
