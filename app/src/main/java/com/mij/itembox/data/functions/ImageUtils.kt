package com.mij.itembox.data.functions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


@Deprecated("Old helper - not used")
fun saveImageToInternalStorageDeprecated(context: Context, sourceUri: Uri, filename: String): String? {

    throw UnsupportedOperationException("Use com.mij.itembox.util.saveImageToInternalStorage")
}