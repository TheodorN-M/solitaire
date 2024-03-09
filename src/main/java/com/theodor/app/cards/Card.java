package com.theodor.app.cards;

public class Card {
    private final CardType type;
    private final int value;
    private String name;
    private CardColor color;

    public Card(CardType type, int value) {
        this.type = type;
        this.value = value;
        setColor(type);
        setName(value);

    }

    private void setColor(CardType type) {
        switch (type){
            case CLUBS:
            case SPADES:
                this.color = CardColor.BLACK;
                break;
            default:
                this.color = CardColor.RED;
        }
    }

    private void setName(int value) {
        switch (value) {
            case 11:
                name = "Jack";
                break;
            case 12:
                name = "Queen";
                break;
            case 13:
                name = "King";
                break;
            case 1:
                name = "Ace";
                break;
            default:
                name = "" + value;
                break;

        }

    }

    public int getValue() {
        return value;
    }

    public CardType getType() {
        return type;
    }

    public CardColor getColor(){
        return color;
    }

    public String toString() {
        return "" + name + " of " + type;
    }

    public boolean equals(Card other){
        return this.type.equals(other.type) && this.value == other.value;
    }

}
