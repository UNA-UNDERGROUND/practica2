package cr.ac.una.collections;

import java.util.Iterator;

/**
 *
 * (c) 2021
 *
 * @author Georges Alfaro S.
 * @version 1.0.1 2021-08-24
 *          1.0.0 2021-08-21
 */
public class Array<T> extends Collection<T> {

	public Array(int m, String name) {
		super(name);
		this.e = new Object[m];
	}

	public Array(int m) {
		this(m, null);
	}

	public Array() {
		this(MAX_ARRAY, null);
	}

	public int maxCapacity() {
		return e.length;
	}

	@Override
	public void add(T obj) {
		if ((obj != null) && (n < e.length)) {
			e[n++] = obj;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void add(T obj, int pos) {
		if ((pos < 0) || (n <= pos)) {
			pos = n;
		}
		if (obj != null) {
			if (n < e.length) {
				for (int i = n; i > pos; i--) {
					e[i] = e[i - 1];
				}
				e[pos] = obj;
				n++;
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public T remove() {

		// Elimina el ULTIMO elemento del arreglo en un tiempo O(1).
		// Lanza una excepción IndexOutOfBoundsException si el
		// arreglo está vacío.
		if (n < 0) {
			throw new RuntimeException();
		}
		T val = (T) e[n - 1];
		e[n - 1] = null;
		n--;
		return val;
	}

	@Override
	@SuppressWarnings("Unchecked")
	public T remove(int pos) {
		// Elimina el elemento en la i-ésima posición del arreglo
		// en un tiempo O(n). La primera posición es la posición 0.
		// Lanza una excepción IndexOutOfBoundsException si el
		// arreglo está vacío o la posición está fuera de los límites
		// del arreglo.
		if (pos < 0 || pos > n) {
			throw new RuntimeException();
		}
		T val = (T) e[pos];
		e[pos] = null;
		for (int i = pos; (i + 1) < n; i++) {
			e[i] = e[i + 1];
		}
		n--;
		return val;
	}

	@Override
	@SuppressWarnings("Unchecked")
	public T remove(T e) {
		// Elimina el elemento e del arreglo en un tiempo O(n).
		// Para comparar el elemento, debe utilizar el método equals().
		// https://www.geeksforgeeks.org/difference-equals-method-java/
		// https://www.baeldung.com/java-equals-hashcode-contracts
		//
		// Lanza una excepción IllegalArgumentException si el
		// elemento no se encuentra en el arreglo.
		T val = null;
		for (int i = 0; i < this.n; i++) {
			if (this.e[i].equals(e)) {
				val = (T) this.e[i];
				this.e[i] = null;
				for (int j = i; (j + 1) < this.n; j++) {
					this.e[j] = this.e[j + 1];
				}
				n--;
				break;
			}
		}
		return val;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(int pos) {
		T r = null;
		if ((0 <= pos) && (pos < n)) {
			r = (T) e[pos];
		}
		return r;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator<>(n, e);
	}

	private static final int MAX_ARRAY = 128;
	private Object[] e;

}
