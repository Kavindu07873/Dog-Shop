package Controller.ProductController;

import Model.Customer;
import Model.medicine;
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

public class medicineController {

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
    public TableView<medicine> tblmedicine;


    public void initialize(){
        // colName.setCellValueFactory(new PropertyValueFactory("CusName"));
            colId.setCellValueFactory(new PropertyValueFactory("Product_id"));
        colName.setCellValueFactory(new PropertyValueFactory("Product_name"));
        colDescription.setCellValueFactory(new PropertyValueFactory("Description"));
        colqty.setCellValueFactory(new PropertyValueFactory("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("Price"));


        try {
            LoadAllMedicine();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private  void  LoadAllMedicine() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM medicine");
        ObservableList<medicine> obList = FXCollections.observableArrayList();
        while (result.next()){
            obList.add(
                    new medicine(
                    result.getString("Product_id"),
                    result.getString("Product_name"),
                    result.getString("Description"),
                    result.getInt("qty"),
                    result.getDouble("Price")
                    )
                    );
        }
        tblmedicine.setItems(obList);

    }
    public void btnOnActionhSearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Search();
    }

    public void btnOnActionDelete(ActionEvent actionEvent) {
        try {
            if(  CrudUtil.execute("DELETE FROM medicine WHERE Product_id = ?",txtid.getText())){
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted!..").show();

            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again!").show();

            }
        }catch (SQLException | ClassNotFoundException e){

        }
    }

    public void btnOnActionUpdate(ActionEvent actionEvent)throws SQLException,ClassNotFoundException {
        medicine M = new medicine(
        txtid.getText(),txtName.getText(),txtDescription.getText(),
                Integer.parseInt(txtqty.getText()),Double.parseDouble(txtPrice.getText())
                    );
        try {
            boolean isupdated = CrudUtil.execute
     ("UPDATE medicine SET Product_name = ?,Description = ?,qty =?,Price=? WHERE Product_id = ?"
                            ,M.getProduct_name(),M.getDescription(),M.getQty(),M.getPrice(),M.getProduct_id());
            if (isupdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {

        }
    }

    public void btnOnActionSave(ActionEvent actionEvent) {
            medicine m = new medicine(
              txtid.getText(),txtName.getText(),txtDescription.getText(),Integer.parseInt(txtqty.getText()),Double.parseDouble(txtPrice.getText())
            );
     //        if (CrudUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?)",C.getCusId(),C.getCusName()
        try {
            if (CrudUtil.execute("INSERT INTO medicine VALUES(?,?,?,?,?)",m.getProduct_id(),m.getProduct_name()
            ,m.getDescription(),m.getQty(),m.getPrice())) {
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new  Alert(Alert.AlertType.ERROR,e.getMessage()).show();

        }
    }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DashBoard.fxml"))));
        stage.show();
    }

    public void txtidSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Search();
    }

    private void Search() throws SQLException, ClassNotFoundException {
        try {
         ResultSet  result = CrudUtil.execute("SELECT * FROM medicine WHERE Product_id='"+txtid.getText()+"'");
         if(result.next()){
             txtName.setText(result.getString(2));
            txtDescription.setText(result.getString(3));
         txtqty.setText(result.getString(4));
         txtPrice.setText(result.getString(5));

         }else {
             new Alert(Alert.AlertType.WARNING, "Empty Result").show();

         }
        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
}
}
