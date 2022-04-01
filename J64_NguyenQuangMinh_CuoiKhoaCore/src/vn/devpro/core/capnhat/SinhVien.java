package vn.devpro.core.capnhat;

import java.util.Scanner;

public class SinhVien {
	private int maSV;
	private String hodem;
	private String ten;
	private int namSinh;
	private String gioiTinh;
	
	static Scanner sc = new Scanner(System.in);
	
	public void display() {
		System.out.printf("%10d %25s %8d %10s\n",maSV,hodem + " " + ten, namSinh,gioiTinh);
	}
	
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int maSV, String hodem, String ten, int namSinh, String gioiTinh) {
		super();
		this.maSV = maSV;
		this.hodem = hodem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getHodem() {
		return hodem;
	}

	public void setHodem(String hodem) {
		this.hodem = hodem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
