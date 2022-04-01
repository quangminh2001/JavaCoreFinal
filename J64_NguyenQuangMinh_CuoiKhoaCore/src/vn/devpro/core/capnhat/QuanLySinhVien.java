package vn.devpro.core.capnhat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class QuanLySinhVien {
	
	static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<SinhVien> list = new ArrayList<SinhVien>();
	
	public static int autoID = 100;
	
	public static void init() {
		list.add(new SinhVien(autoID++,"Bui Dinh" ,"Truong", 2000, "Nam"));
		list.add(new SinhVien(autoID++,"Nguyen Thi" ,"Huyen", 2001, "Nu"));
		list.add(new SinhVien(autoID++,"Nguyen Van" ,"Duc", 1999, "Nam"));
		list.add(new SinhVien(autoID++,"Nguyen Thi" ,"Thoa", 2003, "Nu"));
	}
	public static void capNhatDSSinhVien() {
		do {
			System.out.println("\n----------------CAP NHAT DANH SACH SINH VIEN---------------------");
			System.out.println("Cac lua chon cap nhat");
			System.out.println("\t1. Them sinh vien moi");
			System.out.println("\t2. Sua thong tin sinh vien");
			System.out.println("\t3. Xoa thong tin sinh vien");
			System.out.println("\t4. Hien thi danh sach duoc sap xep");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
				case 1: themSinhVien();
					break;
				case 2: suaThongTinSinhVien();
					break;
				case 3: xoaSinhVien();
					break;
				case 4: hienThiDSSinhVien();
					break;
				case 0: System.out.println("Da thoat");
					return;
				default: System.out.println("Lua chon khong hop le. Xin nhap lai");
					break;
			}
		}while(true);
	}
	private static void themSinhVien() {
		System.out.println("\n-------------------Them sinh vien moi---------------");
		System.out.print("Nhap ho dem: ");
		String hoDem = sc.nextLine();
		System.out.print("Nhap ten: ");
		String ten = sc.nextLine();
		//kiem tra ten de trong
		if(hoDem.trim().length() == 0 || ten.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		System.out.print("Nhap nam sinh: ");
		int namSinh = Integer.parseInt(sc.nextLine());
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		//kiem tra nam sinh nho hon 0 hoac nam sinh lon hon nam hien tai
		if(namSinh < 0 || namSinh > year) {
			System.out.println("Nam ban nhap sai");
			return;
		}
		System.out.print("Nhap gioi tinh: ");
		String gioiTinh = sc.nextLine();
		list.add(new SinhVien(autoID++,hoDem,ten,namSinh,gioiTinh));
		System.out.println("Da them thanh cong");
	}
	private static void suaThongTinSinhVien() {
		// TODO Auto-generated method stub
		System.out.println("\n----------------Sua thong tin sinh vien-------------------");
		System.out.print("Nhap ma sinh vien: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = isExistMaSV(id);
		if(index == -1) {
			System.out.println("\tSinh vien ban muon sua khong co trong danh sach");
			return;
		}
		
		do {
			System.out.println("\n----------------------------------");
			System.out.println("\t1. Sua ho dem");
			System.out.println("\t2. Sua ten");
			System.out.println("\t3. Sua nam sinh");
			System.out.println("\t4. Sua gioi tinh");
			System.out.println("\t0. De thoat");
			System.out.print("Chon thuoc tinh muon sua: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
				case 1: 
					System.out.print("Nhap ho dem: ");
					String hoDem = sc.nextLine();
					if(hoDem.trim().length() == 0) {
						System.out.println("\tHo dem khong duoc de trong");
						return;
					}
					list.get(index).setHodem(hoDem);
					break;
				case 2:
					System.out.print("Nhap ten: ");
					String ten = sc.nextLine();
					if(ten.trim().length() == 0) {
						System.out.println("\tTen khong duoc de trong");
						return;
					}
					list.get(index).setTen(ten);
					break;
				case 3:
					System.out.print("Nhap nam sinh: ");
					int namSinh = Integer.parseInt(sc.nextLine());
					Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					//kiem tra nam sinh nho hon 0 hoac nam sinh lon hon nam hien tai
					if(namSinh < 0 || namSinh > year) {
						System.out.println("Nam ban nhap sai");
						return;
					}
					list.get(index).setNamSinh(namSinh);
					break;
				case 4:
					System.out.print("Nhap gioi tinh: ");
					String gioiTinh = sc.nextLine();
					list.get(index).setGioiTinh(gioiTinh);
					break;
				case 0:
					System.out.println("Thoat sua");return;
				default:
					System.out.println("Ban chon khong dung");
					break;
			}
		}while(true);
		
		/*System.out.print("Nhap ho dem: ");
		String hoDem = sc.nextLine();
		System.out.print("Nhap ten: ");
		String ten = sc.nextLine();
		
		
		//kiem tra ten de trong
		if(hoDem.trim().length() == 0 || ten.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		
		System.out.print("Nhap nam sinh: ");
		int namSinh = Integer.parseInt(sc.nextLine());
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		//kiem tra nam sinh nho hon 0 hoac nam sinh lon hon nam hien tai
		if(namSinh < 0 || namSinh > year) {
			System.out.println("Nam ban nhap sai");
			return;
		}
		System.out.print("Nhap gioi tinh: ");
		String gioiTinh = sc.nextLine();*/
		
		//list.set(index, new SinhVien(id, hoDem, ten, namSinh, gioiTinh));
		//System.out.println("Sua thanh cong");
	}
	
	private static void xoaSinhVien() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------------Xoa sinh vien---------------------");
		System.out.print("Nhap ma sinh vien: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = isExistMaSV(id);
		if(index == -1) {
			System.out.println("\tKhong co sinh vien trong danh sach");
			return;
		}
		// con chua kiem tra ben bang diem
		if(QuanLyBangDiem.isExistsMaSV(id) != -1) {
			System.out.println("\tKhong xoa duoc sinh vien vi sinh vien da co diem roi");
			return;
		}
		list.remove(index);
		System.out.println("Da xoa thanh cong");
	}
	private static void hienThiDSSinhVien() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return o1.getTen().compareToIgnoreCase(o2.getTen());
			}
		});
		System.out.printf("%3s %10s %25s %8s %10s\n","STT","Ma SV","Ho va ten","Nam sinh","Gioi tinh");
		int count = 1;
		for(SinhVien x : list) {
			System.out.printf("%3d ",count++);
			x.display();
		}
	}
	//kiem tra ma sinh vien co thi tra ve index khong co thi tra ve -1
	public static int isExistMaSV(int id) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMaSV() == id) 
				index  = i;
		}
		return index;
	}
	public static SinhVien sinhVien(int id) {
		for( SinhVien x : list) {
			if(x.getMaSV() == id)
				return x;
		}
		return null;
	}
	/*public static void suaTT() {
			do {
				System.out.println("\n----------------------------------");
				System.out.println("\t1. Sua ho dem");
				System.out.println("\t2. Sua ten");
				System.out.println("\t3. Sua nam sinh");
				System.out.println("\t4. Sua gioi tinh");
				System.out.print("Chon thuoc tinh muon sua: ");
				int chon = Integer.parseInt(sc.nextLine());
				switch(chon) {
				case 1: 
				}
			}while(true);
		}*/
}
