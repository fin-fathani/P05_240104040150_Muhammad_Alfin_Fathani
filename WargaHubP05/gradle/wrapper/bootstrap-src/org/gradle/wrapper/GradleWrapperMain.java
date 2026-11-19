package org.gradle.wrapper;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;
public final class GradleWrapperMain {
    public static void main(String[] args) throws Exception {
        Path base = Paths.get(System.getProperty("user.home"), ".gradle", "wrapper", "dists", "wargahub-p05-8.13");
        String dist = "gradle-8.13";
        Path runner = base.resolve(dist).resolve("bin").resolve(isWindows() ? "gradle.bat" : "gradle");
        if (!Files.isRegularFile(runner)) {
            Files.createDirectories(base);
            Path archive = base.resolve(dist + "-bin.zip");
            if (!Files.exists(archive)) {
                URL url = new URL("https://services.gradle.org/distributions/gradle-8.13-bin.zip");
                System.out.println("Downloading official Gradle 8.13 distribution: " + url);
                URLConnection connection = url.openConnection();
                connection.setConnectTimeout(30000);
                connection.setReadTimeout(120000);
                Path part = base.resolve(dist + ".part");
                try (InputStream in = connection.getInputStream()) { Files.copy(in,part,StandardCopyOption.REPLACE_EXISTING); }
                Files.move(part,archive,StandardCopyOption.REPLACE_EXISTING);
            }
            System.out.println("Extracting Gradle distribution...");
            try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(archive))) {
                ZipEntry e;
                while ((e = zis.getNextEntry()) != null) {
                    Path out = base.resolve(e.getName()).normalize();
                    if (!out.startsWith(base)) throw new IOException("Unsafe ZIP path");
                    if (e.isDirectory()) Files.createDirectories(out);
                    else { Files.createDirectories(out.getParent()); Files.copy(zis,out,StandardCopyOption.REPLACE_EXISTING); }
                }
            }
            if (!Files.isRegularFile(runner)) throw new IOException("Gradle binary missing after unzip");
            if (!isWindows()) runner.toFile().setExecutable(true);
        }
        List<String> cmd = new ArrayList<>();
        if (isWindows()) { cmd.add("cmd.exe"); cmd.add("/c"); }
        cmd.add(runner.toAbsolutePath().toString());
        Collections.addAll(cmd,args);
        ProcessBuilder pb = new ProcessBuilder(cmd).inheritIO();
        int rc = pb.start().waitFor();
        System.exit(rc);
    }
    private static boolean isWindows() { return System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win"); }
}
