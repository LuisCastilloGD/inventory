package com.grid.inventory.models.dtos;

import javax.validation.constraints.NotBlank;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ItemDto {

    private Long id;

    @NotBlank
    private String uniqId;

    @Min(0)
    private Long availability;
}
