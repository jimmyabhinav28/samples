package dev.abhinav.spring.samples.jpaSampleApplication.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

/**
 * This entity corresponds to the table with the given definition
 * 
 * CREATE TABLE stations (
    station_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(100) NOT NULL,
    number_of_platforms INT(2) NOT NULL
);

 * @author abhinav
 *
 */
@Getter
@Setter
@Entity
@Table(name="stations")
public class Stations 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="station_id")
	Integer stationId;
	
	@Column(name="station_name")
	String stationName;
	
	@Column(name="number_of_platforms")
	Integer numberOfPlatforms;
	
	//stations is the inverse entity in the many to many relationship between Stations and route
	@JsonBackReference
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE},mappedBy="stationsInThisRoute")
	private Set<Routes> routesCrossinThisStation;
}
