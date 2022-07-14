package Controller.ProductController;

import Model.food;
import Model.shampoo_odours;
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

public class shampoo_odoursControllers {
    public JFXTextField txtid;
    public JFXTextField txtName;
    public JFXTextField txtDescription;
    public JFXTextField txtqty;
    public JFXTextField txtPrice;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colDescription;
    public TableColumn colqty;
    public TableColumn colPrice;
    public TableView tblShampoo;


    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory("Product_id"));
        colName.setCellValueFactory(new PropertyValueFactory("Product_name"));
        colDescription.setCellValueFactory(new PropertyValueFactory("Description"));
        colqty.setCellValueFactory(new PropertyValueFactory("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("Price"));

        try {
            LoadAllShampoo();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void LoadAllShampoo() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM shampoo_odours");
        ObservableList<shampoo_odours> obList  = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new shampoo_odours(
                            result.getString("Product_id"),
                            result.getString("Product_name"),
                            result.getString("Description"),
                            result.getInt("qty"),
                            result.getDouble("Price")


                            )
            );

        }
        tblShampoo.setItems(obList);
    }
    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DashBoard.fxml"))));
        stage.show();    }

    public void btnOnActionSave(ActionEvent actionEvent) {

        shampoo_odours S = new shampoo_odours(
                txtid.getText(),txtName.getText(),txtDescription.getText(),
                Integer.parseInt(txtqty.getText()),Double.parseDouble(txtPrice.getText())
        );

        try {
            if(CrudUtil.execute("INSERT INTO shampoo_odours VALUES(?,?,?,?,?)",
                    S.getProduct_id(),S.getProduct_name(),S.getDescription(),
                    S.getQty(),S.getPrice()
                    )){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }

    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
        shampoo_odours F = new shampoo_odours(
                txtid.getText(),txtName.getText(),txtDescription.getText(),
                Integer.parseInt(txtqty.getText()),Double.parseDouble(txtPrice.getText())
        );
        try {
            boolean  isUpdated = CrudUtil.execute
                    ("UPDATE shampoo_odours SET Product_name=?,Description=?,qty=?,Price=? WHERE  Product_id=?"
                            ,F.getProduct_name(), F.getDescription(), F.getQty(), F.getPrice(),F.getProduct_id());
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
//Product_name   Description  qty  Price  Product_id
        tblShampoo.refresh();
    }

    public void btnOnActionDelete(ActionEvent actionEvent) {
        try {
            if(CrudUtil.execute("DELETE FROM shampoo_odours WHERE Product_id=?",txtid.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();

            }
        } catch (SQLException | ClassNotFoundException e) {
        }

    }

    public void btnOnActionhSearch(ActionEvent actionEvent) {
        try {
            Search();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void txtidSearchOnAction(ActionEvent actionEvent) {
        try {
            Search();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public  void Search() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM shampoo_odours WHERE Product_id =?", txtid.getText());
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
