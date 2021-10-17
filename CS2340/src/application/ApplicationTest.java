package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.stage.Stage;

class ApplicationTest {

    @Test
    void eliasTowerTest() {
        VanillaCatapult v1 = new VanillaCatapult(Difficulty.EASY);
        VanillaCatapult v2 = new VanillaCatapult(Difficulty.MEDIUM);
        VanillaCatapult v3 = new VanillaCatapult(Difficulty.HARD);
        WaffleConeLauncher w1 = new WaffleConeLauncher(Difficulty.EASY);
        WaffleConeLauncher w2 = new WaffleConeLauncher(Difficulty.MEDIUM);
        WaffleConeLauncher w3 = new WaffleConeLauncher(Difficulty.HARD);
        ChocolateChipGatlingGun c1 = new ChocolateChipGatlingGun(Difficulty.EASY);
        ChocolateChipGatlingGun c2 = new ChocolateChipGatlingGun(Difficulty.MEDIUM);
        ChocolateChipGatlingGun c3 = new ChocolateChipGatlingGun(Difficulty.HARD);
        assertEquals(v1.getPrice() * 1.2, v2.getPrice());
        assertEquals(v1.getPrice() * 1.5, v3.getPrice());
        assertEquals(w1.getPrice() * 1.2, w2.getPrice());
        assertEquals(w1.getPrice() * 1.5, w3.getPrice());
        assertEquals(c1.getPrice() * 1.2, c2.getPrice());
        assertEquals(c1.getPrice() * 1.5, c3.getPrice());
    }

}
