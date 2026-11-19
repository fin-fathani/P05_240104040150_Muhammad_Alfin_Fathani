# WargaHub P05 — Al-Fathani

**Pemilik:** Muhammad Alfin Fathani  
**NIM:** 240104040150  
**Kelas:** TI24A  
**Mata kuliah:** Praktikum Pemrograman Mobile — Praktikum 05  
**Dosen:** Muhayat, M.IT

## Ruang lingkup
Aplikasi Kotlin Native Android (XML Views, ViewBinding) untuk laporan fiktif yang tersimpan di perangkat.
- CRUD SQLite melalui Room 3
- Entity, DAO, Repository, ViewModel/Factory, Coroutine/Flow
- SharedPreferences untuk opsi urutan berdasarkan ID
- Validasi input, konfirmasi hapus, keadaan kosong/gagal, uji persistensi
- Identitas visual **AL-FATHANI** pada layar utama dan form

## Cara membuka
1. Ekstrak ZIP ke folder tanpa spasi bermasalah (contoh `C:\AndroidProjects\P05_240104040150_Muhammad_Alfin_Fathani`).
2. Android Studio → Open → pilih folder `WargaHubP05` yang berisi `settings.gradle.kts`.
3. Gunakan **Gradle JDK 17 atau 21** dan Android SDK API 36.
4. Tunggu Gradle Sync (memerlukan internet untuk dependency pertama).
5. Pilih emulator/HP dengan Android API 26+ lalu Run.
6. Jika CLI Gradle Wrapper belum diinisialisasi, lihat `docs/catatan-wrapper.md`.

## Alur data
Activity → ViewModel → Repository → DAO → Room/SQLite → Flow → ViewModel → Activity.
SharedPreferences menyimpan `urut_terbaru`, bukan data laporan.

## Catatan penting
- Database **tidak** dipopulasi dengan data contoh; input harus ditambahkan pengguna.
- Proyek belum diuji Build/Run di perangkat pengguna. Catat hasil yang benar-benar terjadi.
- File `app/schemas/*.json` akan dihasilkan saat build berhasil.
- Screenshot di `screenshots/` masih belum ada dan harus dibuat sendiri setelah praktik.
- Kode mengikuti Modul Praktikum 05; dekorasi AL-FATHANI adalah penyesuaian visual, bukan perubahan alur CRUD.
