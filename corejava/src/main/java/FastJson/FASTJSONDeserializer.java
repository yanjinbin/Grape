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

        System.out.println(JSON.toJSONString(pos, true));






        /*JSONObject jb0 = JSON.parseObject(jsonContent);

        for (Object o : jb0.values()) {
            System.out.println(o);
            System.out.println("|||");
            JSONObject jb1 = JSON.parseObject(o.toString());
            for (Object o1 : jb1.values()) {
                System.out.println(o1);
            }
        }
        System.out.println("~~~~~~");

        for (String s : jb0.keySet()) {
            String s1 = jb0.getString(s);
            System.out.println(s1);
            JSONObject jb2 = JSON.parseObject(s1);
            System.out.println(jb2);
            for (String s2 : jb2.keySet()) {
                System.out.println(jb2.get(s2));
            }
        }


        System.out.println("============");

        ArchiveOperDurationPO po1 = new ArchiveOperDurationPO();
        po1.setRound(30);
        AvInfo av1 = AvInfo.builder().avID(111L).takeTime(19L).uid(11).build();
        AvInfo av2 = AvInfo.builder().avID(14L).takeTime(19L).uid(7).build();
        AvInfo av3 = AvInfo.builder().avID(22L).takeTime(33L).uid(2).build();
        po1.setAvInfos(Lists.newArrayList(av1, av2));


        ArchiveOperDurationPO po2 = new ArchiveOperDurationPO();
        po2.setRound(40);
        AvInfo av4 = AvInfo.builder().avID(333L).takeTime(20L).uid(3).build();
        AvInfo av5 = AvInfo.builder().avID(41L).takeTime(19L).uid(6).build();
        AvInfo av6 = AvInfo.builder().avID(92L).takeTime(55L).uid(3).build();
        po2.setAvInfos(Lists.newArrayList(av4, av5));


        List<ArchiveOperDurationPO> pos = Lists.newArrayList(po1, po2);

        System.out.println(JSON.toJSONString(pos,true));*/
    }
}
