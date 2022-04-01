package vn.devpro.core.capnhat;

import java.util.Scanner;

public class MonHoc {
	private int maMon;
	private String tenMon;
	private double heSo;
	
	static Scanner sc = new Scanner(System.in);

	public void display() {
		System.out.printf("%10d %20s %10.2f\n",maMon,tenMon,heSo);
	}
	
	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonHoc(int maMon, String tenMon, double heSo) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.heSo = heSo;
	}

	public int getMaMon() {
		return maMon;
	}

	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public double getHeSo() {
		return heSo;
	}

	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}
	
	
}
