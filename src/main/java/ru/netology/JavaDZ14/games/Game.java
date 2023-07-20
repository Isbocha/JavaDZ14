
package ru.netology.JavaDZ14.games;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private HashMap<String, Player> map = new HashMap<>();
        public Player register(Player player) {
            map.put(player.getName(), player);
            return player;
        }

        public Player findByName(String name) {
            for (String key : map.keySet()) {
                if (key == name) {
                    return map.get(key);
                }
            }
            return null;
        }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);


        if (
                    player1 == null) {
                throw new NotRegisteredException(
                        "Игрок " + player1 + "не зарегистрирован"
                );
            }
            if (player2 == null) {
                throw new NotRegisteredException(
                        "Игрок " + player2 + "не зарегистрирован"
                );
            }

                       if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else if (player1.getStrength() < player2.getStrength()) {
                return 2;
            } else {
                return 0;
            }
        }
    }

