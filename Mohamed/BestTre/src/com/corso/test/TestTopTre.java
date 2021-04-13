package com.corso.test;

import java.util.ArrayList;

import com.corso.algo.TopTreAlgoritmo;

public class TestTopTre {
	
	public static void main(String[] args) {
		
		TopTreAlgoritmo algo1 = new TopTreAlgoritmo();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i= 0; i <10; i++) {
			list.add((int)(Math.random()*1000.00) );
			System.out.println(list.get(i));
		}
		
		System.out.println("I primi tre sono:");
		for(int i : algo1.order(list))
			System.out.println(i);
		
	}

}
