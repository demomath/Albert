package com.demomath.albert;

/**
 * JsBundle是JS应用的打包文件，包含了应用的所有源码和资源，如本地图片资源和应用信息清单。
 */
public class JsBundle {

    private String mAppJavaScript;

    public String getAppJavaScript() {
        return mAppJavaScript;
    }

    public void setAppJavaScript(String appJavaScript) {
        this.mAppJavaScript = appJavaScript;
    }

}
