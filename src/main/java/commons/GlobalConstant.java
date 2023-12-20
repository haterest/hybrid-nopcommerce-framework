package commons;

import lombok.Getter;

@Getter
public class GlobalConstant {
    private static GlobalConstant globalInstance;
    private GlobalConstant() {
    }

    public static synchronized GlobalConstant getGlobalConstants() {
        if (globalInstance == null) {
            globalInstance = new GlobalConstant();
        }
        return globalInstance;
    }
    private final long shortTimeout = 5;
    private final long longTimeout = 30;
    private final String adminPageURL = "https://admin-demo.nopcommerce.com/";
    private final String userPageURL = "https://demo.nopcommerce.com/";
    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");
    private final String javaVersion = System.getProperty("java.version");
    private final String stagingPageURL = "https://staging.nopcommerce.com/";
    private final String productionPageURL = "https://production.nopcommerce.com/";
}
