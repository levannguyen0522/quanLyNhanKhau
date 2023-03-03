package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import database.JDBCUtil;
import model.HoKhauModel;
import model.NhanKhauModel;

public class HoKhauDAO implements DAOInterface<HoKhauModel> {
	public static HoKhauDAO getInstance() {
		return new HoKhauDAO();
	}

	@Override
	public int insert(HoKhauModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			String sql = "INSERT INTO quanlyhokhau (maHoKhau, tenChuHo, diaChiThuongTru, ngayCap) "+
						" VALUES ('"+t.getMaHoKhau()+"' "
								+ ", '"+t.getTenChuHo()+"' "
								+ ", '"+t.getDiaChiThuongTru()+"' "
								+ ", '"+t.getNgayCap()+"')";

			ketQua = st.executeUpdate(sql);
			
			// Bước 4:  sử lí kết quả đầu ra
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5: ngắt kết nối với CSDL
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int update(HoKhauModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE hokhau "+
						 " SET " +
						 " tenChuHo='"+ t.getTenChuHo()+"'"
						 +", diaChiThuongTru='"+ t.getDiaChiThuongTru()+"'"
		 				 +", ngayCap='"+ t.getNgayCap()+"'"
						 +" WHERE maHoKhau='"+t.getMaHoKhau()+"\'";
			
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	@Override
	public int delete(HoKhauModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from quanlyhokhau " + "WHERE maHoKhau = '" + t.getMaHoKhau() + "'";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<HoKhauModel> selectAll() {
		ArrayList<HoKhauModel> ketQua = new ArrayList<HoKhauModel>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM hokhau";
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maHoKhau = rs.getInt("maHoKhau");
				String tenChuHo = rs.getString("tenChuHo");
				String diaChiThuongTru = rs.getString("diaChiThuongTru");
				String ngayCap = rs.getString("ngayCap");
				
				HoKhauModel hokhau = new HoKhauModel(maHoKhau, tenChuHo, diaChiThuongTru, ngayCap);
				ketQua.add(hokhau);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public HoKhauModel selectById(HoKhauModel t) {
		HoKhauModel ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nhankhau WHERE maHoKhau = '" + t.getMaHoKhau() + "'";
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maHoKhau = rs.getInt("maHoKhau");
				String tenChuHo = rs.getString("tenChuHo");
				String diaChiThuongTru = rs.getString("diaChiThuongTru");
				String ngayCap = rs.getString("ngayCap");
				
				HoKhauModel hokhau = new HoKhauModel(maHoKhau, tenChuHo, diaChiThuongTru, ngayCap);
				
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<HoKhauModel> selectByCondition(String condition) {
		ArrayList<HoKhauModel> ketQua = new ArrayList<HoKhauModel>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM hokhau WHERE " + condition;
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maHoKhau = rs.getInt("maHoKhau");
				String tenChuHo = rs.getString("tenChuHo");
				String diaChiThuongTru = rs.getString("diaChiThuongTru");
				String ngayCap = rs.getString("ngayCap");
				
				HoKhauModel hokhau = new HoKhauModel(maHoKhau, tenChuHo, diaChiThuongTru, ngayCap);
				ketQua.add(hokhau);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
