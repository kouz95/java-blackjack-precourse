package view;

import java.util.ArrayList;
import java.util.List;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;

public class OutputView {
    private static final String[] FIRST_DISTRIBUTION_MESSAGES = {"딜러와 ", "에게 2장의 카드를 나누었습니다."};
    private static final String DEALER_CARDS_STATE_MESSAGE = "딜러: ";
    private static final String PLAYER_CARDS_STATE_MESSAGE = "카드: ";

    public static void printFirstDistributionMessage(ArrayList<Player> players) {
        List<String> playerNames = new ArrayList<>();
        for (Player player : players) {
            playerNames.add(player.getName());
        }
        System.out.println(FIRST_DISTRIBUTION_MESSAGES[0] + String.join(",", playerNames)
            + FIRST_DISTRIBUTION_MESSAGES[1]);
    }

    public static void printCardsState(Dealer dealer, ArrayList<Player> players) {
        for (Card card : dealer.showCards()) {
            System.out.println(DEALER_CARDS_STATE_MESSAGE + card.toString());
        }
        System.out.println(getPlayersCardsState(players));
    }

    private static String getPlayersCardsState(ArrayList<Player> players) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(player.getName());
            stringBuilder.append(PLAYER_CARDS_STATE_MESSAGE);
            stringBuilder.append(getPlayerCardState(player));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static String getPlayerCardState(Player player) {
        ArrayList<String> playerCardState = new ArrayList<>();
        for (Card card : player.showCards()) {
            playerCardState.add(card.toString());
        }
        return String.join(", ", playerCardState);
    }

    public static void printPlayerCardState(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(player.getName());
        stringBuilder.append(PLAYER_CARDS_STATE_MESSAGE);
        stringBuilder.append(getPlayerCardState(player));
        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString());
    }
}
