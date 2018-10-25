package FastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author xiaobin
 * @Since 04-24
 */
public class FASTJSONDeserializer {

    public static String jsonContent = "{\"30\":{\"20280949\":{\"take_time\":2029,\"uid\":650},\"22447168\":{\"take_time\":154,\"uid\":433}},\"40\":{\"9806592\":{\"take_time\":182,\"uid\":550},\"9833148\":{\"take_time\":185,\"uid\":550}},\"90\":{\"21372952\":{\"take_time\":609,\"uid\":650},\"21836663\":{\"take_time\":1438,\"uid\":475}}}";

    public static void main(String[] args) {

        JSONObject jb0 = JSON.parseObject(jsonContent);

        List<ArchiveOperDurationPO> pos = Lists.newArrayList();

        for (String s : jb0.keySet()) {
            Integer round = Integer.valueOf(s);
            ArchiveOperDurationPO po = ArchiveOperDurationPO.builder().round(round).build();
            String avContent = jb0.getString(s);
            JSONObject jb1 = JSON.parseObject(avContent);
            List<AvInfo> avInfos = Lists.newArrayList();
            for (String s1 : jb1.keySet()) {
                Long avid = Long.valueOf(s1);
                String string = jb1.getString(s1);
                AvInfo avInfo = JSON.parseObject(string, AvInfo.class);
                avInfo.setAvID(avid);
                avInfos.add(avInfo);
            }
            po.setAvInfos(avInfos);
            pos.add(po);
        }
    }
}
