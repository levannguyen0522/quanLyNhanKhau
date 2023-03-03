package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller_nhanKhau;
import controller.Controller_phuongHoaXuan;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PhuongHoaXuanView extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhuongHoaXuanView frame = new PhuongHoaXuanView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PhuongHoaXuanView() {
		setBackground(new Color(204, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 421);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		URL urlIcon_NK = QLNKView.class.getResource("icon_NK.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon_NK);
		this.setIconImage(img);
		
		ActionListener actionListener = new Controller_phuongHoaXuan(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_quanLyNK = new JButton("Quản Lý Nhân Khẩu");
		btn_quanLyNK.addActionListener(actionListener);
		btn_quanLyNK.setBackground(new Color(192, 192, 192));
		btn_quanLyNK.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_quanLyNK.setBounds(0, 0, 175, 25);
		contentPane.add(btn_quanLyNK);
		
		JButton btn_quanLySoHK = new JButton("Quản Lý Sổ Hộ Khẩu");
		btn_quanLySoHK.addActionListener(actionListener);
		btn_quanLySoHK.setBackground(new Color(192, 192, 192));
		btn_quanLySoHK.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_quanLySoHK.setBounds(175, 0, 175, 25);
		contentPane.add(btn_quanLySoHK);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(actionListener);
		btn_thoat.setForeground(Color.RED);
		btn_thoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_thoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("icon_thoat.png"))));
		btn_thoat.setBackground(new Color(192, 192, 192));
		btn_thoat.setBounds(495, 339, 110, 45);
		contentPane.add(btn_thoat);
		
		JLabel lbl_hinhAnh = new JLabel("New label");
		lbl_hinhAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QLNKView.class.getResource("image_giaDinh.jpg"))));
		lbl_hinhAnh.setBounds(0, -15, 605, 420);
		contentPane.add(lbl_hinhAnh);
		
		
		this.setTitle("Quản Lý Nhân Khẩu Phường Hòa Xuân");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
