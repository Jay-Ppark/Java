
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A var1 = new A();
		A var2 = new B();
		B var3 = new D();
		C var4 = new C();
		D var5 = new D();
		Object var6 = new B();
		
		
		//var1.method1();
		var2.method1();
		//var3.method1();
		//var4.method1();
		//var5.method1();
		//var6.method1();   //자식 클래스에만 함수가있고 부모클래스에 함수가 없으면 컴파일타임에러!!!!
		var1.method2();
		var2.method2();
		//var3.method2();
		//var4.method2();
		//var5.method2();
		//var6.method2();  //컴파일 에러!!!!!!!!!!!!!!!!!!1
		//var3.method3();    //컴파일 에러!!!!!!!!!!!!!!!!
		//var5.method3();
		//((B) var1).method1();   // downcasting error run-time error
		//((C) var2).method2();   // downcasting error run-time error
		//((D) var5).method1();
		//((C) var3).method3();
		//((D) var6).method3();   // downcasting error run-time error587
		//((C) var6).method2();   // downcasting error run-time error
	}

}
