package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {
    private final CarListGenerator carListGenerator = new CarListGenerator();
    private final RacingController racingController = new RacingController(carListGenerator);

    @Test
    void test(){
        System.out.println(racingController.racing("audi,benz,bmw", 3));
    }
}