package RentOxy.model;

import java.sql.Date;

import lombok.Data;

@Data
public class DonDangKy {
	private String thoigian;
	private int soLuong;
	private String status;
	private Integer idbenhvien;
	private Integer idoxy;
}
