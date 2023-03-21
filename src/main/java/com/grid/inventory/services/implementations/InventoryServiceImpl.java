package com.grid.inventory.services.implementations;

import com.grid.inventory.models.Item;
import com.grid.inventory.repositories.ItemRepository;
import com.grid.inventory.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final ItemRepository itemRepository;
    @Override
    public List<Item> getItemsByUniqueIds(final List<String> uniqueId) {
        return itemRepository.findByUniqIds(uniqueId);
    }

}
