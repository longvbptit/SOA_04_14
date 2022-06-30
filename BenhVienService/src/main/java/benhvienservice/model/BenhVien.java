package benhvienservice.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "benhvien")
public class BenhVien implements Serializable {
//	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idbenhvien;
	private String mabv;
	private String tenbv;
	private String diachi;
	private String sdt;
	private String mail;
//	public String getDiachi() {
//		// TODO Auto-generated method stub
//		return diachi;
//	}
}
