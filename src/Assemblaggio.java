import java.util.concurrent.*;

public class Assemblaggio implements Runnable {
    public Semaphore semaphore = new Semaphore(1);
    public BraccioMeccanico braccioMeccanico;
    public boolean hasObject;

    public Assemblaggio(BraccioMeccanico braccioMeccanico) {
        this.braccioMeccanico = braccioMeccanico;
    }

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

                if (braccioMeccanico.hasObject() && !hasObject) {
                    System.out.println("Il braccio meccanico rilascia l'oggetto sull'assemblaggio.");
                    braccioMeccanico.releaseObject();
                    hasObject = true;
                }

                semaphore.release();
                Thread.sleep(1500); // Tempo che l'assemblaggio impiega per assemblare un oggetto
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}