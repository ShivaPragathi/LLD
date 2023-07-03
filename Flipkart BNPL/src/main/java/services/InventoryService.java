package services;

import exceptions.InvalidSortParamException;
import model.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory getInventory(String name);

    void seedInventory(List<String> inventoryDetails);

    List<String> viewInventory(String sortParam) throws InvalidSortParamException;

    void removeInventory(String inventoryName, int quantity);
}
