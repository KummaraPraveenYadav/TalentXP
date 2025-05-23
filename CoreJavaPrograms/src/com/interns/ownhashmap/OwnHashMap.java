package com.interns.ownhashmap;

class SimpleHashMap<K,V>
{
	private Object[] keys;
	private Object[] values;
	private static final int SIZE = 16;
	
	
	public SimpleHashMap()
	{
		keys = new Object[SIZE];
		values = new Object[SIZE];
	}
	private int getIndex(K key)
	{
		//long s = key.hashCode();
		//System.out.println(s);
		return key.hashCode() % SIZE;
	}
	
	public void put(K key,V value)
	{
		int index = getIndex(key);
		keys[index]=key;
		values[index]=value;
	}
	public V get(K key)
	{
		int index = getIndex(key);
		return (V) values [index];
	}
}
public class OwnHashMap {
	private static final int SIZE = 0;

	public static void main(String[] args) {
		SimpleHashMap<String,Integer> map = new SimpleHashMap<>();
		//if(SIZE>16)
		//{
		//	final int DSIZE = SIZE*2;
		//}
		//else
			
		map.put("IND", 1);
		map.put("HYD", 2);
		map.put("BLR", 3);
		//map.put("Chennai",5);
		map.put("AP", 6);
		map.put("GOA", 9);
		
		
		System.out.println(map.get("GOA"));

		
	}
}
