package net.iturrioz.tests

import net.iturrioz._
import junit.framework.Assert._
import android.test.{TouchUtils, AndroidTestCase, ActivityInstrumentationTestCase2}

class AndroidTests extends AndroidTestCase {
  def testPackageIsCorrect() {
    assertEquals("net.iturrioz", getContext.getPackageName)
  }
}

class ActivityTests extends ActivityInstrumentationTestCase2(classOf[MainActivity]) {
  def testHelloWorldIsShown() {
    val activity = getActivity
    val textview = activity.findView(TR.textview)
    assertEquals(textview.getText, "Hi")

    TouchUtils.clickView(this, textview)
    assertEquals(textview.getText, "I'm still here")
  }
}
