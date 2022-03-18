package queue;

public class QueueTest {
	public static void main(String[] args) {
		QueueInterface<String> line2 = new LinkedQueue<>();
		
		System.out.println(line2.enqueue("A"));
		System.out.println(line2.enqueue("B"));
		System.out.println(line2);
		System.out.println(line2.dequeue());
		System.out.println(line2.dequeue());
		System.out.println(line2.enqueue("C"));
		System.out.println(line2.dequeue());
		System.out.println(line2.enqueue("D"));
		System.out.println(line2);


		

	}
}
