package com.youdu.latte.net.callback;

import android.os.Handler;

import com.youdu.latte.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.youdu.latte.ui.LatteLoader.stopLoading;

/**
 * Created by 胡炼炼 on 2017/9/7.
 * 功能：
 */

@SuppressWarnings("unused")
public class RequestCallback implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYPE;
    //handler声明时用final 避免内存泄漏
    private static final Handler HANDLER=new Handler();

    public RequestCallback(
            IRequest request,
            ISuccess success,
            IFailure failure,
            IError error,
            LoaderStyle loaderStyle
            ) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADER_STYPE=loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()){
            if(call.isExecuted()){
                if(SUCCESS!=null){
                    SUCCESS.onSuccess(response.body());
                }
            }
        }else{
            if(ERROR!=null){
                ERROR.onError(response.code(),response.message());
            }
        }
            stopLoading();

        }
    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if(FAILURE!=null){
            FAILURE.onFailure();
        }
        if(REQUEST!=null){
            REQUEST.onRequestEnd();
        }
        stopLoading();
    }
    private void shtopLoading(){
            //网络加载是 加载图标的延迟时间
            if(LOADER_STYPE !=null){
                HANDLER.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stopLoading();
                    }
                },3000);
        }
    }
}
