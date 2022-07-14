package Controller.SuplliersControllers;

import Model.Customer;
import Model.Suplliers;
import Utill.CrudUtil;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Supplier;

public class loadAllSuplliersController {

    public TableView<Suplliers> tblCustomer;
    public TableColumn colName;
    public TableColumn colId;
    public TableColumn colCotNo;
    public TableColumn colAddress;
    public TableView tblSupllier;
    public JFXTextField txtSupNo;
    public JFXTextField txtSupName;
    public JFXTextField txtSupAdress;
    public JFXTextField txtSupllierId;

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory("Suplliers_id"));
        colName.setCellValueFactory(new PropertyValueFactory("Suplliers_Name"));
        colCotNo.setCellValueFactory(new PropertyValueFactory("Suplliers_CotNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory("Address"));


        try {
            loadAllSupllier();
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }

    private void loadAllSupllier() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM suplliers");
        ObservableList<Suplliers> obList = FXCollections.observableArrayList();
        while (result.next()){
            obList.add(
                    new Suplliers(
                            result.getString("id"),
                            result.getString("name"),
                            result.getString("ConNO"),
                            result.getString("address")

                            )
            );
        }
        tblSupllier.setItems(obList);

    }

    public void btnOnActionDelete(ActionEvent actionEvent) {

        try {
            if(  CrudUtil.execute("DELETE FROM suplliers WHERE id = ?",txtSupllierId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted!..").show();

            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again!").show();

            }
        }catch (SQLException | ClassNotFoundException e){

        }
    }

    public void btnOnActionUpdate(ActionEvent actionEvent)throws ClassNotFoundException,SQLException {

        Suplliers S = new Suplliers(
                txtSupName.getText(),txtSupllierId.getText(),
                txtSupNo.getText(),txtSupAdress.getText()
        );
        try {
          boolean isupdated = CrudUtil.execute("UPDATE suplliers SET name=?,address=?,ConNO=? WHERE id=?",
          S.getSuplliers_Name(),S.getAddress(),S.getSuplliers_CotNo(),S.getSuplliers_id());
          if (isupdated){
              new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();

          }else {
              new Alert(Alert.AlertType.WARNING, "Try Again!").show();
          }
        }catch (SQLException|ClassNotFoundException e){

        }
    }

    public void btnOnActionSave(ActionEvent actionEvent)throws IOException {
            Suplliers S = new Suplliers(
              txtSupllierId.getText(),txtSupName.getText(),txtSupNo.getText(),
              txtSupAdress.getText()
            );
         try {
             if(CrudUtil.execute("INSERT INTO suplliers VALUES(?,?,?,?)",
                     S.getSuplliers_id(),S.getSuplliers_Name(),S.getSuplliers_CotNo(),
                     S.getAddress()
                     )){
                 new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();

             }
         }catch (ClassNotFoundException|SQLException e){
             e.printStackTrace();
         }
        }

    public void btnOnActionRefresh(ActionEvent actionEvent) {
    }

    public void txtIdSearchOnAction(ActionEvent actionEvent) {
    Search();
    }

    public void btnOnActionSearch(ActionEvent actionEvent) {
    Search();
    }

    private void Search() {
        try {
    ResultSet result = CrudUtil.execute("SELECT * FROM suplliers WHERE id ='"+txtSupllierId.getText()+"'");
    if(result.next()){
        txtSupName.setText(result.getString(2));
        txtSupNo.setText(result.getString(3));
        txtSupAdress.setText(result.getString(4));

    } else {
        new Alert(Alert.AlertType.WARNING, "Empty Result").show();

    }

        }catch (SQLException | ClassNotFoundException e){

        }
    }

}
