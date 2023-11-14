import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Menu;
import domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;
import java.util.LinkedHashMap;

public class OrderTest {
    Map<Menu, Integer> menuList = new LinkedHashMap<>();
    Order test = new Order();

    @DisplayName("방문 날짜 확인")
    @Test
    void check_visit_day() {
        assertThatThrownBy(() -> test.validateDay("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> test.validateDay("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 이름 체크")
    @Test
    void check_validate_menu_name() {
        assertThat(test.validateMenuName("asdf")).isEqualTo(0);
        assertThat(test.validateMenuName("해산물파스타")).isEqualTo(1);
    }

    @DisplayName("메뉴 주문 숫자 체크")
    @Test
    void check_validate_menu_count() {
        assertThat(test.validateMenuCount("asdf")).isEqualTo(0);
        assertThat(test.validateMenuCount("0")).isEqualTo(0);
        assertThat(test.validateMenuCount("4")).isEqualTo(4);
    }

    @DisplayName("메뉴 주문 체크")
    @Test
    void check_validate_order() {
        menuList.put(Menu.MAIN3, 2);
        menuList.put(Menu.BEVERAGE2, 1);
        menuList.put(Menu.DESSERT1, 1);
        assertThat(test.validateOrder("해산물파스타-2,레드와인-1,초코케이크-1")).isEqualTo(menuList);
        assertThatThrownBy(() -> test.validateOrder("asdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
