package net.iturrioz

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import scala.concurrent._

import ExecutionContext.Implicits.global

class MainActivity extends Activity with TypedActivity with MainActivity.Listeners with MenuOptions {

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    val textview: TextView = findView(TR.textview)

    textview.setText("Hi")
    textview.setOnClickListener((v: View) => textview.setText("I'm still here"))


    findView(TR.button).setOnClickListener{view: View =>
      val task = future {
        blockingMethod()
      }
      task onFailure { case t =>
        runOnUiThread(new Runnable {
          override def run() {
            textview.setText(t.getMessage)
          }
        })
      }
      task onComplete { value =>
        runOnUiThread(new Runnable {
          override def run() {
            value.foreach(afterBlockingCode)
          }
        })
      }
    }
  }

  def blockingMethod() = {
    // Blocking code
    "Downloaded text"
  }

  def afterBlockingCode(value: String) {
    // After code
    findView(TR.textview).setText(value)
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
