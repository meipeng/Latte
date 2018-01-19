package hztywl.com.latte.app.net.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ${梅鹏} on 2018/1/19.
 *
 * @author meipeng
 */

public class RequestCallback implements Callback<String> {

    private final IRequest REQUEST;

    private final ISuccess SUCCESS;

    private final IFailure FAILURE;

    private final IError ERROR;

    public RequestCallback(IRequest request, ISuccess success, IFailure failure, IError error) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body().toString());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST!=null){
            REQUEST.onRequsetEnd();
        }
    }
}
