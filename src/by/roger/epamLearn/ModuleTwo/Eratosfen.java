package by.roger.epamLearn.ModuleTwo;

import java.util.Arrays;

/*
Алгоритм нахождения всех простых чисел до некоторого целого числа n.
 */
public class Eratosfen {
    boolean[] primes;
    public Eratosfen(int n) {
        primes=new boolean[n+1];
    }
    public void fillSieve() {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; ++j) {
                    primes[i * j] = false;
                }
            }
        }
    }
    public boolean get(int i){
        return primes[i];
    }
}
