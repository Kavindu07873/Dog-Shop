package Controller.CustomerController;

import Model.Customer;
import Utill.CrudUtil;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class LoadAllCustomerFormController {
    public TableView<Customer> tblCustomer;
    public TableColumn colAddress;
    public TableColumn colCotNo;
    public JFXTextField txtCusId;
    public JFXTextField txtConNo;
    public JFXTextField txtCusName;
    public JFXTextField txtAddress;
    public TableColumn colname;
    public TableColumn colid;

    public  void  initialize(){
        colid.setCellValueFactory(new PropertyValueFactory("CusId"));
        colname.setCellValueFactory(new PropertyValueFactory("CusName"));
        colCotNo.setCellValueFactory(new PropertyValueFactory("CusNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory("Address"));

        try {
            loadAllCustomer();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
    private void loadAllCustomer() throws SQLException, ClassNotFoundException {
ResultSet result = CrudUtil.execute("SELECT * FROM Customer");
   ObservableList<Customer> obList = FXCollections.observableArrayList();
   while (result.next()){
       obList.add(
               new Customer(
                       result.getString("name"),
                       result.getString("id"),
                       result.getString("ConNO"),
                       result.getString("address")

               )
       );
   }
   tblCustomer.setItems(obList);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void btnOnActionSave(ActionEvent actionEvent){

        Customer C = new Customer(
               txtCusName.getText(), txtCusId.getText(),
                txtConNo.getText(),txtAddress.getText()
        );
/*          //step 1 load Driver
           // Class.forName("com.mysql.cj.jdbc.Driver");
            //step 2 create a new connection
          // Connection con = DriverManager.getConnection
              //     ("jdbc:mysql://localhost:3306/dog_paradise","root","1234");


            //step 3 write sql query

            String sql = "INSERT INTO Customer VALUES (?,?,?,?)";

            //step 4 create statement

            PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(sql);
            // step 5  execute query
                stm.setObject(1,C.getCusId());
                stm.setObject(2,C.getCusName());
            stm.setObject(3,C.getCusNo());
            stm.setObject(4,C.getAddress());
*/
            try {
            if (CrudUtil.execute("INSERT INTO Customer VALUES(?,?,?,?)",
                C.getCusId(),C.getCusName(),C.getCusNo(),C.getAddress())){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new  Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void btnOnActionRefresh(ActionEvent actionEvent) throws IOException {
        tblCustomer.refresh();
        /*URL resource = getClass().getResource("../CustomerView/LoadAllCustomerForm.fxml");

        Parent load= FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        */
    }
//////////////////////////////////////////////////////////////////////////////////////////////
    public void btnOnActionDelete(ActionEvent actionEvent) {
           try {
                  if(  CrudUtil.execute("DELETE FROM Customer WHERE id = ?",txtCusId.getText())){
                      new Alert(Alert.AlertType.CONFIRMATION,"Deleted!..").show();

                  }else {
                      new Alert(Alert.AlertType.WARNING,"Try Again!").show();

                  }
           }catch (SQLException | ClassNotFoundException e){

           }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////

    public void btnOnActionUpdate(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        Customer C = new Customer(
                txtCusName.getText(), txtCusId.getText(), txtConNo.getText(), txtAddress.getText()
        );
        try {
            boolean isupdated = CrudUtil.execute
                    ("UPDATE Customer SET name=?,address=?,ConNO =? WHERE id = ?"
                    , C.getCusName(), C.getAddress(), C.getCusNo(), C.getCusId());
            if (isupdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {

        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          public void btnOnActionSearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
                  Search();

          }

          public void txtIdSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
                  Search();
          }

    private void  Search() throws ClassNotFoundException, SQLException{
               //step 1 load Driver
              try {
                  ResultSet result = CrudUtil.execute("SELECT * FROM Customer WHERE id ='"+txtCusId.getText()+"'");
                      if (result.next()){
                          txtCusName.setText(result.getString(2));
                          txtConNo.setText(result.getString(3));
                          txtAddress.setText(result.getString(4));

                      }else {
                          new Alert(Alert.AlertType.WARNING, "Empty Result").show();
                      }
          }catch (SQLException | ClassNotFoundException e){
              e.printStackTrace();
              }
          }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/DashBoard.fxml"))));
        stage.show();

    }
}

