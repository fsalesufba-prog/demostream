# DEMOSTREAM - Android Streaming Application

## Overview
DEMOSTREAM is a native Android application for streaming content on mobile and TV platforms. It's built with Kotlin and uses Android's modern architecture components.

## Project Structure
```
/
├── mobile/          # Mobile phone Android app module
│   └── src/main/    # Kotlin source code
├── tv/              # Android TV app module
│   └── src/main/    # Kotlin source code
├── gradle/          # Gradle wrapper files
├── build.gradle     # Root build configuration
└── settings.gradle  # Project settings and module includes
```

## Technology Stack
- **Language**: Kotlin 1.9.23
- **Build System**: Gradle 8.5
- **JDK**: 19 (GraalVM)
- **Min SDK**: 21 (Android 5.0)
- **Target SDK**: 34 (Android 14)
- **Architecture**: MVVM with Hilt dependency injection

### Key Dependencies
- AndroidX (Core, AppCompat, Navigation, Lifecycle)
- Hilt for dependency injection
- Room for local database
- Retrofit for networking
- Media3/ExoPlayer for video playback
- Glide for image loading
- Leanback library for TV interface

## Build Status
- Gradle builds are configured and working
- JDK 19 is used for compilation
- **Note**: Full APK builds require Android SDK (not available on Replit)

## Important Notes
- This project's Gradle configuration is verified working
- To build actual APKs, use Android Studio on a local machine or a CI/CD service with Android SDK
- The source code can be viewed and edited on Replit
- For full development, clone this repo to a machine with Android Studio installed

## API Configuration
The mobile module expects Supabase configuration:
- `SUPABASE_URL` - Your Supabase project URL
- `SUPABASE_ANON_KEY` - Your Supabase anonymous key

These are currently set to placeholder values in `mobile/build.gradle`.

## Recent Changes
- 2026-02-05: Initial Replit environment setup
- Updated JDK version to 19 for compatibility with GraalVM
- Cleaned local.properties for cross-platform compatibility
- Added foojay-resolver plugin for toolchain management
