package appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Server {
    static AppiumDriverLocalService service;

    public static void startAppiumServer() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withAppiumJS(new File(getAppiumExecutable()))
                .withStartUpTimeOut(2, TimeUnit.MINUTES)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "warn");

        service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();

        if (service == null || !service.isRunning()) {
            throw new RuntimeException("Client server is not started!");
        }
    }

    public static void stopAppiumServer() {
        if (service != null) {
            service.stop();
        }
    }

    private static String getAppiumExecutable() {
        String hostOS = System.getProperty("os.name", "generic").toLowerCase();
        if ((hostOS.contains("mac")) || (hostOS.contains("darwin"))) {
            return "/usr/local/bin/appium";
        } else if (hostOS.contains("win")) {
            return System.getenv("APPDATA") + "\\npm\\node_modules\\appium\\build\\lib\\main.js";
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
