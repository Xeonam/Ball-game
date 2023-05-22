import Model.PlayerDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDatabaseTest {
    private PlayerDatabase player;

    @BeforeEach
    void setUp(){
        player = new PlayerDatabase("player", 32, "2023-01-01");
    }


    @Test
    void testGetName(){
        assertEquals("player", player.getName());
    }

    @Test
    void testGetPlayerSteps(){
        assertEquals(32, player.getPlayerSteps());
    }

    @Test
    void testGetCreated(){
        assertEquals("2023-01-01", player.getCreated());
    }

    @Test
    void testSetName(){
        player.setName("newPlayerName");
        assertEquals("newPlayerName", player.getName());
    }

    @Test
    void testSetPlayerSteps(){
        player.setPlayerSteps(10);
        assertEquals(10, player.getPlayerSteps());
    }

}