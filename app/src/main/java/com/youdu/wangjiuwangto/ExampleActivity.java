package com.youdu.wangjiuwangto;

import com.youdu.latte.activities.ProxyActivity;
import com.youdu.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }

}
