package hztywl.com.festec;

import android.app.Application;

import hztywl.com.latte.app.Latte;

/**
 * Created by ${梅鹏} on 2018/1/17.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("")
                .configure();

    }
}
