# PAM5 – Kumpulan Tugas Pengembangan Aplikasi Mobile

Repositori ini digunakan untuk **mengumpulkan tugas mata kuliah Pengembangan Aplikasi Mobile (PAM)**.
Seluruh tugas dikerjakan dengan **Kotlin** dan **Jetpack Compose** di dalam **satu proyek Android Studio**.
Setiap tugas disimpan di package dan folder yang terpisah, sehingga tugas yang lebih baru **tidak menimpa** tugas sebelumnya.

## Identitas Mahasiswa

| | |
|---|---|
| **Nama** | Rafa Maritza Hanasaputri |
| **NIM** | 245150401111035 |

NIM dan nama ditampilkan di semua layar pada setiap tugas.

---

## Daftar Tugas

| No | Tugas | Ringkasan | Package | Activity |
|----|-------|-----------|---------|----------|
| 1 | **Tugas 2** | Aplikasi 2 Activity: kirim teks dari Activity 1 ke Activity 2 | `tugas2` | `Tugas2FirstActivity` |
| 2 | **Latihan 2** | Compose Navigation: 1 Activity, 2 Screen | `latihan2` | `Latihan2Activity` |
| 3 | **Tugas 3** | LazyColumn dengan stickyHeader dan gambar lokal | `tugas3` | `Tugas3Activity` |
| 4 | **Tugas 4** | Aplikasi counter dengan ViewModel | `tugas4` | `MainActivity` (**activity utama**) |

> **Catatan:** `MainActivity` adalah **Tugas 4** (tugas terakhir). Tugas lainnya tetap ada dan dapat dijalankan langsung (lihat bagian [Cara Menjalankan](#cara-menjalankan)).

### Tugas 2 – Aplikasi 2 Activity

**Soal**
- Activity 1: 1 TextField dan 1 Tombol.
- Activity 2: 1 Label.
- Teks yang dimasukkan di TextField Activity 1 ditampilkan di label Activity 2.
- NIM dan nama ditampilkan di Activity 1 dan 2.

**Implementasi**
- Activity 1 memiliki `OutlinedTextField`, tombol **Reset** (mengosongkan input), dan tombol **Kirim Data**.
- Data dikirim dengan `Intent.putExtra("EXTRA_TEXT", ...)` lalu dibaca di Activity 2 dengan `intent.getStringExtra(...)`.
- Activity 2 menampilkan teks tersebut pada label dan memiliki tombol **Kembali** (`finish()`).

**Lokasi kode:** `tugas2/activity/` dan `tugas2/ui/screen/`

### Latihan 2 – Compose Navigation

**Soal**
- Aplikasi menggunakan Compose Navigation, 1 Activity dan 2 Screen.
- NIM dan nama ditampilkan di semua screen.
- Screen 1: teks "Screen 1" dan tombol "Ke Halaman 2".
- Screen 2: teks "Screen 2".

**Implementasi**
- `NavHost` dengan dua rute: `"first"` dan `"second"`.
- Tombol **Ke Halaman 2** memakai `navController.navigate("second")`.
- Tombol **Kembali** di Screen 2 memakai `navController.popBackStack()`.

**Lokasi kode:** `latihan2/activity/` dan `latihan2/ui/screen/`

### Tugas 3 – LazyLayout dengan Sticky Header

**Soal**
- Aplikasi Android yang menampilkan LazyLayout.
- NIM dan nama ditampilkan dalam `stickyHeader`.
- Image di dalam list berasal dari resource lokal.

**Implementasi**
- `LazyColumn` dengan `stickyHeader` berisi NIM dan nama.
- Daftar 8 buah (Apel, Pisang, Jeruk, Mangga, Semangka, Alpukat, Stroberi, Anggur) dengan gambar dari `res/drawable`.
- Data dimodelkan dengan `data class Fruit` dan disimpan di `fruitList`.
- Tampilan tiap item dipisah ke komponen `CatalogItem`.

**Lokasi kode:** `tugas3/activity/`, `tugas3/model/`, `tugas3/ui/screen/`, dan `tugas3/ui/component/`

### Tugas 4 – Aplikasi Counter dengan ViewModel

**Soal**
1. Menampilkan NIM dan nama.
2. Tombol Up, Down, dan Reset.
3. Menggunakan ViewModel.

**Implementasi**
- `CounterViewModel` menyimpan state counter dengan `StateFlow`.
- UI mengamati state dengan `collectAsState()`.
- Tombol **Up** (+1), **Down** (-1), dan **Reset** (kembali ke 0) memakai komponen `ColoredButton`.
- Setiap klik dicatat di Logcat dengan tag `COUNTER`.
- Navigasi ke Screen 2 memakai `NavHost` dan rute pada `NavDestination`.

**Lokasi kode:** `MainActivity.kt`, `tugas4/viewmodel/`, `tugas4/ui/screen/`, `tugas4/ui/component/`, dan `tugas4/navigation/`

---

## Struktur Proyek

Kode berada di `app/src/main/java/com/example/pam5/`.
Setiap tugas memisahkan **activity**, **model**, **UI**, dan **ViewModel** ke folder masing-masing.

```
com.example.pam5/
├── MainActivity.kt                  ← Tugas 4 (activity utama)
│
├── tugas2/                          ← Tugas 2: 2 Activity + Intent
│   ├── activity/
│   │   ├── Tugas2FirstActivity.kt
│   │   └── Tugas2SecondActivity.kt
│   └── ui/screen/
│       ├── Tugas2FirstScreen.kt
│       └── Tugas2SecondScreen.kt
│
├── latihan2/                        ← Latihan 2: Compose Navigation
│   ├── activity/
│   │   └── Latihan2Activity.kt
│   └── ui/screen/
│       ├── Latihan2FirstScreen.kt
│       └── Latihan2SecondScreen.kt
│
├── tugas3/                          ← Tugas 3: LazyColumn + stickyHeader
│   ├── activity/
│   │   └── Tugas3Activity.kt
│   ├── model/
│   │   ├── Fruit.kt
│   │   └── FruitData.kt
│   └── ui/
│       ├── screen/CatalogScreen.kt
│       └── component/CatalogItem.kt
│
└── tugas4/                          ← Tugas 4: Counter + ViewModel
    ├── viewmodel/CounterViewModel.kt
    ├── navigation/NavDestination.kt
    └── ui/
        ├── screen/
        │   ├── Tugas4CounterScreen.kt
        │   └── Tugas4SecondScreen.kt
        └── component/ColoredButton.kt
```

Aset gambar buah (`apel`, `pisang`, `jeruk`, `mangga`, `semangka`, `alpukat`, `stroberi`, `anggur`) berada di `app/src/main/res/drawable/`.

---

## Riwayat Commit

| Tanggal | Commit | Tugas |
|---------|--------|-------|
| 15 Sep 2026, 20:15 | `first commit` | Tugas 2 |
| 22 Sep 2026, 08:44 | `penambahan_navCompose` | Latihan 2 |
| 30 Sep 2026, 09:41 | `Adding Fruit Catalog` | Tugas 3 |
| 30 Sep 2026, 09:46 | `adding the files for fruit` | Tugas 3 |
| 13 Okt 2026, 15:30 | `Adding view model` | Tugas 4 |

Struktur folder di atas adalah struktur setelah kode dirapikan dan dipisah per tugas.

---

## Persyaratan

- Android Studio (versi terbaru yang mendukung Jetpack Compose)
- JDK yang sudah disertakan oleh Android Studio
- Emulator Android atau HP Android (dengan USB debugging aktif)
- Dependency berikut harus ada di `app/build.gradle(.kts)`:
    - `androidx.navigation:navigation-compose`
    - `androidx.lifecycle:lifecycle-viewmodel-compose`

---

## Cara Menjalankan

### 1. Persiapan

1. Clone repositori ini, lalu buka foldernya di Android Studio (**File > Open**).
2. Tunggu proses **Gradle Sync** sampai selesai.
3. Siapkan emulator (**Device Manager**) atau sambungkan HP Android.
4. Pastikan `AndroidManifest.xml` sudah mendaftarkan keempat activity (sudah termasuk di repositori ini).

### 2. Menjalankan dengan Ikon di HP/Emulator

Keempat activity didaftarkan sebagai launcher, sehingga setiap tugas muncul sebagai ikon tersendiri.

1. Klik tombol **Run ▶** di Android Studio. Secara default yang dijalankan adalah `MainActivity` (Tugas 4).
2. Setelah aplikasi terpasang, buka **app drawer** di HP/emulator.
3. Akan muncul 4 ikon aplikasi PAM5 dengan label berbeda:

| Label ikon | Tugas yang dibuka |
|------------|-------------------|
| **Tugas 4 - Counter** | Tugas 4 (counter + ViewModel) |
| **Tugas 2 - Dua Activity** | Tugas 2 (2 Activity) |
| **Latihan 2 - Navigation** | Latihan 2 (Compose Navigation) |
| **Tugas 3 - Katalog Buah** | Tugas 3 (LazyColumn + sticky header) |

4. Ketuk ikon tugas yang ingin dinilai.

### 3. Menjalankan dengan Run Configuration

Cara ini cocok bila ingin menjalankan activity tertentu langsung dari Android Studio.

1. Klik dropdown konfigurasi di toolbar atas (biasanya bertuliskan `app`), lalu pilih **Edit Configurations...**.
2. Klik tombol **+** lalu pilih **Android App** (atau pilih konfigurasi `app` yang sudah ada).
3. Beri nama, misalnya `run_tugas3`.
4. Pada **Module**, pilih `app`.
5. Pada tab **General**, bagian **Launch Options**, ubah **Launch** dari *Default Activity* menjadi **Specific Activity**.
6. Pada kolom **Activity**, pilih activity tugas yang diinginkan:

| Tugas | Activity yang dipilih |
|-------|-----------------------|
| Tugas 2 | `com.example.pam5.tugas2.activity.Tugas2FirstActivity` |
| Latihan 2 | `com.example.pam5.latihan2.activity.Latihan2Activity` |
| Tugas 3 | `com.example.pam5.tugas3.activity.Tugas3Activity` |
| Tugas 4 | `com.example.pam5.MainActivity` |

7. Klik **Apply**, lalu **OK**.
8. Pilih konfigurasi tersebut di dropdown toolbar dan klik **Run ▶**.

Agar tidak perlu mengubah pengaturan berulang kali, buat satu konfigurasi untuk setiap tugas (`run_tugas2`, `run_latihan2`, `run_tugas3`, `run_tugas4`), lalu cukup ganti pilihan di dropdown.

### 4. Menjalankan dengan ADB (opsional)

```bash
adb shell am start -n com.example.pam5/.tugas2.activity.Tugas2FirstActivity
adb shell am start -n com.example.pam5/.latihan2.activity.Latihan2Activity
adb shell am start -n com.example.pam5/.tugas3.activity.Tugas3Activity
adb shell am start -n com.example.pam5/.MainActivity
```

---

## Teknologi

- Kotlin
- Jetpack Compose (Material 3)
- Compose Navigation
- ViewModel + StateFlow
- Android Studio