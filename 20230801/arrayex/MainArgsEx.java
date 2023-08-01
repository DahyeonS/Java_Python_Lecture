package arrayex;

public class MainArgsEx {

	public static void main(String[] args) {
		int rs = 0; int i1 = 0; int i2 = 0; 
		if (args.length != 2) {
			System.out.println("args not found!!");
		} else {
			String args1 = args[0];
			String args2 = args[1];
			i1 = Integer.parseInt(args1);
			i2 = Integer.parseInt(args2);
			rs = i1 + i2;
		}
		
		System.out.printf("%s + %s = %s", i1, i2, rs);
	}

}
