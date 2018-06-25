package dev.abhinav.spring.samples.jpaSampleApplication.entities;

/**
 * Enum for the passenger table
 * 
 * gender ENUM('MALE', 'FEMALE', 'DO_NOT_WISH_T0_SPECIFY')
 * 
 * @author abhinav
 *
 */
public enum Gender 
{
	
	
	MALE("MALE"),
	FEMALE("FEMALE"),
	UNDISCLOSED("DO_NOT_WISH_T0_SPECIFY"); //note the semicolon which ends this
	
	//this constructor had be necessarily declared in the end. Why??
	//this constructor is implicity private and no other access specifier will
	//work. It will be a compile time error
	
	Gender(String gender)
	{
	}
}
