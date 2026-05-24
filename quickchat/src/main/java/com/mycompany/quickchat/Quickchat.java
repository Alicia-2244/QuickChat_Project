/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner;
/**
 *
 * @author rikha
 */
public class Quickchat {

    static Scanner scanner = new Scanner(System.in);

    // Login details
    static final String USERNAME = "Mike";
    static final String PASSWORD = "1234";

    // Arrays to store messages
    static String[] recipients = new String[60];
    static String[] messages = new String[60];
    static String[] hashes = new String[60];

    static int totalMessagesSent = 0;

    public static void main(String[] args) {

        System.out.println("Welcome to QuickChat");

        // Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!loginUser(username, password)) {
            System.out.println("Username or password incorrect.");
            return;
        }

        System.out.println("Login successful!");

        boolean running = true;

        while (running) {

            System.out.println(" QUICKCHAT MENU ");
            System.out.println("Total messages sent: " + totalMessagesSent);
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Quit");
            System.out.print("Choose option: ");

            String option = scanner.nextLine();

            switch (option) {

                case "1" -> sendMessages();

                case "2" ->System.out.println("Coming Soon.");
                            
                case "3" -> {
                    System.out.println("Thank you for using QuickChat.");
                    running = false;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static boolean loginUser(String username, String password) {
        return username.equals(USERNAME) &&
               password.equals(PASSWORD);
    }

    public static void sendMessages() {

        System.out.print("How many messages would you like to enter? ");

        int numberOfMessages;

        try {
            numberOfMessages = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }

        for (int i = 0; i < numberOfMessages; i++) {

            if (totalMessagesSent >= recipients.length) {   
                System.out.println("Message storage is full.");
                return;
            }

            System.out.println(" Message " + (i + 1));

            System.out.print("Enter recipient number: ");
            String recipient = scanner.nextLine();

            System.out.print("Enter message: ");
            String message = scanner.nextLine();

            if (message.length() > 250) {
                System.out.println(
                        "Message exceeds 250 characters by "
                                + (message.length() - 250)
                                + ", please reduce size.");
                i--;
                continue;
            } else {
                System.out.println("Message ready to send.");
            }

            String hash =
                    createMessageHash(recipient,
                            totalMessagesSent + 1,
                            message);

            System.out.println("  Message ID: " + (totalMessagesSent + 1));
            System.out.println("Message Hash: " + hash);

            System.out.println("1. Send Message");    
            System.out.println("2. Discard Message");
            System.out.print("Select option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    recipients[totalMessagesSent] = recipient;
                    messages[totalMessagesSent] = message;
                    hashes[totalMessagesSent] = hash;
                    totalMessagesSent++;
                    System.out.println("Message successfully sent.");
                    System.out.println("Total messages sent: "
                            + totalMessagesSent);
                }
                case "2" -> System.out.println("Message successfully discarded.");
                default -> {
                    System.out.println("Invalid selection.");
                    i--;
                }
            }
        }
    }

   
    public static void showRecentMessages() {

        if (totalMessagesSent == 0) {
            System.out.println("No messages sent yet.");
            return;
        }

        System.out.println(" Recently Sent Messages ");

        for (int i = 0; i < totalMessagesSent; i++) {
            System.out.println("Message ID: " + (i + 1));
            System.out.println("Recipient:  " + recipients[i]);
            System.out.println("Message:    " + messages[i]);
            System.out.println("Hash:       " + hashes[i]);
            System.out.println("---");
        }
    }

    public static String createMessageHash(String recipient,
                                           int messageNumber,
                                           String message) {

        String firstTwo;

        if (recipient.length() >= 2) {
            firstTwo = recipient.substring(0, 2);
        } else {
            firstTwo = "00";
        }

        String[] words = message.trim().split("\\s+");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return firstTwo + ":" +
                messageNumber + ":" +
                firstWord + " " +
                
                lastWord;
    }
}
