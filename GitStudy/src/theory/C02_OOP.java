package theory;
import myobj.Cat;
import myobj.Peach;

public class C02_OOP {

	/*
		# 객체지향 프로그래밍 (OOP: Object Oriented Programming)
		- 세상에 존재하는 모든 것들을 변수와 함수로 표현하려는 프로그래밍 방법론
		- 변수와 함수를 무분별하게 사용하기 보다는 현실에 존재하는 객체 단위로 묶어서 표현하여 가독성을 올린다
		- 객체 (Object) : 세상에 존재하는 모든 것을 말한다 (사물, 개념 ... 등등)
		
		ex: 사과
		- 사과의 변수: 크기, 색깔, 당도, 유통기한, 보유한 칼로리 ...
		- 사과의 메서드
		  -> 던진다 (크기 만큼의 데미지를 입힌다)
		  -> 먹는다 (먹은 만큼 칼로리가 줄어들고 사과의 크기가 줄어든다)
		  -> 보관한다 (냉장고에 보관하면 유통기한이 느리게 감소한다)
		※ 클래스 내부에 있는 함수를 메서드라고 부른다 (사실 JAVA에는 메서드 밖에 없다)
		
		# 클리스 (Class)
		- 객체를 프로그래밍 언어로 표현한 것
		- 클래스는 객체의 설계도이다 (정의한 시점에서는 실체가 없음)
		- 클래스를 통해 생성하는 실체 객체를 '인스턴스'라고 부른다
		- 클래스는 참조형 변수 타입이다
	*/
	
	// 프로그램 실행 시에 public class에 있는 main만 찾을 수 있다
	public static void main(String[] args) {
		
		// Apple 클래스(설계도)로 만들어낸 인스턴스(생산품) a1
		Apple a1 = new Apple();
		Apple a2 = new Apple();
		Apple a3 = new Apple();

		// 다른 패키지에 선언한 public class를 사용할 수 있다
		myobj.Peach p1 = new myobj.Peach();
		Peach p2 = new Peach();
	
		a1.calorie = 100;
		a2.calorie = 120;
		a3.calorie = 115;
		
		a1.eat();
		a1.eat();
		
		System.out.println(a1.calorie);
		System.out.println(a2.calorie);
		System.out.println(a3.calorie);
		
		String str1 = "abc";
		String str2 = "ccc";
		String str3 = "bb";
		
		/*
			myobj 패키지에 현실의 객체를 참조하여 클래스를 하나 생성한 후
			인스턴스를 생성하고 값을 채운다음 출력해보세요
			
			※ 인스턴스 변수 3개 이상, 인스턴스 메서드 2개 이상, 과일 금지
		*/
		
		Cat c1 = new Cat();
		Cat c2 = new Cat("설탕", "흰색");
		c1.kilogram = 4.0;
		c1.name = "보리";
		c1.color = "갈색";
		c1.full = 50.0;
		
		System.out.printf("고양이 이름 : %s, 색깔 : %s\n", c1.name, c1.color);
		System.out.printf("고양이 이름2: %s, 색깔2: %s\n", c2.name, c2.color);
		System.out.printf("몸무게 : %.1fkg, 포만감 : %.2f\n",  c1.kilogram, c1.full);
		c1.Eat();
		System.out.printf("포만감 : %.2f, 몸무게 : %.1fkg\n", c1.full, c1.kilogram);
		c1.Meow();
		c1.Eat();
		System.out.printf("포만감 : %.2f, 몸무게 : %.1fkg\n", c1.full, c1.kilogram);
		
	}
	
}

// default class (public이 안붙은 class)
class Apple {
	
	/*
		# 인스턴스 변수
		- 각 인스턴스마다 다른 값을 가질 수 있는 변수
		- aka 필드, 속성, 멤버 변수, 상태 ...
	*/
	int size;
	int calorie;
	long lifetime;
	double sweet;
	String color;
	
	/*
		# 인스턴스 메서드
		- 인스턴스 변수를 활용하여 해당 인스턴스의 상태를 변화시키는 메서드
	*/
	void eat() {
		size--;
		calorie -= 10;
	}
}
