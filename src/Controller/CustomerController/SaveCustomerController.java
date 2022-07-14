package Controller.CustomerController;

import Model.Customer;
import Utill.CrudUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SaveCustomerController {
    public TextField txtCusid;
    public TextField txtName;
    public TextField txtConNo;
    public TextField txtAddress;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Customer C = new Customer(
                txtCusid.getText(), txtName.getText(),
                txtConNo.getText(),txtAddress.getText()
        );
        try {
            if (CrudUtil.execute("INSERT INTO Customer VALUES(?,?,?,?)",
                    C.getCusName(),C.getCusId(),C.getCusNo(),C.getAddress())){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new  Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }




    }
}
