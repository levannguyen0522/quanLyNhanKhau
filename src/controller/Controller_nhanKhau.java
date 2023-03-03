package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QLHKView;
import view.QLNKView;

public class Controller_nhanKhau implements ActionListener{
	   QLNKView qlnkView;

	public Controller_nhanKhau(QLNKView qlnkView) {
		this.qlnkView = qlnkView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String acction = e.getActionCommand();
		if(acction.equals("Thêm")) {
			this.qlnkView.themVaoCSDL_nhanKhau();
			this.qlnkView.themVaoJtable_nhanKhau();
			this.qlnkView.xoaForm();
		} else if (acction.equals("Xóa")) {
			this.qlnkView.xoaKhoiJtable_nhanKhau();
			this.qlnkView.xoaKhoiCSDL_nhanKhau();
			this.qlnkView.xoaForm();
		} else if (acction.equals("Cập Nhật")) {
			this.qlnkView.xoaKhoiJtable_nhanKhau();
			this.qlnkView.xoaKhoiCSDL_nhanKhau();
			this.qlnkView.themVaoCSDL_nhanKhau();
			this.qlnkView.themVaoJtable_nhanKhau();
			this.qlnkView.xoaForm();
		} else if (acction.equals("Tìm Kiếm")) {
			this.qlnkView.timKiem();
		} else if (acction.equals("Hủy Tìm")) {
			this.qlnkView.huyTim();
		}else if (acction.equals("Thoát")) {
			System.exit(0);
		}
		
	}
 
}
