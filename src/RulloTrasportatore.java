import java.util.concurrent.*;

public class RulloTrasportatore implements Runnable {
    public Semaphore semaphore = new Semaphore(1);
    public boolean hasObject;

    public boolean hasObject() {
        return hasObject;
    }

    public void releaseObject() {
        hasObject = false;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                semaphore.acquire();

                if (!hasObject) {
                    System.out.println("Un oggetto parte dal rullo.");
                    hasObject = true;
                }

                semaphore.release();
                Thread.sleep(500); // Intervallo tra l'invio di un oggetto e il successivo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
