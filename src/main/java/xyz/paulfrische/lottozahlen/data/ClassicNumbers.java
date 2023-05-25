package xyz.paulfrische.lottozahlen.data;

import java.util.List;

public class ClassicNumbers implements Numbers {
    private List<Short> numbers;

    public ClassicNumbers(List<Short> numbers) {
        this.numbers = numbers;
    }

    public List<Short> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Short> numbers) {
        this.numbers = numbers;
    }
}
