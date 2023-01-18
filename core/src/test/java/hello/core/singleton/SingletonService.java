package hello.core.singleton;

public class SingletonService {
    //자기 자신을 외부에 private으로 가지고 있는데 static임
    //클래스 레벨이 존재하기 때문에 딱 하나만 존재하게 됨
    // ==>java static 참고
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {    //외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 private으로 막는다.

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
