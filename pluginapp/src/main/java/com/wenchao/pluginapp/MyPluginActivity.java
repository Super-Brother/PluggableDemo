package com.wenchao.pluginapp;

import android.os.Bundle;

import com.wenchao.plugublib.PluginActivity;

public class MyPluginActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin_home);
    }
}
