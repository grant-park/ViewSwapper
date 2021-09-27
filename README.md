# ViewSwapper
Simple view container that supports transitions from Android (API level 19+).

## Install
In your root `build.gradle`
```groovy
allprojects {
    repositories {
        ...
        mavenCentral()
    }
}
```
In your app `build.gradle`
```groovy
implementation 'ai.grant:viewswapper:1.0.0'
```

## Usage
In your layout.xml:
```
<ai.grant.viewswapper.ViewSwapper
  android:id="@id/viewSwapper"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
/>
```
In your activity:
```
viewSwapper.setInitialView(myFirstView)
viewSwapper.next(mySecondView)
viewSwapper.next(myThirdView)
viewSwapper.next(myFourthView, Slide())
viewSwapper.next(myfifthView, Slide(Gravity.START))
viewSwapper.next(mySixthView, Explode())
...
```
## License

Copyright 2020 Grant Park

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
