package com.grid.inventory.repositories;

import com.grid.inventory.exceptions.ItemNotFoundedException;
import com.grid.inventory.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    default List<Item> findByUniqIds(List<String> uniqueIds){
        return uniqueIds.stream()
                        .map(unique -> { return this.findByUniqId(unique).orElseThrow(ItemNotFoundedException::new);})
                        .toList();
    }

    Optional<Item> findByUniqId(String uniq_id);

}
