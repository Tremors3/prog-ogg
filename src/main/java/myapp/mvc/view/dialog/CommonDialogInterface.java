package myapp.mvc.view.dialog;

/**
 * @brief Interfaccia per i dialog di conferma.
 *
 * Questa interfaccia definisce un metodo per chiudere una finestra di dialogo. Le classi che
 * implementano questa interfaccia devono fornire una specifica implementazione del metodo
 * per gestire la chiusura della finestra di dialogo.
 */
public interface CommonDialogInterface {
    
    /**
     * @brief Chiude la finestra di dialogo.
     *
     * Questo metodo viene chiamato per chiudere la finestra di dialogo. Deve essere implementato
     * dalle classi che gestiscono i dialog per eseguire le operazioni necessarie alla chiusura
     * della finestra.
     */
    void CloseWindow();
}