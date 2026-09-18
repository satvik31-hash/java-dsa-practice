package com.satvik.projects.familytree;

import java.util.List;
import java.util.Scanner;

/**
 * Menu-driven front end for {@link FamilyTree}.
 *
 * <p>All console reading lives here; the tree itself has no I/O, which is what makes it
 * testable.
 */
public final class FamilyTreeApp {

    private FamilyTreeApp() {
    }

    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("""

                    ----- FAMILY TREE MENU -----
                    1. Add parent-child relationship
                    2. Find parents
                    3. Find children
                    4. Find siblings
                    5. Find ancestors
                    6. Print all relationships
                    7. Exit""");
            System.out.print("Enter your choice: ");

            String choice = input.hasNextLine() ? input.nextLine().trim() : "7";

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter parent name: ");
                        String parent = input.nextLine();
                        System.out.print("Enter child name: ");
                        String child = input.nextLine();
                        tree.addRelation(parent, child);
                        System.out.println("Relationship added.");
                    }
                    case "2" -> report("Parents", tree.parentsOf(askName(input)));
                    case "3" -> report("Children", tree.childrenOf(askName(input)));
                    case "4" -> report("Siblings", tree.siblingsOf(askName(input)));
                    case "5" -> report("Ancestors", tree.ancestorsOf(askName(input)));
                    case "6" -> printAll(tree);
                    case "7" -> {
                        System.out.println("Program exited.");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static String askName(Scanner input) {
        System.out.print("Enter person's name: ");
        return input.nextLine();
    }

    private static void report(String label, List<String> names) {
        System.out.println(names.isEmpty()
                ? "No %s found.".formatted(label.toLowerCase())
                : "%s: %s".formatted(label, String.join(", ", names)));
    }

    private static void printAll(FamilyTree tree) {
        if (tree.isEmpty()) {
            System.out.println("No relationships added.");
            return;
        }
        System.out.printf("%-20s %s%n", "PARENT", "CHILD");
        System.out.println("-".repeat(40));
        tree.relations().forEach(row -> System.out.printf("%-20s %s%n", row[0], row[1]));
    }
}
