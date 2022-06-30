package dondangkyservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dondangkyservice.model.DonDangKy;

public interface DonDangKyRepository extends JpaRepository<DonDangKy, Integer> {
//	@Query("SELECT lich FROM LichKham lich WHERE lich.idbenhnhan = ?1")
//	public List<Oxy> findLichKhamByIdBenhnhan(Integer id);
	
}