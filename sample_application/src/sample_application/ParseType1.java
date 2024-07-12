package sample_application;

public class ParseType1 {
	public static void main(String[] args) {
		String numberString = "10";
		byte byteNumber = Byte.parseByte(numberString);
		System.out.println(byteNumber);
		
		numberString = "10000";
		short shortNumber = Short.parseShort(numberString);
		System.out.println(shortNumber);
		
		numberString = "1000000"; //문자로만 인식이 되는 상태
		int intNumber = Integer.parseInt(numberString); //이 과정을 통해 문자를 Int 값으로 변경
		System.out.println(intNumber); // 출력 시 int 값으로 나옴
		
		numberString = "1000000000";
		long longNumber = Long.parseLong(numberString);
		System.out.println(longNumber);
		
		String numberString2 = "10.5";
		float floatNumber = Float.parseFloat(numberString2);
		System.out.println(floatNumber);
		
		numberString2 = "11.577777";
		double doubleNumber = Double.parseDouble(numberString2);
		System.out.println(doubleNumber);
		
		numberString2 = "12";
		double doubleNumber2 = Double.parseDouble(numberString2);
		System.out.println(doubleNumber2);
		
		String str = "true";
		boolean bool = Boolean.parseBoolean(str);
		System.out.println(bool);
		
		str = "TRUE";
		bool = Boolean.parseBoolean(str);
		System.out.println(bool);
		
		str = "tRuE";
		bool = Boolean.parseBoolean(str);
		System.out.println(bool); //boolean 값은 스펠링만 맞으면 그대로 인식함
		
		String str2 = "false";
		boolean bool2 = Boolean.parseBoolean(str2);
		System.out.println(bool2);
		
		str2 = "";
		bool2 = Boolean.parseBoolean(str2);
		System.out.println(bool2);
		
		str2 = "anystring";
		bool2 = Boolean.parseBoolean(str2);
		System.out.println(bool2); // str2에 들어가는게 true가 아니면 다 flase로 처리
		
		
	}
}
