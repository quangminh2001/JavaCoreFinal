package vn.devpro.core.capnhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyMonHoc {
	
	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<MonHoc> list = new ArrayList<MonHoc>();
	
	public static int autoID = 200;
	
	public static void init() {
		list.add(new MonHoc(autoID++, "Lap trinh Web", 2.3));
		list.add(new MonHoc(autoID++, "Do hoa may tinh", 4));
		list.add(new MonHoc(autoID++, "Co so du lieu", 2.5));
		list.add(new MonHoc(autoID++, "Lap trinh mobile", 3));
	}
	
	public static void capNhatDSMonHoc() {
		do {
			System.out.println("\n-------------------Cap nhat danh sach mon hoc--------------------");
			System.out.println("Cac lua chon cap nhat danh sach mon hoc");
			System.out.println("\t1. Them mon hoc moi");
			System.out.println("\t2. Sua thong tin mon hoc");
			System.out.println("\t3. Xoa thong tin mon hoc");
			System.out.println("\t4. Hien thi danh sach mon hoc");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1: themMonHoc(); 
				break;
			case 2: suaMonHoc(); 
				break;
			case 3: xoaMonHoc(); 
				break;
			case 4: hienThiDSMonHoc(); 
				break;
			case 0: 
				System.out.println("Da thoat");
				return;
			default: 
				System.out.println("Ban nhap khong chinh xac");
				break;
			}
		}while(true);		
	}

	private static void themMonHoc() {
		System.out.println("\n--------------------Them mon hoc moi-----------------");
		System.out.print("Nhap ten mon hoc: ");
		String tenMon = sc.nextLine();
		if(tenMon.trim().length() == 0) {
			System.out.println("Khong duoc de ten mon bo trong");
			return;
		}
		System.out.println("Nhap he so: ");
		double heSo = Double.parseDouble(sc.nextLine());
		list.add(new MonHoc(autoID, tenMon, heSo));
		System.out.println("Da them mon hoc thanh cong");
	}

	private static void suaMonHoc() {
		// TODO Auto-generated method stub
		System.out.println("\n--------------------Sua thong tin mon hoc----------------------");
		System.out.print("Nhap ma mon hoc: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = isExistsMaMH(id);
		if(index == -1) {
			System.out.println("\tMa mon hoc ban nhap khong co trong danh sach");
			return;
		}
		System.out.print("Nhap ten mon hoc: ");
		String tenMH = sc.nextLine();
		if(tenMH.trim().length() == 0) {
			System.out.println("\tTen mon hoc khong duoc de trong");
			return;
		}
		System.out.print("Nhap he so diem: ");
		double heSo = Double.parseDouble(sc.nextLine());
		list.set(index, new MonHoc(id,tenMH,heSo));
		System.out.println("Sua thanh cong");
	}

	private static void xoaMonHoc() {
		System.out.println("\n--------------------Xoa mon hoc----------------------");
		System.out.print("Nhap ma mon hoc: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = isExistsMaMH(id);
		if(index == -1) {
			System.out.println("\tMa mon hoc ban nhap khong co trong danh sach");
			return;
		}
		//lien ket den bang bang diem
		if(QuanLyBangDiem.isExistsMaMH(id) != -1) {
			System.out.println("\tKhong xoa duoc mon hoc vi co diem trong bang diem roi");
			return;
		}
		list.remove(index);
		System.out.println("Da xoa thanh cong");
	}

	private static void hienThiDSMonHoc() {
		// TODO Auto-generated method stub
		Collections.sort(list, new  Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				// TODO Auto-generated method stub
				return o1.getTenMon().compareToIgnoreCase(o2.getTenMon());
			}
		});
		int count = 1;
		System.out.printf("%3s %10s %20s %10s\n","STT","Ma mon","Ten mon","He so");
		for(MonHoc x : list) {
			System.out.printf("%3d ",count++);
			x.display();
		}
	}
	static public int isExistsMaMH(int id) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(id == list.get(i).getMaMon()) {
				index = i;
			}
		}
		return index;
	}
	static public MonHoc monHoc(int id) {
		for( MonHoc x : list) {
			if(x.getMaMon() == id) {
				return x;
			}
		}
		return null;
	}
}
