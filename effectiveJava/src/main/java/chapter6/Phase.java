package chapter6;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * P142  主要是实现了  归类元素  比如 按不同动物（鸭 ，鹅， 猪） 分成三类 ，收集三类元素的对象集合
 *
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public enum  Phase {
    SOLID,LIQUID,GAS;

    public enum  Transaction{

        MELT(SOLID,LIQUID),FREEZE(LIQUID,SOLID),
        BOIL(LIQUID,GAS),CONDENSE(GAS,LIQUID),
        SUBLIME(SOLID,GAS),DEPOSIT(GAS,SOLID);

        private static final Map<Phase,Map<Phase,Transaction>> m = new EnumMap<Phase, Map<Phase, Transaction>>(Phase.class);


        static {
            for (Phase phase :
                    Phase.values()) {
                m.put(phase, new EnumMap<Phase, Transaction>(Phase.class));
            }
            for (Transaction transaction:Transaction.values()){
                m.get(transaction.src).put(transaction.des,transaction);
            }

        }


        private final Phase src;
        private final  Phase des;
        Transaction(Phase src, Phase des) {
            this.src = src;
            this.des = des;
        }

        public static Transaction from(Phase src,Phase des){
            return m.get(src).get(des);
        }
    }


}
