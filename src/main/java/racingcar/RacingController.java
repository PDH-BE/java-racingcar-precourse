package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final CarListGenerator carListGenerator;

    public RacingController(CarListGenerator carListGenerator) {
        this.carListGenerator = carListGenerator;
    }

    public String racing(String namesWithComma, int round) {
        ArrayList<Car> carList = carListGenerator.generate(namesWithComma);
        List<Car> winners = racingForRounds(carList, round);
        return makeResultString(winners);
    }

    private List<Car> racingForRounds(ArrayList<Car> carList, int round) {
        List<Car> winners = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();

        System.out.println("실행 결과");
        while (round-- > 0) {
            for (Car car : carList) {
                positions.add(car.goOrStop());
                System.out.println(car);
            }
            System.out.println();
        }

        int maxPosition = Collections.max(positions);
        for (Car car : carList) {
            if (car.isPosition(maxPosition)) {
                winners.add(car);
            }
        }

        return winners;
    }

    private String makeResultString(List<Car> winners) {
        List<String> namesOfWinners = winners.stream().map(Car::getName).collect(Collectors.toList());
        return String.join(", ", namesOfWinners) + " 가 최종 우승입니다.";
    }
}
