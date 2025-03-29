package myapp.mvc.view.dialog.AddExamDialog.tab.common;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

/**
 * @brief Layout per le prove parziali degli esami
 *
 * Questa classe fornisce un layout che permette di visualizzare e gestire
 * le prove parziali di un esame composto. Permette di aggiungere o eliminare
 * campi per inserire i voti parziali.
 */
public class PartialExamsLayout extends VBox {
    
    // ------------ COMPONENTS
    
    /** @brief Contenitore per le prove parziali */
    private final VBox partialExamsLayout = new VBox();
    
    /** @brief Pannello a scorrimento per le prove parziali */
    private final ScrollPane scrollPane = new ScrollPane();
    
    // ------------ OTHER
    
    /** @brief Numero predefinito di record obbligatori */
    private static final int DEFAULT_MANDATORY_RECORD_NUMBER = 2;
    
    /** @brief Numero massimo predefinito di record */
    private static final int DEFAULT_MAXIMUM_RECORD_NUMBER = 5;
    
    /** @brief Numero corrente di record obbligatori */
    private int CURRENT_MANDATORY_RECORD_NUMBER = 2;
    
    /** @brief Numero corrente di record massimi */
    private int CURRENT_MAXIMUM_RECORD_NUMBER = 5;
    
    /** @brief Lista di record delle prove parziali */
    private final LinkedList<PartialExamField> partialExamFields = new LinkedList<>();
    
    // ------------ CONSTRUCTORS
    /**
     * @brief Costruttore di default
     *
     * Crea un layout per le prove parziali utilizzando il numero predefinito di record
     * obbligatori e massimi.
     */
    public PartialExamsLayout() {
        this(
            PartialExamsLayout.DEFAULT_MANDATORY_RECORD_NUMBER,
            PartialExamsLayout.DEFAULT_MAXIMUM_RECORD_NUMBER
        );
    }
    
    /**
     * @brief Costruttore personalizzato
     *
     * Permette di creare un layout con un numero specifico di record obbligatori
     * e massimi.
     *
     * @param min Numero minimo di record obbligatori
     * @param max Numero massimo di record
     */
    public PartialExamsLayout(int min, int max) {
        this.setCurrentMandatoryRecordNumber(min);
        this.setCurrentMaximumRecordNumber(max);
        this.setupFrame();
        this.setupComponents();
    }
    
    // ------------ SETTING UP
    
    /**
     * @brief Configura il layout del pannello
     *
     * Imposta il padding del layout principale.
     */
    private void setupFrame() {
        /* Setting up current VBox (this) */
        setPadding(new Insets(10, 0, 0, 0)); // OK
    }
    
    /**
     * @brief Configura i componenti del layout
     *
     * Inizializza e imposta i componenti grafici, inclusi i campi per le prove
     * parziali e lo scroll.
     */
    private void setupComponents() {
        
        /* Creating the Mandatory Records */
        createMandatoryRecords();
        
        /* Setting up the VBox containing the Records */
        partialExamsLayout.setPadding(new Insets(20, 0, 20, 20));  // OK
        partialExamsLayout.setSpacing(25);
        
        /* Setting up the ScrollPane containing the VBox */
        scrollPane.setPrefHeight(130);
        scrollPane.setContent(partialExamsLayout);
        
        /* Adding the ScrollPane to current VBox (this) */
        getChildren().add(scrollPane);
    }
    
    // ------------ API
    
    /**
     * @brief Crea i record obbligatori
     *
     * Aggiunge i record iniziali obbligatori al layout delle prove parziali.
     */
    private void createMandatoryRecords() {
        for (int i = 0; i < CURRENT_MANDATORY_RECORD_NUMBER; i++) {
            partialExamFields.add(new PartialExamField(i, false));
        }
        partialExamsLayout.getChildren().addAll(partialExamFields);
    }
    
    /**
     * @brief Aggiunge una prova parziale
     *
     * Aggiunge un nuovo campo per una prova parziale, se non si è raggiunto
     * il numero massimo di record.
     */
    public void addPartial() {
        if (partialExamFields.size() + 1 > CURRENT_MAXIMUM_RECORD_NUMBER) return;
        PartialExamField partial = new PartialExamField(partialExamFields.size(), true);
        partialExamFields.push(partial); // Pushing element at the end of the list
        partialExamsLayout.getChildren().add(partial);
    }
    
    /**
     * @brief Elimina una prova parziale
     *
     * Elimina il primo campo di una prova parziale se è eliminabile,
     * ossia se non è un record obbligatorio.
     */
    public void delPartial() {
        if (partialExamFields.isEmpty() || !partialExamFields.getFirst().isDeletable()) return;
        PartialExamField partial = partialExamFields.pop(); // Retriving the First element
        partialExamsLayout.getChildren().remove(partial);
    }
    
    /**
     * @brief Ottiene la lista delle prove parziali
     *
     * Restituisce la lista delle prove parziali attualmente presenti nel layout.
     *
     * @return ObservableList delle prove parziali
     */
    public ObservableList<PartialExamField> getPartialExamFields() {
        return FXCollections.observableList(partialExamFields);
    }
    
    /**
     * @brief Ottiene il numero corrente di record obbligatori
     *
     * Restituisce il numero corrente di record obbligatori presenti nel layout.
     *
     * @return Numero corrente di record obbligatori
     */
    public int getCurrentMandatoryRecordNumber() {
        return CURRENT_MANDATORY_RECORD_NUMBER;
    }
    
    /**
     * @brief Imposta il numero corrente di record obbligatori
     *
     * Permette di impostare il numero minimo di record obbligatori.
     *
     * @param currentMandatoryRecordNumber Numero minimo di record obbligatori
     */
    public void setCurrentMandatoryRecordNumber(int currentMandatoryRecordNumber) {
        CURRENT_MANDATORY_RECORD_NUMBER = currentMandatoryRecordNumber;
    }
    
    /**
     * @brief Ottiene il numero massimo di record
     *
     * Restituisce il numero massimo di record che possono essere aggiunti.
     *
     * @return Numero massimo di record
     */
    public int getCurrentMaximumRecordNumber() {
        return CURRENT_MAXIMUM_RECORD_NUMBER;
    }
    
    /**
     * @brief Imposta il numero massimo di record
     *
     * Permette di impostare il numero massimo di record aggiungibili.
     *
     * @param currentMaximumRecordNumber Numero massimo di record
     */
    public void setCurrentMaximumRecordNumber(int currentMaximumRecordNumber) {
        CURRENT_MAXIMUM_RECORD_NUMBER = currentMaximumRecordNumber;
    }
}