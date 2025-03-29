package myapp.autosaver;

/**
 * @brief Interfaccia che rappresenta un'operazione di salvataggio eseguibile dall'Autosaver.
 *
 * Gli oggetti che implementano questa interfaccia devono definire la logica dell'operazione
 * da eseguire periodicamente dall'oggetto Autosaver.
 */
public interface AutosaverJob {
    
    /**
     * @brief Metodo da implementare per eseguire l'operazione di salvataggio.
     *
     * Questo metodo verrà chiamato dall'Autosaver ad ogni intervallo di tempo specificato.
     */
    void ExecuteJob();
}
