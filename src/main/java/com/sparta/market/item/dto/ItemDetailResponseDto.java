package com.sparta.market.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDetailResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ItemDetailResponseDto(Long id, String title, String content, int price, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }
}
