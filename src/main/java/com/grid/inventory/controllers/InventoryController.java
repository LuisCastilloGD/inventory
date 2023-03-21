package com.grid.inventory.controllers;

import com.grid.inventory.models.Item;
import com.grid.inventory.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/quantity")
    public List<Item> getItemsByUniqueIds(@RequestBody List<String> uniqueIds){
        return inventoryService.getItemsByUniqueIds(uniqueIds);
    }
}
