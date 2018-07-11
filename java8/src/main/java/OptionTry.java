import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * @author xiaobin
 * @Since 03-22
 */
public class OptionTry {
    public static void main(String[] args) {
        final List<String> list = Lists.newArrayList();
        System.out.println(list.isEmpty());
         Optional.ofNullable(list).filter(strings1 -> strings1.isEmpty()).ifPresent(strings -> System.out.println(strings.size()));
    }
}
