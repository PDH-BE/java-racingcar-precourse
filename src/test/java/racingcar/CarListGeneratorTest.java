package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarListGeneratorTest {
    private static CarListGenerator carListGenerator;

    @BeforeAll
    static void init() {
        carListGenerator = new CarListGenerator();
    }

    @Test
    @DisplayName("카 리스트 생성 테스트")
    void test() {
        String namesWithComma = "a,b,c";
        String[] expectedNames = namesWithComma.split(",");
        int expectedSize = expectedNames.length;

        ArrayList<Car> carList = carListGenerator.generateCarList(namesWithComma);
        ArrayList<String> actualNames = new ArrayList<>();
        for (Car car : carList) {
            actualNames.add(car.getName());
        }
        int actualSize = carList.size();

        assertArrayEquals(expectedNames, actualNames.toArray());
        assertEquals(expectedSize, actualSize);
    }

}