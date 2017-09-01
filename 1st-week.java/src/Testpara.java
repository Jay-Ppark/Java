public class Testpara {

	private int a;
	private String[] s = { "", null, null };

	public Testpara(int a, String[] s) {
		this.a = a;
		//s = new String[3];//  이게 왜이럴까?
		this.s[0] = s[0];
		this.s[1] = s[1];
		this.s[2] = s[2];
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String[] getS() {
		return s;
	}

	public void setS(String[] s) {
		s = new String[3];
		this.s[0] = s[0];
		this.s[1] = s[1];
		this.s[2] = s[2];
	}

	public void print() {
		System.out.println(a);
		for (int i = 0; i < 3; i++) {
			System.out.println(s[i]);
		}
	}

}
