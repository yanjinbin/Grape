package CommonUtil;

import java.io.UnsupportedEncodingException;

/**
 * Created by luobin.lzb on 15-5-27.
 */
public final class Constants {


    /**
     * token管理前缀
     **/
    public static final String TOKEN_PREFIX = "TOKEN#";

    public static class TimePeriod {

        public static final int ONE_YEAY = 365 * 24 * 60 * 60;
        public static final int ONE_YEAR = 365 * 24 * 60 * 60;
        public static final int ONE_MONTH = 30 * 24 * 60 * 60;
        public static final int ONE_DAY = 24 * 60 * 60;

        public static final int ONE_HOUR = 60 * 60;
    }


    public static class Symbol {
        public static final String SEMICOLON = ";";

        public static final String COMMA = ",";

        public static final String COLON = ":";
    }

    public static class Encode {
        public static final String UTF8 = "UTF-8";

        public static final String GBK = "GBK";

        public static final String GB2312 = "GB2312";
    }

    public static class TimeFormat {
        public static final String slackSeparate = "yyyy/MM/dd HH:mm:ss";

        public static final String hyphenSeparate = "yyyy-MM-dd HH:mm:ss";

        public static final String hyphenSeparateDayEnd = "yyyy-MM-dd";

        public static final String DAYEND = "yyyyMMdd";

        public static final String MONTHEND = "yyyyMM";

        public static final String YEAREND = "yyyy";

        public static final int[] M_31 = {1, 3, 5, 7, 8, 10, 12};

        public static final int[] M_30 = {4, 6, 9, 11};

        public static final int M_28 = 2;

    }


    public static byte[] createKey(String prefix, Object val, String charset) throws UnsupportedEncodingException {
        byte[] key = createKey(prefix, val).getBytes(charset);
        return key;
    }

    public static byte[] createKeyV2(String prefix, Object val, String charset, String type) throws UnsupportedEncodingException {
        byte[] key = createKeyV2(prefix, val, type).getBytes(charset);
        return key;
    }

    public static String createKeyV2(String prefix, Object val, String type) {
        String key = new StringBuilder(prefix).append((val + type).toString()).toString();
        return key;
    }

    public static String createKey(String prefix, Object val) {
        String key = new StringBuilder(prefix).append(val.toString()).toString();
        return key;
    }


}
