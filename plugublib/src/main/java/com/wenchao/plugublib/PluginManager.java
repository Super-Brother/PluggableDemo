package com.wenchao.plugublib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * @author wenchao
 * @date 2019/7/6.
 * @time 17:26
 * description：
 */
public class PluginManager {

    private static final PluginManager instance = new PluginManager();

    public static PluginManager getInstance() {
        return instance;
    }

    private PluginManager() {
    }

    private Context mContext;
    private PluginApk mPluginApk;

    public PluginApk getPluginApk(){
        return mPluginApk;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    /**
     * 加载apk文件
     * 创建DexClassLoader加载dex文件
     * 创建resource加载资源文件
     */
    public void loadApk(String apkPath) {
        PackageInfo packageInfo = mContext.getPackageManager().getPackageArchiveInfo(apkPath,
                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
        if (packageInfo == null) {
            return;
        }
        DexClassLoader loader = createDexClassLoader(apkPath);
        AssetManager am = createAssetManager(apkPath);
        Resources resources = createResource(am);
        mPluginApk = new PluginApk(packageInfo, resources, loader);
    }

    private Resources createResource(AssetManager am) {
        Resources resources = mContext.getResources();
        return new Resources(am, resources.getDisplayMetrics(), resources.getConfiguration());
    }

    private AssetManager createAssetManager(String apkPath) {
        try {
            AssetManager am = AssetManager.class.newInstance();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            method.invoke(am, apkPath);
            return am;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private DexClassLoader createDexClassLoader(String apkPath) {
        File file = mContext.getDir("dex", Context.MODE_PRIVATE);
        return new DexClassLoader(apkPath, file.getAbsolutePath(), null, mContext.getClassLoader());
    }
}
