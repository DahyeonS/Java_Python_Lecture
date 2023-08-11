package iopkg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) {
		SerializableUser beforeUser = new SerializableUser("hong", "1111", "홍길동", 22);
		SerializableUser afterUser = null;
		FileOutputStream fileos = null;
		ObjectOutputStream objectos = null;
		FileInputStream fileis = null;
		ObjectInputStream objectis = null;
		
		String path = "C:/kdigital2307/data/userInfo.ser";
		
//		write
		try {
			fileos = new FileOutputStream(path);
			objectos = new ObjectOutputStream(fileos);
			objectos.writeObject(beforeUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				objectos.close();
				fileos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Object Write OK!!");
	}

}
