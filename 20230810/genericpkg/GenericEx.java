package genericpkg;

public class GenericEx {
	
	public static void main(String[] args) {
		NoGeneric nogen = new NoGeneric();
		String[] ss = {"hong", "lee", "kim"};
		nogen.set(ss);
		nogen.print();
		
		Object[] objs = nogen.get();
		for (Object o : objs) {
			String s = (String)o;
		}
		
		Integer[] ii = {1, 2, 3};
		nogen.set(ii);
		objs = nogen.get();
		for (Object o : objs) {
//			String s = (String)o;
			int i = (int)o;
		}
	}
	
}
