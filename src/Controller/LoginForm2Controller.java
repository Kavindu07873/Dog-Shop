package Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginForm2Controller {
    public PasswordField txtPassword;
    public TextField txtUserName;
    public AnchorPane AnchorPaneLogIn;
    public Label lblTime;

    public  void initialize(){
        time();
    }

    public void time() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd    HH:mm:ss");

            lblTime.setText(LocalDateTime.now().format(formatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void btnOnActionLogIn(ActionEvent actionEvent) throws IOException {


        ParallelTransition anchormanLogin;
        AnchorPaneLogIn.getChildren().clear();
        String tempUser = txtUserName.getText();
        String tempPassword = txtPassword.getText();

         if(tempUser.equals("admin")&& tempPassword.equals("1234")) {

        URL resource = getClass().getResource("../View/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
         }
    }
}
