package view;

public class OutputView {
    private static final String PREVIEW_BENEFIT = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ERROR_VISIT_DAY = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String ERROR_INPUT_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void printPreview() {
        System.out.println(PREVIEW_BENEFIT);
    }

    public static void printErrorVisitDay() {
        System.out.println(ERROR_VISIT_DAY);
    }

    public static void printErrorInputOrder() {
        System.out.println(ERROR_INPUT_ORDER);
    }

}
