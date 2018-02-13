package com.abhishek;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            //StockItem inStock = list.get(item.getName());
            StockItem inStock = list.getOrDefault(item.getName(), item);// if the key is found it will return the
                                                                        // corresponding value; otherwise the item is returned
            //if(inStock != null){
            if(inStock != item){
                item.adjustStock(inStock.getQuantityStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }

    public int sellStock(StockItem item, int quantity){
        StockItem inStock = list.getOrDefault(item.getName(), null);
        if((inStock != null) && (item.getQuantityStock() >= quantity) && (quantity >= 0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    // Here the collection becomes unmodifiable - adding/removing/replacing cannot be done.
    // the objects in the collections can be changed
    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();

            s = s + stockItem + ". There are " + stockItem.getQuantityStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + String.format("%.3f", totalCost);
    }
}
