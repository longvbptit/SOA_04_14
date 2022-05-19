package Entity.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "dondangky")
public class DonDangKy implements Serializable {
	private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDon;
	
	
	private String thoigian;
	private Long soLuong;
	private String status;
	
	private Integer idbenhvien;
	@ManyToOne
	@JoinColumn(name = "idbenhvien", insertable = false, updatable = false)
	private BenhVien benhVien;
	
	private Integer idoxy;
	@ManyToOne
	@JoinColumn(name = "idoxy", insertable = false, updatable = false)
	private Oxy oxy;
	
	
}
