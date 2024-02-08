package org.selenium.basics;

import java.util.ArrayList;

public class Fruits {
	public static  ArrayList<String> display()
	{
		ArrayList<String> fruitsList = new ArrayList<>();

	     
        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Orange");
        fruitsList.add("Grapes");
        fruitsList.add("Mango");
        return fruitsList;

       
        
       
	}

	public static void main(String[] args) {
		ArrayList<String> ob=Fruits.display();
		
		System.out.println("Fruits in the ArrayList:"+ob);
		
		

	}

	}
