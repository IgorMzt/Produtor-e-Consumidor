import java.util.Random;

public class Consumer implements Runnable {
    private final SharedList sharedList;
    private final Random random = new Random();

    public Consumer(SharedList sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer value = sharedList.remove();
                
                if (value == null) {
                    System.err.println("Nothing more to consume");
                    break;
                }
                
                System.out.println("Consuming an integer: " + String.valueOf(value));
                Thread.sleep(random.nextLong(1000, 2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
