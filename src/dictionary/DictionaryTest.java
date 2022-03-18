package dictionary;

public class DictionaryTest {
	public static void main(String[] args) {
		DictionaryInterface<String, Integer> dic = new ArrayDictionary<>();
		
		dic.add("A", 5);
		dic.add("B", 3);
		dic.add("C", 20);
		
		System.out.println(dic.contains("C"));
		System.out.println(dic.contains("D"));
		System.out.println(dic.getValue("A"));
		System.out.println(dic.getValue("B"));
		System.out.println(dic.getValue("C"));



	}

}
