package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("이름이 , 로 끝나는 경우")
    void invalidName_endsWithComma() {
        String namesWithComma = "audi,";

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateNamesWithComma(namesWithComma);
        });
        assertEquals("[ERROR] 이름이 ,로 끝나서는 안됩니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("이름이 공백인 경우")
    void invalidName_blank() {
        String namesWithComma = "audi, ,benz";

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateNamesWithComma(namesWithComma);
        });
        assertEquals("[ERROR] 이름이 공백이여선 안됩니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("이름 제한을 초과한 경우")
    void invalidName_exceedLimit() {
        String namesWithComma = "Lamborghini";

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateNamesWithComma(namesWithComma);
        });
        assertEquals("[ERROR] 이름은 5자 이하여야 합니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Round가 숫자가 아닌 경우")
    void invalidRound_notNumber() {
        String round = "abcd";

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateRoundString(round);
        });
        assertEquals("[ERROR] 횟수는 1 이상의 정수여야 합니다.",illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Round가 정수가 아닌 경우")
    void invalidRound_notInteger() {
        String round = "1.23";

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateRoundString(round);
        });
        assertEquals("[ERROR] 횟수는 1 이상의 정수여야 합니다.",illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Round가 0인 경우")
    void invalidRound_isZero() {
        String round = "0";

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateRoundString(round);
        });
        assertEquals("[ERROR] 횟수가 0 이여서는 안됩니다.",illegalArgumentException.getMessage());
    }
}