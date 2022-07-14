package Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashBoardController {
    public Label time;
    public ComboBox<String> cmbProduct;
    public Label lblTime;
    public Label lblDate;
    public Label dateAndTime;
    public JFXComboBox cmbProduct2;
    public ComboBox cmbProduct3;

    public void initialize() throws IOException {
        time();
    ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("");

        obList.add("Medicine");
    obList.add("Food");
        obList.add("shampoo_odours");
        obList.add("toys");
        obList.add("vitamins_supliment");

        cmbProduct3.setItems(obList);
        cmbProduct3.getSelectionModel().select(0);
    }


    public void time() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd \n   HH:mm:ss");

            dateAndTime.setText(LocalDateTime.now().format(formatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    public void btnOnActionProduct(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../ProductView/LoadAllProductForm.fxml");

        Parent load= FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void btnOnActionSuppliers(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../SuplliersView/LoadAllSuplliersForm.fxml");

        Parent load= FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }

    public void btnOnActionCustomer(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../CustomerView/LoadAllCustomerForm.fxml");

        Parent load= FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OnActionOpen3(ActionEvent actionEvent) throws IOException {

        if (cmbProduct3.getSelectionModel().getSelectedItem().equals("Food")) {

            URL resource = getClass().getResource("../ProductView/foodForm.fxml");

            Parent load= FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        if (cmbProduct3.getSelectionModel().getSelectedItem().equals("Medicine")){

            URL resource = getClass().getResource("../ProductView/medicineForm.fxml");

            Parent load= FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        if (cmbProduct3.getSelectionModel().getSelectedItem().equals("shampoo_odours")) {

            URL resource = getClass().getResource("../ProductView/shampoo_odoursForm.fxml");

            Parent load= FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        if (cmbProduct3.getSelectionModel().getSelectedItem().equals("toys")) {

            URL resource = getClass().getResource("../ProductView/toysForm.fxml");

            Parent load= FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        if (cmbProduct3.getSelectionModel().getSelectedItem().equals("vitamins_supliment")) {

            URL resource = getClass().getResource("../ProductView/vitamins_suplimentForm.fxml");

            Parent load= FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void placeOrderOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../View/PlaceOrderForm.fxml");

        Parent load= FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }


    public void onActionOpen2(ActionEvent actionEvent) {
    }

    public void btnOnActionorders(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../View/Orders.fxml");

        Parent load= FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}


