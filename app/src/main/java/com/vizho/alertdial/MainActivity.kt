package com.vizho.alertdial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var enterYourName: EditText
    private lateinit var checkButton: Button
    private lateinit var btnOpenWebsite: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnShowSnackbar: Button
    private lateinit var btnShowAlert: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterYourName = findViewById(R.id.enterYourName)
        checkButton = findViewById(R.id.check)
        btnOpenWebsite = findViewById(R.id.btnOpenWebsite)
        btnDialNumber = findViewById(R.id.btnDialNumber)
        btnShowSnackbar = findViewById(R.id.btnShowSnackbar)
        btnShowAlert = findViewById(R.id.btnShowAlert)

        checkButton.setOnClickListener {
            val name = enterYourName.text.toString()
            Toast.makeText(this, "Name: $name", Toast.LENGTH_SHORT).show()
        }

        btnOpenWebsite.setOnClickListener {
            val websiteIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(websiteIntent)
        }

        btnDialNumber.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:7340908812"))
            startActivity(dialIntent)
        }

        btnShowSnackbar.setOnClickListener {
            Snackbar.make(findViewById(R.id.main), "This is a Snackbar", Snackbar.LENGTH_LONG).show()
        }

        btnShowAlert.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog")
        builder.setMessage("This is an alert dialog example.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}