package com.wenchao.plugublib;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * @author wenchao
 * @date 2019/7/6.
 * @time 15:17
 * description：插件apk的实体对象
 */
public class PluginApk {

    public PackageInfo mPackageInfo;
    public Resources mResources;
    public AssetManager mAssetManager;
    public DexClassLoader mClassLoader;

    public PluginApk(PackageInfo mPackageInfo, Resources mResources, DexClassLoader mClassLoader) {
        this.mPackageInfo = mPackageInfo;
        this.mResources = mResources;
        this.mAssetManager = mResources.getAssets();
        this.mClassLoader = mClassLoader;
    }
}
