package com.youdu.wangjiuwangto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.youdu.latte.delegates.LatteDelegate;

/**
 * Created by 胡炼炼 on 2017/9/6.
 * 功能：
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
    private void testRestClient(){

    }
}
