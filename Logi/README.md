## Logi <img src=https://user-images.githubusercontent.com/64600215/234035353-7e23a6e6-f9a3-493f-928d-68e7fa37a563.png width=50 height=50>

Logi is an android library that help you monitor and track your logs when the app is not running.
Based on android roomSql library, Logi provides out of the box interface for all required actions!

### Get Started
#### installation

**STEP 1 -> Add to your settings.gradle file:**
```
pluginManagement {
    repositories {
        ...
        mavenCentral()
        maven { url 'https://jitpack.io' }
        ...
    }
}
```

**STEP 2 -> Add to your build.gradle file (.app):** (replce with specific tag)
```
	dependencies {
          ...
	        implementation 'com.github.GalShamir8:Logi:latest'
          ...
	}
```
Ready to Go!

#### Usage

- After building the app and instance of LoggerHelper will be accesable in all of your project `LoggerHelper.getInstance();`
- Callable callback, used for set data return fron async request to fetch logs data.
- Public methods:
  - `#add(Logger log)`
  - `#addAll(Logger... logs)`
  - `#findBetweenDate(long startTimeStamp, long endTimeStamp, Callable callable)`
  - `#getAll(Callable callable)` -> **NOTE to add pagination!**
  - `#loadAllByIds(int[] loggerIds, Callable callable)` -> **NOTE to add pagination!**
  - `#findByTag(String tag, Callable callable)`
  - `#findByTagStartWith(String tagPrefix, Callable callable)`
  - `#findFromDate(long timestamp, Callable callable)`
  - `#delete(Logger log)`
  - `#deleteAll(Callable callable)`

Issues and PR's are more than Welcom!
