# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


-keepclasseswithmembers class com.jcraft** { *; } -dontoptimize -dontobfuscate
-keepclasseswithmembers class org.ietf** { *; } -dontoptimize -dontobfuscate
-keepclasseswithmembers class org.xmlpull** { *; } -dontoptimize -dontobfuscate
-keep class org.kobjects.** { *; }
-keep class org.ksoap2.** { *; }
-keep class org.kxml2.** { *; }

-dontwarn android.content.res.XmlResourceParser
-dontwarn com.jcraft.jzlib.ZStream
-dontwarn org.ietf.jgss.GSSContext
-dontwarn org.ietf.jgss.GSSCredential
-dontwarn org.ietf.jgss.GSSException
-dontwarn org.ietf.jgss.GSSManager
-dontwarn org.ietf.jgss.GSSName
-dontwarn org.ietf.jgss.MessageProp
-dontwarn org.ietf.jgss.Oid
-dontwarn org.xmlpull.v1.**
-dontwarn org.kobjects.**
-dontwarn org.ksoap2.**
-dontwarn org.kxml2.**
-dontwarn android.adservices.measurement.DeletionRequest$Builder
-dontwarn android.adservices.measurement.DeletionRequest
-dontwarn android.adservices.measurement.MeasurementManager
-dontwarn android.adservices.measurement.WebSourceParams$Builder
-dontwarn android.adservices.measurement.WebSourceParams
-dontwarn android.adservices.measurement.WebSourceRegistrationRequest$Builder
-dontwarn android.adservices.measurement.WebSourceRegistrationRequest
-dontwarn android.adservices.measurement.WebTriggerParams$Builder
-dontwarn android.adservices.measurement.WebTriggerParams
-dontwarn android.adservices.measurement.WebTriggerRegistrationRequest$Builder
-dontwarn android.adservices.measurement.WebTriggerRegistrationRequest
-dontwarn reactor.blockhound.integration.BlockHoundIntegration
