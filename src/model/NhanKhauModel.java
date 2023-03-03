package model;

import java.util.Date;

public class NhanKhauModel {
    private int maNhanKhau;
    private String tenNhanKhau, gioiTinh, soDienThoai, canCuocCongDan, queQuan, danToc, quocTich, ngaySinh ; 
	
    public NhanKhauModel() {
		
	}

	public NhanKhauModel(int maNhanKhau, String tenNhanKhau, String gioiTinh, String ngaySinh,String soDienThoai, String canCuocCongDan,
			String queQuan, String danToc, String quocTich ) {
		
		this.maNhanKhau = maNhanKhau;
		this.tenNhanKhau = tenNhanKhau;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.canCuocCongDan = canCuocCongDan;
		this.queQuan = queQuan;
		this.danToc = danToc;
		this.quocTich = quocTich;
		this.ngaySinh = ngaySinh;
	}

	public int getMaNhanKhau() {
		return maNhanKhau;
	}

	public void setMaNhanKhau(int maNhanKhau) {
		this.maNhanKhau = maNhanKhau;
	}

	public String getTenNhanKhau() {
		return tenNhanKhau;
	}

	public void setTenNhanKhau(String tenNhanKhau) {
		this.tenNhanKhau = tenNhanKhau;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getCanCuocCongDan() {
		return canCuocCongDan;
	}

	public void setCanCuocCongDan(String canCuocCongDan) {
		this.canCuocCongDan = canCuocCongDan;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		return "NhanKhau [maNhanKhau=" + maNhanKhau + ", tenNhanKhau=" + tenNhanKhau + ", gioiTinh=" + gioiTinh
				+ ", soDienThoai=" + soDienThoai + ", canCuocCongDan=" + canCuocCongDan + ", queQuan=" + queQuan
				+ ", danToc=" + danToc + ", quocTich=" + quocTich + ", thuocHoKhau=" + ", ngaySinh="
				+ ngaySinh + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canCuocCongDan == null) ? 0 : canCuocCongDan.hashCode());
		result = prime * result + ((danToc == null) ? 0 : danToc.hashCode());
		result = prime * result + ((gioiTinh == null) ? 0 : gioiTinh.hashCode());
		result = prime * result + maNhanKhau;
		result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
		result = prime * result + ((queQuan == null) ? 0 : queQuan.hashCode());
		result = prime * result + ((quocTich == null) ? 0 : quocTich.hashCode());
		result = prime * result + ((soDienThoai == null) ? 0 : soDienThoai.hashCode());
		result = prime * result + ((tenNhanKhau == null) ? 0 : tenNhanKhau.hashCode());
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
		NhanKhauModel other = (NhanKhauModel) obj;
		if (canCuocCongDan == null) {
			if (other.canCuocCongDan != null)
				return false;
		} else if (!canCuocCongDan.equals(other.canCuocCongDan))
			return false;
		if (danToc == null) {
			if (other.danToc != null)
				return false;
		} else if (!danToc.equals(other.danToc))
			return false;
		if (gioiTinh == null) {
			if (other.gioiTinh != null)
				return false;
		} else if (!gioiTinh.equals(other.gioiTinh))
			return false;
		if (maNhanKhau != other.maNhanKhau)
			return false;
		if (ngaySinh == null) {
			if (other.ngaySinh != null)
				return false;
		} else if (!ngaySinh.equals(other.ngaySinh))
			return false;
		if (queQuan == null) {
			if (other.queQuan != null)
				return false;
		} else if (!queQuan.equals(other.queQuan))
			return false;
		if (quocTich == null) {
			if (other.quocTich != null)
				return false;
		} else if (!quocTich.equals(other.quocTich))
			return false;
		if (soDienThoai == null) {
			if (other.soDienThoai != null)
				return false;
		} else if (!soDienThoai.equals(other.soDienThoai))
			return false;
		if (tenNhanKhau == null) {
			if (other.tenNhanKhau != null)
				return false;
		} else if (!tenNhanKhau.equals(other.tenNhanKhau))
			return false;
		
				return false;
		
		
	}
    
    
}
