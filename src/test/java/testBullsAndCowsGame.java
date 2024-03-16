import org.example.BullsAndCowsGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testBullsAndCowsGame {

    @Test
    void calcClassCreationTest() {
        BullsAndCowsGame game = new BullsAndCowsGame();
        Assertions.assertNotNull(game);
    }
}
