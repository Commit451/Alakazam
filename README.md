# Alakazam
Android animation made magical

[![Build Status](https://travis-ci.org/Commit451/Alakazam.svg?branch=master)](https://travis-ci.org/Commit451/Alakazam) [![](https://jitpack.io/v/Commit451/Alakazam.svg)](https://jitpack.io/#Commit451/Alakazam)

# Gradle Dependency
Add the jitpack url to the project:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
then, in your app `build.gradle`
```groovy
dependencies {
    implementation "com.github.Commit451:Alakazam:latest.version.here"
}
```

# Usage
Lots of prebuilt `ObjectAnimator`s can be accessed via extension methods including:
- view.widthAnimator()
- view.heightAnimator()
- textview.textColorAnimator()
- view.backgroundColorAnimator()
- window.statusBarColorAnimator()
- window.navigationBarColorAnimator()

For fading views in and out:
```kotlin
icon.fadeOut()
otherIcon.fadeIn()
```

License
--------

    Copyright 2018 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
