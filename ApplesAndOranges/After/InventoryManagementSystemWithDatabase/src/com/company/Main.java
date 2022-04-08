package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// FIXME: data validation on update
// FIXME: make sure user cannot update items price to something other than a double
// FIXME: make sure user cannot update items numItems or maxNumItems to something other than a double



public class Main {
    // DATABASE SETUP
    static final String DB_URL = "jdbc:mysql://localhost/demo";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        // APPLICATION LOGIC
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for commands

        // Introduction
        System.out.println("Welcome to Inventory Management System");
        printMenu();

        // Application loop
        boolean isRunning = true;
        while (isRunning) {

            String command = scanner.nextLine(); // this is the user input while the loop is running

            switch (command) {
                case "add":
                    createInventoryItem();
                    System.out.print("\nEnter command: ");
                    break;
                case "find":
                    findItem();
                    System.out.print("\nEnter command: ");
                    break;
                case "list":
                    readAll();
                    System.out.print("\nEnter command: ");
                    break;
                case "update":
                    updateSpecifiedItem();
                    System.out.print("\nEnter command: ");
                    break;
                case "delete":
                    deleteSpecifiedItem();
                    System.out.print("\nEnter command: ");
                    break;
                case "help":
                    printMenu();
                    break;
                case "quit":
                    System.out.println("Quitting Inventory Management System...");
                    isRunning = false; // exits (outer) loop, terminating program
                    break;
                default: // if user enters something not prescribed above
                    System.out.println("\"" + command + "\" is not a valid command");
                    printMenu();
                    break;
            }
        }
    }

    // HELPER METHODS
    // Print menu (called initially when program is run and when user types "quit" (without quotes))
    static void printMenu() {
        System.out.println("You can enter the following commands:");
        System.out.println("    add");
        System.out.println("    find");
        System.out.println("    list");
        System.out.println("    update");
        System.out.println("    delete");
        System.out.println("    help (to repeat this menu)");
        System.out.println("    quit (this ends the application)");
        System.out.print("\nEnter command: ");
    }

    // prompt user for information and enter it into the database
    static void createInventoryItem() {
        String name;
        double price;
        int numItems;
        int maxNumItems;

        Scanner addScan = new Scanner(System.in);

        // prompt user for item information
        System.out.print("    Enter item name: ");
        name = addScan.nextLine();

        // run data validation checks
        // price
        try {
            System.out.print("    Enter item price: ");
            price = Double.parseDouble(addScan.nextLine());
        }
        catch(Exception e) {
            System.out.println("price must be a floating-point number!");
            return;
        }
        // numItems
        try {
            System.out.print("    Enter number of items in stock: ");
            numItems = Integer.parseInt(addScan.nextLine());
        }
        catch(Exception e) {
            System.out.println("numItems must be an integer!");
            return;
        }
        // MaxNumItems
        try {
            System.out.print("    Enter maximum number of items that can be in stock: ");
            maxNumItems = Integer.parseInt(addScan.nextLine());
        }
        catch(Exception e) {
            System.out.println("price must be an integer!");
            return;
        }
        insertItem(name, price, numItems, maxNumItems);
    }

    // prompt user for item name, search for it, and return it
    static void findItem() {
        Scanner findScan = new Scanner(System.in);

        System.out.print("  Enter item name: ");
        String name = findScan.nextLine();

        readItem(name);
    }

    // prompt user for name of item they wish to delete and delete it
    static void deleteSpecifiedItem() {
        Scanner deleteScan = new Scanner(System.in);

        System.out.print("  Enter item name: ");
        String name = deleteScan.nextLine();

        deleteItem(name);
    }

    // prompt user for name of item, field of item they with to update, and the value of that field
    static void updateSpecifiedItem() {
        Scanner updateScan = new Scanner(System.in);

        System.out.print("  Enter item name: ");
        String name = updateScan.nextLine();

        System.out.println("Enter field you want to alter:");
        System.out.println("    name");
        System.out.println("    price");
        System.out.println("    numItems");
        System.out.println("    maxNumItems");
        String field = updateScan.nextLine();

        System.out.print("  Enter new value: ");
        String value = updateScan.nextLine();

        updateItem(name, field, value);
    }

    // this works!! CREATE
    public static void insertItem(String name, double price, int numItems, int maxNumItems) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM fruits WHERE name = '" + name + "'");
            if (rs.next()) {
                System.out.println("Item already exists. Cannot add duplicate item. Item not added.");
            } else {
                String sql = "INSERT INTO fruits VALUES ('" + name + "', " + price + ", " + numItems + ", " + maxNumItems + ")";
                stmt.executeUpdate(sql);
                System.out.println("Added \"" + name + "\" to inventory.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ ALL - this works!
    public static void readAll() {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fruits");
        ) {
            System.out.println("======================================================== IMS Inventory ======================================================");
            System.out.printf("%-25s%25s%25s%25s%25s%n", "Name:", "Price:", "Number in stock:", "Stock limit:", "Amount to order:"); // may be negative for overstock
            while(rs.next()){
                System.out.printf("%-25s%25.2f%25d%25d%25d%n", rs.getString("name"), rs.getDouble("price"), rs.getInt("numItems"), rs.getInt("maxNumItems"), (rs.getInt("maxNumItems") - rs.getInt("numItems")));
            }
            System.out.println("=============================================================================================================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ ITEM - this works!
    public static void readItem(String name) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fruits WHERE name = '" + name + "'");
        ) {
            System.out.println("======================================================== IMS Inventory ======================================================");
            System.out.printf("%-25s%25s%25s%25s%25s%n", "Name:", "Price:", "Number in stock:", "Stock limit:", "Amount to order:"); // may be negative for overstock
            while(rs.next()){
                System.out.printf("%-25s%25f%25d%25d%25d%n", rs.getString("name"), rs.getDouble("price"), rs.getInt("numItems"), rs.getInt("maxNumItems"), (rs.getInt("maxNumItems") - rs.getInt("numItems")));
            }
            System.out.println("=============================================================================================================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE ITEM (overloaded to allow user to change name (a string) and price (will be converted to a double))
//    used to change number of items and maximum number of items (integers)
    public static void updateItem(String name, String field, int value) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rsInitial = stmt.executeQuery("SELECT * FROM fruits WHERE name = '" + name + "'");
            if (!rsInitial.next()) {
                System.out.println("Item with name \"" + name + "\" not found. Nothing to update.");
            } else {
                String sql = "UPDATE fruits " + "SET " + field + " = " + value + " WHERE name = '" + name + "'";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
//            e.printStackTrace(); // used for development purposes
            System.out.println("    Error: field value must be an integer!");
        }
    }
//used to change name (a string)
    public static void updateItem(String name, String field, String value) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rsInitial = stmt.executeQuery("SELECT * FROM fruits WHERE name = '" + name + "'");
            if (!rsInitial.next()) {
                System.out.println("Item with name \"" + name + "\" not found. Nothing to update.");
            } else {
                ResultSet rs = stmt.executeQuery("SELECT * FROM fruits WHERE name = '" + value + "'");
                if (rs.next()) {
                    System.out.println("Item with that name already exists. Cannot add duplicate item. Item not added.");
                } else {
                    String sql = "UPDATE fruits " + "SET " + field + " = '" + value + "' WHERE name = '" + name + "'";
                    stmt.executeUpdate(sql);
                    System.out.println("Updated \"" + name + "\" to \"" + value + "\"."); // FIXME: weird issue where other methods are using this line???
                }
            }
        } catch (SQLException e) {
//            e.printStackTrace(); // used for development purposes
            System.out.println("    Error: invalid data type!");
        }
    }
//used to change price (will be converted over to a double)
    public static void updateItem(String name, String field, double value) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rsInitial = stmt.executeQuery("SELECT * FROM fruits WHERE name = '" + name + "'");
            if (!rsInitial.next()) {
                System.out.println("Item with name \"" + name + "\" not found. Nothing to update.");
            } else {
                String sql = "UPDATE fruits " + "SET " + field + " = " + value + " WHERE name = '" + name + "'";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
//            e.printStackTrace(); // used for development purposes
            System.out.println("    Error: field value must be an integer!"); // FIXME: weird issue where other methods are using this line???
        }
    }

    // this works! DESTROY
    public static void deleteItem(String name) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM fruits WHERE name = '" + name + "'");
            if (!rs.next()) {
                System.out.println("Item with name \"" + name + "\" not found. Nothing deleted.");
            } else {
                String sql = "DELETE FROM fruits " + "WHERE name = '" + name + "'";
                stmt.executeUpdate(sql);
                System.out.println("\"" + name + "\" has been deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}