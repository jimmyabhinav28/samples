package dev.abhinav.spring.samples.jpaSampleApplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

/**
 * This class corresponds to the table defined with the following create table
 * 
 * CREATE TABLE trains (
    train_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    train_name VARCHAR(100) NOT NULL,
    route_id INT(10) NOT NULL REFERENCES route (route_id),
    number_of_coaches INT(3)
);
 * @author abhinav
 *
 */
@Getter
@Setter
@Entity
@Table(name="trains")
public class Trains 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="train_id")
	Integer trainId;
	
	@Column(name="train_name")
	String name;
	
	@Column(name="number_of_coaches")
	Integer numberOfCoaches;
	
	//many trains map to a single route.
	//The relation is many-to-one from train->route
	//The relation is one-to-many from route->train
	
	//There is also a concept of direction in JPA.
	//The one i am defining is bidirectional
	//In bidirectional definition of two entities A and B, A will have instance(s)
	//of B and B will have instance(s) of A
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="routeId") //note that we used the entity field  here
	Routes route;
}
