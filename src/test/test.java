package test;

import java.nio.charset.CharacterCodingException;

class test {
	public static void main(String args[]) {
		String str1 = "my string";
		String str2 = "my string";
		String str3 = "string";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
		String s = new String("one");
		System.out.println(Integer.toHexString(s.hashCode()));
		String s1 = new String("one");
		System.out.println(Integer.toHexString(s1.hashCode()));
		
		System.out.println(System.identityHashCode(s));
		System.out.println(System.identityHashCode(s1));
		
		System.out.println("------------");
		String string1 = "Lemon";
		String string2 = "Lemon";
		
		String string3 = new String(string1);
		String string4 = new String(string2);
		
		if(string1==string2)
			System.out.println("string1==string2");
		else
			System.out.println("string1!=string2");

		if(string1==string3)
			System.out.println("string1==string3");
		else
			System.out.println("string1!=string3");

		if(string1==string4)
			System.out.println("string1==string4");
		else
			System.out.println("string1!=string4");

		System.out.println("------------");
		if(string2==string3)
			System.out.println("string2==string3");
		else
			System.out.println("string2!=string3");
		
		if(string2==string4)
			System.out.println("string2==string4");
		else
			System.out.println("string2!=string4");
		System.out.println("------------");
		if(string3==string4)
			System.out.println("string3==string4");
		else
			System.out.println("string3!=string4");
		System.out.println("------------");
		System.out.println(string1.hashCode());
		System.out.println(string2.hashCode());
		System.out.println(string3.hashCode());
		System.out.println(string4.hashCode());
		System.out.println("------------");
		System.out.println(System.identityHashCode(string1));
		System.out.println(System.identityHashCode(string2));
		System.out.println(System.identityHashCode(string3));
		System.out.println(System.identityHashCode(string4));
		System.out.print("------------");
		System.out.println("------------");
		String st1 = "Lemon".concat(String.valueOf('A')); //String.valueOf('A')는 문자열 "A"의 인스턴트 참조 값이다. "Lemon".concat(~)는 String st1 = "Lemon" + 'A';와 같은 말. concat('A')는 아니다.
		String st2 = "Lemon".concat(String.valueOf(3)); ////String st1 = "Lemon" + 3;와 같은 말. concat(3)은 아니다.
		String st3 = 1 + "Lemon" + 2; //String.valueOf(1).concat("Lemon").concat(String.valueOf(2)); 이렇게 하면 5번의 String instance가 생성된다.
									//---optimization of string concatenation--->String st3=new StringBuilder().append(1).append("Lemmon").append(2).toString();
									//이렇게 하면 최대 2개의 instance가 생성된다.(append는 this를 반환하기 때문에, StringBuilder와 String instance가 생성됨)
		StringBuilder strbuf = new StringBuilder("hello"); //buffer 크기 확장은 많은 연산이 요구됨. 미리 size를 fix하는 것이 좋다.
		System.out.println(strbuf.reverse()); //olleh
		strbuf.reverse(); //hello
		System.out.println(strbuf.deleteCharAt(2)); //helo
		/*
		java.lang 패키지의 StringBuilder는 문자열의 저장 및 변경을 위한 메모리 공간(버퍼)를 내부에 지니는데, 이 메모리 공간은 크기가 자동으로 조절된다.
		주요 method로는 append(문자열을 뒤에 붙인다), insert(0부터 시작하는 buffer에서 index+1번째 위치에 insert한다. aaaaa일때 insert(2,'A')인 경우, 3번째 위치인 aaAaaa),
		length(저장된 문자열 길이, 버퍼 길이가 아니다)가 있다.
		 */
		//java.sun.com 참고
		
		
	}
}

/*class simplenumber {
	int num = 0;
	private simplenumber(){}
	public void addNum(int n) { num+=n; }
	public void showNum() { System.out.println(num); }
	
	private static simplenumber snInst = null;
	public static simplenumber getSinpleNumberInst() {
		if(snInst == null)
			snInst = new simplenumber();
		return snInst;
	}
	
}
class test {
	public static void main(String args[]) {
		simplenumber num1 = simplenumber.getSinpleNumberInst();
		num1.addNum(20);
		
		simplenumber num2 = simplenumber.getSinpleNumberInst();
		num2.addNum(30);
		
		num1.showNum();
		num2.showNum();
	}
}*/

/*class other {
	int vv = 11;
	static int ss = 11;////
	final int ff = 22;
	static final int sfsf = 33;//
	static public int spsp = 44;////
	static private int sprr = 55; //private이라서 안보임

	public void othertest() {
		vv++;
		ss++;
		//ff++;
		//sfsf++;
		spsp++;
		sprr++;
		
		test.s++;
		//test.sf++;
		test.sp++;
		
		test t = new test();
		t.v++;
		test.s++; //static이라서 변경 알림
		//t.f++; //final이라서 변경 못함
		System.out.println(t.f);//출력은 됨(test.f는 안됨)
		//test.sf++; //static이라서 변경 알림 //final이라서 변경 못함
		System.out.println(test.sf);//출력은 됨
		test.sp++; //static이라서 변경 알림
		//t.spr++;
	}
	
	public static void psps_m () {
		System.out.println("public static method() in other class");
		
		//othertest(); //static method 내에서 instance method 접근 불가
		
		//vv++; //static method 내에서 instance 변수 접근 불가
		ss++;
		//ff++; //final이라서 변경 못함
		//sfsf++; //final이라서 변경 못함
		spsp++;
		sprr++;
	}
}

class test {
	int v = 11;
	static int s = 1; ////
	final int f = 2;
	static final int sf = 3; //
	static public int sp = 4; ////
	static private int spr = 5; //private이라서 안보임
	
	public static void ps_m () {
		System.out.println("public static method() in test class");
		
		//v++; //static method 내에서 instance 변수 접근 불가
		s++;
		//f++; //final이라서 변경 못함
		//sf++; //final이라서 변경 못함
		sp++;
		spr++;
	}
	
	public void testmethod() {
		ps_m();
		//psps_m();
		other.psps_m();
		
		v++;
		s++;
		//f++;
		//sf++;
		sp++;
		spr++;
		
		//other.sfsf++;
		other.spsp++;
		other.ss++;
		
		other o = new other();
		o.vv++;
		other.ss++; //static이라서 변경 알림
		//o.ff++; //final이라서 변경 못함
		//other.sfsf++; //static이라서 변경 알림 //final이라서 변경 못함
		System.out.println(o.ff); //출력은 됨
		System.out.println(other.sfsf); //출력은 됨
		other.spsp++; //static이라서 변경 알림
		//o.sprr++;
	}
	
	public static void main(String[] args) {
		//v = 1;
		//test.v++;
		//vv = 1;
		//other.vv++;
		
		s = 11;
		test.s = 11;
		//ss = 1111;
		other.ss = 1111;
		
		//f = 22;
		//test.f = 22;
		//ff = 2222;
		//other.ff = 2222;
		
		//sf = 33;
		//test.sf = 33;
		//other.sfsf = 3333;
		System.out.println(sf);
		System.out.println(other.sfsf);
		
		sp = 44;
		test.sp = 4444;
		//spsp = 44;
		other.spsp = 44;
		
		spr = 55;
		test.spr = 55;
		//sprr = 55;
		//other.sprr = 55;
		
		ps_m();
		//psps_m();
		other.psps_m();
		
	} 
}*/