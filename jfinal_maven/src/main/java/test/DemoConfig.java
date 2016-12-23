package test;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;

/**
 * Created by My on 2016/12/23.
 */
public class DemoConfig extends JFinalConfig {
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }

    public void configRoute(Routes routes) {
        routes.add("/", TestController.class);
    }

    public void configPlugin(Plugins plugins) {

    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }

    public static void main(String args[]) {
        JFinal.start("src/main/webapp", 80, "/", 3);
    }
}
