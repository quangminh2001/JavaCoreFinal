package vn.devpro.core.hienthi;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.core.capnhat.MonHoc;
import vn.devpro.core.capnhat.QuanLyBangDiem;
import vn.devpro.core.capnhat.QuanLyMonHoc;
import vn.devpro.core.capnhat.QuanLySinhVien;
import vn.devpro.core.capnhat.SinhVien;

public class HienThi {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void hienThiBangDiemSV() {
		System.out.println("\n----------------Hien thi bang diem theo sinh vien-------------------\n");
		
		QuanLyBangDiem.sapXep();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < QuanLyBangDiem.list.size(); i++) {
			if(arr.contains(QuanLyBangDiem.list.get(i).getMaSV()) == true) {
				continue;
			}
			arr.add(QuanLyBangDiem.list.get(i).getMaSV());
		}
		int n = QuanLyBangDiem.list.size();
		for(int i = 0; i < arr.size(); i++) {
			System.out.println("----------------Bang diem ca nhan-------------------------");
			SinhVien sinhVien = QuanLySinhVien.sinhVien(arr.get(i));
			System.out.printf("%-10s %-10d","Ma SV: ",sinhVien.getMaSV());
			System.out.printf("%-10s %-25s\n","Ten SV: ",sinhVien.getHodem() + " "+ sinhVien.getTen());
			System.out.printf("%-10s %-10d","Nam sinh: ",sinhVien.getNamSinh());
			System.out.printf("%-10s %-25s\n","Gioi tinh: ",sinhVien.getGioiTinh());
			double tongDiem = 0;
			double tongHS = 0;
			System.out.printf("%3s %10s %25s %10s\n","STT","Ma MH","Ten mon hoc","Diem so");
			int count = 1;
			for( int j = 0; j < n; j++) {
				if(arr.get(i) == QuanLyBangDiem.list.get(j).getMaSV()) {
					int maMH = QuanLyBangDiem.list.get(j).getMaMH();
					MonHoc monHoc = QuanLyMonHoc.monHoc(maMH);
					double diemSo = QuanLyBangDiem.list.get(j).getDiemSo();
					System.out.printf("%3d %10d %25s %10.2f\n",count++,monHoc.getMaMon(),monHoc.getTenMon(),diemSo);
					tongDiem += diemSo * monHoc.getHeSo();
					tongHS += monHoc.getHeSo();
				}
			}
			System.out.printf("Diem tong ket: %f \n\n",tongDiem/tongHS);
		}
		
		/*int n = QuanLyBangDiem.list.size();
		System.out.printf("%3s %10s %25s %25s %10s\n","STT","Ma SV","Ten sinh vien","Ten mon hoc","Diem so");
		for(int i = 0; i < n; i++) {
			int maSV = QuanLyBangDiem.list.get(i).getMaSV();
			SinhVien sinhVien = QuanLySinhVien.sinhVien(maSV);
			int maMH = QuanLyMonHoc.list.get(i).getMaMon();
			MonHoc monHoc = QuanLyMonHoc.monHoc(maMH);
			System.out.printf("%3d %10d %25s %25s %10.2f\n",i +1,sinhVien.getMaSV()
					,sinhVien.getHodem()+" "+sinhVien.getTen(),monHoc.getTenMon(),QuanLyBangDiem.list.get(i).getDiemSo());
		}*/
	}
	
	public static void hienThiBangDiemMH() {
		System.out.println("\n----------------Hien thi theo mon hoc-----------------------\n");
		ArrayList<Integer> arrMaMH = new ArrayList<Integer>();
		
		for(int i = 0; i < QuanLyBangDiem.list.size(); i++) {
			if(arrMaMH.contains(QuanLyBangDiem.list.get(i).getMaMH()) == true) {
				continue;
			}
			arrMaMH.add(QuanLyBangDiem.list.get(i).getMaMH());
		}
		
		for( int i = 0; i < arrMaMH.size(); i++) {
			System.out.println("--------------------Bang diem mon hoc-------------------------");
			MonHoc monHoc = QuanLyMonHoc.monHoc(arrMaMH.get(i));
			System.out.printf("\t\tMa mon hoc: %s\n",monHoc.getMaMon());
			System.out.printf("\t\tTen mon hoc: %s\n",monHoc.getTenMon());
			System.out.printf("\t\tHe so: %.2f\n",monHoc.getHeSo());
			System.out.printf("%3s %10s %25s %10s %10s %10s\n","STT","Ma SV","Ten sinh vien","Nam sinh","Gioi tinh","Diem so");
			double tongDiem = 0;
			double count = 0;
			int count1 = 1;
			for( int j = 0; j < QuanLyBangDiem.list.size(); j++) {
				if(arrMaMH.get(i) == QuanLyBangDiem.list.get(j).getMaMH()) {
					int maSV = QuanLyBangDiem.list.get(j).getMaSV();
					SinhVien sinhVien = QuanLySinhVien.sinhVien(maSV);
					double diemSo = QuanLyBangDiem.list.get(j).getDiemSo();
					System.out.printf("%3d %10d %25s %10d %10s %10.2f\n",count1,sinhVien.getMaSV(),
							sinhVien.getHodem()+" "+sinhVien.getTen(),sinhVien.getNamSinh(),sinhVien.getGioiTinh(),diemSo);
					tongDiem += diemSo;
					count++;
					
				}
			}
			System.out.printf("Diem trung binh:  %f \n\n" , (tongDiem/count));
		}
	}
	
	
}
