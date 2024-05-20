package com.sparta.market.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequestDto {
    private String title;
    private String content;
    private int price;
    private String username;
}
