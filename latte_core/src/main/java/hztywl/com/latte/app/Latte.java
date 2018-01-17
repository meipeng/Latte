package hztywl.com.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by ${梅鹏} on 2018/1/17.
 */

public final class Latte {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICTION_COTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
}
