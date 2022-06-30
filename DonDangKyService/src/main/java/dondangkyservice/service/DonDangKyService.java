package dondangkyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dondangkyservice.repository.DonDangKyRepository;
import dondangkyservice.model.DonDangKy;

@Service
public class DonDangKyService {
	@Autowired
	private DonDangKyRepository donDangKyRepository;

	public List<DonDangKy> listAll(){
		return donDangKyRepository.findAll();
	}
	
	public void saveDon(DonDangKy donDangKy) {
		donDangKyRepository.save(donDangKy);
	}
	
//	public List<Oxy> getLichKhamByIdBenhnhan(Integer id) {
//		return oxyRepository.findLichKhamByIdBenhnhan(id);
//		
//	}
	
	
}
