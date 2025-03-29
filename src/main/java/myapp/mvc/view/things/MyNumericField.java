package myapp.mvc.view.things;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * @brief Classe estesa da {@link TextField} per accettare solo input numerici.
 *
 * La classe {@link MyNumericField} estende {@link TextField} e utilizza un {@link TextFormatter}
 * per garantire che l'input dell'utente consista solo in caratteri numerici.
 */
public class MyNumericField extends TextField {
    
    /** @brief Espressione regolare per accettare solo numeri. */
    public static final String DIGITS = "\\d*";
    
    /**
     * @brief Costruttore per {@link MyNumericField}.
     *
     * Questo costruttore imposta un {@link TextFormatter} che consente solo l'inserimento di
     * caratteri numerici nell'area di testo.
     */
    public MyNumericField() {
        // Imposta il formato di testo per accettare solo numeri
        this.setTextFormatter(new TextFormatter<>(change ->
            change.getControlNewText().matches(DIGITS) ? change : null
        ));
    }
}
