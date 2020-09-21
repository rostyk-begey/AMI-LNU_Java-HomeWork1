package com.company;

import java.util.Scanner;
import java.io.File;

public class Task2 {
    private static void execute(String[] words) {
        System.out.print("Result: ");
        for (var word : words) {
            System.out.printf("%s => %s\n", word, word.replaceAll("t", "th"));
        }
        System.out.print('\n');
    }

    public static void Run() {
        var in = new Scanner(System.in);
        System.out.print("Enter words: ");
        var words = in.nextLine().split(",");
        execute(words);
    }

    public static void RunTest() {
        var input = "lorem, ipsum, dolor, sit, amet, consectetur, adipiscing, elit, sed, do, eiusmod, tempor, incididunt, ut, labore, et, dolore, magna, aliqua, ut, enim, ad, minim, veniam, quis, nostrud, exercitation, ullamco, laboris, nisi, ut, aliquip, ex, ea, commodo, consequat, duis, aute, irure, dolor, in, reprehenderit, in, voluptate, velit, esse, cillum, dolore, eu, fugiat, nulla, pariatur, excepteur, sint, occaecat, cupidatat, non, proident, sunt, in, culpa, qui, officia, deserunt, mollit, anim, id, est, laborum";
        execute(input.split(", "));
    }
}
