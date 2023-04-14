package xyz.paulfrische.lottozahlen.games;

import java.util.List;

public interface Game {
    public List<Short> generateNumbers(List<Short> badNumbers);
}
