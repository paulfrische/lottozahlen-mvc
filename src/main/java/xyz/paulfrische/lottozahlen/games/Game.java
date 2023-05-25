package xyz.paulfrische.lottozahlen.games;

import java.util.List;

import xyz.paulfrische.lottozahlen.data.Numbers;

public interface Game {
    public Numbers generateNumbers(List<Short> badNumbers);
}
