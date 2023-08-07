package interfacepkg;

public class ComplexMain2 {

	public static void main(String[] args) {
		Fax fax = new Fax() {
			
			@Override
			public void send(String tel) {
				System.out.println(FAX_NUMBER + " => " + tel);
			}

			@Override
			public void receive(String tel) {
				System.out.println(FAX_NUMBER + " <= " + tel);
			}
		};
		fax.send("02-2222-3333");
		fax.receive("02-3333-4444");
	}

}
