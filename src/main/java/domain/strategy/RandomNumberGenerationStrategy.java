package domain.strategy;

import java.util.Random;

public class RandomNumberGenerationStrategy implements NumberGenerationStrategy {

    @Override
    public int generateNumber() {
        return new Random().nextInt(45) + 1;
    }
}
