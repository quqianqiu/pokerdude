package de.pokerdude.simulation;

import java.util.ArrayList;

import de.pokerdude.game.Card;
import de.pokerdude.game.Suite;

public class PreFlopPropability {
	private ArrayList<Card> hand;
	private double[] props;
	
	public PreFlopPropability(Card c1, Card c2, int maxNumPlayers) {
		hand = new ArrayList<Card>();
		hand.add(c1);
		hand.add(c2);
		props = new double[maxNumPlayers+1];
	}
	
	public PreFlopPropability(ArrayList<Card> Hand, int maxNumPlayers) {
		this.hand = Hand;
		props = new double[maxNumPlayers+1];
	}
	
	public PreFlopPropability(String toParse) {
		String[] tokens = toParse.split(";");
		
		Suite s;
		if(tokens[0].equals(tokens[1]))
			s = Suite.CLUBS;
		else s = Suite.DIAMONDS;

		hand = new ArrayList<Card>();
		hand.add(new Card(Suite.CLUBS, Integer.parseInt(tokens[2])));
		hand.add(new Card(s, Integer.parseInt(tokens[3])));
		props = new double[tokens.length-2];
		
		for(int i=4;i<tokens.length;i++) {
			props[i-2] = Double.parseDouble(tokens[i]);
		}
	}
	
	public void setProp(int numPlayers, double value) {
		props[numPlayers] = value;
	}
	
	public double getProp(int numPlayers) {
		return props[numPlayers];
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public String encode() {
		String result="";
		if(hand.get(0).getSuite() == hand.get(1).getSuite())
			result = "A;A;";
		else result = "A;B;";
		result = result + hand.get(0).getValue() + ";" + hand.get(1).getValue() + ";";
		for(int i=2;i<props.length;i++) {
			result = result + props[i] + ";";
		}
		return result;
	}
	
	public String toString() {
		String result = "Propabilities for " + hand.get(0).toString() + ", " 
				+ hand.get(1).toString() + ": ";
		
		if(hand.get(1).getSuite() == Suite.CLUBS)
			result = result + "   ";
		
		for(int i=2;i<props.length;i++) {
			result = result + " " + i + ": " + props[i];		
		}
		return result;
		
	}
	
	public String getIdentString() {
		return hand.get(0).toString()+hand.get(1).toString();
	}
	
	
	


	
	
}
