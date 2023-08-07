package interfacepkg;

public class InterfaceExMain {

	public static void main(String[] args) {
		InterfaceExImpl ie = new InterfaceExImpl();
		ie.getSalePrice(100); // default
		ie.meanPrice();
		ie.totalPrice();
		InterfaceEx.printPrice(0);
	}

}
