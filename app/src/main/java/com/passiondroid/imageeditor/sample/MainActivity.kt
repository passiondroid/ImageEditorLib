package com.passiondroid.imageeditor.sample

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.passiondroid.imageeditorlib.ImageEditor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        select_image_btn.setOnClickListener {
            ImageEditor.Builder(this, "/sdcard/Download/scr.png").open()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            ImageEditor.RC_IMAGE_EDITOR ->
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val imagePath: String = data.getStringExtra(ImageEditor.EXTRA_EDITED_PATH)
                    edited_image.setImageBitmap(BitmapFactory.decodeFile(imagePath))
                }
        }
    }
}
