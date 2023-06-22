/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cesgranrio.lp5.sisacademico.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.layout.*;

/**
 * FXML Controller class
 *
 * @author rogerps
 */
public class JanelaPrincipalController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    void onPerfilClick(ActionEvent event) {

    }

    @FXML
    void onUsuarioClick(ActionEvent event) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("../views/JanelaUsuario.fxml"));
        borderPane.setCenter(root);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
