package Controller.ProductController;

import Model.medicine;
import Utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class medicineCrudController {
    public static ArrayList<String> getMedicineIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT Product_id FROM Medicine");
    ArrayList<String> ids = new ArrayList<>();
    while (result.next()){
        ids.add(result.getString(1));
    }
    return ids;
    }
    public static medicine getMedicineDetails(String Product_id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Medicine WHERE Product_id=?",Product_id);
        if(result.next()){
            return new medicine(
              result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getDouble(5)
                    );
        }
        return null;
    }
}
