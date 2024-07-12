package sample_application;

public class IncreaseOperatorExam {
	/**
	 * 클래스를 실행시키는 특별한 코드
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 스스로에게 1을 더하는 실습.
		// 일반 연산자
		int number1 = 0; // number1을 num1로 대체가능
		number1 = number1 + 1;
		
		
		// 짧은 연산자
		number1 = 0; // 0으로 초기화 (재할당) - 위에서 이미 number1에 1을 더해서 다시 초기화함.
		number1 += 1;
		
		// 단항 연산자
		number1 = 0; // 0으로 초기화 (재할당)
		number1++;
		
		System.out.println(number1++); // 1. 1 (먼저 출력한 후 수행)
		System.out.println(number1++); // 2. 2
		System.out.println(number1++); // 3. 3
		System.out.println(number1); // 4. 4
		
		int number2 = 0;
		++number2;
		System.out.println(number2); // 1
		System.out.println(++number2); // 1. 2 (먼저 수행 후 출력)
		System.out.println(++number2); // 2. 3
		System.out.println(++number2); // 3. 4
		System.out.println(number2); // 4. 4
		
	}
}
