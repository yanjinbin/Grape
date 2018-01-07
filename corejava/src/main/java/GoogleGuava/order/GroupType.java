package GoogleGuava.order;

/**
 * Created by lifei on 17/2/15.
 */
public enum GroupType {
   DAY(1, "分天"), WEEK(2, "分周"), MONTH(3, "分月");

    private Integer code;

    private String desc;

    GroupType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }

    public final static GroupType getByCode(Integer code){
        for (GroupType groupType : GroupType.values()) {
            if (groupType.getCode().equals(code)) {
                return groupType;
            }
        }
        return null;
    }
}
