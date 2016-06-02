package list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Developing custom ArrayList clone.
 * @author Tribel
 *
 */
public class CustomArrayList<E> implements List<E>{

	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elementData;
	private int size;
	
	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public CustomArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}
	
	
	/**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  initialCapacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
	public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    } 
	
	/**
     * @return the number of elements in this list
     */
	@Override
	public int size() {
		return this.size;
	}

	/**
     * @return <tt>true</tt> if this list contains no elements
     */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
     * Increases the capacity of this instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     */
	private void ensureCapacity(int minCapacity) {
		if(minCapacity - elementData.length >0) {
			grow(minCapacity);
		}
	}
	
	/**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     */
	private void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = (oldCapacity * 3)/2 + 1;
		if(newCapacity - minCapacity < 0) {
			newCapacity = minCapacity;
		}
		
		elementData = Arrays.copyOf(elementData, newCapacity);
	}
	 
	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
	 */
	@Override
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}
	
	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	/**
    * Appends the specified element to the end of this list.
    * @param e element to be appended to this list
    */
	@Override
	public boolean add(E e) {
		ensureCapacity(size + 1);
		elementData[size++] = e;
		return true;
	}

	/**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
    }
	
    
    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
	@Override
	public boolean remove(Object o) {
		 if (o == null) {
	            for (int index = 0; index < size; index++)
	                if (elementData[index] == null) {
	                    remove(index);
	                    return true;
	                }
	        } else {
	            for (int index = 0; index < size; index++)
	                if (o.equals(elementData[index])) {
	                    remove(index);
	                    return true;
	                }
	        }
	        return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
	}

	
	/**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     */
	@Override
	public E get(int index) {
		rangeCheckForAdd(index);
		return (E) elementData[index];
	}

	/**
     * Replaces the element at the specified position in this list with
     * the specified element.
     */
	@Override
	public E set(int index, E element) {
		rangeCheckForAdd(index);
		E oldValue = (E) elementData[index];
		elementData[index] = element;
		return oldValue;
	}

	
	/**
     * Inserts the specified element at the specified position in this
     * list. 
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		elementData[index] = element;
		ensureCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = element;
		size++;
	}

	/**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
	@Override
	public E remove(int index) {
		rangeCheckForAdd(index);
		
		E oldValue = (E) elementData[index];
		int numMoved = size - index - 1;
		if(numMoved > 0) {
			System.arraycopy(elementData, index +1, elementData, index, numMoved);
		}
		
		elementData[--size] = null;
		return oldValue; 
	}

	@Override
	public int indexOf(Object o) {
		 if (o == null) {
	            for (int i = 0; i < size; i++)
	                if (elementData[i]==null)
	                    return i;
	        } else {
	            for (int i = 0; i < size; i++)
	                if (o.equals(elementData[i]))
	                    return i;
	        }
	        return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListIterator<E>() {
			int index = 0;
			
			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public E next() {
				return (E) elementData[index++];
			}

			@Override
			public boolean hasPrevious() {
				return index > 0;
			}

			@Override
			public E previous() {
				return (E) elementData[--index];
			}

			@Override
			public int nextIndex() {
				return index + 1;
			}

			@Override
			public int previousIndex() {
				return index - 1;
			}

			@Override
			public void remove() {
				CustomArrayList.this.remove(index--);
			}

			@Override
			public void set(E e) {
				CustomArrayList.this.set(index, e);
			}

			@Override
			public void add(E e) {
				CustomArrayList.this.add(index, e);
			}
			
		};
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
