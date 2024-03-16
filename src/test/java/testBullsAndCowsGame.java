import org.example.BullsAndCowsGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("Неправильный ввод уровня сложности с первого раза")
    public void testUnCorrectChoiceLevel() {
        // Создаем строку, которую мы хотим положить в поток ввода
        String inputString = "1\n3";

        // Создаем объект ByteArrayInputStream с использованием нашей строки
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());

        // Сохраняем стандартный поток ввода
        InputStream originalSystemIn = System.in;

        try {
            // Устанавливаем наш созданный поток в качестве текущего System.in
            System.setIn(inputStream);

            // Теперь, когда вы вызываете Scanner(System.in), он будет читать из нашего потока ByteArrayInputStream
            assertEquals(3, game.choiceLevel());

        } finally {
            // Восстанавливаем оригинальный System.in после завершения работы
            System.setIn(originalSystemIn);
        }
    }

    @Test
    @DisplayName("Получение случайного не повторяющегося набора цифр длинной 4")
    public void testGenerateSecretNumber() {
        int[] secretNumber = game.generateGuessNumber(4);
        assertEquals(4, secretNumber.length);
        for (int digit : secretNumber) {
            assertTrue(digit >= 0 && digit <= 9);
        }
    }

    @Test
    @DisplayName("Получение Быков и Коров на входные данные")
    public void testGetResult() {
        int[] secretNumber = {1, 2, 3, 4};
        int[] guess1 = {1, 2, 3, 4}; // 4 bulls
        int[] guess2 = {4, 3, 2, 1}; // 0 bulls, 4 cows
        int[] guess3 = {5, 6, 7, 8}; // 0 bulls, 0 cows
        int[] guess4 = {1, 3, 2, 5}; // 2 bulls, 1 cows
        game.setSecretNumber(secretNumber);
        assertArrayEquals(new int[]{4, 0}, game.getResult(guess1));
        assertArrayEquals(new int[]{0, 4}, game.getResult(guess2));
        assertArrayEquals(new int[]{0, 0}, game.getResult(guess3));
        assertArrayEquals(new int[]{1, 2}, game.getResult(guess4));
    }

    @Test
    @DisplayName("Преобразования строки с цифрами в массив цифр")
    public void testConvertToIntArray() {
        String number = "1234";
        int[] intArray = game.convertToIntArray(number);
        int[] expectedArray = {1, 2, 3, 4};
        assertArrayEquals(expectedArray, intArray);
    }
}
