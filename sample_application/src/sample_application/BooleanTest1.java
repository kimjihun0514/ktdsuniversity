package sample_application;

public class BooleanTest1 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		boolean isEquals = num1 == num2;
		boolean isNum1GreaterThanNum2 = num1 > num2;
		boolean isNum1GreaterOrEqualsThanNum2 = num1 >= num2;
		boolean isNum1LessThanNum2 = num1 < num2;
		boolean isNum1LessOrEqualsThanNum2 = num1 <= num2;
		boolean isNotEquals = num1 != num2;
		
		System.out.println(isEquals); //false
		System.out.println(isNum1GreaterThanNum2); //true
		System.out.println(isNum1GreaterOrEqualsThanNum2); //true
		System.out.println(isNum1LessThanNum2); //false
		System.out.println(isNum1LessOrEqualsThanNum2); //false
		System.out.println(isNotEquals); //true
		
		
	}
}
