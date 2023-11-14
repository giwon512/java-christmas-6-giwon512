package domain;

public enum Menu {
    APPETIZER1("양송이수프", 6000), APPETIZER2("타파스", 5500), APPETIZER3("시저샐러드", 8000),
    MAIN1("티본스테이크", 55000), MAIN2("바비큐립", 54000), MAIN3("해산물파스타", 35000), MAIN4("크리스마스파스타", 25000),
    DESSERT1("초코케이크", 15000), DESSERT2("아이스크림", 5000),
    BEVERAGE1("제로콜라", 3000), BEVERAGE2("레드와인", 60000), BEVERAGE3("샴페인", 25000);

    private final int price;
    private final String name;
    private Menu(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }
}
