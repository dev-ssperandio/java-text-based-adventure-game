package com.textbasedadventuregame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int health = 100;
    public static int score = 0;

    public static void main(String[] args) {
        System.out.println("Welcome To The Text Adventure Game!\n");
        startGame();
        clear();
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You find yourself in a mysterious place: ");
        System.out.print("1. Explore the Dark Cave\n2. Walk through the Enchanted Forest\nEnter your choice: ");
        int choice = scanner.nextInt();

        System.out.println();
        clear();

        if (choice == 1) exploreDarkCave();
        else if (choice == 2) walkEnchantedForest();
        else System.out.println("Inválid Choice. Game Over!");

        clear();
        scanner.close();
    }

    public static void exploreDarkCave() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You enter the Dark Cave and discover a Treasure Chest!");
        System.out.print("1. Open the Chest\n2. Leave the Cave\nEnter your choice: ");

        int choice = scanner.nextInt();
        System.out.println();

        if (choice == 1) {
            int action = exploreRandom();
            if (action == 0) {
                System.out.println("A Dragon comes out and it eats you alive!\nYou Died!");
                System.out.println("Your Collected Score: " + score);
                pause();
            } else {
                System.out.println("You find out a Treasure!");
                score += 20;
                System.out.println("Your Score: " + score);
                System.out.println("You Are Now Good To Go Ahead");
                pause();
                clear();
                confir();
            }
        } else if (choice == 2) {
            System.out.println("You Leave The Cave And Continue Your Adventure.");
            confir();
        } else {
            System.out.println("Invalid Choice. Game Over!");
        }

        scanner.close();
    }

    public static void walkEnchantedForest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You walk trough the Echanted Forest and encounter a Dangerous Creature!");
        System.out.print("1. Fight with the Dangerous Creature\n2. Continue walking\nEnter your choice: ");

        int choice = scanner.nextInt();

        clear();

        if (choice == 1) {
            int action = exploreRandom();
            if (action == 0) {
                System.out.println("The Dangerous Creature win and ate you alive\nYou Died!");
                System.out.println("Your Collected Score: " + score);
                pause();
            } else {
                System.out.println("You win the battle!");
                score += 20;
                System.out.println("Your Score: " + score);
                System.out.println("You Are Now Good To Go Ahead");
                pause();
                clear();
                confir();
            }
        } else if (choice == 2) {
            System.out.println("You continue walking through the Echanted Forest");
            confir();
        } else {
            System.out.println("Invalid Choice. Game Over!");
        }

        scanner.close();
    }

    public static void confir() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. Start the game\n2. End the game\nEnter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            startGame();
        } else {
            System.out.println("\nGame Over!\nYour Health: " + health + "\nYour Collected Score: " + score);
        }
        pause();
        clear();
    }

    public static int exploreRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public static void pause() {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    public static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}