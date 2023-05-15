package com.example.kotlinappfeature

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        drawer Code start
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout_id)
        val navMenu: NavigationView = findViewById(R.id.nav_menu_id)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu1 -> Toast.makeText(this, "One", Toast.LENGTH_SHORT).show()
                R.id.menu2 -> Toast.makeText(this, "Two", Toast.LENGTH_SHORT).show()
                R.id.menu3 -> Toast.makeText(this, "Three", Toast.LENGTH_SHORT).show()
            }
            true
        }

//        drawer code end

        findViewById<Button>(R.id.btn_ad_id).setOnClickListener {
            startActivity(Intent(this, AlertDialog::class.java))
        }

        // start TOAST

        findViewById<Button>(R.id.btn_toast_msg_id).setOnClickListener {
            Toast.makeText(this@MainActivity, "Hello There", Toast.LENGTH_SHORT).show()
        }
        // SNACK BAR CODE
        findViewById<Button>(R.id.btn_snack_bar_id).setOnClickListener {

            // Snackbar.make(it, "This is SnackBar", Snackbar.LENGTH_SHORT).show()

           val snackbar = Snackbar.make(it, "This is SnackBar", Snackbar.LENGTH_LONG)
            snackbar.setAction("Ok", View.OnClickListener {
                snackbar.dismiss()
            })
            snackbar.setTextColor(getColor(R.color.black))
            snackbar.setBackgroundTint(getColor(R.color.purple_500))
            snackbar.show()

        }

        // Recycler View
        findViewById<Button>(R.id.btn_show_recycler_view_id).setOnClickListener {
            startActivity(Intent(this, RecyclerView::class.java))
        }

        findViewById<Button>(R.id.btn_ext_img_id).setOnClickListener {
            val intent = Intent(this, LoadImageFromUrl::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.piano_app_btn_id).setOnClickListener {
            startActivity(Intent(this, AppPiano::class.java))
        }
        findViewById<Button>(R.id.counter_app_btn_id).setOnClickListener {
            startActivity(Intent(this, CounterApp::class.java))
        }
        // GRAGMENTS

        findViewById<Button>(R.id.btn_fragments_id).setOnClickListener {
            startActivity(Intent(this, Fragments::class.java))
        }
        findViewById<Button>(R.id.btn_ext_font_id).setOnClickListener {
            startActivity(Intent(this, ExternalFont::class.java));
        }

        findViewById<Button>(R.id.btn_ext_icon_id).setOnClickListener {
            startActivity(Intent(this, ExternalIcon::class.java).putExtra("key", "values"));
        }

        findViewById<Button>(R.id.btn_ext_icon_id).setOnClickListener {
            startActivity(Intent(this, ExternalIcon::class.java).putExtra("key", "values"));
        }
        findViewById<Button>(R.id.bmi_app_btn_id).setOnClickListener {
            startActivity(Intent(this, AppBMI::class.java));
        }
        findViewById<Button>(R.id.quiz_app_btn_id).setOnClickListener {
            startActivity(Intent(this, QuizApp::class.java));
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
           return true
        }
        return super.onOptionsItemSelected(item)
    }
}