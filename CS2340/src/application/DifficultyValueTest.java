package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DifficultyValueTest {

    @Test
    void ethanDifficultyValue() {
        Difficulty easy = Difficulty.EASY;
        Difficulty medium = Difficulty.MEDIUM;
        Difficulty hard = Difficulty.HARD;
        HomeScreen homeScreen = new HomeScreen();
        assertEquals(4, homeScreen.setModifier(easy));
        assertEquals(3, homeScreen.setModifier(medium));
        assertEquals(2, homeScreen.setModifier(hard));
        assertEquals(0, homeScreen.setModifier(null));
    }
}