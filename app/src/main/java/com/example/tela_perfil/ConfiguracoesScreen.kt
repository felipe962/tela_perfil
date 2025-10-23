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
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Topo com fundo azul e círculos decorativos sobrepostos
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color(0xFF1B5283))
            ) {
                // Primeiro círculo (mais à esquerda)
                Box(
                    modifier = Modifier
                        .offset(x = (-50).dp, y = (-80).dp)
                        .size(250.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF0D3A5C).copy(alpha = 0.4f))
                )
                
                // Segundo círculo (centro)
                Box(
                    modifier = Modifier
                        .offset(x = 80.dp, y = (-60).dp)
                        .size(230.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF0D3A5C).copy(alpha = 0.3f))
                )
                
                // Terceiro círculo (mais à direita)
                Box(
                    modifier = Modifier
                        .offset(x = 200.dp, y = (-70).dp)
                        .size(240.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF0D3A5C).copy(alpha = 0.35f))
                )
            }

            Spacer(modifier = Modifier.height(70.dp))

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

        // Card branco com imagem de perfil - sobreposto
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 80.dp)
                .size(120.dp)
                .shadow(8.dp, RoundedCornerShape(24.dp))
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Avatar",
                modifier = Modifier.size(80.dp)
            )
        }
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
