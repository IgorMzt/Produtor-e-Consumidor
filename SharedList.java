import java.util.LinkedList;
import java.util.List;

public class SharedList {
    private final List<Integer> list = new LinkedList<>();
    private boolean productionFinished = false;

    public synchronized void add(int value) {
        list.add(value);
        notifyAll();
    }

    public synchronized Integer remove() throws InterruptedException {
        while (list.isEmpty() && !productionFinished) {
            wait();
        }
        
        if (list.isEmpty() && productionFinished) {
            return null;
        }
        
        return list.remove(0);
    }

    public synchronized boolean isEmpty() {
        return list.isEmpty();
    }

    public synchronized void finishProduction() {
        productionFinished = true;
        notifyAll();
    }
}
