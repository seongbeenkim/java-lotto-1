package domain.strategy;

public class ManualNumberGenerationStrategy implements NumberGenerationStrategy {

    private int numberStart = 0;

    @Override
    public int generateNumber() {
        if(numberStart == 6)
            numberStart=0;
        return numberStart++;
    }
}
