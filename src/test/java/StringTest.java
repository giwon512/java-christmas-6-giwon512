import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;
import java.util.LinkedHashMap;

public class StringTest {
    String input = "해산물파스타-2,레드와인-1,초코케이크-1";

    @DisplayName("입력받은 문자열이 잘 분리되는지 확인하기")
    @Test
    void stringSplitTest() {
        String[] orders = input.split(",");
        int cnt = 0;
        for (String order : orders) {
            String[] temp = order.split("-");
            cnt += Integer.parseInt(temp[1]);
        }
        assertThat(cnt).isEqualTo(4);
    }
}