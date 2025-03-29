package myapp.mvc.view.pane;

/**
 * @brief Interfaccia per la gestione delle operazioni sui pannelli centrali.
 *
 * Questa interfaccia definisce i metodi per passare i dati relativi a un esame parziale
 * e per nascondere i dettagli dell'esame parziale. Le classi che implementano questa
 * interfaccia devono fornire implementazioni concrete per questi metodi.
 */
public interface CenterPaneInterface {
    
    /**
     * @brief Passa i dettagli di un esame parziale al pannello centrale.
     *
     * Questo metodo è chiamato per fornire i dettagli di un esame parziale al pannello
     * centrale, in modo che possano essere visualizzati o modificati.
     *
     * @param uniqueExamId ID unico dell'esame parziale da visualizzare.
     */
    void passPartialExam(String uniqueExamId);
    
    /**
     * @brief Nasconde i dettagli dell'esame parziale.
     *
     * Questo metodo è chiamato per nascondere i dettagli dell'esame parziale attualmente
     * visualizzati nel pannello centrale.
     */
    void hidePartialExam();
}
