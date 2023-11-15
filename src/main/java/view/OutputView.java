package view;

import static view.StringList.*;

import domain.Badge;
import domain.Menu;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    static DecimalFormat decFormat = new DecimalFormat("###,###");

    public static void printVisitDay() {
        System.out.println(HELLO);
        System.out.println(INPUT_VISIT_DAY);
    }

    public static void printInputOrder() {
        System.out.println(INPUT_ORDER);
    }

    public static void printPreview() {
        System.out.println(PREVIEW_BENEFIT);
        System.out.println();
    }

    public static void printErrorVisitDay() {
        System.out.println(ERROR_VISIT_DAY);
    }

    public static void printErrorInputOrder() {
        System.out.println(ERROR_INPUT_ORDER);
    }

    public static void printMenuList(Map<Menu, Integer> menuList) {
        printPreview();
        System.out.println(ORDER_MENU);
        menuList.forEach((menu, cnt) -> {
            System.out.println(menu.getName() + " " + decFormat.format(cnt) + "개");
        });
        System.out.println();
    }

    public static void printCost(int cost) {
        System.out.println(BEFORE_SALE_COST);
        System.out.println(decFormat.format(cost) + "원");
        System.out.println();
    }

    public static void printGiftMenu(int cost) {
        System.out.println(GIFT_MENU);
        if (cost >= 120000) {
            System.out.println("샴페인 1개");
        } else if (cost < 120000) {
            System.out.println(NONE);
        }
        System.out.println();
    }

    public static void printSaleList(int[] sale_list, boolean isWeekdays) {
        System.out.println(BENEFIT_LIST);
        if (sale_list[0] == 0 && sale_list[1] == 0 && sale_list[2] == 0 && sale_list[3] == 0) {
            System.out.println(NONE);
        }
        if (sale_list[0] != 0) {
            System.out.println(DDAY_SALE + decFormat.format(sale_list[0]) + "원");
        }
        if (sale_list[1] != 0 && isWeekdays) {
            System.out.println(WEEKDAY_SALE + decFormat.format(sale_list[1]) + "원");
        } else if (sale_list[1] != 0 && !isWeekdays) {
            System.out.println(WEEKEND_SALE + decFormat.format(sale_list[1]) + "원");
        }
        if (sale_list[2] != 0) {
            System.out.println(SPECIAL_SALE + decFormat.format(sale_list[2]) + "원");
        }
        if (sale_list[3] != 0) {
            System.out.println(GIFT_EVENT + decFormat.format(sale_list[3]) + "원");
        }
        System.out.println();
    }

    public static void printTotalBenefit(int[] sale_list) {
        int total = 0;
        for (int sale : sale_list) {
            total += sale;
        }
        System.out.println(TOTAL_BENEFIT);
        System.out.println(decFormat.format((-1) * total) + "원");
        System.out.println();
    }

    public static void printSaledCost(int cost, int[] sale_list) {
        int sale = sale_list[0] + sale_list[1] + sale_list[2];
        System.out.println(EXPECTED_COST);
        System.out.println(decFormat.format(cost - sale) + "원");
        System.out.println();
    }

    public static void printEventBadge(int[] sale_list) {
        int total_sale = sale_list[0] + sale_list[1] + sale_list[2] + sale_list[3];
        System.out.println(EVENT_BADGE);
        if (total_sale < 5000){
            System.out.println(NONE);
        } else if (total_sale >= 20000) {
            System.out.println(Badge.SANTA.getName());
        } else if (total_sale >= 10000) {
            System.out.println(Badge.TREE.getName());
        } else if (total_sale >= 5000) {
            System.out.println(Badge.STAR.getName());
        }
        System.out.println();
    }
}
