package com.youdu.wangjiuwangto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.youdu.latte.delegates.LatteDelegate;
import com.youdu.latte.net.RestClient;
import com.youdu.latte.net.callback.IError;
import com.youdu.latte.net.callback.IFailure;
import com.youdu.latte.net.callback.ISuccess;

/**
 * Created by 胡炼炼 on 2017/9/6.
 * 功能：
 */

@SuppressWarnings("unused")
public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
            testRestClient();
    }
    private void testRestClient(){
        RestClient.builder()
                .url("http://news.baidu.com")
               // .params("","")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
