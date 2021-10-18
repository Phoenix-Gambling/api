package phoenix.api.service;

import java.io.File;
import java.nio.file.Path;

public interface Phoenix {

    <T> T get(Class<?> pluginClass, Class<T> instanceClass);

    <T> T get(String pluginId, Class<T> instanceClass);

    <T> T get(Class<T> instanceClass);

    File getPluginDirectory();

    String getWebsiteURL();

    Phoenix installModule(String... module);

    Phoenix copyResource(String classPathSource, Path to);

    Phoenix copyResourceDirectory(String classPathSource, Path to);

    String readResource(String classPathSource);

    Phoenix grantAllPermissions(File file);

}
