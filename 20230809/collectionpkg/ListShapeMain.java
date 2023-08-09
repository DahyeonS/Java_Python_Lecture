package collectionpkg;

import java.util.ArrayList;
import java.util.List;

public class ListShapeMain {
	
	public static void main(String[] args) {
		Circle c1 = new Circle(3.0);
		System.out.println(ShapeUtil.areaSumF(c1));
		
		List list = new ArrayList();
		list.add(new Circle(3.0));
		list.add(new Circle(5));
		list.add(new Rectangle(3, 4));
		list.add(new Rectangle(5, 6));
		
		ShapeUtil su = new ShapeUtil();
		double rs = su.areaSum(list);
		System.out.println(rs);
	}

}
