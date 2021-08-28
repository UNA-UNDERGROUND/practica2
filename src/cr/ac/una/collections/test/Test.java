package cr.ac.una.collections.test;

import cr.ac.una.collections.Array;
import cr.ac.una.collections.Collection;
import cr.ac.una.collections.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        new Test().init();
    }

    public void init() {
        System.out.println();
        System.out.println("========================================================================");
        System.out.println("Operaciones de arreglo:");
        System.out.println("------------------------------------------------------------------------");
        System.out.println();

        Collection<A> c1 = new Array<>();
        generalTest(c1);

        System.out.println();
        System.out.println("========================================================================");
        System.out.println("Operaciones de lista:");
        System.out.println("------------------------------------------------------------------------");
        System.out.println();

        Collection<A> c2 = new List<>();
        generalTest(c2);

        System.out.println("------------------------------------------------------------------------");
        System.out.println();
    }

    public void generalTest(Collection<A> c1) {

        System.out.println("Elimina elementos al inicio de la coleccion:");
        System.out.println();
        test1(c1);

        System.out.println("Elimina elementos al final de la coleccion:");
        System.out.println();
        test2(c1);

        System.out.println("Elimina elementos en posiciones arbitrarias de la coleccion:");
        System.out.println();
        test3(c1);

        System.out.println("Recupera elementos por posicion:");
        System.out.println();
        test4(c1);

        System.out.println("Elimina elementos por valor:");
        System.out.println();
        test5(c1);

        System.out.println("Inserta elementos en posiciones arbitrarias:");
        System.out.println();
        test6(c1);
    }

    public void test1(Collection<A> c1) {
        System.out.println("Agrega elementos al final..");
        System.out.println();
        for (int i = 0; i < N; i++) {
            c1.add(new A("a" + (i + 1)));
            System.out.println(c1);
        }
        System.out.println();

        while (!c1.isEmpty()) {
            System.out.printf("Elimina (inicio): %s%n", c1.remove(0));
            System.out.println(c1);
        }
        System.out.println();
        System.out.println(c1);
        System.out.println();

        System.out.println("Agrega elementos al inicio..");

        for (int i = 0; i < N; i++) {
            c1.add(new A("a" + (i + 1)), 0);
            System.out.println(c1);
        }
        System.out.println();

        while (!c1.isEmpty()) {
            System.out.printf("Elimina (inicio): %s%n", c1.remove(0));
            System.out.println(c1);
        }
        System.out.println();
    }

    public void test2(Collection<A> c1) {
        for (int i = 0; i < N; i++) {
            c1.add(new A("a" + (i + 1)));
        }
        System.out.println(c1);
        System.out.println();

        while (!c1.isEmpty()) {
            System.out.printf("Elimina (final): %s%n", c1.remove());
            System.out.println(c1);
        }
        System.out.println();
    }

    public void test3(Collection<A> c1) {
        System.out.println(c1);
        for (int i = 0; i < N; i++) {
            c1.add(new A("a" + (i + 1)));
        }
        System.out.println();

        {
            int pos = 0;
            m1(pos = -1, c1);
            m1(pos = 999, c1);
        }

        System.out.println();

        while (!c1.isEmpty()) {
            int pos = r.nextInt(c1.size());
            System.out.printf("Elimina %d: %s%n", pos, c1.remove(pos));
            System.out.println(c1);
        }
        System.out.println();
    }

    private int m1(int pos, Collection<A> c1) {
        try {
            A e = c1.remove(pos);
            if (e != null) {
                System.out.printf("Elimina %d: %s%n", pos, e);
            } else {
                System.err.printf("No existe la posición: %d%n", pos);
            }
        } catch (Exception ex) {
            System.err.printf("No puede eliminar el elemento en la posición: %d%n", pos);
        }
        return pos;
    }

    public void test4(Collection<A> c1) {
        System.out.println(c1);
        for (int i = 0; i < N; i++) {
            c1.add(new A("a" + (i + 1)));
        }
        System.out.println(c1);
        System.out.println();

        for (int i = 0; i < c1.size(); i++) {
            System.out.printf("%d: %s%n", i, c1.get(i));
        }
        System.out.println();
    }

    public void test5(Collection<A> c1) {
        System.out.println(c1);
        System.out.println();

        while (!c1.isEmpty()) {
            int p = r.nextInt(c1.size());
            A e = c1.get(p);
            System.out.printf("Eliminar: %s (%d) ...%n", e, p);
            c1.remove(e);
            System.out.println(c1);
            System.out.println();
        }
        System.out.println();
    }

    public void test6(Collection<A> c1) {
        System.out.println(c1);
        System.out.println();

        int i = 0;
        while (c1.size() < N) {
            int p0 = r.nextInt(c1.size() + 8) - 3;
            A a1 = new A("a" + (i + 1));
            System.out.printf("Insertando: %s ->[%d] ...%n", a1, p0);
            c1.add(a1, p0);
            System.out.println(c1);
        }

        c1.clear();
        System.out.println(c1);
        System.out.println();
    }

    private static final int N = 8;
    private final Random r = new Random();
}
