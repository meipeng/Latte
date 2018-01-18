package hztywl.com.festec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import hztywl.com.latte.app.delegates.LattesDelegate;
import hztywl.com.latte.app.net.RestClient;
import hztywl.com.latte.app.net.callback.IError;
import hztywl.com.latte.app.net.callback.IFailure;
import hztywl.com.latte.app.net.callback.ISuccess;

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

    private void testRestClient() {
        RestClient.bulider()
                .url("")
                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String success) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                }).error(new IError() {
            @Override
            public void onError(int code, String msg) {

            }
        });

    }

}
