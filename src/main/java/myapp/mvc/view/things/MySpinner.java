package myapp.mvc.view.things;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * @brief Classe che estende {@link Spinner} per fornire uno spinner numerico con valori personalizzati.
 *
 * La classe {@link MySpinner} è una sottoclasse di {@link Spinner} che consente di configurare
 * uno spinner numerico con intervalli di valori, valore iniziale e passo di incremento.
 */
public class MySpinner extends Spinner<Integer> {
    
    /**
     * @brief Costruttore predefinito per {@link MySpinner}.
     *
     * Questo costruttore imposta l'intervallo di valori dell'spinner da 18 a 30, con un valore iniziale di 18 e un passo di incremento di 1.
     */
    public MySpinner() {
        this(18, 30, 18, 1);
    }
    
    /**
     * @brief Costruttore personalizzato per {@link MySpinner}.
     *
     * Questo costruttore consente di configurare l'spinner con valori personalizzati per l'intervallo, il valore iniziale e il passo di incremento.
     *
     * @param lower Il valore minimo che l'spinner può assumere.
     * @param upper Il valore massimo che l'spinner può assumere.
     * @param init Il valore iniziale dell'spinner.
     * @param step Il passo di incremento per l'spinner.
     */
    public MySpinner(int lower, int upper, int init, int step) {
        // Imposta la larghezza massima dell'spinner
        this.setMaxWidth(500);
        
        // Imposta la fabbrica di valori per l'spinner con i parametri forniti
        this.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(lower, upper, init, step)
        );
    }
}
