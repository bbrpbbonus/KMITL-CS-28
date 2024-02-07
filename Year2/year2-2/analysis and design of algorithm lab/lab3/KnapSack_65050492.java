import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KnapSack_65050492 {

    static class Item {
        int weight;
        int profit;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }

    static double fractionalKnapSack(int capacity, Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble(i -> (double) i.profit / i.weight));

        double totalValue = 0.0;

        for (int i = items.length - 1; i >= 0; i--) {
            if (capacity >= items[i].weight) {
                totalValue += items[i].profit;
                capacity -= items[i].weight;
            } else {
                totalValue += (double) items[i].profit / items[i].weight * capacity;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the capacity of the knapsack (M): ");
        int capacity = scanner.nextInt();

        Item[] items = new Item[n];

        System.out.print("Enter the profits of the items (p): ");
        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }

        System.out.print("Enter the weights of the items (w): ");
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], profits[i]);
        }

        double result = fractionalKnapSack(capacity, items);
        System.out.println("Maximum value in the knapsack: " + result);

        scanner.close();
    }
}