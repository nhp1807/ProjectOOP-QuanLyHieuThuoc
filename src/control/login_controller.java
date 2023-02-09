package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.database;
import javafx.stage.StageStyle;
public class login_controller {

    @FXML
    private Button close_btn;

    @FXML
    private Button minus_btn;

    @FXML
    private PasswordField password_txt;

    @FXML
    private Button signin_btn;

    @FXML
    private TextField username_txt;

    @FXML
    private AnchorPane signin_form;

    //Database tool
    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;

    private double x = 0;
    private double y = 0;

    @FXML
    void close_form(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void minus_form(ActionEvent event) {
        Stage stage = (Stage) signin_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void signin() {
        String sql = "SELECT * FROM account WHERE username = ? and password = ?";
        connection = database.getConnection("jdbc:mysql://localhost:3306/database_pharmacy", "root", "");

        try {
            Alert alert;

            prepare = connection.prepareStatement(sql);
            prepare.setString(1, username_txt.getText());
            prepare.setString(2, password_txt.getText());

            result = prepare.executeQuery();

            //Check if textfields are empty
            if (username_txt.getText().isEmpty() || password_txt.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    //Go to dashboard
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Sign in!");
                    alert.showAndWait();

                    //Hide sign form
                    signin_btn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();
                }else{
                    //Username or password is wrong
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR MESSAGE");
                    alert.setHeaderText(null);
                    alert.setContentText("Username or password is wrong!");
                    alert.showAndWait();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
