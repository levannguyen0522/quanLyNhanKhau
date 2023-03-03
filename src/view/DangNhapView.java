package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JSeparator;

public class DangNhapView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_taiKhoan;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapView frame = new DangNhapView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Đăng Nhập");
		this.setLocation(400, 200);
		
		URL urlIcon_NK = QLNKView.class.getResource("icon_NK.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon_NK);
		this.setIconImage(img);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_thongTinDangNhap = new JLabel("Thông Tin Đăng Nhập ");
		lbl_thongTinDangNhap.setBounds(157, 11, 269, 35);
		lbl_thongTinDangNhap.setForeground(new Color(255, 255, 255));
		lbl_thongTinDangNhap.setBackground(new Color(128, 255, 255));
		lbl_thongTinDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 24));
		contentPane.add(lbl_thongTinDangNhap);
		
		JLabel lb_DangNhap_1 = new JLabel("Tài Khoản:");
		lb_DangNhap_1.setForeground(new Color(255, 255, 255));
		lb_DangNhap_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lb_DangNhap_1.setBounds(10, 91, 129, 39);
		contentPane.add(lb_DangNhap_1);
		
		JLabel lb_DangNhap_1_1 = new JLabel("Mật Khẩu:");
		lb_DangNhap_1_1.setForeground(new Color(255, 255, 255));
		lb_DangNhap_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lb_DangNhap_1_1.setBounds(10, 157, 142, 39);
		contentPane.add(lb_DangNhap_1_1);
		
		textField_taiKhoan = new JTextField();
		textField_taiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_taiKhoan.setBounds(159, 92, 242, 39);
		contentPane.add(textField_taiKhoan);
		textField_taiKhoan.setColumns(10);
		
		JButton btn_dangNhap = new JButton("Đăng Nhập");
		btn_dangNhap.setBackground(new Color(255, 255, 255));
		btn_dangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn_dangNhap.setBounds(194, 222, 166, 39);
		contentPane.add(btn_dangNhap);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passwordField.setBounds(159, 158, 242, 39);
		contentPane.add(passwordField);
		
		JToggleButton tglbtn_hienThi = new JToggleButton("Hiển Thị");
		tglbtn_hienThi.setBackground(new Color(255, 255, 255));
		tglbtn_hienThi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tglbtn_hienThi.setBounds(417, 165, 107, 27);
		contentPane.add(tglbtn_hienThi);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 514, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 207, 504, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("image_DangNhap.jpg"))));
		lblNewLabel.setBounds(0, 0, 540, 283);
		contentPane.add(lblNewLabel);
		
		tglbtn_hienThi.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (tglbtn_hienThi.isSelected()) {
		            passwordField.setEchoChar((char) 0);
		        } else {
		            passwordField.setEchoChar('\u2022');
		        }
		    }
		});
		
		String username = "admin";
		String password = "admin";

		btn_dangNhap.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String inputUsername = textField_taiKhoan.getText();
		        String inputPassword = new String(passwordField.getPassword());

		        if (inputUsername.equals(username) && inputPassword.equals(password)) {
		            // Đăng nhập thành công
					PhuongHoaXuanView frame = new PhuongHoaXuanView();
		        } else {
		            // Đăng nhập không thành công
		            JOptionPane.showMessageDialog(null, "Bạn đã nhập sai tài khoản hoặc mật khẩu !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
       
		this.setTitle("Quản Lý Nhân Khẩu Phường Hòa Xuân");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}