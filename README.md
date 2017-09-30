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
     compile 'sg.fooyo:FRAndroidSdk:1.2'
```
## Start Monitoring
use this method  in the  MainActivity of Application.

it will monitor user's location and save to the local memory if user location is in sentosa firstly.
And this monitor will be in background and listen the change of user location until callBack return true.

the callback will return true when user is no longer in sentosa area or current time is two hours later than the recordTime ,otherwise false.
```
 FooyoFRAndroidSDK.startMonitoring(this, new FRSDKMonitorListener() {
            @Override
            public void onResult(boolean result) {
                LogUtils.e(result+"");
            }
        });
 ```

## Create photo collage

- `startTime` ,this param represents the time that photo collage start to search.
- `userId` used when share

There are two Overriden methods to start collage.`startTime`is not necessary. if don't deliver `startTime`
,default startTime will be set to past two hours.
```
FooyoFRAndroidSDK.createPhotoCollage(Context context, String userId);
FooyoFRAndroidSDK.createPhotoCollage(Context context, long startTime,String userId);
```
