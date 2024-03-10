package com.theodor.app.cards;

public class Card implements ICard {
    private final CardSuit suit;
    private final int value;
    private String name;
    private CardColor color;
    private boolean faceUp;

    public Card(CardSuit suit, int value, boolean faceUp) {
        this.suit = suit;
        this.value = value;
        this.faceUp = faceUp;
        setColor(suit);
        setName(value);

    }
    /**
     * Second constructor that puts card face-down
     * @param suit
     * @param value
     */
    public Card(CardSuit suit, int value){
        this(suit, value, false);
    }

    private void setColor(CardSuit type) {
        switch (type) {
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

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public CardColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "" + name + " of " + suit;
    }

    @Override
    public void turnCard() {
        faceUp = !faceUp;
    }

    public boolean faceUp(){
        return faceUp;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;

        Card card = (Card) other;

        return value == card.value &&
                suit == card.suit;
    }

}
