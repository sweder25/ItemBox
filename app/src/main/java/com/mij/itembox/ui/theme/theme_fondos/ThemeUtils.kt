package com.mij.itembox.ui.theme.theme_fondos

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.mij.itembox.R

@Composable
fun backgroundForTheme(isDark: Boolean): Painter {
    return if (isDark) {
        painterResource(id = R.drawable.fondo_2)
    } else {
        painterResource(id = R.drawable.fondo)
    }
}
