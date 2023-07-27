package datatypeex;

public class CharIsInt {

	public static void main(String[] args) {
		char a = 'a';
		char z = 'z';
		char A = 'A';
		char Z = 'Z';
		
		int ia = a; // int ia = (int)a;
		int iz = z;
		
		int iA = A;
		int iZ = Z;
		
		String f = "%d, %d, %d, %d";
		System.out.printf(f, ia, iz, iA, iZ);
		System.out.println();
		String f2 = "%s, %s, %s, %s";
		System.out.printf(f2, ia, iz, iA, iZ);
		System.out.println();
		String f3 = "%c, %c, %c, %c";
		System.out.printf(f3, ia, iz, iA, iZ);
		System.out.println();
		
		int aa = 97;
		char cc = (char)aa;
		System.out.println(cc);
		/* Error
		char zz = iz;
		char AA = iA;
		*/
		
		char zz = (char)iz;
		char AA = (char)iA;
		
		System.out.printf("%s, %s", zz, AA);
		System.out.println();
		
		int B = A + 1; // B, char A = 'A'
		int y = z - 1; // y
		
		System.out.printf("%s, %s %n", B, y);  // 66, 121
		System.out.printf("%c, %c %n", B, y); // B, y
		System.out.printf("%s, %s", (char)B, (char)y); // B, y
	}

}
