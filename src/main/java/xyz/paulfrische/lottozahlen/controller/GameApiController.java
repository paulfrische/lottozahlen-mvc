package xyz.paulfrische.lottozahlen.controller;

import org.springframework.context.annotation.Bean;
import xyz.paulfrische.lottozahlen.games.ClassicGame;
import xyz.paulfrische.lottozahlen.games.Eurojackpot;
import xyz.paulfrische.lottozahlen.model.ClassicModel;
import xyz.paulfrische.lottozahlen.model.EurojackpotModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
public class GameApiController {
    private static final ClassicGame classicGame = new ClassicGame();
    private static final Eurojackpot eurojackpot = new Eurojackpot();
    @GetMapping("/classic")
    public List<Short> classic(@RequestParam(name = "bn", required = true, defaultValue = "0,0,0,0,0,0") String badNumbersParameter) {
        List<Short> badNumbers = new ArrayList<>();
        String[] badNumbersString =  badNumbersParameter.split(",");
        for (String num : badNumbersString) {
            badNumbers.add(Short.parseShort(num));
        }
        System.out.println(badNumbers);
        return classicGame.generateNumbers(badNumbers);
    }

    @GetMapping("/eurojackpot")
    public List<Short> eurojackpot(@RequestParam(name = "bn", required = true, defaultValue = "0,0,0,0,0,0") String badNumbersParameter) {
        List<Short> badNumbers = new ArrayList<>();
        String[] badNumbersString =  badNumbersParameter.split(",");
        for (String num : badNumbersString) {
            badNumbers.add(Short.parseShort(num));
        }
        System.out.println(badNumbers);
        return eurojackpot.generateNumbers(badNumbers);
    }
}
