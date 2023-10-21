package edu.project1;

import java.util.Scanner;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GameManager gameManager = new GameManager();
        gameManager.run(in);
    }

}
