package dev.abhinav.spring.samples.jpaSampleApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.spring.samples.jpaSampleApplication.entities.Routes;


public interface RoutesRepository extends JpaRepository<Routes, Integer> 
{

}
