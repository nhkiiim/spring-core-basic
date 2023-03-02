package hello.core.singleton;

public class SingletonService {

    // 1. static 영역에 객체 하나 생성
    private static final SingletonService instance = new SingletonService();

    // 2. static 메서드를 이용해서만 instance get!
    public static SingletonService getInstance() {
        return instance; // 항상 같은 인스턴스 반환
    }

    // 3. 생성자를 private으로 선언해 외부에서 new 로 인스턴스 생성 못하게 막기
    private SingletonService() { // 컴파일에서 방지하는게 좋은 객체 설계 !
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
