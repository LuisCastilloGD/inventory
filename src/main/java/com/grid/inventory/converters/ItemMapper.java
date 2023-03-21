package com.grid.inventory.converters;

import com.grid.inventory.models.Item;
import com.grid.inventory.models.dtos.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDto modelToDto(Item item);

    Item dtoToModel(ItemDto productDto);
}
