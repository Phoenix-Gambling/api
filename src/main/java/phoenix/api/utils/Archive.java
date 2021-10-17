package phoenix.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Archive {

    public static void extractTarGz(String path, String target) {
        try {
            Files.createDirectories(Paths.get(target));
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("sh", "-c", String.format("tar xfz %s -C %s", path, target));
            builder.directory(new File("/tmp"));

            Process process = builder.start();
            int exitCode = process.waitFor();
            assert exitCode == 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void extractZip(String path, String target) {
        try {
            Files.createDirectories(Paths.get(target));
            byte[] buffer = new byte[1024];
            ZipInputStream inputStream = new ZipInputStream(new FileInputStream(path));
            ZipEntry zipEntry = inputStream.getNextEntry();

            while(zipEntry != null) {
                File newFile = newFile(new File(target), zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) throw new IOException("Failed to create directory " + newFile);
                } else {
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) throw new IOException("Failed to create directory " + parent);

                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = inputStream.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
                zipEntry = inputStream.getNextEntry();
            }

            inputStream.closeEntry();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

}
