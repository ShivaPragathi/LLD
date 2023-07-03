package services.impl;

import exceptions.InvalidSortParamException;
import javafx.util.Pair;
import model.Inventory;
import services.InventoryService;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService {

    public static InventoryService INSTANCE = new InventoryServiceImpl();
    public List<Inventory> inventoryList = new ArrayList<>();
    private List<String> validSortParams = Arrays.asList("name","quantity", "price");
    public Map<String, Inventory> inventoryMap = new HashMap<>();

    @Override
    public Inventory getInventory(String name) {
        return inventoryMap.get(name);
    }

    @Override
    public void seedInventory(List<String> inventoryDetails) {
        for(String inventoryDetail : inventoryDetails) {
            String[] inventoryAttr = inventoryDetail.split(" ");
            String itemName = inventoryAttr[0];
            int quantity = Integer.parseInt(inventoryAttr[1]);
            int price = Integer.parseInt(inventoryAttr[2]);
            Inventory inventory = new Inventory(itemName, quantity, price);
            inventoryList.add(inventory);
            inventoryMap.put(itemName, inventory);
        }
    }

    @Override
    public List<String> viewInventory(String sortParam) throws InvalidSortParamException {
        if(!validSortParams.contains(sortParam)) {
            throw new InvalidSortParamException("Invalid sort field + "+sortParam);
        }
        List<String> inventories = new ArrayList<>();
//        if(sortParam.equals("name"))
//            inventoryList = inventoryList.stream().sorted((r1, r2)->(C)).collect(Collectors.toList());
        if(sortParam.equals("quantity"))
            inventoryList = inventoryList.stream().sorted((r1,r2)->(r1.quantity<r2.quantity?1:-1)).collect(Collectors.toList());
        else
            inventoryList = inventoryList.stream().sorted((r1,r2)->(r1.price<r2.price?1:-1)).collect(Collectors.toList());
        for (Inventory inventory : inventoryList) {
            inventories.add(inventory.getName() + " "+inventory.quantity +" "+ inventory.getPrice());
        }
        return inventories;
    }

    @Override
    public void removeInventory(String inventoryName, int quantity) {
        Inventory inventory1 = inventoryMap.get(inventoryName);
        inventory1.setQuantity(quantity);
    }
}
