package dev.abhinav.spring.samples.jpaSampleApplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * This entity class corresponds to a table with the following
 * create table statement
 * CREATE TABLE passengers (
    passenger_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    passenger_name VARCHAR(200) NOT NULL,
    gender ENUM('MALE', 'FEMALE', 'DO_NOT_WISH_T0_SPECIFY') NOT NULL,
    pnr VARCHAR(32)
);
 * @author abhinav
 *
 */
@Getter
@Setter
@Entity
@Table(name="passengers")
public class Passenger 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="passenger_id")
	Integer passengerId;
	
	@Column(name="passenger_name")
	String passengerName;
	
	@Column(name="pnr")
	String pnr;
	
	//you defined an enum of type gender in a specific way.
	@Enumerated(EnumType.STRING)
	Gender gender;
	
}

