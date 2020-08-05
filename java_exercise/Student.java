package java_exercise;

import java.io.Serializable;
import java.util.Collections;
import java.util.Scanner;

public class Student extends Person {
	private String rollNo;
	private float mediumScore;
	private String email;
	
	public Student() {
		super();
	}
	public Student(String rollNo, float mediumScore, String email) {
		super();
		this.rollNo = rollNo;
		this.mediumScore = mediumScore;
		this.email = email;
	}
	public String getRollNo() {
		return rollNo;
	}
	public boolean setRollNo(String rollNo) {
		if(rollNo != null&& rollNo.length()==8) {
			this.rollNo = rollNo;
			return true;
		}else {
			System.err.println("Nhập lại mã (mã dài 8 ký tự) : ");
			return false;
		}
	}
	public float getMediumScore() {
		return mediumScore;
	}
	public boolean setMediumScore(float mediumScore) {
		if(mediumScore>=0 && mediumScore<=10) {
			this.mediumScore = mediumScore;
			return true;
		}else {
			System.err.println("Nhập lại điểm trung bình (điểm trung bình lớn hơn >=0 && <=10):");
			return false;
		}
	}
	public String getEmail() {
		return email;
	}
	public boolean setEmail(String email) {
		if( email !=null && email.contains("@") && !email.contains(" ")
				&& email.contains(".com")) {
			this.email = email;
			return true;
		}else {
			System.err.println("Nhập lại email (phải chứa '@' và không có khoảng trắng):");
			return false;
		}
	}
	@Override
	public void inputInfor() {
		super.inputInfor();
		Scanner input=new Scanner(System.in);
		System.out.println("Nhập mã sinh viên:");
		while(true) {
			String rollNoInput=input.nextLine();
			boolean check =setRollNo(rollNoInput);
			if(check==true) {
				break;
			}
		}
		System.out.println("Nhập điểm trung bình:");
		while(true) {
			float mediumScoreInput=Float.parseFloat(input.nextLine());
			boolean check=setMediumScore(mediumScoreInput);
			if(check) {
				break;
			}
		}
		System.out.println("Nhập email:");
		while(true) {
			String emailInput=input.nextLine();
			boolean check =setEmail(emailInput);
			if(check) {
				break;
			}
		}
	}
	@Override
	public void showInfor() {
		// TODO Auto-generated method stub
		super.showInfor();
		System.out.print(" Mã sinh viên "+rollNo+" Điểm trung bình "+mediumScore+" Email "+email);
		System.out.println();
	}
	public boolean checkScholarship() {
		if(mediumScore>=8)
		{
			return true;
		}else
			return false;
	}
	
	
}
