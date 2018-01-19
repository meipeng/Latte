package hztywl.com.latte.app.net;

import java.util.Map;
import java.util.WeakHashMap;

import hztywl.com.latte.app.net.callback.IError;
import hztywl.com.latte.app.net.callback.IFailure;
import hztywl.com.latte.app.net.callback.IRequest;
import hztywl.com.latte.app.net.callback.ISuccess;
import hztywl.com.latte.app.net.callback.RequestCallback;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by ${梅鹏} on 2018/1/18.
 *
 * @author meipeng
 */

public class RestClient {

    private final String URL;

    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();

    private final IRequest REQUEST;

    private final ISuccess SUCCESS;

    private final IFailure FAILURE;

    private final IError ERROR;

    private final RequestBody BODY;

    public RestClient(String url, Map<String, Object> params, IRequest request, ISuccess success,
                      IError error, IFailure failure, RequestBody body) {
        this.URL = url;
        PARAMS.putAll(PARAMS);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.BODY = body;
    }

    public static RestClientBulider bulider() {

        return new RestClientBulider();
    }

    public void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequsetStart();
        }
        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallback(REQUEST, SUCCESS, FAILURE, ERROR);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }
}
