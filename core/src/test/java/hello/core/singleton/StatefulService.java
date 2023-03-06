package hello.core.singleton;

public class StatefulService {

    // private int price; // 지역변수 사용 X

    public int order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        // this.price = price; // 여기가 문제
        return price;
    }

}
