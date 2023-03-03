package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import database.JDBCUtil;
import model.NhanKhauModel;

public class NhanKhauDAO implements DAOInterface<NhanKhauModel> {
	public static NhanKhauDAO getInstance() {
		return new NhanKhauDAO();
	}

	@Override
	public int insert(NhanKhauModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			String sql = "INSERT INTO nhankhau (maNhanKhau, tenNhanKhau, gioiTinh, ngaySinh, soDienThoai, canCuocCongDan, queQuan, danToc, quocTich) "+
						" VALUES ('"+t.getMaNhanKhau()+"' "
								+ ", '"+t.getTenNhanKhau()+"' "
								+ ", '"+t.getGioiTinh()+"' "
								+ ", '"+t.getNgaySinh()+"' "
								+ ", '"+t.getSoDienThoai()+"' "
								+ ", '"+t.getCanCuocCongDan()+"' "
								+ ", '"+t.getQueQuan()+"' "
								+ ", '"+t.getDanToc()+"' "
								+ ", '"+t.getQuocTich()+"')";

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
	public int update(NhanKhauModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE nhankhau "+
						 " SET " +
						 " tenNhanKhau='"+ t.getTenNhanKhau()+"'"
						 +", gioiTinh='"+ t.getGioiTinh()+"'"
		 				 +", ngaySinh='"+ t.getNgaySinh()+"'"
		 				 +", soDienThoai='"+ t.getSoDienThoai()+"'"
						 +", canCuocCongdan='"+ t.getCanCuocCongDan()+ "'"
						 +", queQuan='"+ t.getQueQuan()+ "'"
						 +", danToc='"+ t.getDanToc()+ "'"
						 +", quocTich='"+ t.getQuocTich()+ "'"
						 +" WHERE maNhanKhau='"+t.getMaNhanKhau()+"\'";
			
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
	public int delete(NhanKhauModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from nhankhau " + "WHERE maNhanKhau = '" + t.getMaNhanKhau() + "'";
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
	public ArrayList<NhanKhauModel> selectAll() {
		ArrayList<NhanKhauModel> ketQua = new ArrayList<NhanKhauModel>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nhankhau";
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maNhanKhau = rs.getInt("maNhanKhau");
				String tenNhanKhau = rs.getString("tenNhanKhau");
				String gioiTinh = rs.getString("gioiTinh");
				String ngaySinh = rs.getString("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				String canCuocCongDan = rs.getString("canCuocCongDan");
				String queQuan = rs.getString("queQuan");
				String danToc = rs.getString("danToc");
				String quocTich = rs.getString("quocTich");
				
				NhanKhauModel nhankhau = new NhanKhauModel(maNhanKhau, tenNhanKhau, gioiTinh, ngaySinh, soDienThoai, canCuocCongDan, queQuan, danToc, quocTich);
				ketQua.add(nhankhau);
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
	public NhanKhauModel selectById(NhanKhauModel t) {
		NhanKhauModel ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nhankhau WHERE maNhanKhau = '" + t.getMaNhanKhau() + "'";
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maNhanKhau = rs.getInt("maNhanKhau");
				String tenNhanKhau = rs.getString("tenNhanKhau");
				String gioiTinh = rs.getString("gioiTinh");
				String ngaySinh = rs.getString("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				String canCuocCongDan = rs.getString("canCuocCongDan");
				String queQuan = rs.getString("queQuan");
				String danToc = rs.getString("danToc");
				String quocTich = rs.getString("quocTich");
				
				NhanKhauModel nhankhau = new NhanKhauModel(maNhanKhau, tenNhanKhau, gioiTinh, ngaySinh, soDienThoai, canCuocCongDan, queQuan, danToc, quocTich);
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
	public ArrayList<NhanKhauModel> selectByCondition(String condition) {
		ArrayList<NhanKhauModel> ketQua = new ArrayList<NhanKhauModel>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM nhankhau WHERE " + condition;
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maNhanKhau = rs.getInt("maNhanKhau");
				String tenNhanKhau = rs.getString("tenNhanKhau");
				String gioiTinh = rs.getString("gioiTinh");
				String ngaySinh = rs.getString("ngaySinh");
				String soDienThoai = rs.getString("soDienThoai");
				String canCuocCongDan = rs.getString("canCuocCongDan");
				String queQuan = rs.getString("queQuan");
				String danToc = rs.getString("danToc");
				String quocTich = rs.getString("quocTich");
				
				NhanKhauModel nhankhau = new NhanKhauModel(maNhanKhau, tenNhanKhau, gioiTinh, ngaySinh, soDienThoai, canCuocCongDan, queQuan, danToc, quocTich);
				ketQua.add(nhankhau);
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
