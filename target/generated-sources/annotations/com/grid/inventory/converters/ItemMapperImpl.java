package com.grid.inventory.converters;

import com.grid.inventory.models.Item;
import com.grid.inventory.models.dtos.ItemDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-22T15:22:31-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Homebrew)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDto modelToDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setId( item.getId() );
        itemDto.setUniqId( item.getUniqId() );
        itemDto.setAvailability( item.getAvailability() );

        return itemDto;
    }

    @Override
    public Item dtoToModel(ItemDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( productDto.getId() );
        item.setUniqId( productDto.getUniqId() );
        item.setAvailability( productDto.getAvailability() );

        return item;
    }
}
