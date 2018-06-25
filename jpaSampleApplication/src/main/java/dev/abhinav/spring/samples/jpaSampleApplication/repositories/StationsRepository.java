package dev.abhinav.spring.samples.jpaSampleApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.spring.samples.jpaSampleApplication.entities.Stations;


public interface StationsRepository extends JpaRepository<Stations, Integer> 
{

}
