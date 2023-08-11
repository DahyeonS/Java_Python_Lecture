package iopkg;

import java.io.Serializable;

public class SerializableUser implements Serializable {
	private String id;
	private transient String password;
	private String name;
	private int age;
	
	public SerializableUser(String id, String password, String name, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SerializableUser [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
