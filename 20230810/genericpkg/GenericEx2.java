package genericpkg;

public class GenericEx2 {
	
	public static void main(String[] args) {
		Generic<String> gen = new Generic<String>();
		String[] ss = {"hong", "lee", "kim"};
		
		gen.set(ss);
		gen.print();
		for (String s : gen.get()) {
			System.out.println(s);
		}
		
		Integer[] ii = {1, 2, 3};
		Generic<Integer> gen2 = new Generic<Integer>();
		gen2.set(ii);
		gen2.print();
		for (Integer i : gen2.get()) {
			System.out.println(i);
		}
	}
	
}
