package RentOxy.controller;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import RentOxy.model.BenhVien;
import RentOxy.model.DataOxy;
import RentOxy.model.DonDangKy;
import RentOxy.model.Oxy;

@RestController
@RequestMapping(path = "/", produces = "application/json;charset=UTF-8")
public class DangKyThueOxyController {

	private RestTemplate rest = new RestTemplate();

	@PostMapping("/donDangKy")
	public ResponseEntity<DataOxy> start(@RequestBody DataOxy dataOxy){
		
		DataOxy result = dataOxy;
		DonDangKy donDangKy = new DonDangKy();
		List<BenhVien> bvList = Arrays.asList(rest.getForObject("http://localhost:8026/benhvien", BenhVien[].class));
		int check = 0;
		BenhVien benhVien1 = new BenhVien();
		for(BenhVien bVien : bvList) {
			if(result.getMaBV().equals(bVien.getMabv())) {
				List<Oxy> oxyList = Arrays.asList(rest.getForObject("http://localhost:8025/oxy", Oxy[].class));
				benhVien1 = bVien;
				for(Oxy oxy : oxyList) {
					if(result.getSoLuongOxy() <= oxy.getSoLuong()) {
						check = 1;
						//tao xac nhan dang ky
						
						Date date = Calendar.getInstance().getTime();  
						Calendar c = Calendar.getInstance(); 
						c.setTime(date); 
						c.add(Calendar.DATE, 3);
						date = c.getTime();
				
		                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		                String strDate = dateFormat.format(date); 
		                
						
						donDangKy.setIdbenhvien(bVien.getIdbenhvien());
						donDangKy.setIdoxy(oxy.getIdoxy());
						donDangKy.setSoLuong(result.getSoLuongOxy());
						donDangKy.setStatus("Chua giao");
						donDangKy.setThoigian(strDate);
						
						oxy.setSoLuong(oxy.getSoLuong() - result.getSoLuongOxy());
						rest.put("http://localhost:8025/oxy/capnhat", oxy);
						rest.postForObject("http://localhost:8027/dondangky/them", donDangKy, DonDangKy.class);
						
					} else {
						check = 2;
					}
				
				}
			}
		}
		
		if(check == 1) {
			List<String> mail = new ArrayList<>();
			mail.add(benhVien1.getMail());
			mail.add("Đơn xác nhận thành công");
			mail.add("Xác nhận đăng ký thuê Oxy thành công của " + benhVien1.getTenbv() + 
					" với số lượng bình Oxy là: " + donDangKy.getSoLuong() 
					+ "\nNgày nhận dự kiến: " + donDangKy.getThoigian());
		
			rest.postForObject("http://localhost:8089/notify", mail, String.class);
		} else if(check == 2) {
			List<String> mail = new ArrayList<>();
			mail.add(benhVien1.getMail());
			mail.add("Đăng ký không thành công");
			mail.add("Đăng ký thuê Oxy của "+ benhVien1.getTenbv() + " không thành công\n"  + 
					"Nguyên nhân: Số lượng bình Oxy không đủ");
			rest.postForObject("http://localhost:8089/notify", mail, String.class);
		} else {
			return null;
		}

		return new ResponseEntity<DataOxy>(result, HttpStatus.OK);
	}
}
