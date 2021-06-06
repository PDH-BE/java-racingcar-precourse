package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {
    private static InputValidator inputValidator;

    @BeforeAll
    static void init() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("이름이 , 로 끝나는 경우")
    void namesEndsWithComma() {
        String namesWithComma = "a,";
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> inputValidator.validateNamesWithComma(namesWithComma));

        assertEquals("[ERROR] 이름이 ,로 끝나서는 안됩니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("이름이 공백인 경우")
    void namesWithComma() {
        String namesWithComma = ",c";
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> inputValidator.validateNamesWithComma(namesWithComma));

        assertEquals("[ERROR] 이름이 공백이여선 안됩니다.", illegalArgumentException.getMessage());

    }

    @Test
    @DisplayName("이름이 5자를 초과한 경우")
    void namesExceedLimit() {
        String namesWithComma = "a,qwerty,c";
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> inputValidator.validateNamesWithComma(namesWithComma));

        assertEquals("[ERROR] 이름은 5자 이하여야 합니다.", illegalArgumentException.getMessage());

    }

    @Test
    @DisplayName("횟수가 숫자가 아닌 경우")
    void roundNotNumber() {
        String roundString = "abc";
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> inputValidator.validateRoundString(roundString));
        assertEquals("[ERROR] 횟수는 1 이상의 정수여야 합니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("횟수가 정수가 아닌 경우")
    void roundNotInteger() {
        String roundString = "2.1";
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> inputValidator.validateRoundString(roundString));
        assertEquals("[ERROR] 횟수는 1 이상의 정수여야 합니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("횟수가 음수인 경우")
    void roundMinus() {
        String roundString = "-1";
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> inputValidator.validateRoundString(roundString));
        assertEquals("[ERROR] 횟수는 1 이상의 정수여야 합니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("횟수가 0 인 경우")
    void roundLessThanOne() {
        String roundString = "0";
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> inputValidator.validateRoundString(roundString));
        assertEquals("[ERROR] 횟수가 0 이여서는 안됩니다.", illegalArgumentException.getMessage());
    }
}