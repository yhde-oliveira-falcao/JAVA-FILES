package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting the pyramid of numbers");
        final int ROWS = 8;

        for(int i = 1; i <= ROWS; i++){
            for(int j = ROWS - i; j > 0; j--) {
                System.out.printf("%4s", ' ');
            }
            for(int l = 0; l < i; l++){
                System.out.printf("%4s", (int) Math.pow(2,l));
            }
            for(int res = (i - 2); res >= 0; res--){
                System.out.printf("%4s", (int) Math.pow(2,res));
            }
            System.out.println();
        }
        //I've tried with if conditions and and only
        // two for loops and got close. but the code was too messy.
        //So instead of working with 2 dimensions, I worked with each
        //part of the printout of the numbers, inside the x axis.
    }
}

/*#include <stdio.h>
//It is coded in C to check the logic quickly.
        int main()
        {
        int col = 16; int middle = 8;
        int rows = 8;
        int num;
        for(int i = 1; i <= rows; i++){
        for (int j = col; j > 1; j--){
        int res = (middle+1) - j;
        if (res < 0){
        res -= res *2;
        }
        if(res < i){
        //int c = (rows - res);
        int d = (res - i); d -=d*2;

        printf("%d", d);
        } else {
        printf(" ");
        }

        printf("    ");
        }
        printf("\n");
        }

        return 0;
        }
*/