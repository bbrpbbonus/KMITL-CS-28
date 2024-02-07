package pack7a;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<String, Product> productList;
    private Map<String, Integer> priceList;

    public Catalog() {
        productList = new HashMap<>();
        priceList = new HashMap<>();
    }

    public void add(Product product, int price) {
        productList.put(product.getpName(),product);
        priceList.put(product.getpName(),price);
    }

    public void showCatalog() {
        for(String itemN : productList.keySet()){
            System.out.println(String.format("%s @ %d",productList.get(itemN).getpName(),priceList.get(itemN)));
        }

    }

    public Product getProduct(String productName) {
        return productList.get(productName);
    }
    
    public int getPrice(String productName) {
        return priceList.get(productName);
    }
}
