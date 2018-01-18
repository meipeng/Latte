package hztywl.com.festec;

import hztywl.com.latte.app.activity.ProxyActivity;
import hztywl.com.latte.app.delegates.LattesDelegate;

/**
 * @author meipeng
 */
public class ExampleActivity extends ProxyActivity {

    @Override
    public LattesDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
