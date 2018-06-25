package dev.abhinav.spring.samples.jpaSampleApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.spring.samples.jpaSampleApplication.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
