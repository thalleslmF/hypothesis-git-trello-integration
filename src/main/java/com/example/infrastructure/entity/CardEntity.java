package com.example.infrastructure.entity;

import com.example.domain.card.Card;
import com.example.domain.card.CardType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardEntity  {
    @Id
    private String id;
    private String name;
    private CardType cardType;
    private String authorId;
    private String description;

    public CardEntity(String name, CardType cardType, String authorId, String description, String id) {

        this.name = name;
        this.cardType = cardType;
        this.authorId = authorId;
        this.description = description;
        this.id = id;
    }

    public CardEntity() {

    }
}
