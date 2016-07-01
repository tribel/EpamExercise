package map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CustomHashMap<K, V>  implements Map<K, V>{

	private final static float DEFAULT_LOAD_FACTOR = 0.75f;
	private final static int DEFAULT_CAPACITY = 16;
	
	static class Node<K, V> {
		final int hash;
		final K key;
		V value;
		private Node<K, V> next;
		
		public Node(int hash, K k, V v, Node<K, V> next) {
			this.hash = hash;
			this.key = k;
			this.value = v;
			this.next = next;
		}
		
		public int hashCode() {
			return key.hashCode();
		}
		
		public K getKey() { return key; }
		public V getValue() {return value; }
		public Node<K, V> getNext() {return next; };
		
		public void setNext(Node<K, V> node) {
			this.next = node;
		}
		
	}
	
	private Node<K, V>[] bukets;
	private int size;
	private final float loadFactor;
	private int capacity;
	
	
	public CustomHashMap() {
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		this.capacity = DEFAULT_CAPACITY;
		this.bukets = new Node[capacity];
	}
	
	private void addCapacity() {
		Node[] temp = new Node[size + DEFAULT_CAPACITY];
		System.arraycopy(bukets, 0, temp, 0, bukets.length);
	}
	
	private void checkCapacity() {
		if(bukets.length >= size) addCapacity();
	}
	
	private int calculatePosition(Object object) {
		return object.hashCode() % bukets.length;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		int position = calculatePosition(key);	
		return (V) bukets[position].getValue();
	}

	private void putNext(Node next, K k, V v) {
		if(next.getNext() != null) {
			putNext(next.getNext(), k, v);
			
		} else {
			next.setNext(new Node(k.hashCode(), k, v, null));
		}
	}
	
	@Override
	public V put(K key, V value) {
		int position = calculatePosition(key);
		
		if(bukets[position] == null) {
			bukets[position] = new Node<>(key.hashCode(), key, value, null);
		} else {
			putNext(bukets[position], key, value);
		}
		
		size++;
		return value;
	}

	private void removeNext(Node next) {
		if(next != null) {
			if(next.getNext() != null) {
				removeNext(next);
			}
		
			next = null;
		}
	}
	
	@Override
	public V remove(Object key) {
		int position = calculatePosition(key);
		Node temp = bukets[position];
		removeNext(bukets[position]);
		bukets[position] = null;
		size--;
		return (V) temp.getValue();
	}

	@Override  
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
