package org.example;

public class Prime {

    private Prime() {
        throw new AssertionError();
    }

    public static boolean check(int num) {
        if (num < 2) throw new IllegalArgumentException("Illegal number argument " + num);

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
