package com.sparta.market.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponseDto {
    private Long id;
    private String title;
    private int price;
    private String username;

    public ItemResponseDto(Long id, String title, int price, String username) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.username = username;
    }
}

