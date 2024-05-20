package com.sparta.market.item.controller;

import com.sparta.market.item.dto.ItemDetailResponseDto;
import com.sparta.market.item.dto.ItemRequestDto;
import com.sparta.market.item.dto.ItemResponseDto;
import com.sparta.market.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("post")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemDetailResponseDto createItem(@RequestBody ItemRequestDto newItem) {
        return itemService.createItem(newItem);
    }

    @GetMapping
    public List<ItemResponseDto> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemResponseDto getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public ItemDetailResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto itemDetails) {
        return itemService.updateItem(id, itemDetails);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        Map<String, String> response = new HashMap<>();
        response.put("msg", "삭제완료");
        return response;
    }
}
