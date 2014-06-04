package net.iturrioz

import android.app.Activity
import android.view.{Menu, MenuItem}
import android.content.Intent

trait MenuOptions extends Activity {

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
