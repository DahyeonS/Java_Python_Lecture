package collectionpkg;

import java.util.List;

public class ShapeUtil {
	List list;
	
//	areaSum
	static double areaSumF(Shape shape) {
		return shape.area();
	}
	
	static double areaSum(List list) {
		double sum = 0;
		for (int i=0; i<list.size(); i++) {
			Shape shape = (Shape)list.get(i);
			sum += shape.area();
		}
		return sum;
	}
	
//	lengthSum
	static double lengthSumF(Shape shape) {
		return shape.length();
	}
	
	static double lengthSum(List list) {
		double sum = 0;
		for (int i=0; i<list.size(); i++) {
			Shape shape = (Shape)list.get(i);
			sum += shape.length();
		}
		return sum;
	}
}
