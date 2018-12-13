package com.maxcode.demo.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {
    // 先加载开发环境配置，再追加生产环境的少量配置覆盖掉开发环境配置
    private static Prop p = PropKit.use("jfinal_club_config_dev.txt")
            .appendIfExists("jfinal_club_config_pro.txt");

    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class, 80, true);

    }

    @Override
    public void configConstant(Constants arg0) {
        arg0.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        me.add(new FrontRoutes());

    }

    @Override
    public void configEngine(Engine me) {
        me.setDevMode(p.getBoolean("engineDevMode", false));

        me.addSharedFunction("/_view/common/__layout.html");
        me.addSharedFunction("/_view/common/_paginate.html");

    }

    @Override
    public void configHandler(Handlers arg0) {
    }

    @Override
    public void configInterceptor(Interceptors arg0) {
    }

    @Override
    public void configPlugin(Plugins arg0) {
    }
}
