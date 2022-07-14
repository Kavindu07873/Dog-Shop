package Controller.ProductController;

import Model.medicine;
import Model.shampoo_odours;
import Utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Shampoo_odoursCrudController {
    public  static ArrayList<String> getshampooIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT Product_id FROM shampoo_odours");
        ArrayList<String> ids = new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }
public static shampoo_odours getShampooDetails(String Product_id) throws SQLException,ClassNotFoundException {
    ResultSet result = CrudUtil.execute("SELECT * FROM shampoo_odours WHERE Product_id=?",Product_id);
    if(result.next()){
        return new shampoo_odours(
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
