package com.main;

import com.factory.CarType;
import com.factory.Factory;

public class Main {

		public static void main(String[] args) {
			
			System.out.println(Factory.buildCar(CarType.SMALL));
	        System.out.println(Factory.buildCar(CarType.SEDAN));
	        System.out.println(Factory.buildCar(CarType.LUXURY));
		}
}
