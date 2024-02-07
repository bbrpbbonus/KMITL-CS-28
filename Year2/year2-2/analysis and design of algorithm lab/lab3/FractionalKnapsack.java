import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

    static class Item {
        int weight;
        int profit;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }

    static double fractionalKnapSack(int W, Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble(i -> (double) i.profit / i.weight));

        double totalValue = 0.0;

        for (int i = items.length - 1; i >= 0; i--) {
            if (W >= items[i].weight) {
                totalValue += items[i].profit;
                W -= items[i].weight;
            } else {
                totalValue += (double) items[i].profit / items[i].weight * W;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the capacity of the knapsack (W): ");
        int W = scanner.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter the profits and weights of the items:");
        for (int i = 0; i < n; i++) {
            int profit = scanner.nextInt();
            int weight = scanner.nextInt();
            items[i] = new Item(weight, profit);
        }

        double result = fractionalKnapSack(W, items);
        System.out.println("Maximum value in the knapsack: " + result);

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
