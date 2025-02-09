package ru.netology.hw16game.game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Kirill", 350);
    Player player2 = new Player(2, "Fedor", 500);
    Player player3 = new Player(3, "Ivan", 500);
    Player player4 = new Player(4, "Pavel", 400);

    Game game = new Game();

    @BeforeEach
    void setUp() {
        game.register(player1);
        game.register(player3);
        game.register(player2);
    }

    @Test
    public void shouldCheckWhenFirstPlayerWin() {
        int expected = 1;
        int actual = game.round("Fedor", "Kirill");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckWhenSecondPlayerWin() {
        int expected = 2;
        int actual = game.round("Kirill", "Fedor");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckWhenStrengthsEqual() {
        int expected = 0;
        int actual = game.round("Fedor", "Ivan");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckWhenPlayer1NotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Pavel", "Kirill");
        });
    }

    @Test
    public void shouldCheckWhenPlayer2NotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Kirill", "Pavel");
        });
    }
}
