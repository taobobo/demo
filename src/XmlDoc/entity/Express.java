package XmlDoc.entity;

import java.util.List;

public class Express {
    private long expreNo;
    private String company;
    private String com;
    private int resultCode;
    private String reason;
    private List<Item> itemList;

    public Express(){}
    public Express(long expreNo, String company, String com, int resultCode, String reason, List<Item> itemList) {
        this.expreNo = expreNo;
        this.company = company;
        this.com = com;
        this.resultCode = resultCode;
        this.reason = reason;
        this.itemList = itemList;
    }

    public long getExpreNo() {
        return expreNo;
    }

    public void setExpreNo(long expreNo) {
        this.expreNo = expreNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Express{" +
                "expreNo=" + expreNo +
                ", company='" + company + '\'' +
                ", com='" + com + '\'' +
                ", resultCode=" + resultCode +
                ", reason='" + reason + '\'' +
                ", itemList=" + itemList +
                '}';
    }
}
