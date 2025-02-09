package ru.netology.hw16game.game;

import java.util.HashMap;

public class Game {

    HashMap<String, Player> map = new HashMap<>();

    public void register(Player player) {
        map.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : map.values()) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player with name " + playerName1 + " is not registered"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player with name " + playerName2 + " is not registered"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
