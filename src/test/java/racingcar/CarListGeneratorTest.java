package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarListGeneratorTest {
    private final CarListGenerator carListGenerator = new CarListGenerator();

    @Test
    void generate(){
        String namesWithComma = "Audi,Benz,Lamborghini";
        String[] names = namesWithComma.split(",");

        ArrayList<Car> carList = carListGenerator.generate(namesWithComma);

        assertEquals(names.length,carList.size());
        for(int i=0;i<carList.size();i++){
            assertEquals(names[i],carList.get(i).getName());
        }
    }
}