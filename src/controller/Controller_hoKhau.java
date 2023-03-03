package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.HoKhauModel;
import view.QLHKView;

public class Controller_hoKhau implements ActionListener {
	QLHKView qlhkView;
	

	public Controller_hoKhau(QLHKView qlhkView) {
		this.qlhkView = qlhkView;
	}


	public void actionPerformed(ActionEvent e) {
		String acction = e.getActionCommand();
		if(acction.equals("Thêm")) {
			this.qlhkView.themVaoCSDL_hoKhau();
			this.qlhkView.themVaoJtable_hoKhau();
			this.qlhkView.xoaForm();
		} else if (acction.equals("Xóa")) {
			this.qlhkView.xoaKhoiJtable_hoKhau();
			this.qlhkView.xoaKhoiCSDL_hoKhau();
			this.qlhkView.xoaForm();
		} else if (acction.equals("Cập Nhật")) {
			this.qlhkView.xoaKhoiJtable_hoKhau();
			this.qlhkView.xoaKhoiCSDL_hoKhau();
			this.qlhkView.themVaoCSDL_hoKhau();
			this.qlhkView.themVaoJtable_hoKhau();
			this.qlhkView.xoaForm();
		} else if (acction.equals("Tìm Kiếm")) {
			this.qlhkView.timKiem();
		} else if (acction.equals("Hủy Tìm")) {
			this.qlhkView.huyTim();
		}else if (acction.equals("Thoát")) {
			System.exit(0);
		}
		
	}
 
}

