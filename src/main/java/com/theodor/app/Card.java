package com.theodor.app;

public class Card {
    private final CardColor color;
    private final int value;
    private String name;

    public Card(CardColor color, int value) {
        this.color = color;
        this.value = value;
        setName(value);

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

    public CardColor egtColor() {
        return color;
    }

    public String toString() {
        return "" + name + " of " + color;
    }

    public boolean equals(Card other){
        return this.color.equals(other.color) && this.value == other.value;
    }

}
