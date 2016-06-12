package com.election.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp="\\d{11}")
	private String peselNumber;
	
	@Column(unique = true)
	@Size(min = 9, max = 9)
	@Pattern(regexp="[A-Za-z]{3}\\d{6}")
	/*- może lepiej jednak po odebraniu danych uwzględniać wielkość znaków i automatycznie zamieniać na małe, żeby nie było podwójnej wartości klucza */
	@NotBlank
	private String idNumber;

}
