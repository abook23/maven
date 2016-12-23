package com.demo.common.config;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * Created by My on 2016/12/23.
 */
public class DatabaseConfig {

    public static C3p0Plugin connectC3p0Plugin() {
        return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }
}
