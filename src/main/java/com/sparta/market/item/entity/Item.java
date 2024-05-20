package com.sparta.market.item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "username", nullable = false, length = 255)
    private String username;
}
