import java.util.concurrent.Semaphore;

public class BraccioMeccanico implements Runnable {
    public Semaphore semaphore = new Semaphore(1);
    public RulloTrasportatore rulloTrasportatore;
    public boolean hasObject;

    public BraccioMeccanico(RulloTrasportatore rulloTrasportatore) {
        this.rulloTrasportatore = rulloTrasportatore;
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

                if (rulloTrasportatore.hasObject() && !hasObject) {
                    System.out.println("Il braccio meccanico prende l'oggetto dal rullo.");
                    rulloTrasportatore.releaseObject();
                    hasObject = true;
                } else {
                    System.out.println("Il braccio meccanico non può prendere l'oggetto perché è occupato.");
                }

                semaphore.release();
                Thread.sleep(1000); // Tempo che il braccio meccanico impiega per prendere un oggetto
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

