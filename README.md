# Solitaire Game

This repository contains a Java project for a basic implementation of the Solitaire card game. The game is designed to be run in a console environment and includes classes for managing cards, decks, and the game logic.

## Project Structure

The project is organized into the following main classes:

- `Card`: Represents a playing card with a suit (type), value, and color.
- `CardType`: An enumeration for the card types (Hearts, Diamonds, Spades, Clubs).
- `CardColor`: An enumeration for the card colors (Red, Black).
- `CardDeck`: Extends `ArrayList<Card>` to represent a deck of cards with methods to shuffle and print the deck.
- `SolitaireGame`: Contains the game logic and the main method to run the game.
- `Main`: The entry point of the application that initializes and starts a new game of Solitaire.

## Features

- Generate a standard deck of 52 playing cards.
- Shuffle the deck with a specified number of shuffles.
- Basic game setup and logic for placing cards according to Solitaire rules (currently in development).

## How to Run

Ensure you have Java installed on your system. Clone the repository and navigate to the src directory. Compile and run the Main class using the following commands:

```bash
javac com/theodor/app/*.java com/theodor/app/cards/*.java
java com.theodor.app.Main
