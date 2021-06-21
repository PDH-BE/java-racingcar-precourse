package racingcar;

import java.util.ArrayList;

public class CarListGenerator {
    public ArrayList<Car> generate(String namesWithComma) {
        ArrayList<Car> carList = new ArrayList<>();
        String[] names = namesWithComma.split(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }
}
