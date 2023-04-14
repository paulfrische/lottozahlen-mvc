package xyz.paulfrische.lottozahlen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.paulfrische.lottozahlen.games.ClassicGame;
import xyz.paulfrische.lottozahlen.games.Eurojackpot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.paulfrische.lottozahlen.util.ParserUtil;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GameApiController {
    private static final ClassicGame classicGame = new ClassicGame();
    private static final Eurojackpot eurojackpot = new Eurojackpot();
    private static final Logger logger = LoggerFactory.getLogger(GameApiController.class);
    @GetMapping("/classic")
    public List<Short> classic(@RequestParam(name = "bn", required = true, defaultValue = "0,0,0,0,0,0") String badNumbersParameter) {
        List<Short> badNumbers = ParserUtil.parseNumbers(badNumbersParameter);
        logger.debug("classic, bad numbers: " + badNumbers.toString());
        return classicGame.generateNumbers(badNumbers);
    }

    @GetMapping("/eurojackpot")
    public List<Short> eurojackpot(@RequestParam(name = "bn", required = true, defaultValue = "0,0,0,0,0,0") String badNumbersParameter) {
        List<Short> badNumbers = ParserUtil.parseNumbers(badNumbersParameter);
        logger.debug("eurojackpot, bad numbers: " + badNumbers.toString());
        return eurojackpot.generateNumbers(badNumbers);
    }
}
