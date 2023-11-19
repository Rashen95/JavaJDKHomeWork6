package org.example;

import java.util.HashMap;
import java.util.Random;

public class Main {

    public static final String WIN = "Победа";
    public static final String LOSE = "Проигрыш";

    public static void main(String[] args) {
        Random random = new Random();
        HashMap<Integer, String> statistic = new HashMap<>();
        int numberLoop = 1_000_000;

        for (int i = 1; i <= numberLoop; i++) {
            // Рандомное помещение машины за одну из дверей
            int carIndex = random.nextInt(0, 3);

            // Рандомный выбор игрока
            int playerChange = random.nextInt(0, 3);

            // Ведущий делает выбор на двери, которая не является ни машиной ни выбором игрока
            int montiChange = random.nextInt(0, 3);
            while (montiChange == playerChange || montiChange == carIndex) {
                montiChange = random.nextInt(0, 3);
            }

            // Игрок меняет выбор
            int playerChangeNew = random.nextInt(0, 3);
            while (playerChangeNew == playerChange || playerChangeNew == montiChange) {
                playerChangeNew = random.nextInt(0, 3);
            }

            // Проверка на выигрыш
            if (playerChangeNew == carIndex) {
                statistic.put(i, WIN);
            } else {
                statistic.put(i, LOSE);
            }

        }

        // Подводим итоги
        int win = 0;
        int lose = 0;
        for (String s : statistic.values()) {
            if (s.equals(WIN)) {
                win++;
            } else {
                lose++;
            }
        }
        System.out.printf("Количество побед равно %d (%d процентов)\n", win, (int) (win * 1.0 / numberLoop * 100));
        System.out.printf("Количество поражений равно %d (%d процентов)\n", lose, (int) (lose * 1.0 / numberLoop * 100));
    }
}