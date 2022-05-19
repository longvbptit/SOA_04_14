package Entity.Controller;

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

import Entity.Service.BenhVienService;
import Entity.model.BenhVien;

@RestController
@RequestMapping(path = "/", produces = "application/json;charset=UTF-8")
public class BenhvienController {
	
	@Autowired
	private BenhVienService benhVienService;

	
	@GetMapping("/benhvien")
	public List<BenhVien> list(){
		return benhVienService.listAll();
	}
	
	@GetMapping("/benhvien/{id}")
	public ResponseEntity<BenhVien> getBenhVien(@PathVariable Integer id) {
		try {
			BenhVien benhVien = benhVienService.getBenhVien(id);
			return new ResponseEntity<BenhVien>(benhVien, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BenhVien>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/benhvien")
	public void add(@RequestBody BenhVien benhVien) {
		benhVienService.saveBenhVien(benhVien);
	}
	
	@PutMapping("/benhvien/{id}")
	public ResponseEntity<?> update(@RequestBody BenhVien benhVien, @PathVariable Integer id) {
		try {
			BenhVien extBenhVien = benhVienService.getBenhVien(id);
			benhVienService.saveBenhVien(benhVien);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}
