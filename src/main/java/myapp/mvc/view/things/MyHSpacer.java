package myapp.mvc.view.things;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * @brief Classe estesa da {@link Region} per creare uno spazio orizzontale flessibile.
 *
 * La classe {@link MyHSpacer} estende {@link Region} e viene utilizzata per creare uno spazio orizzontale
 * che si espande automaticamente per occupare l'area disponibile in un layout {@link HBox}.
 */
public class MyHSpacer extends Region {
    
    /**
     * @brief Costruttore per {@link MyHSpacer}.
     *
     * Questo costruttore inizializza lo spazio orizzontale configurando il suo comportamento
     * all'interno di un {@link HBox}.
     */
    public MyHSpacer() {
        this.setup();
    }
    
    /**
     * @brief Configura le proprietà del {@link MyHSpacer}.
     *
     * Questo metodo imposta la priorità di espansione orizzontale come {@link Priority#ALWAYS} e
     * la larghezza minima del {@link MyHSpacer} come {@link Region#USE_PREF_SIZE}.
     */
    private void setup() {
        // Imposta la priorità di crescita orizzontale su "ALWAYS" per il componente spacer
        HBox.setHgrow(this, Priority.ALWAYS);
        
        // Imposta la larghezza minima a quella preferita per il componente spacer
        this.setMinWidth(Region.USE_PREF_SIZE);
    }
}
