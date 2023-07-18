package org.example;

import java.util.Scanner;

public class Main {
    int n;

    void solve() {
        System.out.print(n + " ");
        while (n!=1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        main.n = scanner.nextInt();
        main.solve();
    }
}