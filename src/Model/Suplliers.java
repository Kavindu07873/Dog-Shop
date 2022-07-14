package Model;

public class Suplliers {

     private String Suplliers_id;
     private String Suplliers_Name;
     private String Suplliers_CotNo;
     private String Address;

     public Suplliers() {
     }

     public Suplliers(String suplliers_id, String suplliers_Name, String suplliers_CotNo, String address) {
          Suplliers_id = suplliers_id;
          Suplliers_Name = suplliers_Name;
          Suplliers_CotNo = suplliers_CotNo;
          Address = address;
     }

     public String getSuplliers_id() {
          return Suplliers_id;
     }

     public void setSuplliers_id(String suplliers_id) {
          Suplliers_id = suplliers_id;
     }

     public String getSuplliers_Name() {
          return Suplliers_Name;
     }

     public void setSuplliers_Name(String suplliers_Name) {
          Suplliers_Name = suplliers_Name;
     }

     public String getSuplliers_CotNo() {
          return Suplliers_CotNo;
     }

     public void setSuplliers_CotNo(String suplliers_CotNo) {
          Suplliers_CotNo = suplliers_CotNo;
     }

     public String getAddress() {
          return Address;
     }

     public void setAddress(String address) {
          Address = address;
     }

     @Override
     public String toString() {
          return "Suplliers{" +
                  "Suplliers_id='" + Suplliers_id + '\'' +
                  ", Suplliers_Name='" + Suplliers_Name + '\'' +
                  ", Suplliers_CotNo='" + Suplliers_CotNo + '\'' +
                  ", Address='" + Address + '\'' +
                  '}';
     }
}
