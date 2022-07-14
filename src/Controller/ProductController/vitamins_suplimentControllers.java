package Controller.ProductController;

import Model.food;
import Model.toy;
import Model.vitamins_supliment;
import Utill.CrudUtil;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class vitamins_suplimentControllers {
    public JFXTextField txtid;
    public JFXTextField txtName;
    public JFXTextField txtDescription;
    public JFXTextField txtqty;
    public JFXTextField txtPrice;
    public TableView tblVitamin;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colDescription;
    public TableColumn colqty;
    public TableColumn colPrice;

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory("Product_id"));
        colName.setCellValueFactory(new PropertyValueFactory("Product_name"));
        colDescription.setCellValueFactory(new PropertyValueFactory("Description"));
        colqty.setCellValueFactory(new PropertyValueFactory("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("Price"));

        try {
            loadAllVitamins();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllVitamins() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM vitamins_supliment");
        ObservableList<vitamins_supliment> obList = FXCollections.observableArrayList();
        while (result.next()) {
            obList.add(
                    new vitamins_supliment(
                            result.getString("Product_id"),
                            result.getString("Product_name"),
                            result.getString("Description"),
                            result.getInt("qty"),
                            result.getDouble("Price")

                    )
            );
        }
        tblVitamin.setItems(obList);
    }


    public void txtidSearchOnAction(ActionEvent actionEvent) {
        try {
            Search();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnOnActionhSearch(ActionEvent actionEvent) {
        try {
            Search();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
        vitamins_supliment F = new vitamins_supliment(
                txtid.getText(),txtName.getText(),txtDescription.getText(),
                Integer.parseInt(txtqty.getText()),Double.parseDouble(txtPrice.getText())
        );
        try {
            boolean  isUpdated = CrudUtil.execute
                    ("UPDATE vitamins_supliment SET Product_name=?,Description=?,qty=?,Price=? WHERE  Product_id=?"
                            ,F.getProduct_name(), F.getDescription(), F.getQty(), F.getPrice(),F.getProduct_id());
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
//Product_name   Description  qty  Price  Product_id
        tblVitamin.refresh();
    }

    public void btnOnActionDelete(ActionEvent actionEvent) {
        try {
            if(CrudUtil.execute("DELETE FROM vitamins_supliment WHERE Product_id=?",txtid.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();

            }
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

    public void btnOnActionSave(ActionEvent actionEvent) {
        vitamins_supliment V = new vitamins_supliment(
                txtid.getText(),txtName.getText(),txtDescription.getText(),
                Integer.parseInt(txtqty.getText()),
                Double.parseDouble(txtPrice.getText())
        );
        try {
            if (CrudUtil.execute("INSERT INTO vitamins_supliment VALUES(?,?,?,?,?)", V.getProduct_id(),
                    V.getProduct_name(), V.getDescription(), V.getQty(), V.getPrice())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }
    }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DashBoard.fxml"))));
        stage.show();
    }
    public void Search() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM vitamins_supliment WHERE Product_id =?", txtid.getText());
        if (result.next()) {
            txtName.setText(result.getString(2));
            txtDescription.setText(result.getString(3));
            txtqty.setText(result.getString(4));
            txtPrice.setText(result.getString(5));

        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();

        }
    }
}
