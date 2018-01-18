package hztywl.com.latte.app.net;

import hztywl.com.latte.app.ConfigType;
import hztywl.com.latte.app.Latte;

/**
 * Created by ${梅鹏} on 2018/1/18.
 *
 * @author meipeng
 */

public class RestCreator {

    private static final class ReatHolder {
        private static final String BASE_URL = (String) Latte.getConfigurations().get(ConfigType.API_HOST.name());
    }
}
