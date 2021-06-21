package racingcar;

import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidator inputValidator = new InputValidator();
    private static final CarListGenerator carListGenerator = new CarListGenerator();
    private static final RacingController racingController = new RacingController(carListGenerator);

    public static void main(String[] args) {
        System.out.println(racingController.racing(inputNamesWithCommaUntilValid(), inputRoundUntilValid()));
    }

    private static int inputRoundUntilValid() {
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

    private static String inputNamesWithCommaUntilValid() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String namesWithComma = scanner.next();
            try {
                inputValidator.validateNamesWithComma(namesWithComma);
                return namesWithComma;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
