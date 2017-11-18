package FastJson;

import lombok.Data;

import java.util.List;

/**
 * @author Silver & Bullet
 *         Created on 九月 23
 */
@Data
public class WeiCheCarResult extends WeiCheFailResult{
    private String vehicle_status;//车辆状态信息

    private List<WcCar> violations;//违章具体信息



    //车辆违章信息
    @Data
    public static class WcCar{
        private String time;//违章时间

        private String address;//违章地点

        private int fine;//罚款

        private int point;//扣分

        private boolean handled;//是否已处理

        private String agency;//采集机关

        private String violation_type;//违章行为

    }



}
