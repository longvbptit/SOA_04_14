package oxyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import oxyservice.model.Oxy;

public interface OxyRepository extends JpaRepository<Oxy, Integer> {
	
}
