package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int CRITERIA_FOR_GO = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int goOrStop() {
        processGoOrStop();
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return this.name + " : " +
                "-".repeat(Math.max(0, this.position));
    }

    private void processGoOrStop() {
        int numberForGoOrStop = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
        if (numberForGoOrStop >= CRITERIA_FOR_GO) {
            position++;
        }
    }
}
