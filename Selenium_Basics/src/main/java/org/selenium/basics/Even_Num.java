package org.selenium.basics;

public class Even_Num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1,count =0;
		for(i=1;i<=10;i++)
		{
			if(i%2==0)
			{
				count=count+1;
			}
		}
		System.out.println("count the even numbers:"+count);

	}

	}


