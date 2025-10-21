package com.example.tela_perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// ==================== TELA: MEU PERFIL ====================
@Composable
fun PerfilScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController, currentScreen = "perfil") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
        ) {
            // ====== HEADER AZUL COM PAS E ÍCONE DE CONFIGURAÇÕES ======
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFF1B5283))
            ) {
                // Círculo de fundo decorativo
                Box(
                    modifier = Modifier
                        .offset(x = 150.dp, y = (-50).dp)
                        .size(250.dp)
                        .clip(androidx.compose.foundation.shape.CircleShape)
                        .background(Color(0xFF0D3A5C).copy(alpha = 0.3f))
                )

                // Logo "PAS" no canto superior esquerdo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo PAS",
                    modifier = Modifier
                        .height(40.dp)
                        .width(100.dp)
                        .padding(start = 20.dp, top = 16.dp)
                        .align(Alignment.TopStart)
                )

                // Ícone de configurações (engrenagem)
                IconButton(
                    onClick = { navController.navigate("configuracoes") },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 100.dp)
                        .align(Alignment.CenterStart)
                        .size(48.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = "Configurações",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }

                // Texto "Meu Perfil"
                Text(
                    text = "Meu Perfil",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(y = (-20).dp)
                )

                // CARD BRANCO COM ÍCONE DE PERFIL
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = 60.dp)
                        .size(120.dp)
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

            Spacer(modifier = Modifier.height(70.dp))

            // ====== CARD DADOS PESSOAIS ======
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Dados pessoais",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E4A7A)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    DataItem(
                        icon = R.drawable.ic_person,
                        label = "Nome",
                        value = "Nicolas Silva de Almeida Santos"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = R.drawable.ic_id_card,
                        label = "CPF",
                        value = "123.456.789-00"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = R.drawable.ic_location,
                        label = "Naturalidade",
                        value = "Barueri/SP"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = R.drawable.ic_calendar,
                        label = "Nascimento",
                        value = "10/10/2007"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = R.drawable.ic_mother,
                        label = "Nome da Mãe",
                        value = "Aline Silva de Almeida Santos"
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ====== CARD DADOS DE CADASTRO ======
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Dados de cadastro",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E4A7A)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    DataItem(
                        icon = R.drawable.ic_email,
                        label = "E-mail",
                        value = "nicolasemail@email.com"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = R.drawable.ic_pin,
                        label = "Endereço",
                        value = "R. Bananeira, 40"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = R.drawable.ic_phone,
                        label = "Telefone",
                        value = "(11) 12345-6789"
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ====== BOTÃO EDITAR ======
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Editar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

// ==================== COMPONENTE: DATA ITEM ====================
@Composable
fun DataItem(icon: Int, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(0xFF1E4A7A),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color(0xFF888888)
            )
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF1E4A7A)
            )
        }
    }
}
