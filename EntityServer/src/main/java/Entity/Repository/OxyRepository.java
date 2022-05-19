package Entity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.model.Oxy;

public interface OxyRepository extends JpaRepository<Oxy, Integer> {
	
}
