package quiz;

import java.util.Scanner;

public class B05_ConditionQuiz2 {
		
	/*
	    [ 알맞은 조건식을 만들어보세요 ]
	    1. char형 변수 a가 'q'또는 'Q'일 때 true
	    2. char형 변수 b가 공백이나 탭이 아닐 때 true
	    3. char형 변수 c가 문자('0' ~ '9')일 때 true
	    4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
	    
	    ※ 유니코드 표 참조
	    5. char형 변수 e가 한글일 때 true
	    6. char형 변수 f가 일본어일 때 true
	    
	    7. 사용자가 입력한 문자열이 exit일때 true 
	*/
	public static void main(String[] args) {
		
		char a = 'Q';
		char b = '1';
		char c = 'a';
		char d = '3';
		char e = '힡';
		char f;
		String user;
		
		System.out.println(a == 'q' || a == 'Q');
		System.out.println(b != ' ' && b != '	');
		System.out.println(c >= '0' && c <= '9');
		System.out.println((d >= 'a' && d <= 'z') || (d >= 'A' && d <= 'Z'));
		System.out.println(e >= '가' && e <= '힣');
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자가 입력한 문자 > ");
		user = sc.next();
		System.out.println(user.equals("exit"));
		
	}
	
}

