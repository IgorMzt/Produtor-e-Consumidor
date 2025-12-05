import java.util.Random;

public class Producer implements Runnable {
    private final SharedList sharedList;
    private final Random random = new Random();

    public Producer(SharedList sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int randomInteger = random.nextInt();
            System.out.println("Producing a new integer: " + String.valueOf(randomInteger));
            sharedList.add(randomInteger);
            
            try {
                Thread.sleep(random.nextLong(1000, 2000));
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        sharedList.finishProduction();
    }
}
