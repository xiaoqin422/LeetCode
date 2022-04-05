package com.study;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        String path = sc.next();
        int result = X;
        for (int i = 0; i < N; i++) {
            char c = path.charAt(i);
            if (c == 'U'){
                result = result / 2;
            }else if (c == 'R'){
                result = result * 2 + 1;
            }else {
                result = result * 2;
            }
        }
        System.out.println(result);
    }
}