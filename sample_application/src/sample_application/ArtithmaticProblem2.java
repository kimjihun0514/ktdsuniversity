package sample_application;

public class ArtithmaticProblem2 {
	public static void main(String[] args) {
		int processTime = 145;
		int minutes = 0;
		int seconds = 0;
		final int DIV = 60;
		
		minutes = processTime / DIV;
		seconds = processTime % DIV;
		System.out.println(minutes);
		System.out.println(seconds);
		
	}
	
}
