package oxyservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oxyservice.repository.OxyRepository;
import oxyservice.model.Oxy;

@Service
@Transactional
public class OxyService {

	@Autowired
	private OxyRepository oxyRepository;
	
	public List<Oxy> findAll(){
		return oxyRepository.findAll();
	}
	
	public Oxy getOxy(Integer id) {
		return oxyRepository.findById(id).get();
		
	}

	public void saveOxy(Oxy oxy) {
		oxyRepository.save(oxy);
	}
	
}
