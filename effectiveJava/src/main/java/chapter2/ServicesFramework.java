package chapter2;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author Silver bullet
 * @Since 2017/6/23.
 */
public class ServicesFramework {

    private ServicesFramework(){}

    private final  static Map<String, ConnectionProvider> providers = Maps.newConcurrentMap();

    private final static String default_name = "mysql";

    public static void registerDefaultProvider(ConnectionProvider connectionProvider){
        registerProvider(default_name, connectionProvider);
    }

    private static void registerProvider(String defult_name, ConnectionProvider connectionProvider) {
        providers.put(defult_name, connectionProvider);
    }

    public static ConnectionService newInstance(){
        return newInstance(default_name);
    }

    private static ConnectionService newInstance(String defult_name) {
        ConnectionProvider connectionProvider = providers.get(defult_name);
        if (connectionProvider != null) {
            return connectionProvider.newService();
        }else {
            throw  new IllegalStateException("不存在");
        }


    }

}
