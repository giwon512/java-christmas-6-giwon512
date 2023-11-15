import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Benefits;
import domain.Menu;
import domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Map;
import java.util.LinkedHashMap;

public class BenefitsTest {
    Benefits benefits = new Benefits();

    @DisplayName("할인 전 총주문 금액 계산 확인")
    @Test
    void checkGetPrice() {
        Map<Menu, Integer> menuList = new LinkedHashMap<>();
        menuList.put(Menu.MAIN3, 2);
        menuList.put(Menu.BEVERAGE2, 1);
        menuList.put(Menu.DESSERT1, 1);
        int price = benefits.getPrice(menuList);
        assertThat(price).isEqualTo(145000);
    }

    @DisplayName("평일, 주말 할인 금액 계산 확인")
    @Test
    void checkWeekSales() {
        Map<Menu, Integer> menuList = new LinkedHashMap<>();
        menuList.put(Menu.MAIN3, 2);
        menuList.put(Menu.BEVERAGE2, 1);
        menuList.put(Menu.DESSERT1, 1);
        int price = benefits.weekSales(29, menuList);
        assertThat(price).isEqualTo(4046);
    }

    @DisplayName("할인 혜택 내역 확인")
    @Test
    void checkSales() {
        Map<Menu, Integer> menuList = new LinkedHashMap<>();
        menuList.put(Menu.MAIN1, 1);
        menuList.put(Menu.MAIN2, 1);
        menuList.put(Menu.DESSERT1, 2);
        menuList.put(Menu.BEVERAGE1, 1);
        int[] Sale_List = benefits.checkSales(3, menuList, 142000);
        int[] compareList = {1200, 4046, 1000, 25000};
        assertThat(Sale_List).isEqualTo(compareList);
    }
}
