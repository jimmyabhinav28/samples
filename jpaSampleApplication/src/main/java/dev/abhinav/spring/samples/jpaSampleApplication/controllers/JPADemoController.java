package dev.abhinav.spring.samples.jpaSampleApplication.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.spring.samples.jpaSampleApplication.entities.Passenger;
import dev.abhinav.spring.samples.jpaSampleApplication.entities.Routes;
import dev.abhinav.spring.samples.jpaSampleApplication.entities.Stations;
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
	
	@GetMapping(path="/getRoute")
	public Routes getRouteById(@RequestParam Map<String,String> allQueryParameters)
	{
		String idString=allQueryParameters.get("routeId");
		Integer id= Integer.parseInt(idString);
		if(id!=null && id.intValue()>0)
			return routesRepository.findById(id).get();
		return null;
	}
	
	@GetMapping(path="/getStation")
	public Stations getStationById(@RequestParam Map<String,String> allQueryParameters)
	{
		String idString=allQueryParameters.get("stationId");
		Integer id= Integer.parseInt(idString);
		if(id!=null && id.intValue()>0)
			{
				Stations toreturn=stationsRepository.findById(id).get();
				if(toreturn!=null)
					{
						System.out.println("routes crossing  this station"+toreturn.getRoutesCrossinThisStation().size());
						for(Routes r: toreturn.getRoutesCrossinThisStation())
						{
							System.out.println("route id"+ r.getRouteId());
						}
					}
				return toreturn;
			}
		return null;
	}
	
	@GetMapping(path="/isRouteAvailable")
	public Routes isRouteAvailableBetweenTwoStations(@RequestParam Map<String,String> allQueryParameters)
	{
		Routes commonRoute=null;
		Integer stationId1=Integer.parseInt(allQueryParameters.get("stationId1"));
		Integer stationId2=Integer.parseInt(allQueryParameters.get("stationId2"));
		
		Stations station1=stationsRepository.findById(stationId1).get();
		Stations station2=stationsRepository.findById(stationId2).get();
		
		//check if there is a routeId common to the two stations
		
		for(Routes r: station1.getRoutesCrossinThisStation())
		{
			if(station2.getRoutesCrossinThisStation().contains(r))
			{
				commonRoute=r;
				break;
			}
		}
		return commonRoute;
	}
}
