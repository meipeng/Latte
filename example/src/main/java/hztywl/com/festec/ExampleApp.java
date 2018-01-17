package hztywl.com.festec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import hztywl.com.latte.app.Latte;
import hztywl.com.latte.ec.icon.FontEcModule;

/**
 * Created by ${梅鹏} on 2018/1/17.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("")
                .configure();

    }
}
