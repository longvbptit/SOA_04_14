package dondangkyservice.controller;

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


import dondangkyservice.service.DonDangKyService;
import dondangkyservice.model.DonDangKy;

@RestController
@RequestMapping(path = "/", produces = "application/json;charset=UTF-8")
public class DonDangKyController {
	@Autowired
	private DonDangKyService donDangKyService;
	
	@PostMapping(value = "/dondangky/them")
	public void add(@RequestBody DonDangKy donDangKy) {
		donDangKyService.saveDon(donDangKy);
	}
	
	

}
