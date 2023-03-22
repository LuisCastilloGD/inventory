package com.grid.inventory.assemblers;

import com.grid.inventory.controllers.InventoryController;
import com.grid.inventory.models.dtos.ItemDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ItemAssembler implements RepresentationModelAssembler<ItemDto, EntityModel<ItemDto>> {

    @Override
    public EntityModel<ItemDto> toModel(final ItemDto entity) {
        return EntityModel.of(entity,
                              linkTo(methodOn(InventoryController.class).getItemsByUniqueIds(List.of(entity.getUniqId()))).withRel("getFromList"),
                              linkTo(methodOn(InventoryController.class).getItemByUniqueId(entity.getUniqId())).withSelfRel());
    }

}
