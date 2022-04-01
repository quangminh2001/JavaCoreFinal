package vn.devpro.core.capnhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyBangDiem {

	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<BangDiem> list = new ArrayList<BangDiem>();
	
	public static void init() {
		list.add(new BangDiem(101,200,8.4));
		list.add(new BangDiem(100,200,8.5));
		list.add(new BangDiem(100,201,8.4));
		list.add(new BangDiem(101,202,8.5));
	}
	
	public static void capNhatBangDiem() {
		do {
			System.out.println("\n--------------------Cap nhat bang diem-----------------------");
			System.out.println("Cac chuc nang cap nhat bang diem");
			System.out.println("\t1. Them diem cua mot sinh vien hoc mot mon hoc");
			System.out.println("\t2. Sua thong tin mon hoc cuar mot sinh vien");
			System.out.println("\t3. Xoa diem mot mon hoc cua mot sinh vien");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1: 
				themDiem();
				break;
			case 2: 
				suaThongTinDiem();
				break;
			case 3: 
				xoaDiem();
				break;
			case 0: 
				System.out.println("Da thoat");
				return;
			default: 
				System.out.println("Ban nhap khong dung.Xin nhap lai!!!");
				break;
			}
		}while(true);
	}

	private static void themDiem() {
		System.out.println("\n----------------Them diem cua mot sinh vien---------------------");
		System.out.print("Nhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap ma mon hoc: ");
		int maMH = Integer.parseInt(sc.nextLine());
		
		int index = isExistsMaSVMaMH(maSV, maMH);
		//kiem tra mot sinh vien chi hoc 1 mon hoc 1 lan
		if(index != -1) {
			System.out.println("\tHoc sinh nay da co diem mon hoc nay roi");
			return;
		}
		//kiem tra ma sinh vien co trong bang sinh vien khong
		if(QuanLySinhVien.isExistMaSV(maSV) ==  -1) {
			System.out.println("\tSinh vien khong co trong danh sach sinh vien");
			return;
		}
		//kiem tra mon hoc co trong bang mon hoc khong
		if(QuanLyMonHoc.isExistsMaMH(maMH) == -1) {
			System.out.println("\tMon hoc khong co trong danh sach mon hoc");
			return;
		}
		System.out.print("Nhap diem: ");
		double diem = Double.parseDouble(sc.nextLine());
		//kiem tra diem co hop le
		if(diem < 0 || diem > 10) {
			System.out.println("\tDiem khong duoc nho hon 0 hoac lon hon 10");
			return;
		}
		list.add(new BangDiem(maSV, maMH, diem));
		System.out.println("Da them thanh cong");
	}

	private static void suaThongTinDiem() {
		// TODO Auto-generated method stub
		System.out.println("\n----------------------Sua diem mon hoc-------------------------");
		System.out.print("Nhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap ma mon hoc: ");
		int maMH = Integer.parseInt(sc.nextLine());
		int index = isExistsMaSVMaMH(maSV, maMH);
		// kiem tra mon hoc cua sinh vien khong co
		if(index == -1) {
			System.out.println("\tMon hoc cua sinh vien ban chon khong co");
			return;
		}
		System.out.print("Nhap diem so: ");
		double diemSo = Double.parseDouble(sc.nextLine());
		if(diemSo < 0 || diemSo > 10) {
			System.out.println("\tDiem khong duoc nho hon 0 hoac lon hon 10");
			return;
		}
		list.set(index, new BangDiem(maSV, maMH, diemSo));
		System.out.println("Sua bang diem thanh cong");
	}

	private static void xoaDiem() {
		// TODO Auto-generated method stub
		System.out.println("\n----------------Xoa diem--------------------------");
		System.out.print("Nhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap ma mon hoc: ");
		int maMH = Integer.parseInt(sc.nextLine());
		int index = isExistsMaSVMaMH(maSV, maMH);
		// kiem tra mon hoc cua sinh vien khong co
		if(index == -1) {
			System.out.println("\tMon hoc cua sinh vien ban chon khong co");
			return;
		}
		list.remove(index);
		System.out.println("Da xoa diem thanh cong");
	}
	
	public static int isExistsMaSVMaMH(int maSV, int maMH) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMaMH() == maMH &&  list.get(i).getMaSV() == maSV) 
				index = i;	
		}
		return index;
	}
	//kiem tra dieu kien xoa ben sinh vien
	public static int isExistsMaSV(int maSV) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMaSV() == maSV) 
				index = i;	
		}
		return index;
	}
	//kiem tra dieu kien xoa mon hoc
	public static int isExistsMaMH(int maMH) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMaMH() == maMH) 
				index = i;	
		}
		return index;
	}
	public static void sapXep() {
		Collections.sort(list, new Comparator<BangDiem>() {
			@Override
			public int compare(BangDiem o1, BangDiem o2) {
				// TODO Auto-generated method stub
				return o1.getMaSV() > o2.getMaSV() ? 1 : -1;
			}
		});
	}
	
}
