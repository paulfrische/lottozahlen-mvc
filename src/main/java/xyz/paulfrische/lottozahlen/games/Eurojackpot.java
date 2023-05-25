package xyz.paulfrische.lottozahlen.games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import xyz.paulfrische.lottozahlen.data.EurojackpotNumbers;

public class Eurojackpot implements Game {
    private static final Random random = new Random();
    @Override
    public EurojackpotNumbers generateNumbers(List<Short> badNumbers) {
        List<Short> numbers = new ArrayList<>(List.of(badNumbers.get(0), badNumbers.get(0), badNumbers.get(0), badNumbers.get(0), badNumbers.get(0)));
        List<Short> superNumbers = new ArrayList<>(List.of(badNumbers.get(0), badNumbers.get(0)));
        boolean valid = false;
        while (!valid) {
            for (int i = 0; i < 5; i++) {
                numbers.set(i, (short)(random.nextInt(49) + 1));
            }

            superNumbers.set(0, (short)(random.nextInt(9) + 1));
            superNumbers.set(1, (short)(random.nextInt(9) + 1));

            // check for bad numbers
            valid = true;
            for (short number : badNumbers) {
                if (numbers.contains(number) || superNumbers.contains(number)) {
                    valid = false;
                    break;
                }
            }

            // check for duplicates
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (numbers.get(i) == numbers.get(j)) {
                        valid = false;
                        break;
                    }
                }
            }

            if (superNumbers.get(0) == superNumbers.get(1)) {
                valid = false;
            }
        }
        Collections.sort(numbers);
        Collections.sort(superNumbers);
        return new EurojackpotNumbers(numbers, superNumbers);
    }
}
