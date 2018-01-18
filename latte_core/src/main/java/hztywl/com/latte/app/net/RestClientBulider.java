package hztywl.com.latte.app.net;

import java.util.Map;
import java.util.WeakHashMap;

import hztywl.com.latte.app.net.callback.IError;
import hztywl.com.latte.app.net.callback.IFailure;
import hztywl.com.latte.app.net.callback.IRequest;
import hztywl.com.latte.app.net.callback.ISuccess;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ${梅鹏} on 2018/1/18.
 *
 * @author meipeng
 */

public class RestClientBulider {

    private String mUrL;

    private static final Map<String, Object> mParams = RestCreator.getParams();

    private IRequest mIRequest;

    private ISuccess mISuccess;

    private IError mIError;

    private IFailure mIFailure;

    private RequestBody mBody;

    public RestClientBulider() {

    }

    public final RestClientBulider url(String url) {
        this.mUrL = url;
        return this;
    }


    public final RestClientBulider params(WeakHashMap<String, Object> params) {
        mParams.putAll(params);
        return this;
    }

    public final RestClientBulider params(String key, Object values) {

        mParams.put(key, values);
        return this;
    }

    public final RestClientBulider raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBulider onRequst(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }


    public final RestClientBulider success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBulider failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBulider error(IError iError) {
        this.mIError = iError;
        return this;
    }

    private Map<String, Object> checkParams() {
        if (mParams == null) {
            return new WeakHashMap<>();
        }
        return mParams;
    }

    public final RestClient build() {
        return new RestClient(mUrL, mParams, mIRequest, mISuccess, mIError, mBody);
    }
}
