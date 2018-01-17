package hztywl.com.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by ${梅鹏} on 2018/1/17.
 */

public final class Latte {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICTION_COTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplicationContext() {
        //通过键值对获取的是上面（init 传过来的context）
        return (Context) getConfigurations().get(ConfigType.APPLICTION_COTEXT.name());
    }
}
