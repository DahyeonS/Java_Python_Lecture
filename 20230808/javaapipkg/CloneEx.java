package javaapipkg;

public class CloneEx {
	public static void main(String[] args) {
		String[] arr = {"홍길동", "이순신", "김유신", "안중근"};
		String[] arr2 = arr.clone();
		System.out.println(arr == arr2); // 주소가 같은가? false
		
		for (String v : arr2) {
			System.out.print(v + " ");
		}
		
		System.out.println();
		
		String[] arr3 = new String[arr.length];
		System.arraycopy(arr, 0, arr3, 0, arr.length);
		System.out.println(arr == arr3); // false
		
		for (String v : arr3) {
			System.out.print(v + " ");
		}
	}
}
