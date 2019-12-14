package domain.user;

import java.util.ArrayList;
import java.util.List;

import domain.card.Card;

public class User {
    private static final String DEALER_NAME = "딜러 ";

    final List<Card> cards = new ArrayList<>();
    private int score = 0;
    private boolean isAce = false;
    private boolean isBigAce = false;

    public List<Card> showCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void subtractScore(int score) {
        this.score -= score;
    }

    public boolean getIsAce() {
        return isAce;
    }

    public void setIsAce(boolean isAce) {
        this.isAce = isAce;
    }

    public boolean getIsBigAce() {
        return isBigAce;
    }

    public void setIsBigAce(boolean isBigAce) {
        this.isBigAce = isBigAce;
    }

    public boolean isScoreGreaterThan(int maxScore) {
        return score > maxScore;
    }

    public boolean isBlackJack(int maxScore) {
        return score == maxScore;
    }

    public String getName() {
        return DEALER_NAME;
    }

    public String openScore() {
        return Integer.toString(score);
    }
}
