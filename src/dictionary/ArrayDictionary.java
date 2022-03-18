package dictionary;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayDictionary<K, V> implements DictionaryInterface<K, V> {
	private Entry[] dictionary;
	private final int DEFAULT_CAPACITY = 50;
	private int numOfEntries;
	@SuppressWarnings("unused")
	private boolean integrityOK = false;
	
	@SuppressWarnings("unchecked")
	public ArrayDictionary() {
		try {
			this.dictionary = (Entry[]) Array.newInstance(Entry.class, DEFAULT_CAPACITY);
			numOfEntries = 0;
			integrityOK = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayDictionary(int capacity) {
		try {
			this.dictionary = (Entry[]) Array.newInstance(Entry.class, capacity);
			numOfEntries = 0;
			integrityOK = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override                           
	public V add(K key, V value) {
		if (!contains(key)) {
			Entry temp = new Entry(key, value);
			dictionary[numOfEntries] = temp;
			numOfEntries++;
			return temp.getValue();
		}else
			return null;
	}

	@Override
	public V remove(K key) {
		int i = findIndex(key);
		if(i != -1) {
			V temp;
			temp = dictionary[i].getValue();
			dictionary[i] = dictionary[numOfEntries -1];
			dictionary[numOfEntries -1] = null;
			numOfEntries--;
			return temp;
		}else
			return null;
	}

	@Override
	public V getValue(K key) {
		int i = findIndex(key);
		if(i != -1) {
			return dictionary[i].getValue();
		}else
			return null;
	}

	@Override
	public boolean contains(K key) {
		if(findIndex(key) != -1) 
			return true;
		else
			return false;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		return null;
	}
	
	private int findIndex(K key) {
		int i = 0;
		boolean found = false;
		while(!found && i < numOfEntries) {
			if (dictionary[i].getKey().equals(key)) {
				found = true;
			}
			i++;
		}
		
		
		if(found)
			return i-1;
		else
			return -1;
	}
	
	
	private class Entry{
		private K key;
		private V value;
		
		private Entry(K searchKey, V dataValue) {
			key = searchKey;
			value = dataValue;
		}

		private V getValue() {
			return value;
		}

		@SuppressWarnings("unused")
		private void setValue(V value) {
			this.value = value;
		}

		private K getKey() {
			return key;
		}
	}

}
