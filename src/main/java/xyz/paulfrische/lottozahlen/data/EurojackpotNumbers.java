package xyz.paulfrische.lottozahlen.data;

import java.util.List;

public class EurojackpotNumbers implements Numbers {
    private List<Short> numbers;
    private List<Short> superNumbers;

    public EurojackpotNumbers(List<Short> numbers, List<Short> superNumbers) {
        this.numbers = numbers;
        this.superNumbers = superNumbers;
    }

    public List<Short> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Short> numbers) {
        this.numbers = numbers;
    }

    public List<Short> getSuperNumbers() {
        return superNumbers;
    }

    public void setSuperNumbers(List<Short> superNumbers) {
        this.superNumbers = superNumbers;
    }

}
