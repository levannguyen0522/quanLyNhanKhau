package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PhuongHoaXuanView;
import view.QLHKView;
import view.QLNKView;

public class Controller_phuongHoaXuan implements ActionListener {
	PhuongHoaXuanView phuonghoaXuanView;

	public Controller_phuongHoaXuan (PhuongHoaXuanView phuonghoaXuanView) {
		this.phuonghoaXuanView = phuonghoaXuanView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String acction = e.getActionCommand();
		if(acction.equals("Quản Lý Nhân Khẩu")) {
			new QLNKView();
		}else if(acction.equals("Quản Lý Sổ Hộ Khẩu")) {
			new QLHKView();
		}else if (acction.equals("Thoát")) {
			System.exit(0);
		}
		
	}
	
}
