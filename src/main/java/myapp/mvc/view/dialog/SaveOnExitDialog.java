package myapp.mvc.view.dialog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @brief Classe per la visualizzazione di una finestra di dialogo di salvataggio all'uscita.
 *
 * Questa classe fornisce un metodo per visualizzare una finestra di dialogo che chiede all'utente
 * se desidera uscire, annullare o salvare e uscire. La scelta dell'utente determina la risposta
 * che viene restituita al termine della visualizzazione della finestra di dialogo.
 */
public class SaveOnExitDialog {
    
    /** @brief Enum per le opzioni di risposta della finestra di dialogo. */
    public enum VALUES {EXIT, CANCEL, SAVE_AND_EXIT}
    
    /** @brief Risposta selezionata dall'utente. */
    private static VALUES answer;
    
    /**
     * @brief Mostra una finestra di dialogo per confermare l'uscita.
     *
     * Questa funzione visualizza una finestra di dialogo con un messaggio e tre pulsanti: "Exit",
     * "Cancel" e "Save and Exit". In base alla selezione dell'utente, viene restituita una delle opzioni
     * definite nell'enum {@link VALUES}.
     *
     * @param title Titolo della finestra di dialogo.
     * @param message Messaggio da visualizzare nella finestra di dialogo.
     * @return La risposta selezionata dall'utente.
     */
    public static VALUES display(String title, String message) {

        Stage window = new Stage();
        
        // Quando si chiude la finestra di dialogo senza fare alcuna scelta, viene selezionato "Cancel"
        window.setOnCloseRequest(e -> answer = VALUES.CANCEL);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(100);
        window.setMinWidth(200);
        window.setResizable(false);

        Label lblMessage = new Label(message);

        Button btnExit = new Button("Exit"); btnExit.setOnAction(e -> {answer = VALUES.EXIT; window.close();});
        Button btnCancel = new Button("Cancel"); btnCancel.setOnAction(e -> {answer = VALUES.CANCEL; window.close();});
        Button btnSaveAndExit = new Button("Save and Exit"); btnSaveAndExit.setOnAction(e -> {answer = VALUES.SAVE_AND_EXIT; window.close();});

        HBox hLayout = new HBox();
        hLayout.getChildren().addAll(btnExit, btnCancel, btnSaveAndExit);
        hLayout.setAlignment(Pos.CENTER);
        hLayout.setPadding(new Insets(10));
        hLayout.setSpacing(10);

        VBox vLayout = new VBox();
        vLayout.getChildren().addAll(lblMessage, hLayout);
        vLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vLayout, 215, 50); // Aumentato per ospitare i pulsanti e il messaggio
        window.setScene(scene);
        window.showAndWait(); // Mostra la finestra e attende che venga chiusa prima di restituire la risposta

        return answer;
    }
}
