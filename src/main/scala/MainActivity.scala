package net.iturrioz

import android.app.Activity
import android.os.Bundle
import android.view.{MenuItem, Menu, View}
import android.widget.TextView
import android.content.Intent

class MainActivity extends Activity with TypedActivity with MainActivity.Listeners {

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    val textview: TextView = findView(TR.textview)

    textview.setText("Hi")
    textview.setOnClickListener((v: View) => textview.setText("I'm still here"))
  }

  override def onCreateOptionsMenu(menu: Menu) = {
    getMenuInflater().inflate(R.menu.main, menu)
    true
  }

  override def onOptionsItemSelected(item: MenuItem) = {
    item.getItemId match {
      case R.id.item1 =>
        startActivity(new Intent(this, classOf[MainActivity]))
      case R.id.item2 =>
        startActivity(new Intent(this, classOf[SecondActivity]))
    }
    true
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
