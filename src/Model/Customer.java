package Model;

public class Customer {
        private String CusName;
        private String CusId;
        private String CusNo;
        private String Address;

    public Customer() {
    }

    public Customer(String cusName, String cusId, String cusNo, String address) {
        CusName = cusName;
        CusId = cusId;
        CusNo = cusNo;
        Address = address;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String cusId) {
        CusId = cusId;
    }

    public String getCusNo() {
        return CusNo;
    }

    public void setCusNo(String cusNo) {
        CusNo = cusNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CusName='" + CusName + '\'' +
                ", CusId='" + CusId + '\'' +
                ", CusNo='" + CusNo + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
