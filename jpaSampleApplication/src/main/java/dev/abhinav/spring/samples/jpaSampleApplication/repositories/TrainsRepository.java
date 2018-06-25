package dev.abhinav.spring.samples.jpaSampleApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhinav.spring.samples.jpaSampleApplication.entities.Trains;

public interface TrainsRepository extends JpaRepository<Trains, Integer>
{

}
