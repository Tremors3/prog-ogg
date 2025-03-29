package myapp.mvc.view.things;

import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * @brief Classe che rappresenta uno spazio verticale personalizzato.
 *
 * La classe estende {@link Region} e viene utilizzata per aggiungere spazi verticali
 * all'interno di un layout VBox. Imposta le proprietà per garantire che lo spazio
 * venga esteso verticalmente e abbia una dimensione minima predefinita.
 */
public class MyVSpacer extends Region {
    
    /**
     * @brief Costruttore della classe {@link MyVSpacer}.
     *
     * Inizializza il componente e applica le impostazioni predefinite.
     */
    public MyVSpacer() {
        this.setup();
    }
    
    /**
     * @brief Configura le proprietà del componente {@link MyVSpacer}.
     *
     * Questo metodo imposta la priorità di crescita verticale su {@link Priority#ALWAYS}
     * e definisce la dimensione minima del componente come la dimensione predefinita.
     */
    private void setup() {
        // Imposta la priorità di crescita verticale come sempre
        VBox.setVgrow(this, Priority.ALWAYS);
        
        // Imposta la dimensione minima come quella predefinita
        this.setMinHeight(Region.USE_PREF_SIZE);
    }
}
