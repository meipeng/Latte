package hztywl.com.festec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import hztywl.com.latte.app.delegates.LattesDelegate;

/**
 * Created by ${梅鹏} on 2018/1/18.
 */

public class ExampleDelegate extends LattesDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public Object onBindView(@Nullable Bundle savedInstanceState, View rootview) {
        return super.onBindView(savedInstanceState, rootview);
    }
}
