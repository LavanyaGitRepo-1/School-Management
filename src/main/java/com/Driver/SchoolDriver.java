package com.Driver;

import java.util.Scanner;

import com.Service.Service;

public class SchoolDriver {
	public static void main(String[] args)
	{
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welcome to my School");
			System.out.println("Enter 1 to save data");
			System.out.println("Enter 2 to update student");
			System.out.println("Enter 3 to delete student");
			System.out.println("Enter 4 to fetch data");
			
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			Service sr=new Service();
			switch(choice)
			{
			case 1:
				int no=sr.insert();
				if(no!=0)
				{
					System.out.println("data saved");
				}
				break;
			case 2:
				int no1=sr.update();
				if(no1!=0)
				{
					System.out.println("data updtated");
				}
				break;
				default :
					break;
				case 3:
					int no2=sr.delete();
					if(no2!=0)
					{
						System.out.println("data deleted");
					}
					break;
					
				case 4:
					sr.fetch();
					break;
			}
		}
		
	}
	
	

}
