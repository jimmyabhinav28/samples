package dev.abhinav.spring.samples.jpaSampleApplication.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.spring.samples.jpaSampleApplication.entities.Passenger;
import dev.abhinav.spring.samples.jpaSampleApplication.repositories.PassengerRepository;
import dev.abhinav.spring.samples.jpaSampleApplication.repositories.RoutesRepository;
import dev.abhinav.spring.samples.jpaSampleApplication.repositories.StationsRepository;
import dev.abhinav.spring.samples.jpaSampleApplication.repositories.TrainsRepository;

@RestController
public class JPADemoController
{
	@Autowired
	TrainsRepository trainsRepository;
	
	@Autowired
	StationsRepository stationsRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	RoutesRepository routesRepository;
	
	@GetMapping(path="/getPassenger")
	public Passenger getPassengerById(@RequestParam Map<String,String> allQueryParameters)
	{
		String idString=allQueryParameters.get("passengerId");
		Integer id= Integer.parseInt(idString);
		Optional<Passenger> passengersById=passengerRepository.findById(id);
		if(passengersById!=null)
			return passengersById.get();
		return null;
	}
}
