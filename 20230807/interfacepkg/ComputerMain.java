package interfacepkg;

public class ComputerMain {

	public static void main(String[] args) {
		GraphicCard gpu = new Amd();
		Computer computer = new Computer(gpu);
		
//		교체
		gpu = new Nvidia();
		computer.setGpu(gpu);
	}

}
