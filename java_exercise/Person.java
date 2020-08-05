package java_exercise;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable{
	private String name;
	private String gender;
	private String birthday;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Person() {
		super();
	}
	public Person(String name, String gender, String birthday, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}
	@Override
	public String toString() {
		return this.name+"\t"+this.gender+"\t"+this.birthday+"\t"+this.address;
	}
	public void inputInfor() {
		System.out.println("Nhập thông tin:");
		System.out.println("Nhập tên:");
		Scanner sc=new Scanner(System.in);
		name=sc.nextLine();
		System.out.println("Nhập giới tính:");
		gender=sc.nextLine();
		System.out.println("Nhập ngày sinh:");
		birthday=sc.nextLine();
		System.out.println("Nhập địa chỉ:");
		address=sc.nextLine();
	}
	public void showInfor() {
		System.out.print("Tên: "+name+"\t"+"Giới tính: "+gender+"\t"+"Ngày sinh: "+birthday+"\t"+"Địa chỉ: "+address);
		System.out.println();
	}
	
}
