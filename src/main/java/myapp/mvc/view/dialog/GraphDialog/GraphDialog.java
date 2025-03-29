package myapp.mvc.view.dialog.GraphDialog;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myapp.mvc.view.dialog.CommonDialogInterface;

import java.util.Map;

/**
 * @brief Dialogo per la visualizzazione di un grafico.
 *
 * Questa classe gestisce la visualizzazione di un dialogo modale che mostra un grafico a barre,
 * rappresentante i voti degli studenti.
 */
public class GraphDialog {
    
    /** @brief Pannello contenente il grafico */
    private static GraphPane grapPane;
    
    /**
     * @brief Mostra il dialogo con il grafico.
     *
     * Questo metodo crea e visualizza una finestra di dialogo modale che mostra un grafico a barre
     * basato sui dati forniti. La finestra è configurata con il titolo e le dimensioni specificate.
     *
     * @param title Titolo del grafico
     * @param studentGrades Mappa dei voti degli studenti
     * @param size Dimensione del grafico
     */
    public static void display(String title, Map<String, int[]> studentGrades, int size) {
        
        final Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Graph View");
        window.setResizable(false);
        window.sizeToScene();
        
        // -----------------------------------
        
        // Inizializzazione del pannello del grafico
        grapPane = new GraphPane(title, studentGrades, size);
        
        // -----------------------------------
        
        // Configurazione dell'interfaccia per chiudere il dialogo
        CommonDialogInterface commonDialogInterface = window::close;
        grapPane.setCommonDialogInterface(commonDialogInterface);
        
        // -----------------------------------
        
        // Creazione e visualizzazione della scena
        Scene scene = new Scene(grapPane);
        window.setScene(scene);
        window.showAndWait(); // Mostra la finestra di dialogo e attende che venga chiusa prima di restituire il controllo
    }
}
