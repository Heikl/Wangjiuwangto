package com.youdu.wangjiuwangto;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.youdu.latte.app.Latte;
import com.youdu.latte.ec.icon.FontEcModule;

/**
 * Created by 胡炼炼 on 2017/9/5.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")//回环
                .configure();
    }
}
