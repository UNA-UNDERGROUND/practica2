package cr.ac.una.collections.test;

import java.util.Objects;

public class A {

    public A(String e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return String.format("a:{e: %s}", getE());
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof A) && (hashCode() == o.hashCode());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.e);
        return hash;
    }

    public String getE() {
        return e;
    }

    private final String e;
}
