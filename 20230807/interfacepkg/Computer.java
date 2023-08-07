package interfacepkg;

public class Computer {
	private GraphicCard gpu;
	
	public Computer(GraphicCard gpu) {
		this.gpu = gpu;
	}

	public GraphicCard getGpu() {
		return gpu;
	}

	public void setGpu(GraphicCard gpu) {
		this.gpu = gpu;
	}
}
