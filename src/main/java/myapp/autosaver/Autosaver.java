package myapp.autosaver;

// https://stackoverflow.com/questions/16758346/how-pause-and-then-resume-a-thread

/**
 * @brief Classe che rappresenta un thread che esegue periodicamente un'operazione di salvataggio automatico.
 *
 * La classe Autosaver estende Thread e implementa un meccanismo per eseguire operazioni a intervalli regolari.
 * Supporta la sospensione e la ripresa del processo in maniera thread-safe.
 */
public class Autosaver extends Thread {
    
    /** @brief Variabile booleana che indica se il processo è in esecuzione. */
    private volatile boolean running = true;
    
    /** @brief Variabile booleana che indica se il processo è in pausa. */
    private volatile boolean paused = false;
    
    /** @brief Intervallo di tempo predefinito in secondi tra un'operazione e l'altra. */
    protected final static int DEFAULT_SLEEP_IN_SECONDS = 5;
    
    /** @brief Intervallo di tempo corrente in secondi tra un'operazione e l'altra. */
    protected int CURRENT_SLEEP_IN_SECONDS = DEFAULT_SLEEP_IN_SECONDS;
    
    /** @brief Oggetto su cui viene applicato il lock per sospendere il thread in modo thread-safe. */
    private final Object pauseLock = new Object();
    
    /** @brief Interfaccia che definisce l'operazione da eseguire ad ogni intervallo di tempo. */
    private AutosaverJob autosaverJob;
    
    /**
     * @brief Imposta l'interfaccia che definisce l'operazione da eseguire ad ogni intervallo di tempo.
     *
     * @param autosaverJob L'oggetto che implementa AutosaverJob e contiene la logica di salvataggio.
     */
    public void setAutosaverJob(AutosaverJob autosaverJob) {
        this.autosaverJob = autosaverJob;
    }
    
    /**
     * @brief Costruttore di default dell'Autosaver.
     *
     * Utilizza un job predefinito che non esegue alcuna operazione concreta.
     */
    public Autosaver() {
        this(
            new AutosaverJob() {
                @Override
                public void ExecuteJob() {
                    System.out.println("Nessuna operazione di salvataggio selezionata!"); // DEBUG
                }
            }, Autosaver.DEFAULT_SLEEP_IN_SECONDS
        );
    }
    
    /**
     * @brief Costruttore dell'Autosaver con parametri personalizzati.
     *
     * @param autosaverJob L'oggetto che implementa AutosaverJob e contiene la logica di salvataggio.
     * @param sleepTime Intervallo di tempo tra un salvataggio e l'altro.
     */
    public Autosaver(AutosaverJob autosaverJob, int sleepTime) {
        this.setAutosaverJob(autosaverJob);
        this.CURRENT_SLEEP_IN_SECONDS = sleepTime;
    }
    
    /**
     * @brief Metodo eseguito all'avvio del thread.
     *
     * Esegue ciclicamente il job di salvataggio finché il thread è attivo. Supporta la sospensione e ripresa.
     */
    @Override
    public void run() {
        while (running) {
            synchronized (pauseLock) {
                // Controlla se il thread deve terminare
                if (!running) break;
                
                // Se il thread è in pausa, aspetta che venga ripreso
                if (paused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException ex) {
                        break;
                    }
                    
                    // Dopo essere ripreso, controlla se deve terminare
                    if (!running) break;
                }
            }
            
            // Esegue il job di salvataggio
            this.autosaverJob.ExecuteJob();
            
            // Attende prima di eseguire il prossimo job
            try {
                Thread.sleep(CURRENT_SLEEP_IN_SECONDS * 1000L);
            } catch (InterruptedException ignored) {
                running = false;
            }
        }
    }
    
    /**
     * @brief Termina l'esecuzione del processo.
     *
     * Interrompe il thread e se è in pausa, lo riprende per permettere la terminazione.
     */
    public void myStop() {
        running = false;
        myResume(); // Assicura che il thread non rimanga bloccato in pausa.
    }
    
    /**
     * @brief Sospende l'esecuzione del processo.
     *
     * Imposta lo stato del thread come "pausa". Il thread sarà sospeso fino alla chiamata di myResume().
     */
    public void myPause() {
        paused = true;
    }
    
    /**
     * @brief Riprende l'esecuzione del processo.
     *
     * Risveglia il thread se era in pausa e ne consente la continuazione.
     */
    public void myResume() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll(); // Risveglia il thread sospeso.
        }
    }
}
