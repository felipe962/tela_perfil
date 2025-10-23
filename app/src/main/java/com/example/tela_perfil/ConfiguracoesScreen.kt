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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tela_perfil.ui.theme.Tela_perfilTheme

// ==================== TELA: CONFIGURAÇÕES ====================
@Composable
fun ConfiguracoesScreen(navController: NavHostController) {
    var isDarkTheme by remember { mutableStateOf(false) }
    var showLogoutDialog by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, currentScreen = "perfil") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9FAFB))
                .padding(paddingValues)
        ) {
            HeaderSection(
                isDarkTheme = isDarkTheme, 
                onThemeToggle = { isDarkTheme = !isDarkTheme },
                onLogoutClick = { showLogoutDialog = true }
            )
            SettingsList()
        }
    }
    
    // Diálogo de confirmação de desconexão
    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = {
                Text(
                    text = "Tem certeza?",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E4A7A)
                )
            },
            text = {
                Text(
                    text = "Deseja realmente desconectar?",
                    color = Color(0xFF666666)
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        showLogoutDialog = false
                        // Aqui você pode adicionar a lógica de logout
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFDC2626)
                    )
                ) {
                    Text("Sim")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { showLogoutDialog = false },
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF2196F3)
                    )
                ) {
                    Text("Não")
                }
            },
            containerColor = Color.White,
            shape = RoundedCornerShape(16.dp)
        )
    }
}

// ==================== HEADER SECTION ====================
@Composable
fun HeaderSection(isDarkTheme: Boolean, onThemeToggle: () -> Unit, onLogoutClick: () -> Unit) {
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
            ) {}

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
                        onClick = onLogoutClick,
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
