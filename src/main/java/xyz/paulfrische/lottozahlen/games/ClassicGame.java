package xyz.paulfrische.lottozahlen.games;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassicGame implements Game {
    private static final Random random = new Random();
    @Override
    public List<Short> generateNumbers(List<Short> badNumbers) {
        List<Short> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add((short)(random.nextInt(49) + 1));
        }
        boolean valid = false;
        while (!valid) {
            for (int i = 0; i < 6; i++) {
                numbers.set(i, (short)(random.nextInt(49) + 1));
            }

            // check for bad numbers
            valid = true;
            for (short number: badNumbers) {
                if (numbers.contains(number)) {
                    valid = false;
                }
            }

            // check for duplicates
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (numbers.get(i) == numbers.get(j)) {
                        valid = false;
                    }
                }
            }
        }

        return numbers;
    }
}
