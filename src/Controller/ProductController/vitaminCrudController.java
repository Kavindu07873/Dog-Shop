package Controller.ProductController;

import Model.shampoo_odours;
import Model.vitamins_supliment;
import Utill.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class vitaminCrudController {
    public  static ArrayList<String> getVitaminIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT Product_id FROM vitamins_supliment");
        ArrayList<String> ids = new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));
        }
        return ids;
    }
    public static vitamins_supliment getVitaminDetails(String Product_id) throws SQLException,ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM vitamins_supliment WHERE Product_id=?",Product_id);
        if(result.next()){
            return new vitamins_supliment(
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
