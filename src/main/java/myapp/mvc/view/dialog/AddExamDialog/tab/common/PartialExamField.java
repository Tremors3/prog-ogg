package myapp.mvc.view.dialog.AddExamDialog.tab.common;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import myapp.mvc.view.things.MySpinner;

/**
 * @brief Campo per inserire i dati di una prova parziale
 *
 * Questa classe rappresenta un campo che permette di inserire il voto e il peso
 * di una prova parziale di un esame. La prova parziale può essere opzionalmente
 * eliminabile.
 */
public class PartialExamField extends GridPane {
    
    // ------------ COMPONENTS
    
    /** @brief Etichetta per il voto della prova parziale */
    private final Label lblPartialGrade = new Label("Grade");
    /** @brief Etichetta per il peso della prova parziale */
    private final Label lblWeight = new Label("Weight");
    /** @brief Etichetta per l'inserimento del voto parziale */
    private final Label lblInsertionFirstGrade = new Label("Insertion of the %d° partial grade:");
    /** @brief Campo per inserire il voto della prova parziale */
    private final MySpinner fldPartialGrade = new MySpinner(18, 30, 18, 1);
    /** @brief Campo per inserire il peso della prova parziale */
    private final MySpinner fldWeight = new MySpinner(1, 100, 1, 1);
    
    // ------------ VARIABLES
    
    /** @brief Numero della prova parziale */
    private final int partialExamNumber;
    /** @brief Indica se la prova è eliminabile */
    private final boolean isDeletable;
    
    // ------------ CONSTRUCTOR
    
    /**
     * @brief Costruttore della classe
     *
     * Inizializza un nuovo campo per una prova parziale con il numero e
     * l'indicazione se è eliminabile o meno.
     *
     * @param partialExamNumber Numero della prova parziale
     * @param isDeletable Indica se la prova può essere eliminata
     */
    public PartialExamField(int partialExamNumber, boolean isDeletable) {
        this.partialExamNumber = partialExamNumber;
        this.isDeletable = isDeletable;
        this.setupField();
        this.setupComponents();
    }
    
    /**
     * @brief Configura il layout del campo
     *
     * Imposta il layout del campo utilizzando un GridPane. Definisce
     * la spaziatura e la posizione delle etichette e dei campi di input.
     */
    private void setupField() {
        
        setVgap(10); setHgap(10);
        
        setConstraints(lblInsertionFirstGrade, 0, 0, 2, 1);
        
        setConstraints(lblPartialGrade, 0, 1);
        setConstraints(fldPartialGrade, 1, 1);
        
        setConstraints(lblWeight, 0, 2);
        setConstraints(fldWeight, 1, 2);
        
        getChildren().setAll(
            lblInsertionFirstGrade,
            lblPartialGrade, fldPartialGrade,
            lblWeight, fldWeight
        );
    }
    
    /**
     * @brief Configura i componenti del campo
     *
     * Aggiorna il testo dell'etichetta dell'inserimento del voto
     * in base al numero della prova parziale.
     */
    private void setupComponents() {
        lblInsertionFirstGrade.setText(
            String.format(lblInsertionFirstGrade.getText(), partialExamNumber + 1)
        );
    }
    
    /**
     * @brief Restituisce il peso della prova parziale
     *
     * Recupera il valore inserito nel campo relativo al peso della prova.
     *
     * @return Peso della prova parziale
     */
    public int getWeight() {
        return this.fldWeight.getValue();
    }
    
    /**
     * @brief Restituisce il voto della prova parziale
     *
     * Recupera il valore inserito nel campo relativo al voto della prova.
     *
     * @return Voto della prova parziale
     */
    public int getPartialGrade() {
        return this.fldPartialGrade.getValue();
    }
    
    /**
     * @brief Indica se la prova è eliminabile
     *
     * Restituisce un valore booleano che indica se questa prova parziale
     * può essere eliminata dall'elenco.
     *
     * @return `true` se la prova è eliminabile, altrimenti `false`
     */
    public boolean isDeletable() {
        return isDeletable;
    }
}
