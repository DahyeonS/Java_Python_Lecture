package exceptionpkg;

public class Exception03 {
	void exceptionMethod () throws Exception {
		throw new Exception();
	} // 예외 발생
	
	public static void main(String[] args) {
		Exception03 et3 = new Exception03();
		try {
			et3.exceptionMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
