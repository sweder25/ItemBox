package com.mij.itembox.data.functions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

// Copia y opcionalmente redimensiona/comprime la imagen seleccionada por el usuario.
// Devuelve la ruta relativa dentro de filesDir, por ejemplo "images/12345.jpg"
@Deprecated("Old helper - not used")
fun saveImageToInternalStorageDeprecated(context: Context, sourceUri: Uri, filename: String): String? {
    // stub to avoid duplicate symbol during migration. Use com.mij.itembox.util.saveImageToInternalStorage instead.
    throw UnsupportedOperationException("Use com.mij.itembox.util.saveImageToInternalStorage")
}