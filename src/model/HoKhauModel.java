package model;

import java.util.ArrayList;
import java.util.Date;

public class HoKhauModel {
      private int maHoKhau;
      private String tenChuHo;
      private String diaChiThuongTru, ngayCap;
   
	public HoKhauModel(int maHoKhau, String tenChuHo, String diaChiThuongTru, String ngayCap) {
		super();
		this.maHoKhau = maHoKhau;
		this.tenChuHo = tenChuHo;
		this.diaChiThuongTru = diaChiThuongTru;
		this.ngayCap = ngayCap;
	}
	public int getMaHoKhau() {
		return maHoKhau;
	}
	public void setMaHoKhau(int maHoKhau) {
		this.maHoKhau = maHoKhau;
	}
	public String getTenChuHo() {
		return tenChuHo;
	}
	public void setTenChuHo(String tenChuHo) {
		this.tenChuHo = tenChuHo;
	}
	public String getDiaChiThuongTru() {
		return diaChiThuongTru;
	}
	public void setDiaChiThuongTru(String diaChiThuongTru) {
		this.diaChiThuongTru = diaChiThuongTru;
	}
	public String getNgayCap() {
		return ngayCap;
	}
	public void setNgayCap(String ngayCap) {
		this.ngayCap = ngayCap;
	}
	@Override
	public String toString() {
		return "HoKhau [maHoKhau=" + maHoKhau + ", tenChuHo=" + tenChuHo + ", diaChiThuongTru=" + diaChiThuongTru
				+ ", ngayCap=" + ngayCap + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaChiThuongTru == null) ? 0 : diaChiThuongTru.hashCode());
		result = prime * result + maHoKhau;
		result = prime * result + ((ngayCap == null) ? 0 : ngayCap.hashCode());
		result = prime * result + ((tenChuHo == null) ? 0 : tenChuHo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoKhauModel other = (HoKhauModel) obj;
		if (diaChiThuongTru == null) {
			if (other.diaChiThuongTru != null)
				return false;
		} else if (!diaChiThuongTru.equals(other.diaChiThuongTru))
			return false;
		if (maHoKhau != other.maHoKhau)
			return false;
		if (ngayCap == null) {
			if (other.ngayCap != null)
				return false;
		} else if (!ngayCap.equals(other.ngayCap))
			return false;
		if (tenChuHo == null) {
			if (other.tenChuHo != null)
				return false;
		} else if (!tenChuHo.equals(other.tenChuHo))
			return false;
		return true;
	}
      
	
	
      
}
