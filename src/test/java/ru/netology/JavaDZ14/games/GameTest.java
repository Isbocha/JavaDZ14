package ru.netology.JavaDZ14.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class GameTest {
    Game games = new Game();
    private HashMap<String, Integer> map = new HashMap();
    Player player1 = new Player(1, "Петя", 7);
    Player player2 = new Player(2, "Слава", 2);
    Player player3 = new Player(3, "Максим", 5);
    Player player4 = new Player(3, "Коля", 5);

    @BeforeEach
    public void setup() {
        games.register(player1);
        games.register(player2);
        games.register(player3);
    }

    @Test
    public void registerTest() {
        Player expected = (player4);
        Player actual = games.register(player4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByNameTest1() {
        Player expected = (player2);
        Player actual = games.findByName("Слава");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByNameTest2() {
        Player expected = null;
        Player actual = games.findByName("");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByNameTest3() {
        Player expected = null;
        Player actual = games.findByName("Кирилл");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldResultsGame1() {
        games.register(player4);
        Assertions.assertEquals(0, games.round("Максим", "Коля"));
    }

    @Test
    public void ShouldResultsGame2() {
        Assertions.assertEquals(1, games.round("Петя", "Слава"));
    }

    @Test
    public void ShouldResultsGame3() {
        Assertions.assertEquals(2, games.round("Слава", "Петя"));
    }

    @Test
    public void exceptionsTest1() {
        Player player = new Player();
        player.setId(77);
        player.setName("Victor");
        player.setStrength(7);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round("Петя", "Victor");
        });
    }

    @Test
    public void exceptionsTest2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round("Roman", "Victor");
        });
    }

    @Test
    public void exceptionsTest3() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round("Roman", "Петя");
        });
    }

}
