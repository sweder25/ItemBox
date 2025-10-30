package com.mij.itembox.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

suspend fun saveImageToInternalStorage(
    context: Context,
    sourceUri: Uri,
    filename: String,
    maxWidth: Int = 1024,
    quality: Int = 80
): String? {
    return withContext(Dispatchers.IO) {
        try {
            val imagesDir = File(context.filesDir, "images")
            if (!imagesDir.exists()) imagesDir.mkdirs()

            context.contentResolver.openInputStream(sourceUri).use { input ->
                if (input == null) return@withContext null

                // Decodificar bitmap
                val bitmap = BitmapFactory.decodeStream(input)
                // Escalar si es necesario
                val scaled = if (bitmap != null && bitmap.width > maxWidth) {
                    val ratio = maxWidth.toFloat() / bitmap.width
                    Bitmap.createScaledBitmap(bitmap, maxWidth, (bitmap.height * ratio).toInt(), true)
                } else bitmap

                val outFile = File(imagesDir, filename)
                FileOutputStream(outFile).use { out ->
                    (scaled ?: bitmap)?.compress(Bitmap.CompressFormat.JPEG, quality, out)
                    out.flush()
                }
                // Liberar si creamos un scaled nuevo
                if (scaled != null && scaled !== bitmap) bitmap?.recycle()

                "images/${outFile.name}"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
