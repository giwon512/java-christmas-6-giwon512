package domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import view.InputView;
import view.OutputView;

public class Order {
    private int visit_day;
    private Map<Menu, Integer> menuList = new LinkedHashMap<>();

    public Order() {
    }

    public static void startOrder() {
        Order order = new Order();
        order.setVisitDay();
        order.setMenuList();
    }

    private void setVisitDay() {
        int day = 0;
        while (true) {
            try {
                day = validateDay(InputView.inputVisitDay());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorVisitDay();
            }
        }
        this.visit_day = day;
    }

    public int validateDay(String day) {
        for (char c : day.toCharArray()) {
            if (c < 48 || c > 57) {
                throw new IllegalArgumentException();
            }
        }
        int temp_day = Integer.parseInt(day);
        if (temp_day < 1 || temp_day > 31) {
            throw new IllegalArgumentException();
        }
        return temp_day;
    }

    private void setMenuList() {
        Map<Menu, Integer> menu = new LinkedHashMap<>();
        while (true) {
            try {
                menu = validateOrder(InputView.inputOrder());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorInputOrder();
            }
        }
        this.menuList = menu;
    }

    public Map<Menu, Integer> validateOrder(String order) {
        Map<Menu, Integer> temp = new LinkedHashMap<>();
        String[] orders = order.split(",");
        for (String s : orders) {
            String[] menu_info = s.split("-");
            if (menu_info.length != 2) {
                throw new IllegalArgumentException();
            }
            if (validateMenuName(menu_info[0]) == 0) {
                throw new IllegalArgumentException();
            }
            if (validateMenuCount(menu_info[1]) == 0) {
                throw new IllegalArgumentException();
            }
            temp.put(getMenuVar(menu_info[0]), Integer.parseInt(menu_info[1]));
        }
        return temp;
    }

    public int validateMenuName(String name) {
        Menu menu = getMenuVar(name);
        if (menu == null) {
            return 0;
        }
        return 1;
    }

    public int validateMenuCount(String count) {
        for (char c : count.toCharArray()) {
            if(c < 48 || c > 57) {
                return 0;
            }
        }
        return Integer.parseInt(count);
    }

    public Menu getMenuVar(String name) {
        for (Menu menu : Menu.values()) {
            if (Objects.equals(menu.getName(), name)) {
                return menu;
            }
        }
        return null;
    }

}
