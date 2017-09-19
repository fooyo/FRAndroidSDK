# FRAndroidSDK
Fooyo photo collage sdk

## include
 - add following script into your root build.gradle
 ```
 allprojects {
     repositories {
         jcenter()
         maven {
             url "https://jitpack.io"
 
         }
         maven {
             url "https://maven.google.com"
         }
         maven {
             url 'https://dl.bintray.com/fooyo/FRAndroidSdk/'
         }
     }
 }
 ```
 - because of sdk using databinding lib,so you should add databinding into your module build.gradle
 
 ```
 android {
     ...
     
     dataBinding {
         enabled = true
     }
 }
 ```
 - add dependency into gradle
 ```
     compile 'sg.fooyo:FRAndroidSdk:1.0.1'
```

## Create photo collage

- `startTime` ,this param represents the time that photo collage start to search.
```
FooyoFRAndroidSDK.createPhotoCollage(Context context, long startTime);
```
