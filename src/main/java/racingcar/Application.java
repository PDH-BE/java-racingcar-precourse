package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputValidator inputValidator = new InputValidator();
        final CarListGenerator carListGenerator = new CarListGenerator();
        final RacingController racingController = new RacingController();

        String validNamesWithComma = inputNamesWithCommaUntilValid(scanner, inputValidator);
        ArrayList<Car> carList = carListGenerator.generateCarList(validNamesWithComma);
        int validRound = inputRoundUntilValid(scanner, inputValidator);
        racingController.setRacing(carList, validRound);
        racingController.racing();
        System.out.println(racingController);
    }

    private static int inputRoundUntilValid(Scanner scanner, InputValidator inputValidator) {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            String round = scanner.next();
            try {
                inputValidator.validateRoundString(round);
                return Integer.parseInt(round);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static String inputNamesWithCommaUntilValid(Scanner scanner, InputValidator nameValidator) {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String namesWithComma = scanner.next();
            try {
                nameValidator.validateNamesWithComma(namesWithComma);
                return namesWithComma;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
