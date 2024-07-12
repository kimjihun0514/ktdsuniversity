package sample_application;

public class ShortCutOperatorExam {
	
	public static void main(String[] args) {
		
		// 일반 산술 연산자 실습
		int number1 = 10;
		number1 = number1 + 2;
		System.out.println(number1); //12
		// Ctrl + F11 ==> 클래스 실행
		
		int number3 = 30;
		number3 = number3 + 6; // number += 6;
		System.out.println(number3); // 36
		
		int number4 = 40;
		number4 = number4 - 10; // number -= 10;
		System.out.println(number4); // 30
		
		int number5 = 50;
		number5 = number5 * 12; // number 5 *= 12;
		System.out.println(number5); // 600
		
		int number6 = 60;
		number6 = number6 / 12; // number6 /= 12;
		System.out.println(number6); // 5
		
		int number7 = 70;
		number7 = number7 % 15; // number7 %= 15;
		System.out.println(number7); // 10 - 나누고 난 후 나머지 몫
		
		//짧은 표현식 실습
		// - 생겨난 배경 : 코드를 짧은 시간내에 효율적으로 작성하기 위해.
		//             -귀찮아서
		int number2 = 20;
		number2 += 4;
		System.out.println(number2); // 24
		
		
	}
	
}
