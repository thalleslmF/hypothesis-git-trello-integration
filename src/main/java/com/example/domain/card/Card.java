package com.example.domain.card;

import com.example.infrastructure.entity.CardEntity;

import java.util.Objects;
import java.util.UUID;

public class Card {
    private String name;
    private CardType cardType;
    private String authorId;
    private String description;

    public Card(String name, CardType cardType, String authorId, String description) {
        this.name = name;
        this.cardType = cardType;
        this.authorId = authorId;
        this.description = description;
    }
    public Card(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardEntity toEntity() {
        return new CardEntity(this.name, this.cardType, this.authorId, this.description, UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(name, card.name) && cardType == card.cardType && Objects.equals(authorId, card.authorId) && Objects.equals(description, card.description);
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", cardType=" + cardType +
                ", authorId='" + authorId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cardType, authorId, description);
    }
}
