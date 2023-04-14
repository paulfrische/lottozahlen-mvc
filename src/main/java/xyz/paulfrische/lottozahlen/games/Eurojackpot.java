package xyz.paulfrische.lottozahlen.games;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Eurojackpot implements Game {
    private static final Random random = new Random();

    private static final Logger logger = LoggerFactory.getLogger(Eurojackpot.class);
    @Override
    public List<Short> generateNumbers(List<Short> badNumbers) {
        List<Short> numbers = new ArrayList<>(List.of(badNumbers.get(0), badNumbers.get(0), badNumbers.get(0), badNumbers.get(0), badNumbers.get(0), badNumbers.get(0), badNumbers.get(0)));
        boolean valid = false;
        while (!valid) {
            for (int i = 0; i < 5; i++) {
                numbers.set(i, (short)(random.nextInt(49) + 1));
            }

            numbers.set(5, (short)(random.nextInt(9) + 1));
            numbers.set(6, (short)(random.nextInt(9) + 1));

            // check for bad numbers
            valid = true;
            for (short number : badNumbers) {
                if (numbers.contains(number)) {
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
        }
        logger.debug("generated numbers " + numbers.toString());
        return numbers;
    }
}
