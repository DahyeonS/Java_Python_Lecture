package variableex;

public class VariableDeclare4 {

	public static void main(String[] args) {
		int i = 100;
		int i2 = i;
		i2 = 100;
		i = i2;
		
		System.out.println(i);
		System.out.println(i2);
	}

}
