package net.iturrioz

import android.app.ListActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class SecondActivity extends ListActivity with MenuOptions {

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.list)

    val adapter = new ArrayAdapter[String](this, android.R.layout.simple_list_item_1, Array("one", "two", "three"))
    setListAdapter(adapter)
  }
}