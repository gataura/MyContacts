package com.hfad.mycontacts

import android.annotation.SuppressLint
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "DEPRECATION")
class ContactsActivity : AppCompatActivity() {

    lateinit var l1:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        l1 = find(R.id.contacts_view)
        get()

    }

    @SuppressLint("Recycle")
    fun get() {
        var cursor: Cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)
        startManagingCursor(cursor)

        var from = arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID)

        var to:IntArray = intArrayOf(android.R.id.text1, android.R.id.text2)

        var simpleCursorAdapter = SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                cursor,
                from,
                to
        )
        l1.adapter = simpleCursorAdapter
        l1.choiceMode = ListView.CHOICE_MODE_MULTIPLE
    }
}
