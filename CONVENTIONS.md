# ENGINEERING STANDARDS & LESSONS LEARNED

## 1. Build System (Gradle/CMake)
- **NEVER** use the local NDK on the host machine. Always rely on GitHub Actions for C++ compilation.
- When creating `CMakeLists.txt`, always include the `aosp_headers` directory to prevent `fatal error: 'system/camera.h' file not found`.
- **Do not** verify C++ builds locally using `./gradlew`. Use the `/git push` workflow to verify on the remote server.

## 2. File Handling
- **NEVER** use `../` (parent directory) traversal in Python/Aider commands on Windows. It causes `pathlib` crashes.
- Always use absolute paths or copy reference files into a local `refs/` folder before reading them.

## 3. Xposed Module Logic
- The entry point must be defined in `assets/xposed_init`.
- `AndroidManifest.xml` must contain the `xposedmodule` meta-data tags.
- Hooking logic must handle obfuscated apps by searching for signatures (methods/strings) rather than relying on class names.

## 4. Architecture
- Keep the `VideoInjector` logic separate from the `MainHook` logic.
- Use `SurfaceTexture` interception for camera hooking.
