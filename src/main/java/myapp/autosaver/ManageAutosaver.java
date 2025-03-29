package myapp.autosaver;

/**
 * @brief Interfaccia per la gestione del ciclo di vita di un Autosaver.
 *
 * Questa interfaccia definisce i metodi necessari per avviare, fermare, mettere in pausa e
 * riprendere l'esecuzione di un oggetto Autosaver.
 */
public interface ManageAutosaver {
    
    /**
     * @brief Avvia l'Autosaver.
     *
     * Questo metodo avvia l'esecuzione del thread Autosaver, permettendogli di eseguire
     * le operazioni di salvataggio ad intervalli regolari.
     */
    void startAutosaver();
    
    /**
     * @brief Ferma l'Autosaver.
     *
     * Termina in modo sicuro l'esecuzione del thread Autosaver, interrompendo eventuali
     * operazioni di salvataggio in corso.
     */
    void stopAutosaver();
    
    /**
     * @brief Riprende l'Autosaver.
     *
     * Riprende l'esecuzione del thread Autosaver se questo era stato precedentemente messo in pausa.
     */
    void resumeAutosaver();
    
    /**
     * @brief Mette in pausa l'Autosaver.
     *
     * Sospende temporaneamente l'esecuzione del thread Autosaver, evitando che esegua operazioni
     * di salvataggio fino a quando non verrà ripreso.
     */
    void pauseAutosaver();
}
