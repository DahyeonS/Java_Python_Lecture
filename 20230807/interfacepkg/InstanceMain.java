package interfacepkg;

public class InstanceMain {
	public static void main(String[] args) {
		O oa = new AAA();
		O oz = new ZZZ();
		
		A a = new AAA();
		Z z = new ZZZ();
		
		AA aa = new AAA();
		ZZ zz = new ZZZ();
		
		AAA aaa = new AAA();
		ZZZ zzz = new ZZZ();
		
//		Object: true
		System.out.println(oa instanceof Object);
		System.out.println(aaa instanceof Object);
		System.out.println(zzz instanceof Object);
		
//		O - A, O - Z: true
		System.out.println(oa instanceof A);
		System.out.println(oz instanceof Z);
		
//		O - AA, O - ZZ: true
		System.out.println(oa instanceof AA);
		System.out.println(oz instanceof ZZ);
		
//		O - AAA, O - ZZZ: true
		System.out.println(oa instanceof AAA);
		System.out.println(oz instanceof ZZZ);
		
//		A - AA, Z - ZZ: true
		System.out.println(a instanceof AA);
		System.out.println(z instanceof ZZ);
		
//		A - AAA, Z - ZZZ: true
		System.out.println(a instanceof AAA);
		System.out.println(z instanceof ZZZ);
		
//		AA - AAA, ZZ - ZZZ: true
		System.out.println(aa instanceof AAA);
		System.out.println(zz instanceof ZZZ);
		
//		A - Z: false
		System.out.println(a instanceof Z);
		System.out.println(a instanceof ZZ);
		System.out.println(a instanceof ZZZ);
	}
}
