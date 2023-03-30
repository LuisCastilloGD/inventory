package com.grid.inventory.services;

import com.grid.inventory.exceptions.ItemNotFoundedException;
import com.grid.inventory.models.Item;
import com.grid.inventory.repositories.ItemRepository;
import com.grid.inventory.services.implementations.InventoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class InventoryServiceTest {

    @InjectMocks
    private InventoryServiceImpl inventoryService;
    @Mock
    private ItemRepository itemRepository;

    private Item item1;
    private Item item2;
    private List<Item> itemList;
    @BeforeEach
    public void setUp() {
        item1 = Item.builder()
                          .id(1L)
                          .uniqId("abc1")
                    .availability(10L)
                          .build();
        item2 =  Item.builder()
                           .id(2L)
                           .uniqId("abc2")
                    .availability(10L)
                           .build();
        itemList = Arrays.asList(item1, item2);
    }

    @Test
    @DisplayName(" should get item")
    public void testGetArticleByUniqueId() {
        String uniqueId = item1.getUniqId();
        when(itemRepository.findByUniqId(uniqueId)).thenReturn(Optional.ofNullable(item1));
        assertEquals(item1, inventoryService.getItemByUniqueId(uniqueId));
    }

    @Test
    @DisplayName(" should throw not founded item ")
    public void testNotFoundGetArticleByUniqueId() {
        String uniqueId = "";
        when(itemRepository.findByUniqId(uniqueId)).thenReturn(Optional.empty());
        assertThrows(ItemNotFoundedException.class, () -> inventoryService.getItemByUniqueId(uniqueId));
    }


    @Test
    @DisplayName(" should get items ")
    public void testGetArticleBySku() {
        List<String> uniqueIds = List.of(item1.getUniqId(),item2.getUniqId());
        when(itemRepository.findByUniqIds(uniqueIds)).thenReturn(List.of(item1,item2));
        assertEquals(itemList, inventoryService.getItemsByUniqueIds(uniqueIds));
    }


}
