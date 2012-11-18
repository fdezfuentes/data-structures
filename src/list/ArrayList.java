package list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<T> implements List<T> {
	private final int CAPACITY = 10;
	private int nextPos;
	private T[] elements;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		elements = (T[]) new Object[CAPACITY];
		nextPos = 0;
	}

	public boolean add(T elem) {
		add(nextPos, elem);
		return true;
	}

	public void add(int i, T elem) {
		ensureCapacity();
		if (i != nextPos) {
			ensureIndex(i);
			for (int pos = nextPos - 1; pos >= i; pos--) {
				elements[pos + 1] = elements[pos];
			}
		}
		elements[i] = elem;
		nextPos++;
	}

	private void ensureCapacity() {
		if (nextPos == elements.length) {
			elements = Arrays.copyOf(elements, nextPos * 2);
		}
	}

	private void ensureIndex(int i) {
		if (i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean addAll(Collection<? extends T> collection) {
		for (T c : collection) {
			add(c);
		}
		return true;
	}

	public boolean addAll(int i, Collection<? extends T> collection) {
		for (T c : collection) {
			add(i, c);
			i++;
		}
		return true;
	}

	public void clear() {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public boolean contains(Object n) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public boolean containsAll(Collection<?> collection) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public int indexOf(Object o) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public T get(int i) {
		ensureIndex(i);
		return elements[i];
	}

	public boolean isEmpty() {
		return nextPos == 0;
	}

	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<T> {
		int current;

		public ArrayListIterator() {
			current = 0;
		}

		public boolean hasNext() {
			return current < nextPos;
		}

		public T next() {
			T x = elements[current];
			current = current + 1;
			return x;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public ListIterator<T> listIterator(int i) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public T remove(int i) {
		ensureIndex(i);
		T previous = elements[i];
		for (int pos = i; pos < nextPos - 1; pos++) {
			elements[pos] = elements[pos + 1];
		}
		nextPos--;
		return previous;
	}

	public boolean removeAll(Collection<?> collection) {
		for (Object c : collection) {
			remove(c);
		}
		return true;
	}

	public boolean retainAll(Collection<?> collection) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public T set(int i, T elem) {
		ensureIndex(i);
		T previous = elements[i];
		elements[i] = elem;
		return previous;
	}

	public int size() {
		return nextPos;
	}

	public List<T> subList(int x, int y) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public Object[] toArray() {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("Not yet implemented.");
	}

}
