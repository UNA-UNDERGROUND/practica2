package cr.ac.una.collections;

import java.util.Iterator;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.0 2021-08-21
 *
 */
public class List<T> extends Collection<T> {

	public List(String name) {
		super(name);
		this.n = 0;
		this.first = this.last = null;
	}

	public List() {
		this(null);
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public void add(T obj) {
		if (obj != null) {
			Node<T> tmp = new Node<>(obj);
			if (first == null) {
				first = last = tmp;
			} else {
				last.setNext(tmp);
				last = tmp;
			}
			n++;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void add(T obj, int pos) {
		if (obj != null) {
			if ((pos < 0) || (n <= pos)) {
				add(obj);
			} else {
				if (pos == 0) {
					first = new Node<>(obj, first);
					if (first.getNext() == null) {
						last = first;
					}
				} else {
					Node<T> cursor = first;
					int k = 1;
					while (k < pos) {
						cursor = cursor.getNext();
						k++;
					}
					cursor.setNext(new Node<>(obj, cursor.getNext()));
					if (cursor.getNext() == null) {
						last = cursor;
					}
				}
				n++;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public T remove() {

		// Elimina el ULTIMO elemento de la lista en un tiempo O(1).
		// Lanza una excepción IndexOutOfBoundsException si la
		// lista está vacía.

		// no es posible debido a la implementacion la cual no tiene un previo a last en
		// O(1)
		T val = last.getInfo();
		Node<T> node = first;
		if (n < 2) {
			last = null;
			first = null;
		} else {
			for (int i = 0; i < n - 2; i++) {
				node = node.getNext();
			}
		}
		last = node;
		if (val != null) {
			n--;
		}
		return val;
	}

	@Override
	public T remove(int pos) {
		// Elimina el elemento en la i-ésima posición de la lista
		// en un tiempo O(n). La primera posición es la posición 0.
		// Lanza una excepción IllegalArgumentException si la
		// lista está vacía o la posición está fuera de los límites
		// de la lista.
		T val = null;
		Node<T> node = first;
		if (n < 2) {
			if (pos == 0 && node != null) {
				val = node.getInfo();
			}
			last = null;
			first = null;
		} else {
			for (int i = 0; i < pos && node != null; i++) {
				node = node.getNext();
			}
			if (node != null) {
				val = node.getInfo();
				node = node.getNext();
			}

		}
		if (val != null) {
			n--;
		}
		return val;
	}

	@Override
	public T remove(T e) {
		// Elimina el elemento e de la lista en un tiempo O(n).
		// Para comparar el elemento, debe utilizar el método equals().
		// https://www.geeksforgeeks.org/difference-equals-method-java/
		// https://www.baeldung.com/java-equals-hashcode-contracts
		//
		// Regresa una referencia nula si el elemento no se encuentra
		// en la lista.
		T val = null;
		Node<T> node = first;

		for (int i = 0; i < n; i++) {
			if (node.getInfo().equals(e)) {
				break;
			}
			node = node.getNext();
		}
		if (node != null) {
			val = node.getInfo();
			node = node.getNext();
		}
		if (val != null) {
			n--;
		}
		return val;
	}

	@Override
	public T get(int pos) {
		T r = null;
		if ((0 <= pos) && (pos < size())) {

			Iterator<T> i = iterator();
			int k = 0;
			while (k < pos) {
				i.next();
				k++;
			}
			r = i.next();
		}
		return r;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<>(first);
	}

	private int n;
	private Node<T> first;
	private Node<T> last;

}
