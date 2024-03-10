package com.theodor.app.cards;

    /**
     * Represents the operations that can be performed on a playing card in a card game.
     */
    public interface ICard {
    
        /**
         * Gets the value of the card.
         * 
         * @return The card's value as an integer.
         */
        int getValue();
    
        /**
         * Gets the type (suit) of the card.
         * 
         * @return The card's type.
         */
        CardSuit getSuit();
    
        /**
         * Gets the color of the card.
         * 
         * @return The card's color.
         */
        CardColor getColor();
    
        /**
         * Returns a string representation of the card, including its name and type.
         * 
         * @return A string representation of the card.
         */
        String toString();
    
        /**
         * Changes the face-up status of the card.
         */
        void turnCard();
    
        /**
         * Compares this card with another card to determine if they are equal.
         * 
         * @param other The other card to compare with this card.
         * @return true if the cards are of the same type and value, false otherwise.
         */
        boolean equals(Object other);
    }
    

