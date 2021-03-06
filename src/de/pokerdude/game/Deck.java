package de.pokerdude.game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Card> withoutTheseCards = null;

	public Deck() {
		generateNewDeck();
	}

	// ToDo: Check if works properly
	@SuppressWarnings("unchecked")
	public Deck(Deck copy, boolean shuffled) {
		this.deck = (ArrayList<Card>) copy.deck.clone();

		if (shuffled)
			Collections.shuffle(deck);
	}

	public Deck(ArrayList<Card> withoutTheseCards) {
		this.withoutTheseCards = withoutTheseCards;
		generateNewDeck();
	}

	public void generateNewDeck() {
		addSuiteCards(Suite.CLUBS);
		addSuiteCards(Suite.DIAMONDS);
		addSuiteCards(Suite.HEARTS);
		addSuiteCards(Suite.SPADES);
		Collections.shuffle(deck);
	}

	public void addSuiteCards(Suite suite) {
		for (int i = 2; i <= 14; i++) {
			Card toAdd = new Card(suite, i);
			if (withoutTheseCards != null && withoutTheseCards.contains(toAdd)) {
				continue;
			}
			deck.add(toAdd);
		}
	}

	public Card getCard() {
		return deck.remove(deck.size() - 1);
	}

	public ArrayList<Card> getCards(int count) {
		ArrayList<Card> result = new ArrayList<Card>();
		for (int i = 0; i < count; i++)
			result.add(getCard());
		return result;

	}

	public int size() {
		return deck.size();
	}

}
