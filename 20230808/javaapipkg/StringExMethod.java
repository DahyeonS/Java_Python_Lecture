package javaapipkg;

public class StringExMethod {
	public static void main(String[] args) {
		String str = "Hello My Name is Hong Gil Dong";
		
		System.out.println(str.charAt(6)); // 6번 인덱스의 문자 - M
		System.out.println(str.equals("Hello My Name is Hong Gil Dong")); // 문자열값 비교 - true
		System.out.println(str.indexOf("Hong")); // "Hong" 문자열의 위치(인덱스) - 17 (없으면 -1)
		System.out.println(str.substring(17)); // 17번 인덱스까지 문자열 앞부분 삭제 - Hong Gil Dong
		System.out.println(str.substring(6, 13)); // 6번부터 13번 인덱스까지 문자열 출력 - My Name
		System.out.println(str.toLowerCase()); // 문자열 소문자로 변경 - hello my name is hong gil dong
		System.out.println(str.toUpperCase()); // 문자열 대문자로 변경 - HELLO MY NAME IS HONG GIL DONG
		System.out.println(str.length()); // 문자열 길이 - 30
		System.out.println(str.startsWith("Hello")); // 문자열이 "Hello"부터 시작하는지 여부 - true
		System.out.println(str.endsWith("Dong")); // 문자열이 "Dong"으로 끝나는지 여부 - true
		System.out.println(str.replace("Hong", "Kim")); // "Hong"을 "Kim"으로 변경 - Hello My Name is Kim Gil Dong
		System.out.println(str.replaceAll("Name", "Nickname")); // "Name"을 "Nickname"으로 변경(replaceAll은 정규표현식 사용 가능 ex.[a-zA-z0-9]) - Hello My Nickname is Hong Gil Dong
		System.out.println(str.toString()); // 문자열로 출력 - Hello My Name is Hong Gil Dong
		
		str = "   안녕 하세요,     반갑습니다.      ";
		System.out.println(str.trim()); // 앞뒤 공백 제거 - 안녕 하세요,     반갑습니다.
		System.out.println(str.replace(" ", "")); // 모든 공백 제거 - 안녕하세요,반갑습니다.
		
		str = String.valueOf(10); // int 10을 문자열로 변환
		str = String.valueOf(10.5); // double 10.5를 문자열로 변환
		
		str = "홍길동,이순신,유관순,안중근";
		String[] arr = str.split(",");
		for (int i=0; i<arr.length; i++) {
			System.out.println(i + "번 인덱스 값 = " + arr[i]);
		}
	}
}
