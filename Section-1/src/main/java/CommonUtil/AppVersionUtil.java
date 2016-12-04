package CommonUtil;

import org.apache.commons.lang3.StringUtils;

public class AppVersionUtil {

    public static final String VERSION_SPLIT = "\\.";

    /**
     * 大于某个版本
     * @param currentVersion
     * @param targetVersion
     * @return
     */
    public static boolean isGreaterVersion(String currentVersion, String targetVersion){
        if(StringUtils.isBlank(currentVersion) || StringUtils.isBlank(targetVersion)){
            return false;
        }
        String[] currentStr = currentVersion.split(VERSION_SPLIT);
        String[] targetStr = targetVersion.split(VERSION_SPLIT);
        if(currentStr == null
                || targetStr == null
                || currentStr.length <= 0
                || currentStr.length != targetStr.length){
            return false;
        }
        int cv =getNumberVersion(currentVersion);
        int tv = getNumberVersion(targetVersion);

        if(cv > tv) {
            return true;
        }

        return false;
    }

    public static boolean isGreaterOrEqualVersion(String currentVersion, String targetVersion){
        if(StringUtils.isBlank(currentVersion) || StringUtils.isBlank(targetVersion)){
            return false;
        }
        String[] currentStr = currentVersion.split(VERSION_SPLIT);
        String[] targetStr = targetVersion.split(VERSION_SPLIT);
        if(currentStr == null
                || targetStr == null
                || currentStr.length <= 0
                || currentStr.length != targetStr.length){
            return false;
        }
        int cv =getNumberVersion(currentVersion);
        int tv = getNumberVersion(targetVersion);

        if(cv >= tv) {
            return true;
        }

        return false;
    }

    public static int getNumberVersion(String version) {
        if(StringUtils.isBlank(version)) {
            return 0;
        }
        String[] vs = version.split(VERSION_SPLIT);
        StringBuilder sb = new StringBuilder();
        for(String v : vs) {
            int vv = Integer.parseInt(v);
            if(vv < 10) {
                sb.append("0").append(v);
            } else {
                sb.append(v);
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
