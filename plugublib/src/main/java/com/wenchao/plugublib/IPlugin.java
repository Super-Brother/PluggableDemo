package com.wenchao.plugublib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author wenchao
 * @date 2019/7/6.
 * @time 17:59
 * description：
 */
public interface IPlugin {

    int FROM_INTERNAL = 0; //内部跳转
    int FROM_EXTERNAL = 1; //外部跳转

    void attach(Activity proxyActivity);

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onRestart();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();
}
