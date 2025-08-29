package SingletonDesignPattern;

public class ThreadSafeEager {
    private static final ThreadSafeEager instance = new ThreadSafeEager();

    private ThreadSafeEager() {
        System.out.println("Singleton Constructor Called!");
    }

    public static ThreadSafeEager getInstance() {
        return instance;
    }

     public static void main(String[] args) {
        ThreadSafeEager s1 = ThreadSafeEager.getInstance();
        ThreadSafeEager s2 = ThreadSafeEager.getInstance();

        System.out.println(s1 == s2);
     }
}
