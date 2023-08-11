package iopkg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest2 {

	public static void main(String[] args) {
		SerializableUser afterUser = null;
		FileInputStream fileis = null;
		ObjectInputStream objectis = null;
		
		String path = "C:/kdigital2307/data/userInfo.ser";
		
//		read
		try {
			fileis = new FileInputStream(path);
			objectis = new ObjectInputStream(fileis);
			afterUser = (SerializableUser)objectis.readObject();
			System.out.println(afterUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				objectis.close();
				fileis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Object Read OK!!");
	}

}
