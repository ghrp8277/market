package com.sparta.market.item.service;

import com.sparta.market.item.dto.ItemDetailResponseDto;
import com.sparta.market.item.dto.ItemRequestDto;
import com.sparta.market.item.dto.ItemResponseDto;
import com.sparta.market.item.entity.Item;
import com.sparta.market.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDetailResponseDto createItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setTitle(itemRequestDto.getTitle());
        item.setContent(itemRequestDto.getContent());
        item.setPrice(itemRequestDto.getPrice());
        item.setUsername(itemRequestDto.getUsername());
        Item savedItem = itemRepository.save(item);
        return new ItemDetailResponseDto(savedItem.getId(), savedItem.getTitle(), savedItem.getContent(), savedItem.getPrice(), savedItem.getUsername());
    }

    public List<ItemResponseDto> getAllItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemResponseDto(item.getId(), item.getTitle(), item.getPrice(), item.getUsername()))
                .collect(Collectors.toList());
    }

    public ItemResponseDto getItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        return new ItemResponseDto(item.getId(), item.getTitle(), item.getPrice(), item.getUsername());
    }

    public ItemDetailResponseDto updateItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        item.setTitle(itemRequestDto.getTitle());
        item.setContent(itemRequestDto.getContent());
        item.setPrice(itemRequestDto.getPrice());
        item.setUsername(itemRequestDto.getUsername());
        Item updatedItem = itemRepository.save(item);
        return new ItemDetailResponseDto(updatedItem.getId(), updatedItem.getTitle(), updatedItem.getContent(), updatedItem.getPrice(), updatedItem.getUsername());
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item not found"));
        itemRepository.delete(item);
    }
}
