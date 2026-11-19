# Gradle Wrapper — catatan transparansi

Proyek menggunakan Gradle 8.13. Karena distribusi Gradle dan JAR Wrapper resmi tidak dapat diunduh saat penyiapan ZIP, launcher `gradlew` / `gradlew.bat` di paket ini memakai **bootstrap Java sederhana yang source-nya disertakan** di `WargaHubP05/gradle/wrapper/bootstrap-src/`. Kode tersebut mengunduh distribusi Gradle 8.13 resmi dari `https://services.gradle.org` saat pertama kali dipakai, lalu menjalankan Gradle dari folder `~/.gradle/wrapper/dists/wargahub-p05-8.13`. Ini **bukan JAR Wrapper resmi Gradle**.

Untuk kesesuaian persis dengan modul, setelah membuka proyek di Android Studio disarankan membuat ulang Wrapper resmi memakai `gradle wrapper --gradle-version 8.13` setelah Gradle siap, lalu commit `gradlew`, `gradlew.bat`, `gradle/wrapper/gradle-wrapper.jar` dan `gradle/wrapper/gradle-wrapper.properties` yang resmi. Build/Sync belum diuji secara langsung dalam lingkungan pembuat ZIP.
