import java.util.ArrayList;
import java.util.Scanner;

// Expense class to represent individual expenses
class Expense {
    private String description;
    private double amount;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount + ", Category: " + category;
    }
}

// ExpenseManager class to handle expense management operations
class ExpenseManager {
    private ArrayList<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    // Add a new expense
    public void addExpense(Scanner scanner) {
        System.out.println("Enter expense description: ");
        String description = scanner.nextLine();

        System.out.println("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter expense category (e.g. food, transport, etc.): ");
        String category = scanner.nextLine();

        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    // View all expenses
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    // Calculate the total amount spent
    public void calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total expenses: $" + total);
    }

    // Filter expenses by category
    public void filterByCategory(Scanner scanner) {
        System.out.println("Enter the category to filter by: ");
        String category = scanner.nextLine();

        boolean found = false;
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                System.out.println(expense);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found for category: " + category);
        }
    }
}

// Main class to run the expense manager
public class ExpenseManagement {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nExpense Manager");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Filter by Category");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    expenseManager.addExpense(scanner);
                    break;
                case 2:
                    expenseManager.viewExpenses();
                    break;
                case 3:
                    expenseManager.calculateTotalExpenses();
                    break;
                case 4:
                    expenseManager.filterByCategory(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Expense Manager.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}