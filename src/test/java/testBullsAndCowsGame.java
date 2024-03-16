import org.example.BullsAndCowsGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBullsAndCowsGame {

    private BullsAndCowsGame game;

    @BeforeEach
    public void setUp() {
        game = new BullsAndCowsGame(4);
    }

    @Test
    @DisplayName("Наличие класса")
    void calcClassCreationTest() {
        BullsAndCowsGame game = new BullsAndCowsGame(4);
        Assertions.assertNotNull(game);
    }

    @Test
    @DisplayName("Правильный ввод уровня сложности")
    public void testCorrectChoiceLevel() {
        // Создаем строку, которую мы хотим положить в поток ввода
        String inputString = "4";

        // Создаем объект ByteArrayInputStream с использованием нашей строки
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());

        // Сохраняем стандартный поток ввода
        InputStream originalSystemIn = System.in;

        try {
            // Устанавливаем наш созданный поток в качестве текущего System.in
            System.setIn(inputStream);

            // Теперь, когда вы вызываете Scanner(System.in), он будет читать из нашего потока ByteArrayInputStream
            assertEquals(4, game.choiceLevel());

        } finally {
            // Восстанавливаем оригинальный System.in после завершения работы
            System.setIn(originalSystemIn);
        }
    }
}
