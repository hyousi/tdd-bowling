import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    @Test
    public void testRoll() {
        BowlingGame game = new BowlingGame();
        Exception exceptionToLow = assertThrows(IllegalArgumentException.class, () -> game.roll(-1));
        Exception exceptionToHigh = assertThrows(IllegalArgumentException.class, () -> game.roll(11));
        assertAll("roll",
            () -> assertTrue(exceptionToLow.getMessage().contains("Illegal Argument:")),
            () -> assertTrue(exceptionToHigh.getMessage().contains("Illegal Argument:")),
            () -> assertDoesNotThrow(() -> game.roll(5))
        );
    }
}
