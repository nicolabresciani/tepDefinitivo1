import java.util.concurrent.Semaphore;

public class Industria {
    public RulloTrasportatore rulloTrasportatore;
    public BraccioMeccanico braccioMeccanico;
    public Assemblaggio assemblaggio;

    public Grafica grafica;
    public Industria() {
        rulloTrasportatore = new RulloTrasportatore();
        braccioMeccanico = new BraccioMeccanico(rulloTrasportatore);
        assemblaggio = new Assemblaggio(braccioMeccanico);
        grafica = new Grafica();
    }

    public void start() throws InterruptedException {
        Thread rulloThread = new Thread(rulloTrasportatore, "rulloThread");
        Thread braccioThread = new Thread(braccioMeccanico, "braccioThread");
        Thread assemblaggioThread = new Thread(assemblaggio, "assemblaggioThread");

        rulloThread.start();
        braccioThread.start();
        assemblaggioThread.start();

        Thread.sleep(10000); // Esecuzione dell'Industria per 10 secondi

        rulloThread.interrupt();
        braccioThread.interrupt();
        assemblaggioThread.interrupt();
    }
}


