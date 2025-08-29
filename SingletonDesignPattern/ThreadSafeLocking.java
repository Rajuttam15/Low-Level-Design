package SingletonDesignPattern;

public class ThreadSafeLocking {
    private static ThreadSafeLocking instance = null;

    private ThreadSafeLocking() {
        System.out.println("Singleton Constructor Called!");
    }

    public static ThreadSafeLocking getInstance() {
        synchronized (ThreadSafeLocking.class) { // Lock for thread safety
            if (instance == null) {
                instance = new ThreadSafeLocking();
            }
            return instance;
        }
    }


     public static void main(String[] args) {
        ThreadSafeLocking s1 = ThreadSafeLocking.getInstance();
        ThreadSafeLocking s2 = ThreadSafeLocking.getInstance();

        System.out.println(s1 == s2);
     }
}
//what is locking in java?

//Locking in Java is a mechanism that restricts access to a shared resource by multiple threads
// at the same time. It ensures that only one thread can access a particular section of code
// or resource at a time, preventing data inconsistency.