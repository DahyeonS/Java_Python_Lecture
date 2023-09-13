package hellojsp;

public class CalService {
	public CalDTO cal(CalDTO dto) {
		int result = 0;
		int num1 = dto.getA();
		int num2 = dto.getB();
		String sel = dto.getSel();
		
		if (sel.equals("+")) result = num1 + num2;
		else if (sel.equals("-")) result = num1 - num2;
		else if (sel.equals("*")) result = num1 * num2;
		else if (sel.equals("/")){
			if (num2 != 0) result = (int)((double)(num1) / num2);
			else result = 0;
		}
		else if (sel.equals("%")){
			if (num2 != 0) result = num1 % num2;
			else result = 0;
		}
		
		dto.setResult(result);
		return dto;
	}
}
