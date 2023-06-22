/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cesgranrio.lp5.sisacademico.controllers;

import cesgranrio.lp5.sisacademico.models.Perfil;
import cesgranrio.lp5.sisacademico.models.Usuario;
import cesgranrio.lp5.sisacademico.services.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author rogerps
 */
public class JanelaUsuarioController implements Initializable {

    private UsuarioService usuarioService = new UsuarioService();
    private PerfilService perfilService = new PerfilService();

    @FXML
    private CheckBox ativoCheck;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idField;

    @FXML
    private TextField loginField;

    @FXML
    private ComboBox<Perfil> perfilCombo;

    @FXML
    private PasswordField senhaField;

    @FXML
    private ListView<Usuario> usuariosList;

    @FXML
    void onAdicionarUsuario(ActionEvent event) {
        try {
            validar();

            Usuario usuario = new Usuario();
            usuario.setLogin(loginField.getText());
            usuario.setSenha(senhaField.getText());
            usuario.setEmail(emailField.getText());
            usuario.setAtivo(ativoCheck.isSelected() ? 1 : 0);
            usuario.setPerfil(perfilCombo.getSelectionModel().getSelectedItem());

            usuarioService.adicionaUsuario(usuario);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Usuário cadastrado");

            alert.showAndWait();

            limpar();

        } catch (IllegalStateException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Dados incompletos");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    @FXML
    void onAlterarUsuario(ActionEvent event) {
        try {
            if (idField.getText().length() == 0) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Atenção");
                alert.setHeaderText(null);
                alert.setContentText("Selecione um usuário na lista");

                alert.showAndWait();

                return;
            }

            validar();

            Usuario usuario = usuariosList.getSelectionModel().getSelectedItem();
            usuario.setLogin(loginField.getText());
            usuario.setSenha(senhaField.getText());
            usuario.setEmail(emailField.getText());
            usuario.setAtivo(ativoCheck.isSelected() ? 1 : 0);
            usuario.setPerfil(perfilCombo.getSelectionModel().getSelectedItem());

            usuarioService.atualizaUsuario(usuario);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Usuário atualizado");

            alert.showAndWait();

            limpar();

        } catch (IllegalStateException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Dados incompletos");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    @FXML
    void onRemoverUsuario(ActionEvent event) {
        try {
            if (idField.getText().length() == 0) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Atenção");
                alert.setHeaderText(null);
                alert.setContentText("Selecione um usuário na lista");

                alert.showAndWait();

                return;
            }

            validar();

            Usuario usuario = usuariosList.getSelectionModel().getSelectedItem();
            usuario.setLogin(loginField.getText());
            usuario.setSenha(senhaField.getText());
            usuario.setEmail(emailField.getText());
            usuario.setAtivo(ativoCheck.isSelected() ? 1 : 0);
            usuario.setPerfil(perfilCombo.getSelectionModel().getSelectedItem());

            usuarioService.removeUsuario(usuario);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Usuário removido");

            alert.showAndWait();

            limpar();

        } catch (IllegalStateException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Dados incompletos");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    private void validar() {
        String mensagem = "";
        if (loginField.getText().length() == 0) {
            mensagem += "Login não informado\n";
        }
        if (senhaField.getText().length() == 0) {
            mensagem += "Senha não informada\n";
        }
        if (emailField.getText().length() == 0) {
            mensagem += "Email não informado\n";
        }
        if (perfilCombo.getSelectionModel().getSelectedItem() == null) {
            mensagem += "Perfil não informado\n";
        }

        if (mensagem.length() != 0) {
            throw new IllegalStateException(mensagem);
        }
    }

    private void limpar() {
        idField.setText("");
        loginField.setText("");
        senhaField.setText("");
        emailField.setText("");
        ativoCheck.setSelected(true);
        perfilCombo.getSelectionModel().clearSelection();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        usuariosList.setItems(usuarioService.getUsuarios());
        usuariosList.setCellFactory(u -> new ListCell<Usuario>() {
            @Override
            protected void updateItem(Usuario item, boolean empty) {
                super.updateItem(item, empty);
                setText(item == null ? "" : item.getLogin() + " (" + item.getPerfil().getNome() + ")");
            }
        });
        usuariosList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostraUsuario(newValue)
        );
        usuariosList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        perfilCombo.setItems(perfilService.getPerfis());
        perfilCombo.setConverter(new StringConverter<Perfil>() {
            @Override
            public String toString(Perfil perfil) {
                return perfil == null ? null : perfil.getNome();
            }

            @Override
            public Perfil fromString(String string) {
                return null;
            }
        });
    }

    private void mostraUsuario(Usuario usuario) {
        if (usuario != null) {
            idField.setText(Integer.toString(usuario.getIdUsuario()));
            loginField.setText(usuario.getLogin());
            senhaField.setText(usuario.getSenha());
            emailField.setText(usuario.getEmail());
            ativoCheck.setSelected(usuario.getAtivo() == 1);
            perfilCombo.getSelectionModel().select(usuario.getPerfil());
        }
    }
}
