package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final ArrayList<Car> winners;
    private ArrayList<Car> carList;
    private int round;
    private int maxPosition;

    public RacingController() {
        this.winners = new ArrayList<>();
    }

    public void setRacing(ArrayList<Car> carList, int round) {
        this.carList = carList;
        this.round = round;
        this.maxPosition = 0;
    }

    public void racing() {
        System.out.println("실행 결과");
        while (round-- > 0) {
            this.racingAllCarsForOneRound();
            this.printStatusOfAllCars();
        }
        this.competeMaxPositionOfAllCars();
        this.competeWinners();
    }

    @Override
    public String toString() {
        List<String> namesOfWinners = winners.stream().map(Car::getName).collect(Collectors.toList());
        return String.join(", ", namesOfWinners) + " 가 최종 우승입니다.";
    }

    private void printStatusOfAllCars() {
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }

    private void racingAllCarsForOneRound() {
        carList.forEach(Car::goOrStop);
    }

    private void competeMaxPositionOfAllCars() {
        for (Car car : carList) {
            if (car.getPosition() > this.maxPosition) {
                this.maxPosition = car.getPosition();
            }
        }
    }

    private void competeWinners() {
        this.winners.clear();
        for (Car car : carList) {
            if (car.isThisPosition(this.maxPosition)) {
                this.winners.add(car);
            }
        }
    }
}
