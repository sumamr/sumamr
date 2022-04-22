package suma.com;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		//menu from user
		
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("******WELCOME TO STUDENT MANAGEMENT SYSTEM***********");
			System.out.println("ENTER YOUR CHOICE");
			System.out.println("1.To Display  student information");
			System.out.println("2.Insert student record");
			System.out.println("3.Update student information based on id");
			System.out.println("4.Delete student information based on id");
			System.out.println("5.Select Student information based on id");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1: StudentDataOPerations.displayStudentInfo();
			         break;
			case 2: StudentDataOPerations.insertStudentInfo();
			          break;
			case 3: StudentDataOPerations.updateStudentInfo();
			            break;
			case 4: StudentDataOPerations.deleteStudentInfo();
			             break;
			case 5: StudentDataOPerations.selectStudentInfo();
			         break;
			         
			  default: System.out.println("INVALID CHOICE");
			}//switch
			System.out.println("DO YOU WANT TO CONTINUE YES/NO");
			String choice=sc.next();
			if(choice.equalsIgnoreCase("NO"))
			{
				break;
			}
			
		}//while end
		System.out.println("Program terminated");
		System.out.println("THANKS FOR USING THE APPLICATION");

	}//main

}//MainApp
