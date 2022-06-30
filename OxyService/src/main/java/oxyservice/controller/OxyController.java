package oxyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oxyservice.service.OxyService;
import oxyservice.repository.OxyRepository;
import oxyservice.model.Oxy;

@RestController
@RequestMapping(path = "/", produces = "application/json")
public class OxyController {
	
	@Autowired
	private OxyService oxyService;
	
	@GetMapping("/oxy")
	public List<Oxy> getOxy() {
//		System.out.println("acc" + oxyService.findAll().get(0).);
		return oxyService.findAll();
	}
	
	@GetMapping("/oxy/{id}")
	public ResponseEntity<Oxy> getOxy(@PathVariable Integer id) {
		try {
			Oxy oxy = oxyService.getOxy(id);
			return new ResponseEntity<Oxy>(oxy, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Oxy>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/oxy/capnhat")
	public ResponseEntity<?> update(@RequestBody Oxy oxy) {
		try {
			Oxy oxy1 = oxyService.getOxy(1);
			oxyService.saveOxy(oxy);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
