public class Main {
    public static void main(String... args) {
        SharedList sharedList = new SharedList();
        
        Thread producer = new Thread(new Producer(sharedList));
        Thread consumer = new Thread(new Consumer(sharedList));
        
        consumer.start();
        producer.start();
        
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
