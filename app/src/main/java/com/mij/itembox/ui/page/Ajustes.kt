package com.mij.itembox.ui.page
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.viewmodel.SettingsViewModel

@Composable
fun AjustesPage(settingsViewModel: SettingsViewModel) {
    val darkMode by settingsViewModel.darkMode.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Ajustes", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text("Modo oscuro", style = MaterialTheme.typography.bodyLarge)
            Switch(
                checked = darkMode,
                onCheckedChange = { settingsViewModel.setDarkMode(it) }
            )
        }
    }
}
