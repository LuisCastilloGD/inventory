package com.grid.inventory.models.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ItemDto {

    private Long id;

    @NotBlank
    private String uniqId;

    @Min(0)
    private Long availability;
}
