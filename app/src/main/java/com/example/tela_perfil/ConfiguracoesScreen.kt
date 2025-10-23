package com.example.tela_perfil

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// ==================== TELA: CONFIGURAÇÕES ====================
@Composable
fun ConfiguracoesScreen(navController: NavHostController) {
    var isDarkTheme by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, currentScreen = "perfil") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9FAFB))
                .padding(paddingValues)
        ) {
            HeaderSection(isDarkTheme = isDarkTheme, onThemeToggle = { isDarkTheme = !isDarkTheme })
            SettingsList()
        }
    }
}

// ==================== HEADER SECTION ====================
@Composable
fun HeaderSection(isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Topo com gradiente azul
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF004aad),
                            Color(0xFF2563eb)
                        )
                    )
                ),
            contentAlignment = Alignment.BottomCenter
        ) {
            // Card branco com ícone de perfil
            Card(
                modifier = Modifier
                    .size(90.dp)
                    .offset(y = 45.dp)
                    .shadow(8.dp, CircleShape),
                shape = CircleShape,
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Perfil",
                        modifier = Modifier.size(48.dp),
                        tint = Color(0xFF2563eb)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(55.dp))

        // Card de Configurações
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .shadow(4.dp, RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Configurações",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1e3a8a)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botão Desconectar
                OutlinedButton(
                    onClick = { /* Ação de logout */ },
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(48.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFFdc2626)
                    ),
                    border = BorderStroke(2.dp, Color(0xFF2563eb)),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text(
                        text = "Desconectar",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

// ==================== SETTINGS LIST ====================
@Composable
fun SettingsList() {
    var isDarkTheme by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Tema
        SettingsItemSimple(
            title = "Tema 🌙",
            subtitle = null,
            onClick = { isDarkTheme = !isDarkTheme }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Idioma
        SettingsItemSimple(
            title = "Idioma",
            subtitle = "Português",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Contato
        SettingsItemSimple(
            title = "Contato",
            subtitle = "pas.suporte@gmail.com",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Termos de uso
        SettingsItemSimple(
            title = "Termos de uso",
            subtitle = null,
            onClick = { }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Sobre
        SettingsItemSimple(
            title = "Sobre",
            subtitle = null,
            onClick = { }
        )
    }
}

// ==================== COMPONENTE: SETTINGS ITEM ====================
@Composable
fun SettingsItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String?,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color(0xFF1e3a8a)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1e3a8a)
            )
        }

        if (subtitle != null) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF9ca3af)
            )
        }
    }
}

// ==================== COMPONENTE: SETTINGS ITEM WITH DRAWABLE ====================
@Composable
fun SettingsItemWithDrawable(
    iconRes: Int,
    title: String,
    subtitle: String?,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color(0xFF1e3a8a)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1e3a8a)
            )
        }

        if (subtitle != null) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF9ca3af)
            )
        }
    }
}

// ==================== COMPONENTE: SETTINGS ITEM SIMPLE (SEM ÍCONES) ====================
@Composable
fun SettingsItemSimple(
    title: String,
    subtitle: String?,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF1e3a8a)
        )

        if (subtitle != null) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                color = Color(0xFF9ca3af)
            )
        }
    }
}
