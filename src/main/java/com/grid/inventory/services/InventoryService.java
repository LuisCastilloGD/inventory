package com.grid.inventory.services;

import com.grid.inventory.models.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    List<Item> getItemsByUniqueIds(List<String> uniqueIds);
}
