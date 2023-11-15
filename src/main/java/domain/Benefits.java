package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import view.OutputView;

public class Benefits {
    static final List<Integer> WEEKEND = new ArrayList<>(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
    static final List<Integer> STARS = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));

    public Benefits() {
    }

    public static void show_benefits(int visitDay, Map<Menu, Integer> menuList) {
        Benefits benefits = new Benefits();
        OutputView.printMenuList(menuList);
        int cost = benefits.getPrice(menuList);
        OutputView.printCost(cost);
        OutputView.printGiftMenu(cost);
        int[] sale_list = benefits.checkSales(visitDay, menuList, cost);
        boolean is_weekdays = benefits.checkDate(visitDay);
        OutputView.printSaleList(sale_list, is_weekdays);
        OutputView.printTotalBenefit(sale_list);
        OutputView.printSaledCost(cost, sale_list);
        OutputView.printEventBadge(sale_list);
    }

    public int[] checkSales(int visitDay, Map<Menu, Integer> menuList, int cost) {
        //sales[0] : 디데이, [1] : 평일, 주말 할인 [2] : 특별 할인 [3] : 증정 이벤트
        int[] sales = {0, 0, 0, 0};
        sales[0] = getDDaySales(visitDay);
        sales[1] = weekSales(visitDay, menuList);
        sales[2] = specialSales(visitDay);
        sales[3] = giftEvent(cost);

        return sales;
    }

    private int getDDaySales(int visitDay) {
        if (visitDay <= 25) {
            return 1000 + ((visitDay - 1) * 100);
        }
        return 0;
    }

    public int weekSales(int visitDay, Map<Menu, Integer> menuList) {
        if (WEEKEND.contains(visitDay)) {
            return countMainMenu(menuList) * 2023;
        }
        return countDessertMenu(menuList) * 2023;
    }

    private int countMainMenu(Map<Menu, Integer> menuList) {
        int cnt = 0;
        for (Map.Entry entry : menuList.entrySet()) {
            Menu menu = Menu.valueOf(entry.getKey().toString());
            int count = Integer.parseInt(entry.getValue().toString());
            if (menu.equals(Menu.MAIN1) || menu.equals(Menu.MAIN2) || menu.equals(Menu.MAIN3) || menu.equals(
                    Menu.MAIN4)) {
                cnt += count;
            }
        }
        return cnt;
    }

    private int countDessertMenu(Map<Menu, Integer> menuList) {
        int cnt = 0;
        for (Map.Entry entry : menuList.entrySet()) {
            Menu menu = Menu.valueOf(entry.getKey().toString());
            int count = Integer.parseInt(entry.getValue().toString());
            if (menu.equals(Menu.DESSERT1) || menu.equals(Menu.DESSERT2)) {
                cnt += count;
            }
        }
        return cnt;
    }

    public int getPrice(Map<Menu, Integer> menuList) {
        int price = 0;
        for (Map.Entry entry : menuList.entrySet()) {
            Menu menu = Menu.valueOf(entry.getKey().toString());
            int cnt = Integer.parseInt(entry.getValue().toString());
            price += menu.getPrice() * cnt;
        }
        return price;
    }

    private int specialSales(int visitDay) {
        if (STARS.contains(visitDay)) {
            return 1000;
        }
        return 0;
    }

    private int giftEvent(int cost) {
        if (cost >= 120000) {
            return 25000;
        }
        return 0;
    }

    private boolean checkDate(int visitDay) {
        if (WEEKEND.contains(visitDay)) {
            return false;
        }
        return true;
    }
}
