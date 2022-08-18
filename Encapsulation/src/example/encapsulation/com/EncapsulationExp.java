package example.encapsulation.com;

public class EncapsulationExp {

	public static void main(String[] args) {
		
		Student obj = new Student();
		obj.setStdid(12);
		obj.setStdname("Brunda Puttaraju");
		obj.setStdrollno(520638);

		System.out.println(obj.getStdid());
		System.out.println(obj.getStdname());
		System.out.println(obj.getStdrollno());
	}

}
