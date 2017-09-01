
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 3;
		String[] namelist = {"Kim", "Park", "lee", "Sam"};
		for(String name : namelist){
			System.out.print(name);
			System.out.print(",");
		}
		for(int i = 0;i<namelist.length;i++){
			System.out.print(namelist[i]);
			System.out.print(",");
		}
		if(k>2)
		{
			System.out.print("!");
		}
		if(k>1)
		{
			System.out.print(",@");
		}
	}

}
