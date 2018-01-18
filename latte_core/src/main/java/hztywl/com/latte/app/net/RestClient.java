package hztywl.com.latte.app.net;

import java.util.Map;
import java.util.WeakHashMap;

import hztywl.com.latte.app.net.callback.IError;
import hztywl.com.latte.app.net.callback.IRequest;
import hztywl.com.latte.app.net.callback.ISuccess;
import okhttp3.RequestBody;

/**
 * Created by ${梅鹏} on 2018/1/18.
 *
 * @author meipeng
 */

public class RestClient {

    private final String URL;

    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();

    private final IRequest IREQUEST;

    private final ISuccess SUCCESS;

    private final IError ERROR;

    private final RequestBody BODY;

    public RestClient(String url, Map<String, Object> params, IRequest request, ISuccess success,
                      IError error, RequestBody body) {
        this.URL = url;
        PARAMS.putAll(PARAMS);
        this.IREQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.BODY = body;
    }

    public static RestClientBulider bulider() {

        return new RestClientBulider();
    }
}
