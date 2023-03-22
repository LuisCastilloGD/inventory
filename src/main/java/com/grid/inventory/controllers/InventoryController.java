package com.grid.inventory.controllers;

import com.grid.inventory.assemblers.ItemAssembler;
import com.grid.inventory.converters.ItemMapper;
import com.grid.inventory.models.Item;
import com.grid.inventory.models.dtos.ItemDto;
import com.grid.inventory.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
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
    private final ItemMapper itemMapper;

    private final ItemAssembler itemAssembler;


    @GetMapping("/quantity/{uniqueId}")
    public EntityModel<ItemDto> getItemByUniqueId(@PathVariable String uniqueId){
        return itemAssembler.toModel(itemMapper.modelToDto(inventoryService.getItemByUniqueId(uniqueId)));
    }

    @GetMapping("/quantity")
    public List<EntityModel<ItemDto>> getItemsByUniqueIds(@RequestBody List<String> uniqueIds){
        return inventoryService.getItemsByUniqueIds(uniqueIds)
                               .stream()
                               .map(itemMapper::modelToDto)
                               .map(itemAssembler::toModel)
                               .toList();
    }



}
