package heap;

public class HeapTest {

	public static void main(String[] args) {
		MinHeapInterface<Integer> heap = new ArrayMinHeap<>();
		heap.add(4);
		heap.add(24);
		heap.add(6);
		heap.add(2);
		heap.add(7);
		heap.add(1);
		int topNumber = heap.removeMin();
		heap.add(topNumber + 2);
		while(!heap.isEmpty()) {
			System.out.println(heap.removeMin());
		}

	}

}
