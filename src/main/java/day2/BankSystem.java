package day2;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem {

    static Scanner scanner = new Scanner(System.in);
    static MongoClient client = MongoClients.create("mongodb://localhost:27017");
    static MongoDatabase database = client.getDatabase("bankdbs");
    static MongoCollection<Document> collection = database.getCollection("accounts");

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n--- Banking Menu ---");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Check Balance");
                System.out.println("5. Exit");
                System.out.print("Choose: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> createAccount();
                    case 2 -> deposit();
                    case 3 -> withdraw();
                    case 4 -> checkBalance();
                    case 5 -> {
                        System.out.println("Goodbye!");
                        client.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input type. Please enter numbers only.");
                scanner.nextLine(); // clear buffer
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void createAccount() {
        try {
            System.out.print("Enter account number: ");
            String accNo = scanner.nextLine().trim();
            System.out.print("Enter name: ");
            String name = scanner.nextLine().trim();

            if (accNo.isEmpty() || name.isEmpty()) {
                throw new IllegalArgumentException("Account number and name cannot be empty.");
            }

            if (collection.find(new Document("accNo", accNo)).first() != null) {
                System.out.println("Account already exists.");
            } else {
                Document doc = new Document("accNo", accNo)
                        .append("name", name)
                        .append("balance", 0.0);
                collection.insertOne(doc);
                System.out.println("Account created and stored in DB.");
            }
        } catch (Exception e) {
            System.out.println("Failed to create account: " + e.getMessage());
        }
    }

    static void deposit() {
        try {
            System.out.print("Enter account number: ");
            String accNo = scanner.nextLine().trim();

            Document acc = collection.find(new Document("accNo", accNo)).first();
            if (acc == null) {
                throw new IllegalArgumentException("Account not found.");
            }

            System.out.print("Enter deposit amount: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive.");
            }

            double newBalance = acc.getDouble("balance") + amount;
            collection.updateOne(new Document("accNo", accNo),
                    new Document("$set", new Document("balance", newBalance)));

            System.out.println("Deposit successful. New Balance: " + newBalance);

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid amount. Please enter a valid number.");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (Exception e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
    }

    static void withdraw() {
        try {
            System.out.print("Enter account number: ");
            String accNo = scanner.nextLine().trim();

            Document acc = collection.find(new Document("accNo", accNo)).first();
            if (acc == null) {
                throw new IllegalArgumentException("Account not found.");
            }

            System.out.print("Enter withdrawal amount: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            double currentBalance = acc.getDouble("balance");

            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            }
            if (amount > currentBalance) {
                throw new IllegalArgumentException("Insufficient funds.");
            }

            double newBalance = currentBalance - amount;
            collection.updateOne(new Document("accNo", accNo),
                    new Document("$set", new Document("balance", newBalance)));

            System.out.println("Withdrawal successful. New Balance: " + newBalance);

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid amount. Please enter a valid number.");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (Exception e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }

    static void checkBalance() {
        try {
            System.out.print("Enter account number: ");
            String accNo = scanner.nextLine().trim();

            Document acc = collection.find(new Document("accNo", accNo)).first();
            if (acc == null) {
                System.out.println("Account not found.");
            } else {
                System.out.println("Account Holder: " + acc.getString("name"));
                System.out.println("Balance: " + acc.getDouble("balance"));
            }
        } catch (Exception e) {
            System.out.println("Failed to check balance: " + e.getMessage());
        }
    }
}
