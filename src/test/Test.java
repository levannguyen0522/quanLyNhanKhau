package test;

import javax.swing.UIManager;

import view.QLNKView;


public class Test {
	public static void main(String[] args) {
    	try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new QLNKView();
	}catch (Exception ex) {
		ex.printStackTrace();
	}
    }
}

