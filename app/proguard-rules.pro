# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
#class:
-keepclassmembers class com.styc.foodie.fragments.Swiggy {
   public *;
}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile
-dontwarn org.xmlpull.v1.**
-dontnote org.xmlpull.v1.**.
-dontnote org.opencv.**
-dontwarn javax.xml.stream.events.**
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontwarn our.company.project.R*
-dontwarn org.opencv.android.CameraBridgeViewBase
-verbose
-optimizations !code/simplification/arithmetic,!field
-dontwarn okio.**
-dontwarn com.google.android.gms.**
-dontwarn retrofit.**
-keepattributes Signature
-keepattributes Exceptions
-dontobfuscate
