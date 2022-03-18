package stack;

public class StackTest {

	public static void main(String[] args) {
		StackInterface<Integer> A = new ArrayStack<>();
		StackInterface<Integer> B = new LinkedStack<>();
		A.push(3);
		A.push(2);
		A.push(5);
		
		B.push(3);
		B.push(2);
		B.push(5);
		
		System.out.println(A);
		System.out.println(B);
		
		while(!B.isEmpty()) {
			System.out.println(B.pop());
		}
	}

}
