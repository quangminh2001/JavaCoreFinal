package vn.devpro.core.timkiem;

import java.util.Scanner;

import vn.devpro.core.capnhat.MonHoc;
import vn.devpro.core.capnhat.QuanLyBangDiem;
import vn.devpro.core.capnhat.QuanLyMonHoc;
import vn.devpro.core.capnhat.QuanLySinhVien;
import vn.devpro.core.capnhat.SinhVien;

public class TimKiem {

	static Scanner sc = new Scanner(System.in);
	
	public static void timKiemSV() {
		System.out.println("\n-------------------Tim kiemm theo sinh vien--------------------");
		System.out.print("Nhap ma sinh vien: ");
		int maSV = Integer.parseInt(sc.nextLine());
		
		SinhVien sinhVien = QuanLySinhVien.sinhVien(maSV);
		
		if(QuanLyBangDiem.isExistsMaSV(maSV) == -1) {
			System.out.println("\tSinh vien chua hoc mon nao");
			return;
		}
		System.out.printf("Ten sinh vien: %s \n",sinhVien.getHodem() + " "+sinhVien.getTen());
		double tongDiem = 0;
		double tongHS = 0;
		System.out.printf("%25s %10s\n","Ten mon hoc","Diem so");
		
		for(int i = 0; i < QuanLyBangDiem.list.size() ; i++) {
			if(maSV == QuanLyBangDiem.list.get(i).getMaSV()) {
				int maMH = QuanLyBangDiem.list.get(i).getMaMH();
				MonHoc monHoc = QuanLyMonHoc.monHoc(maMH);
				System.out.printf("%25s %10.2f\n",monHoc.getTenMon(),QuanLyBangDiem.list.get(i).getDiemSo());	
				tongDiem += QuanLyBangDiem.list.get(i).getDiemSo() * monHoc.getHeSo();
				tongHS += monHoc.getHeSo();
			}
		}
		System.out.printf("Diem tong ket:%10.2f \n", tongDiem / tongHS);
	}
	
	public static void timKiemMH() {
		System.out.println("\n---------------------Tim kiem theo ma mon hoc--------------------");
		System.out.print("Nhap ma mon hoc: ");
		int maMH = Integer.parseInt(sc.nextLine());
		
		if(QuanLyBangDiem.isExistsMaMH(maMH) == -1) {
			System.out.println("\tMon hoc chua co sinh vien nao hoc");
			return;
		}
		MonHoc monHoc = QuanLyMonHoc.monHoc(maMH);
		System.out.println("Ten mon hoc: " + monHoc.getTenMon());
		double tongDiem = 0;
		double soMon = 0;
		System.out.printf("%25s %10s\n","Ten sinh vien","Diem so");
		for(int i = 0; i < QuanLyBangDiem.list.size(); i++) {
			if(maMH == QuanLyBangDiem.list.get(i).getMaMH()) {
				int maSV = QuanLyBangDiem.list.get(i).getMaSV();
				SinhVien sinhVien = QuanLySinhVien.sinhVien(maSV);
				System.out.printf("%25s %10.2f\n",sinhVien.getHodem() + " " + sinhVien.getTen(),QuanLyBangDiem.list.get(i).getDiemSo());
				tongDiem += QuanLyBangDiem.list.get(i).getDiemSo();
				soMon++;
			}
		}
		System.out.printf("Diem trung binh mon la: %f \n",tongDiem/soMon);
	}
}
