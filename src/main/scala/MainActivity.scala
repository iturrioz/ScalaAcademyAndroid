package net.iturrioz

import android.app.Activity
import android.os.{AsyncTask, Bundle}
import android.view.View
import android.widget.TextView

class MainActivity extends Activity with TypedActivity with MainActivity.Listeners with MenuOptions {

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    val textview: TextView = findView(TR.textview)

    textview.setText("Hi")
    textview.setOnClickListener((v: View) => textview.setText("I'm still here"))


    findView(TR.button).setOnClickListener{view: View =>
      new AsyncTask[Unit, Unit, Unit]() {
        override def doInBackground(p1: Unit*) {
          blockingMethod()
        }
        override def onPostExecute(p: Unit) {
          afterBlockingCode()
        }
      }.execute().get()
    }
  }

  def blockingMethod() {
    // Blocking code
  }

  def afterBlockingCode() {
    // After code
  }
}

object MainActivity {

  trait Listeners {
    implicit def function2ViewOnClickListener(f: View => Unit) : View.OnClickListener = {
      new View.OnClickListener() {
        def onClick(view: View) {
          f(view)
        }
      }
    }
  }
}
