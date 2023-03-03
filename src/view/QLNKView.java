package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.HoKhauModel;
import model.NhanKhauModel;
import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.Controller_hoKhau;
import controller.Controller_nhanKhau;
import dao.HoKhauDAO;
import dao.NhanKhauDAO;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class QLNKView extends JFrame {

	private JPanel contentPane;

       private JTable table;
       private JTextField textField_maNK;
       private JTextField textField_hoVaTen;
       private JTextField textField_ngaySinh;
       private JTextField textField_soDienThoai;
       private JTextField textField_cCCD;
       private JTextField textField_queQuan;
       private JTextField textField_danToc;
       private JTextField textField_quocTich;
       private JTextField textField_timKiem;
       private JTextField textField_gioiTinh;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNKView frame = new QLNKView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public QLNKView() {

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.loadDataToJTable_nhanKhau();
		ActionListener actionListener = new Controller_nhanKhau(this);
		
		URL urlIcon_NK = QLNKView.class.getResource("icon_NK.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon_NK);
		this.setIconImage(img);
		contentPane.setLayout(null);
		
		JLabel lbl_maNK = new JLabel("Mã Nhân Khẩu ");
		lbl_maNK.setBounds(10, 370, 134, 24);
		lbl_maNK.setForeground(new Color(255, 0, 0));
		lbl_maNK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_maNK);
		
		JLabel lbl_hoVaTen = new JLabel("Họ & Tên");
		lbl_hoVaTen.setBounds(10, 415, 96, 24);
		lbl_hoVaTen.setForeground(new Color(255, 0, 0));
		lbl_hoVaTen.setBackground(new Color(240, 240, 240));
		lbl_hoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_hoVaTen);
		
		JLabel lbl_gioiTinh = new JLabel("Giới Tính");
		lbl_gioiTinh.setBounds(10, 459, 96, 24);
		lbl_gioiTinh.setForeground(new Color(255, 0, 0));
		lbl_gioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_gioiTinh);
		
		JLabel lbl_qLNK_pHX = new JLabel("Quản Lý Nhân Khẩu Phường Hòa Xuân");
		lbl_qLNK_pHX.setBounds(415, 10, 395, 25);
		lbl_qLNK_pHX.setBackground(new Color(0, 0, 255));
		lbl_qLNK_pHX.setForeground(new Color(0, 0, 255));
		lbl_qLNK_pHX.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lbl_qLNK_pHX);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 44, 20, 1);
		contentPane.add(horizontalStrut);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 1166, 1);
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 55, 1166, 230);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setRowHeaderView(scrollPane_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 296, 1166, 1);
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(0, 0, 0));
		contentPane.add(separator_1);
		
		JLabel lbl_thongTinNK = new JLabel("Thông Tin Nhân Khẩu");
		lbl_thongTinNK.setBounds(490, 310, 220, 25);
		lbl_thongTinNK.setForeground(Color.BLUE);
		lbl_thongTinNK.setFont(new Font("Verdana", Font.BOLD, 18));
		lbl_thongTinNK.setBackground(Color.BLUE);
		contentPane.add(lbl_thongTinNK);
		
		textField_maNK = new JTextField();
		textField_maNK.setBounds(145, 365, 135, 30);
		textField_maNK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(textField_maNK);
		textField_maNK.setColumns(10);
		
		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setBounds(145, 405, 135, 30);
		textField_hoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_hoVaTen.setColumns(10);
		contentPane.add(textField_hoVaTen);
		
		JLabel lbl_ngaySinh = new JLabel("Ngày Sinh");
		lbl_ngaySinh.setBounds(324, 370, 96, 24);
		lbl_ngaySinh.setForeground(Color.RED);
		lbl_ngaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_ngaySinh);
		
		JLabel lbl_soDienThoai = new JLabel("Số Điện Thoại");
		lbl_soDienThoai.setBounds(324, 415, 124, 24);
		lbl_soDienThoai.setForeground(Color.RED);
		lbl_soDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_soDienThoai);
		
		JLabel lbl_cCCD = new JLabel("CCCD");
		lbl_cCCD.setBounds(324, 460, 59, 24);
		lbl_cCCD.setForeground(Color.RED);
		lbl_cCCD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_cCCD);
		
		JLabel lbl_queQuan = new JLabel("Quê Quán");
		lbl_queQuan.setBounds(642, 370, 96, 24);
		lbl_queQuan.setForeground(Color.RED);
		lbl_queQuan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_queQuan);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setBounds(450, 365, 135, 30);
		textField_ngaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_ngaySinh.setColumns(10);
		contentPane.add(textField_ngaySinh);
		
		textField_soDienThoai = new JTextField();
		textField_soDienThoai.setBounds(450, 410, 135, 30);
		textField_soDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_soDienThoai.setColumns(10);
		contentPane.add(textField_soDienThoai);
		
		textField_cCCD = new JTextField();
		textField_cCCD.setBounds(450, 450, 135, 30);
		textField_cCCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_cCCD.setColumns(10);
		contentPane.add(textField_cCCD);
		
		textField_queQuan = new JTextField();
		textField_queQuan.setBounds(760, 370, 135, 30);
		textField_queQuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_queQuan.setColumns(10);
		contentPane.add(textField_queQuan);
		
		JLabel lbl_danToc = new JLabel("Dân Tộc");
		lbl_danToc.setBounds(642, 413, 124, 24);
		lbl_danToc.setForeground(Color.RED);
		lbl_danToc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_danToc);
		
		JLabel lbl_quocTich = new JLabel("Quốc Tịch\r\n");
		lbl_quocTich.setBounds(642, 458, 124, 24);
		lbl_quocTich.setForeground(Color.RED);
		lbl_quocTich.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_quocTich);
		
		textField_danToc = new JTextField();
		textField_danToc.setBounds(760, 407, 135, 30);
		textField_danToc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_danToc.setColumns(10);
		contentPane.add(textField_danToc);
		
		textField_quocTich = new JTextField();
		textField_quocTich.setBounds(760, 453, 135, 30);
		textField_quocTich.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_quocTich.setColumns(10);
		contentPane.add(textField_quocTich);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(actionListener);
		btn_them.setBounds(603, 520, 135, 45);
		btn_them.setForeground(new Color(255, 0, 0));
		btn_them.setBackground(new Color(255, 255, 255));
		btn_them.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_them.png"))));
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn_them);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(actionListener);
		btn_xoa.setBounds(748, 520, 135, 45);
		btn_xoa.setBackground(new Color(255, 255, 255));
		btn_xoa.setForeground(new Color(255, 0, 0));
		btn_xoa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_xoa.png"))));
		contentPane.add(btn_xoa);
		
		JButton btn_capNhat = new JButton("Cập Nhật");
		btn_capNhat.addActionListener(actionListener);
		btn_capNhat.setBounds(893, 520, 135, 45);
		btn_capNhat.setBackground(new Color(255, 255, 255));
		btn_capNhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_capNhat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_capNhat.png"))));
		btn_capNhat.setForeground(new Color(255, 0, 0));
		contentPane.add(btn_capNhat);
		
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(actionListener);
		btn_thoat.addActionListener(actionListener);
		btn_thoat.setBounds(1038, 520, 135, 45);
		btn_thoat.setBackground(new Color(255, 255, 255));
		btn_thoat.setForeground(new Color(255, 0, 0));
		btn_thoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_thoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_thoat.png"))));
		contentPane.add(btn_thoat);
		
		JLabel lbl_nhapThongTin = new JLabel("Nhập ");
		lbl_nhapThongTin.setBounds(75, 532, 59, 24);
		lbl_nhapThongTin.setForeground(Color.RED);
		lbl_nhapThongTin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lbl_nhapThongTin);
		
		textField_timKiem = new JTextField();
		textField_timKiem.setBounds(145, 529, 135, 30);
		textField_timKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_timKiem.setColumns(10);
		contentPane.add(textField_timKiem);
		
		JButton btn_timKiem = new JButton("Tìm Kiếm");
		btn_timKiem.addActionListener(actionListener);
		btn_timKiem.setBounds(314, 520, 135, 45);
		btn_timKiem.setForeground(Color.RED);
		btn_timKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_timKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_timKiem.png"))));
		btn_timKiem.setBackground(Color.WHITE);
		contentPane.add(btn_timKiem);
		
		textField_gioiTinh = new JTextField();
		textField_gioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_gioiTinh.setColumns(10);
		textField_gioiTinh.setBounds(145, 453, 135, 30);
		contentPane.add(textField_gioiTinh);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(10, 494, 1166, 1);
		contentPane.add(separator_2);
		
		JButton btn_huyTim = new JButton("Hủy Tìm");
		btn_huyTim.addActionListener(actionListener);
		btn_huyTim.setForeground(Color.RED);
		btn_huyTim.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_huyTim.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_huyTim.png"))));
		btn_huyTim.setBackground(Color.WHITE);
		btn_huyTim.setBounds(458, 520, 134, 45);
		contentPane.add(btn_huyTim);
		
//		Sự kiện click chuột trái lên 1 dòng trong JTable
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table.getSelectedRow();
		        textField_maNK.setText(table.getValueAt(selectedRow, 0).toString());
		        textField_hoVaTen.setText(table.getValueAt(selectedRow, 1).toString());
		        textField_gioiTinh.setText(table.getValueAt(selectedRow, 2).toString());
		        textField_ngaySinh.setText(table.getValueAt(selectedRow, 3).toString());
		        textField_soDienThoai.setText(table.getValueAt(selectedRow, 4).toString());
		        textField_cCCD.setText(table.getValueAt(selectedRow, 5).toString());
		        textField_queQuan.setText(table.getValueAt(selectedRow, 6).toString());
		        textField_danToc.setText(table.getValueAt(selectedRow, 7).toString());
		        textField_quocTich.setText(table.getValueAt(selectedRow, 8).toString());
		    }
		});
		
		this.setTitle("Quản Lý Nhân Khẩu Phường Hòa Xuân");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void loadDataToJTable_nhanKhau() {
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/quanlynhankhau";
	    String user = "root";
	    String password = "1";
	    String query = "SELECT * FROM nhankhau ";
	    try {
	      con = DriverManager.getConnection(url, user, password);
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columns = rsmd.getColumnCount();
	      DefaultTableModel dtm = new DefaultTableModel();
	      Vector columns_name = new Vector();
	      Vector data_rows = new Vector();
	      for (int i = 1; i <= columns; i++) {
	        columns_name.addElement(rsmd.getColumnName(i));
	      }
	      columns_name.setElementAt("Mã Nhân Khẩu", 0);
	      columns_name.setElementAt("Họ & Tên Nhân Khẩu", 1);
	      columns_name.setElementAt("Giới Tính", 2);
	      columns_name.setElementAt("Ngày Sinh", 3);
	      columns_name.setElementAt("Số Điện Thoại", 4);
	      columns_name.setElementAt("Căn Cước Công Dân", 5);
	      columns_name.setElementAt("Quê Quán", 6);
	      columns_name.setElementAt("Dân Tộc", 7);
	      columns_name.setElementAt("Quốc Tịch", 8);
	      dtm.setColumnIdentifiers(columns_name);
	      while (rs.next()) {
	        data_rows = new Vector();
	        for (int j = 1; j <= columns; j++) {
	          data_rows.addElement(rs.getString(j));
	        }
	        dtm.addRow(data_rows);
	      }
	      table = new JTable(dtm);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	public void xoaKhoiJtable_nhanKhau() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
		    model.removeRow(selectedRow);
		}
	}
	public void xoaKhoiCSDL_nhanKhau() {
		try {
			int maNhanKhau = Integer.parseInt(textField_maNK.getText());
			String tenNhanKhau = textField_hoVaTen.getText();
			String gioiTinh = textField_gioiTinh.getText();
			String ngaySinh = textField_ngaySinh.getText();
			String soDienThoai = textField_soDienThoai.getText();
			String canCuocCongDan = textField_cCCD.getText();
			String queQuan = textField_queQuan.getText();
			String danToc = textField_danToc.getText();
			String quocTich = textField_quocTich.getText();
			
			NhanKhauModel nhanKhauModel = new NhanKhauModel(maNhanKhau, tenNhanKhau, gioiTinh, ngaySinh, soDienThoai, canCuocCongDan, queQuan, danToc, quocTich);
			NhanKhauDAO.getInstance().delete(nhanKhauModel);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void themVaoCSDL_nhanKhau() {
		try {
			int maNhanKhau = Integer.parseInt(textField_maNK.getText());
			String tenNhanKhau = textField_hoVaTen.getText();
			String gioiTinh = textField_gioiTinh.getText();
			String ngaySinh = textField_ngaySinh.getText();
			String soDienThoai = textField_soDienThoai.getText();
			String canCuocCongDan = textField_cCCD.getText();
			String queQuan = textField_queQuan.getText();
			String danToc = textField_danToc.getText();
			String quocTich = textField_quocTich.getText();
			
			NhanKhauModel nhanKhauModel = new NhanKhauModel(maNhanKhau, tenNhanKhau, gioiTinh, ngaySinh, soDienThoai, canCuocCongDan, queQuan, danToc, quocTich);
			NhanKhauDAO.getInstance().insert(nhanKhauModel);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void themVaoJtable_nhanKhau() {
		int maNhanKhau = Integer.parseInt(textField_maNK.getText());
		String tenNhanKhau = textField_hoVaTen.getText();
		String gioiTinh = textField_gioiTinh.getText();
		String ngaySinh = textField_ngaySinh.getText();
		String soDienThoai = textField_soDienThoai.getText();
		String canCuocCongDan = textField_cCCD.getText();
		String queQuan = textField_queQuan.getText();
		String danToc = textField_danToc.getText();
		String quocTich = textField_quocTich.getText();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {	maNhanKhau, 
				tenNhanKhau, 
				gioiTinh, 
				ngaySinh,
				soDienThoai,
				canCuocCongDan,
				queQuan,
				danToc,
				quocTich});
	}
	public void xoaForm() {
		textField_maNK.setText("");
		textField_hoVaTen.setText("");
		textField_gioiTinh.setText("");
		textField_ngaySinh.setText("");
		textField_soDienThoai.setText("");
		textField_cCCD.setText("");
		textField_queQuan.setText("");
		textField_danToc.setText("");
		textField_quocTich.setText("");
		
	}
	public void timKiem() {
		TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter1);
		String text = textField_timKiem.getText(); // Lấy từ khóa tìm kiếm từ JTextField
		if (text.length() == 0) {
		    sorter1.setRowFilter(null); // Nếu không có từ khóa tìm kiếm thì hiển thị toàn bộ dữ liệu
		} else {
		    sorter1.setRowFilter(RowFilter.regexFilter(text)); // Áp dụng bộ lọc với từ khóa tìm kiếm
		}
		
		textField_timKiem.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    private void sortTable() {
		        sorter1.sort(); // Sắp xếp và lọc dữ liệu
		    }
		});
	}
	public void huyTim() {
		TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter1);
		String text = ""; // Lấy từ khóa tìm kiếm từ JTextField
		if (text.length() == 0) {
		    sorter1.setRowFilter(null); // Nếu không có từ khóa tìm kiếm thì hiển thị toàn bộ dữ liệu
		} else {
		    sorter1.setRowFilter(RowFilter.regexFilter(text)); // Áp dụng bộ lọc với từ khóa tìm kiếm
		}
		
		textField_timKiem.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    private void sortTable() {
		        sorter1.sort(); // Sắp xếp và lọc dữ liệu
		    }
		});
	}
}
