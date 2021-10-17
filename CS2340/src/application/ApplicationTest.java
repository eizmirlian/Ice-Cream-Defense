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
    
    @Test
    void eliasPathNextTest() {
        Path[][] allPaths = new Path[3][3];
        Path p1 = new Path(0, 0, 0, 1);
        Path p2 = new Path(0, 1, 0, 2);
        Path p3 = new Path(0, 2, 1, 2);
        Path p4 = new Path(1, 2, 2, 2);
        Path p5 = new Path(2, 2, 2, 1);
        Path p6 = new Path(2, 1, 2, 0);
        Path p7 = new Path(2, 0, 1, 0);
        Path p8 = new Path(1, 0, 1, 1);
        Path p9 = new Path(1, 1, 1, 2);
        allPaths[0][0] = p1;
        allPaths[0][1] = p2;
        allPaths[0][2] = p3;
        allPaths[1][2] = p4;
        allPaths[2][2] = p5;
        allPaths[2][1] = p6;
        allPaths[2][0] = p7;
        allPaths[1][0] = p8;
        allPaths[1][1] = p9;
        Level testLevel = new Level("", Difficulty.EASY, 3, 3, null);
        testLevel.setNexts(allPaths);
        assertEquals(p1.getNext(), p2);
        assertEquals(p2.getNext(), p3);
        assertEquals(p3.getNext(), p4);
        assertEquals(p4.getNext(), p5);
        assertEquals(p5.getNext(), p6);
        assertEquals(p6.getNext(), p7);
        assertEquals(p7.getNext(), p8);
        assertEquals(p8.getNext(), p9);
        assertEquals(p9.getNext(), p4);
    }

}
