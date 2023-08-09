package collectionpkg;

import java.util.ArrayList;
import java.util.List;

public class ShapeListEx {
	static double areaSumF(Shape shape) {
		return shape.area();
	}
	
	static double areaSumF(List list) {
		double sum = 0;
		for (int i=0; i<list.size(); i++) {
			Shape shape = (Shape)list.get(i);
			sum += shape.area();
		}
		return sum;
	}
	
	static double lengthSumF(Shape shape) {
		return shape.length();
	}
	
	static double lengthSumF(List list) {
		double sum = 0;
		for (int i=0; i<list.size(); i++) {
			Shape shape = (Shape)list.get(i);
			sum += shape.length();
		}
		return sum;
	}

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Circle(3.0));
		list.add(new Circle(5));
		list.add(new Rectangle(3, 4));
		list.add(new Rectangle(5, 6));
		
//		전체 도형 면적의 합
		double areaSum = 0;
		for (int i=0; i<list.size(); i++) {
			Shape shape = (Shape)list.get(i);
			areaSum += shape.area();
		}
		System.out.println("전체 도형 면적의 합: " + areaSum);
		
//		전체 도형 둘레의 합
		double lengthSum = 0;
		for (int i=0; i<list.size(); i++) {
			Shape shape = (Shape)list.get(i);
			lengthSum += shape.length();
		}
		System.out.println("전체 도형 둘레의 합: " + lengthSum);
	
//		전체 도형 면적의 합: 메소드
		areaSum = 0;
		for (int i=0; i<list.size(); i++) {
			Shape shape = (Shape)list.get(i);
			areaSum += areaSumF(shape);
		}
		System.out.println("전체 도형 면적의 합(메소드): " + areaSum);
		
//		전체 도형 둘레의 합: 메소드
		lengthSum = 0;
		for (int i=0; i<list.size(); i++) {
			Shape shape = (Shape)list.get(i);
			lengthSum += lengthSumF(shape);
		}
		System.out.println("전체 도형 둘레의 합(메소드): " + lengthSum);
		
		areaSum = areaSumF(list);
		System.out.println(areaSum);
		
		lengthSum = lengthSumF(list);
		System.out.println(lengthSum);
		
//		ShapeUtil 클래스
		areaSum = ShapeUtil.areaSum(list);
		lengthSum = ShapeUtil.lengthSum(list);
		System.out.println("전체 도형 면적의 합(클래스): " + areaSum);
		System.out.println("전체 도형 둘레의 합(클래스): " + lengthSum);
	
		ShapeUtil su = new ShapeUtil();
		areaSum = su.areaSum(list);
		lengthSum = su.lengthSum(list);
		System.out.println(areaSum);
		System.out.println(lengthSum);
	}

}
