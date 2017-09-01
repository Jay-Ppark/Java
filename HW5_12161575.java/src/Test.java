public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cube cub1 = new Cube("myCube", 0.4);      	//make cube object
		Sphere sp1 = new Sphere("mySphere", 0.3);	//make sphere object
		Cone co1 = new Cone("myCone", 0.7, 1.2);	//make cone object

		//print
		System.out.println(cub1.toString());
		System.out.printf("side = %.1f\nsurface area = %.2f\nvolume = %.3f\n\n",
				cub1.getLength(), cub1.getArea(), cub1.getVolume());
		
		//print
		System.out.println(sp1.toString());
		System.out.printf("radius = %.1f\nsurface area = %.3f\nvolume = %.3f\n\n",
				sp1.getRadius(), sp1.getArea(), sp1.getVolume());

		//print
		System.out.println(co1.toString());
		System.out.printf("height = %.1f\nradius = %.1f\nsurface area = %.3f\nvolume = %.3f\n",
				co1.getHeight(),co1.getRadius(), co1.getArea(), co1.getVolume());
	}

}
