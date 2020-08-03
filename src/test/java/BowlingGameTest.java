import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    @Test
    public void testRoll() {
        BowlingGame game = new BowlingGame();
        Exception exceptionToLow = assertThrows(IllegalArgumentException.class,
            () -> game.roll(-1));
        Exception exceptionToHigh = assertThrows(IllegalArgumentException.class,
            () -> game.roll(11));
        assertAll("roll",
            () -> assertTrue(exceptionToLow.getMessage().contains("Illegal Argument:")),
            () -> assertTrue(exceptionToHigh.getMessage().contains("Illegal Argument:")),
            () -> assertDoesNotThrow(() -> game.roll(5))
        );
    }

    @Test
    public void testGetFrameScore() {
        int[] records = {10, 9, 1, 4, 3};
        BowlingGame game = new BowlingGame();

        for (int record : records) {
            game.roll(record);
        }

        Exception exceptionFrameOutOfBoundary1 = assertThrows(IllegalArgumentException.class,
            () -> game.getFrameScore(-1));
        Exception exceptionFrameOutOfBoundary2 = assertThrows(IllegalArgumentException.class,
            () -> game.getFrameScore(11));

        assertAll("get_frame_score",
            () -> assertEquals(20, game.getFrameScore(1)),
            () -> assertEquals(14, game.getFrameScore(2)),
            () -> assertEquals(7, game.getFrameScore(3)),
            () -> assertEquals(0, game.getFrameScore(10)),
            () -> assertTrue(
                exceptionFrameOutOfBoundary1.getMessage().contains("Illegal Argument:")),
            () -> assertTrue(
                exceptionFrameOutOfBoundary2.getMessage().contains("Illegal Argument:"))
        );
    }

    @Test
    public void testGetScoreWhenGameNotEnd() {
        int[] records = {10, 9, 1, 4, 3};
        BowlingGame game = new BowlingGame();

        for (int record : records) {
            game.roll(record);
        }

        assertEquals(41, game.getScore());
    }

    @Test
    public void testGetScoreWhenGameEnd() {
        int[] records = {10, 9, 1, 4, 3, 7, 3, 8, 1, 10, 4, 3, 2, 6, 8, 1, 10, 2, 8};
        BowlingGame game = new BowlingGame();

        for (int record : records) {
            game.roll(record);
        }

        assertEquals(129, game.getScore());

    }
}
