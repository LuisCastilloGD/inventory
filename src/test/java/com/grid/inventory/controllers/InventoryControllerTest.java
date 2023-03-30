package com.grid.inventory.controllers;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InventoryControllerTest {


    private final MockMvc mockMvc;

    @Test
    @DisplayName(" Should get item ")
    public void getItemByUniqueIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/inventory/quantity/b6c0b6bea69c722939585baeac73c13d"))
               .andExpect(status().isOk());
    }

    @Test
    @DisplayName(" Should get items ")
    public void getItemBySkuTest() throws Exception {
        StringBuilder body = new StringBuilder();
        body.append("[\n");
        body.append("\"b6c0b6bea69c722939585baeac73c13d\", \"9efc48aa03dbf453b1ab8bebf9703f2b\"\n");
        body.append("]");

        mockMvc.perform(MockMvcRequestBuilders.get("/inventory/quantity")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(body.toString()))
               .andExpect(status().isOk());
    }
}
