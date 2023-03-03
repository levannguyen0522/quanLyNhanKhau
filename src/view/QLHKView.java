package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.Controller_hoKhau;
import dao.HoKhauDAO;
import model.HoKhauModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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

import javax.swing.JTable;

public class QLHKView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_maHK;
	private JTextField textField_diaChiThuongTru;
	private JTextField textField_ngayCap;
	private JTextField textField_tenChuHo;
	private JTable table;
	private JTextField textField_timKiem;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLHKView frame = new QLHKView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public QLHKView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.loadDataToJTable_hokhau();
		ActionListener actionListener = new Controller_hoKhau(this);
		
		URL urlIcon_NK = QLNKView.class.getResource("icon_NK.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon_NK);
		this.setIconImage(img);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_QLHK = new JLabel("Quản Lý Sổ Hộ Khẩu Phường Hòa Xuân");
		lbl_QLHK.setBounds(224, 11, 401, 25);
		lbl_QLHK.setForeground(Color.BLUE);
		lbl_QLHK.setFont(new Font("Verdana", Font.BOLD, 18));
		lbl_QLHK.setBackground(Color.BLUE);
		contentPane.add(lbl_QLHK);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 45, 852, 2);
		contentPane.add(separator);
		
		JLabel lbl_maHK = new JLabel("Mã Hộ Khẩu");
		lbl_maHK.setForeground(Color.RED);
		lbl_maHK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_maHK.setBounds(10, 70, 110, 25);
		contentPane.add(lbl_maHK);
		
		JLabel lbl_diaChiThuongTru = new JLabel("Địa Chỉ Thường Trú");
		lbl_diaChiThuongTru.setForeground(Color.RED);
		lbl_diaChiThuongTru.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_diaChiThuongTru.setBounds(10, 125, 165, 25);
		contentPane.add(lbl_diaChiThuongTru);
		
		textField_maHK = new JTextField();
		textField_maHK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_maHK.setColumns(10);
		textField_maHK.setBounds(195, 65, 135, 30);
		contentPane.add(textField_maHK);
		
		textField_diaChiThuongTru = new JTextField();
		textField_diaChiThuongTru.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_diaChiThuongTru.setForeground(new Color(0, 0, 0));
		textField_diaChiThuongTru.setColumns(10);
		textField_diaChiThuongTru.setBounds(195, 120, 340, 30);
		contentPane.add(textField_diaChiThuongTru);
		
		JLabel lbl_tenChuHo = new JLabel("Tên Chủ Hộ ");
		lbl_tenChuHo.setForeground(Color.RED);
		lbl_tenChuHo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_tenChuHo.setBounds(585, 70, 135, 25);
		contentPane.add(lbl_tenChuHo);
		
		JLabel lbl_ngayCap = new JLabel("Ngày Cấp");
		lbl_ngayCap.setForeground(Color.RED);
		lbl_ngayCap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_ngayCap.setBounds(585, 125, 135, 25);
		contentPane.add(lbl_ngayCap);
		
		textField_ngayCap = new JTextField();
		textField_ngayCap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_ngayCap.setColumns(10);
		textField_ngayCap.setBounds(730, 120, 135, 30);
		contentPane.add(textField_ngayCap);
		
		textField_tenChuHo = new JTextField();
		textField_tenChuHo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_tenChuHo.setColumns(10);
		textField_tenChuHo.setBounds(730, 65, 135, 30);
		contentPane.add(textField_tenChuHo);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(actionListener);
		btn_them.setForeground(Color.RED);
		btn_them.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_them.png"))));
		btn_them.setBackground(Color.WHITE);
		btn_them.setBounds(509, 182, 135, 45);
		contentPane.add(btn_them);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(actionListener);
		btn_xoa.setForeground(Color.RED);
		btn_xoa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_xoa.png"))));
		btn_xoa.setBackground(new Color(255, 255, 255));
		btn_xoa.setBounds(654, 182, 135, 45);
		contentPane.add(btn_xoa);
		
		JButton btn_capNhat = new JButton("Cập Nhật");
		btn_capNhat.addActionListener(actionListener);
		btn_capNhat.setForeground(Color.RED);
		btn_capNhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_capNhat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_CapNhat.png"))));
		btn_capNhat.setBackground(Color.WHITE);
		btn_capNhat.setBounds(509, 238, 135, 45);
		contentPane.add(btn_capNhat);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(actionListener);
		btn_thoat.setForeground(Color.RED);
		btn_thoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_thoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_thoat.png"))));
		btn_thoat.setBackground(Color.WHITE);
		btn_thoat.setBounds(654, 238, 135, 45);
		contentPane.add(btn_thoat);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(10, 169, 852, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(10, 294, 852, 2);
		contentPane.add(separator_2);
		
//		Sự kiện click chuột trái lên 1 dòng trong JTable
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table.getSelectedRow();
		        textField_maHK.setText(table.getValueAt(selectedRow, 0).toString());
		        textField_tenChuHo.setText(table.getValueAt(selectedRow, 1).toString());
		        textField_diaChiThuongTru.setText(table.getValueAt(selectedRow, 2).toString());
		        textField_ngayCap.setText(table.getValueAt(selectedRow, 3).toString());
		  
		    }
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 307, 850, 220);
		contentPane.add(scrollPane);
		
		JLabel lbl_nhap = new JLabel("Nhập ");
		lbl_nhap.setForeground(Color.RED);
		lbl_nhap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbl_nhap.setBounds(131, 195, 124, 24);
		contentPane.add(lbl_nhap);
		
		textField_timKiem = new JTextField();
		textField_timKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_timKiem.setColumns(10);
		textField_timKiem.setBounds(195, 191, 135, 30);
		contentPane.add(textField_timKiem);
		
		JButton btn_timKiem = new JButton("Tìm Kiếm");
		btn_timKiem.addActionListener(actionListener);
		btn_timKiem.setForeground(Color.RED);
		btn_timKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_timKiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_timKiem.png"))));
		btn_timKiem.setBackground(Color.WHITE);
		btn_timKiem.setBounds(364, 182, 135, 45);
		contentPane.add(btn_timKiem);
		
		JButton btn_huyTim = new JButton("Hủy Tìm");
		btn_huyTim.addActionListener(actionListener);
		btn_huyTim.setForeground(Color.RED);
		btn_huyTim.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_huyTim.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_huyTim.png"))));
		btn_huyTim.setBackground(Color.WHITE);
		btn_huyTim.setBounds(364, 238, 135, 45);
		contentPane.add(btn_huyTim);
		
		this.setTitle("Quản Lý Nhân Khẩu Phường Hòa Xuân");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	
	}

	public void loadDataToJTable_hokhau() {
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/quanlynhankhau";
	    String user = "root";
	    String password = "1";
	    String query = "SELECT * FROM quanlyhokhau";
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
	      columns_name.setElementAt("Mã Hộ Khẩu", 0);
	      columns_name.setElementAt("Tên Chủ Hộ", 1);
	      columns_name.setElementAt("Địa Chỉ Thường Trú", 2);
	      columns_name.setElementAt("Ngày Cấp", 3);
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
	public void xoaKhoiJtable_hoKhau() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
		    model.removeRow(selectedRow);
		}
	}
	public void xoaKhoiCSDL_hoKhau() {
		try {
			int maHoKhau = Integer.parseInt(textField_maHK.getText());
			String tenChuHo = textField_tenChuHo.getText();
			String diaChiThuongTru = textField_diaChiThuongTru.getText();
			String ngayCap = textField_ngayCap.getText();
			
			HoKhauModel hoKhauModel = new HoKhauModel(maHoKhau, tenChuHo, diaChiThuongTru, ngayCap);
			HoKhauDAO.getInstance().delete(hoKhauModel);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void themVaoCSDL_hoKhau() {
		try {
			int maHoKhau = Integer.parseInt(textField_maHK.getText());
			String tenChuHo = textField_tenChuHo.getText();
			String diaChiThuongTru = textField_diaChiThuongTru.getText();
			String ngayCap = textField_ngayCap.getText();
			
			HoKhauModel hoKhauModel = new HoKhauModel(maHoKhau, tenChuHo, diaChiThuongTru, ngayCap);
			HoKhauDAO.getInstance().insert(hoKhauModel);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void themVaoJtable_hoKhau() {
		int maHoKhau = Integer.parseInt(textField_maHK.getText());
		String tenChuHo = textField_tenChuHo.getText();
		String diaChiThuongTru = textField_diaChiThuongTru.getText();
		String ngayCap = textField_ngayCap.getText();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {	maHoKhau, 
				tenChuHo, 
				diaChiThuongTru, 
				ngayCap});
	}
	public void xoaForm() {
		textField_maHK.setText("");
		textField_tenChuHo.setText("");
		textField_diaChiThuongTru.setText("");
		textField_ngayCap.setText("");
		
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
