package vn.devpro.core.quanly;

import java.util.Scanner;

import vn.devpro.core.capnhat.QuanLyBangDiem;
import vn.devpro.core.capnhat.QuanLyMonHoc;
import vn.devpro.core.capnhat.QuanLySinhVien;
import vn.devpro.core.hienthi.HienThi;
import vn.devpro.core.timkiem.TimKiem;

public class QuanLy {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		QuanLySinhVien.init();
		QuanLyMonHoc.init();
		QuanLyBangDiem.init();
		do {
			System.out.println("\n------------------MENU QUAN LY---------------------");
			System.out.println("Cac chuc nang cua chuong trinh");
			System.out.println("\t1. Cap nhat danh sach");
			System.out.println("\t2. Hien thi bang diem");
			System.out.println("\t3. Tim kiem thong tin");
			System.out.println("\t0. Thoat chuong trinh");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
				case 1: capNhatDanhSach();
					break;
				case 2: hienThiBangDiem();	
					break;
				case 3: timKiemThongTin();
					break;
				case 0: System.out.println("Da dong chuong trinh");System.exit(0);
				default: 
					System.out.print("Ban nhap khong dung yeu cau");
					break;
			}
		}while(true);
	}

	private static void capNhatDanhSach() {
		
		do {
			System.out.println("\n--------------------CHUC NANG CAP NHAT------------------------");
			System.out.println("Cac chuc nang cap nhat danh sach: ");
			System.out.println("\t1. Cap nhap danh sach sinh vien");
			System.out.println("\t2. Cap nhat danh sach  mon hoc");
			System.out.println("\t3. Cap nhat bang diem");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
				case 1: QuanLySinhVien.capNhatDSSinhVien(); 
					break;
				case 2: QuanLyMonHoc.capNhatDSMonHoc();
					break;
				case 3: QuanLyBangDiem.capNhatBangDiem();
					break;
				case 0: 
					System.out.println("Da thoat chuc nang cap nhat");
					return;
				default:
					System.out.println("Ban nhap khong dung yeu cau. Xin nhap lai!!!");
					break;
				}
		}while(true);
	}

	private static void hienThiBangDiem() {
		do {
			System.out.println("\n--------------------CHUC NANG HIEN THI BANG DIEM------------------------");
			System.out.println("Cac chuc nang hien thi bang diem ");
			System.out.println("\t1. Hien thi bang diem theo sinh vien");
			System.out.println("\t2. Hien thi bang diem theo mon hoc");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
				case 1: HienThi.hienThiBangDiemSV(); 
					break;
				case 2: HienThi.hienThiBangDiemMH();
					break;
				case 0: 
					System.out.println("Da thoat chuc nang hien thi");
					return;
				default:
					System.out.println("Ban nhap khong dung yeu cau. Xin nhap lai!!!");
					break;
				}
		}while(true);
	}

	private static void timKiemThongTin() {
		do {
			System.out.println("\n--------------------CHUC NANG TIM KIEM------------------------");
			System.out.println("Cac chuc nang tim kiem ");
			System.out.println("\t1. Tim kiem theo sinh vien");
			System.out.println("\t2. Tim kiem theo mon hoc");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
				case 1: TimKiem.timKiemSV(); 
					break;
				case 2: TimKiem.timKiemMH();;
					break;
				case 0: 
					System.out.println("Da thoat chuc nang tim kiem");
					return;
				default:
					System.out.println("Ban nhap khong dung yeu cau. Xin nhap lai!!!");
					break;
				}
		}while(true);
	}
	
}
