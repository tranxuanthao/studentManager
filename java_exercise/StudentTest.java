package java_exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.zip.Deflater;

public class StudentTest  {

	public static void menu() {
		System.out.println("1. Nhập vào số lượng sinh viên:");
		System.out.println("2. Hiển thị thông tin sinh viên:");
		System.out.println("3. Hiển thị điểm trung bình lớn nhất và thấp nhất:");
		System.out.println("4. Tiềm kiếm theo mã sinh viên:");
		System.out.println("5. Sắp xếp và hiển thị tên sinh viên theo thứ tự từ A-Z:");
		System.out.println("6. Hiển thị sinh viên được học bổng và sắp xếp giảm dần theo điểm trung bình:");
		System.out.println("7. Save");
		System.out.println("8. Read");
		System.out.println("9. Nén File");
		System.out.println("10. Giải nén");
		System.out.println("11. Thoát");
	}
	public static void main(String[] args) {
		ArrayList<Student> studentList=new ArrayList<Student>();
		int choose;
		Scanner sc=new Scanner(System.in);
		do {
			menu();
			System.out.println("Mời bạn chọn");
			choose=Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				System.out.println("Nhập số lượng sinh viên:");
				int n=Integer.parseInt(sc.nextLine());
				for(int i=0;i<n;i++) {
					Student std=new Student();
					std.inputInfor();
					studentList.add(std);
				}
				break;
			case 2:
				for(int i=0;i<studentList.size();i++) {
					studentList.get(i).showInfor();
				}
				break;
			case 3:
				int minIndex=0,maxIndex=0;
				float minMediumScore,maxMediumScore;
				minMediumScore=studentList.get(0).getMediumScore();
				maxMediumScore=studentList.get(0).getMediumScore();
				for(int i=1;i<studentList.size();i++) {
					if(studentList.get(i).getMediumScore()<minMediumScore) {
						minIndex=i;
						minMediumScore=studentList.get(i).getMediumScore();
					}
					if(studentList.get(i).getMediumScore()>maxMediumScore) {
						maxIndex=i;
						maxMediumScore=studentList.get(i).getMediumScore();
					}
					System.out.println("Sinh viên có điểm trung bình cao nhất :");
					studentList.get(maxIndex).showInfor();
					System.out.println("Sinh viên có điểm trung bình thấp nhất:");
					studentList.get(minIndex).showInfor();
				}
				break;
			case 4:
				System.out.println("Nhập mã sinh viên cần tìm:");
				
				String rollNoSearch=sc.nextLine();
				int count=0;
				for(Student st:studentList) {
					if(st.getRollNo().equalsIgnoreCase(rollNoSearch)) {
						st.showInfor();
						count++;
					}
				}if(count==0) {
					System.out.println("Không có sinh viên nào");
				}
				break;
			case 5:
				 Collections.sort(studentList, new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {
						int cmp=o1.getName().compareTo(o2.getName());
						if(cmp>0)
							return 1;
						else if(cmp<0)
							return -1;
						
						return 0;
					}
				});
				 for(int i=0;i<studentList.size();i++) {
					 studentList.get(i).showInfor();
				 }
				break;
			case 6:
				Collections.sort(studentList, new Comparator<Student>() {

					@Override
					public int compare(Student o1, Student o2) {
						if(o1.getMediumScore()>o2.getMediumScore())
							return -1;
						if(o1.getMediumScore()<o2.getMediumScore())
							return 1;
						return 0;
					}
				});
				 for(int i=0;i<studentList.size();i++) {
					 if(studentList.get(i).checkScholarship()) {
					 studentList.get(i).showInfor();
					 }
					 if(studentList.get(i).checkScholarship()==false) {
						 System.out.println("Không có học sinh nào được học bổng");
					 }
						 
				 }
				break;
			case 7:
				FileOutputStream fos=null;
				ObjectOutputStream oos=null;
				try {
					fos=new FileOutputStream("D:/student9.dat");
					oos=new ObjectOutputStream(fos);
					oos.writeObject(studentList);
				} catch (Exception e) {
				}finally {
					try {
						if(fos !=null)
							fos.close();
						if(oos !=null)
							oos.close();
					} catch (Exception e2) {
					}
				}
				break;
			case 8:
				FileInputStream fis=null;
				ObjectInputStream ois=null;
				try {
					fis=new FileInputStream("D:/student9.dat");
					ois=new ObjectInputStream(fis);
					studentList= (ArrayList<Student>) ois.readObject();
				} catch (Exception e) {
				}finally {
					try {
						if(fis !=null)
							fis.close();
						if(ois !=null)
							ois.close();
					} catch (Exception e2) {
					}
				}
				break;
			case 9:
				String input="D:/student9.dat";
				try {
					byte [] inputobj= input.getBytes("UTF-8");
					System.out.println("length:"+inputobj.length);
					byte [] output=new byte[100];
					Deflater deflater=new Deflater();
					deflater.setInput(inputobj);
					deflater.finish();
					int compressDataLength=deflater.deflate(output);
					System.out.println(compressDataLength);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 10:
				
				break;
			case 11:
				System.out.println("Goodbye");
				break;

			default:
				System.err.println("Nhập sai");
			}
			
			
		}while(choose != 11);
	}

}
