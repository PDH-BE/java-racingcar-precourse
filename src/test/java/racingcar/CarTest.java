package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void car() {
        String name = "audi";
        Car car = new Car(name);
        int count = 3;
        int curPosition = 0;

        for (int i = 0; i < count; i++) {
            curPosition = car.goOrStop();
        }

        assertTrue(car.isPosition(curPosition));
        assertEquals(name, car.getName());
    }
}