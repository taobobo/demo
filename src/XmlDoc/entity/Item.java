package XmlDoc.entity;
import java.util.Date;

public class Item {
    private Date datetime;
    private String remark;
    private String zone;
    public Item(){}
    public Item(Date datetime, String remark, String zone) {
        this.datetime = datetime;
        this.remark = remark;
        this.zone = zone;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Item{" +
                "datetime=" + datetime +
                ", remark='" + remark + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}
