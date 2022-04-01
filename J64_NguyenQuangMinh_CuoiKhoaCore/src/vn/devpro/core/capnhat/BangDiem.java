package vn.devpro.core.capnhat;

import java.util.Scanner;

public class BangDiem {
	private int maSV;
	private int maMH;
	private double diemSo;
	
	static Scanner sc = new Scanner(System.in);

	public BangDiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BangDiem(int maSV, int maMH, double diemSo) {
		super();
		this.maSV = maSV;
		this.maMH = maMH;
		this.diemSo = diemSo;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public int getMaMH() {
		return maMH;
	}

	public void setMaMH(int maMH) {
		this.maMH = maMH;
	}

	public double getDiemSo() {
		return diemSo;
	}

	public void setDiemSo(double diemSo) {
		this.diemSo = diemSo;
	}
	
	
}
