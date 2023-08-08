package javaapipkg;

public class Fruit {
	String name;
	String color;
	
	public Fruit(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return name + " / " + color;
	}
}
