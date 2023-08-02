package classex;

import java.util.Arrays;

public class CarMain {
	public static void main(String[] args) {
		Car car = new Car();
		/*
		car.color = "red";
		car.company = "현대자동차";
		car.go();
		car.back();
		
		Car car2 = new Car();
		car2.color = "black";
		car2.company = "기아자동차";
		car2.go();
		car2.back();
		
		Car[] carArr = new Car[3];
		carArr[0] = new Car();
		carArr[1] = new Car();
		carArr[2] = new Car();
		carArr[0].color = "red";
		carArr[1].color = "black";
		carArr[2].color = "green";
		System.out.println(Arrays.toString(carArr));
		*/
		System.out.println(car.color);
		System.out.println(car.company);
		System.out.println(car.door);
	}

}
