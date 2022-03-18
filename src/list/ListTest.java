package list;

public class ListTest{
	
	
	public static void main(String[] args) {
		LList<Integer> list = new LList<>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(3, 26);
		System.out.println(list.remove(5));
		list.display();

	}

}
