package com.election.validators;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.election.domain.Person;

@Component
public class IdNumberValidator implements Validator {

	private Logger log = LoggerFactory.getLogger(PeselValidator.class);

	@Override
	public void validate(Object target, Errors errors) {

		Person person = (Person) target;

		if (person != null && person.getIdNumber() != null) {

			if (person.getIdNumber().matches("[A-Za-z]{3}\\d{6}")) {

				Map<Character, Integer> legend = new HashMap();
				/*-  a-> 10, z->35, 26 elementów */
				legend.put('a', 10);
				legend.put('b', 11);
				legend.put('c', 12);
				legend.put('d', 13);
				legend.put('e', 14);
				legend.put('f', 15);
				legend.put('g', 16);
				legend.put('h', 17);
				legend.put('i', 18);
				legend.put('j', 19);
				legend.put('k', 20);
				legend.put('l', 21);
				legend.put('m', 22);
				legend.put('n', 23);
				legend.put('o', 24);
				legend.put('p', 25);
				legend.put('q', 26);
				legend.put('r', 27);
				legend.put('s', 28);
				legend.put('t', 29);
				legend.put('u', 30);
				legend.put('v', 31);
				legend.put('w', 32);
				legend.put('x', 33);
				legend.put('y', 34);
				legend.put('z', 35);

				for (Character key : legend.keySet()) {

					log.info(key + " - " + legend.get(key));
				}

				Boolean isValid = checkControlNumber(person.getIdNumber(), legend);

				if (!isValid) {
					errors.rejectValue("idNumber", "wrongControlNumber");
				}

				/*
				 * String start = "a";
				 * 
				 * Integer startAsNumber = Integer.parseInt(start);
				 * 
				 * String back = startAsNumber.toString();
				 * 
				 * for(int i = 0; i < 26; i++ ){ startAsNumber += i;
				 * 
				 * 
				 * legend.put((startAsNumber).toString(), i+10); }
				 * 
				 * - test for(String key: legend.keySet())
				 * 
				 * log.info(key + " - " + legend.get(key));
				 */

			}
		}

	}

	public Boolean checkControlNumber(String idNumber, Map<Character, Integer> legend) {

		int sum = 0;
		int[] weigth = { 7, 3, 1, 7, 3, 1, 7, 3 };

		/*- dla pierwszych trzech liter */
		for (int i = 0; i < 3; i++) {
			char c = idNumber.charAt(i);
			sum += weigth[i] * legend.get(c);

		}

		int controlNumber = Character.getNumericValue(idNumber.charAt(3)); // konwersja
																			// ?

		for (int i = 4; i < idNumber.length(); i++) {
			int c = Character.getNumericValue(idNumber.charAt(i));
			sum += weigth[i - 1] * c;

		}

		log.info("suma kontrolna wynosi: " + sum);

		sum %= 10;
		log.info("suma kontrolna wynosi po modulo : " + sum);

		if (controlNumber == sum) {
			return true;
		} else {

			return false;
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

}
