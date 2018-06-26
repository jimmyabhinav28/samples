package dev.abhinav.spring.samples.jpaSampleApplication.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/** Entity class that corresponds to the table with the folllowing definition
 * CREATE TABLE routes (
    route_id INT(10) AUTO_INCREMENT PRIMARY KEY,
    route_name VARCHAR(100) NOT NULL,
    direction ENUM('UP', 'DOWN') NOT NULL
);
 * @author abhinav
 *
 */

@Getter
@Setter
@Entity
@Table(name="routes")
public class Routes 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="route_id")
	Integer routeId;
	
	@Column(name="route_name")
	String routeName;
	
	@Enumerated(EnumType.STRING)
	RouteDirection direction;
	
	//Note that we defined a bidirectional relationship between 
	//Routes and trains. Since the relation from route->train is one-to-many
	//the table related to this entity will not have a column for train
	//hence you do not need a @JoinColumn here! Pretty easy to understand, eh! ;)
	
	@JsonManagedReference
	@OneToMany(mappedBy="route") //the field in the many side referring to this entity. This is absolutely necessary
								//In absence of mappedBy hibernate forms query by assuming that an association table exists
	List<Trains> trains;
	
	//Lets make route as the owner side of the relationship
	//the owner side will specify the association table
	//and the join and inverse join attributes in the association table
	//which attribute to make the join attribute and which attribute to make
	//the inverse join attribute??
	//the attribute referring to the owner side of the relationship will be
	//the join attribute
	//the other attribute will become the inverse join attribute
	
	@JsonManagedReference //necessary to resolve the circular reference in JSON conversion.
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="station_route_mapping", joinColumns= {@JoinColumn(name="route_id")},inverseJoinColumns= {@JoinColumn(name="station_id")})
	private Set<Stations> stationsInThisRoute;
	
	
	
}
