package com.lora.firebase

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()
         var logout: Button? = null
         var edit: EditText? = null
         var add: Button? = null
         var listView: ListView? = null
        logout = findViewById(R.id.logout)
        edit = findViewById(R.id.edit)
        add = findViewById(R.id.add)
        listView = findViewById(R.id.listView)
        logout.setOnClickListener(View.OnClickListener {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this@MainActivity, "Logged Out!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity, StartActivity::class.java))
        })
        add?.setOnClickListener(View.OnClickListener {
            val txt_name = edit?.text.toString()
            if (txt_name.isEmpty()) {
                Toast.makeText(this@MainActivity, "No name entered!", Toast.LENGTH_SHORT).show()
            } else {
//                FirebaseDatabase.getInstance().reference.child("Languages").child("Name")
//                    .setValue(txt_name)
//                var mRootRef = FirebaseDatabase.getInstance().reference
//                var mAuth = FirebaseAuth.getInstance()
//                mRootRef.child("notes").child(mAuth.currentUser?.uid!!)


                val userId = FirebaseAuth.getInstance().currentUser!!.uid
                var note = Note(txt_name, false, Timestamp(Date()), userId)

                FirebaseFirestore.getInstance()
                    .collection("notes")
                    .add(note)
            }
        })
        val list = ArrayList<String>()
        val adapter: ArrayAdapter<*> = ArrayAdapter(this, R.layout.list_item, list)
        listView?.adapter = adapter
        val reference =
            FirebaseDatabase.getInstance().reference.child("Information")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                list.clear()
//                for (snapshot in dataSnapshot.children) {
//                    val info = snapshot.getValue(Information::class.java)!!
//                    val txt = info.name + " : " + info.email
//                    list.add(txt)
//                }
//                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

    }
}