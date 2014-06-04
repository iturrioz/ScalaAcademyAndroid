ScalaAcademyAndroid
===================

Prerequisites:
--------------

* Android SDK: http://developer.android.com/sdk/index.html
* SBT 0.12: http://dl.bintray.com/sbt/native-packages/sbt/0.12.4/
* Fix android tools. From platform-tools, run the following:
** ln -s ../build-tools/17.0.0/aapt aapt
** ln -s ../build-tools/17.0.0/lib lib
** ln -s ../build-tools/17.0.0/dx dx

Commands:
---------

* Compile
    sbt clean compile
* Package
    sbt android:package-debug
* Run on device
    sbt android:start-device
* Run unit tests
    sbt test
* Run Android tests
    sbt project tests
    sbt android:install-device
    sbt android:test-device

More information:
-----------------

* Templates:
    https://github.com/jberkel/android-plugin
* Scala usage in adroid:
    http://blog.andresteingress.com/2011/09/20/programming-android-with-scala/
    http://engineering.linkedin.com/incubator/technology-behind-eatin-android-apps-scala-ios-apps-and-play-framework-web-services
* Scaloid: Another Scala plugin:
    https://github.com/pocorall/scaloid
