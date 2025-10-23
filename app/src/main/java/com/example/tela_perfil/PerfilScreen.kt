    package com.example.tela_perfil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tela_perfil.ui.theme.Tela_perfilTheme

// ==================== TELA: MEU PERFIL ====================
@Composable
fun PerfilScreen(navController: NavHostController) {
    var isEditing by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("nicolasemail@email.com") }
    var endereco by remember { mutableStateOf("R. Bananeira, 40") }
    var telefone by remember { mutableStateOf("(11) 12345-6789") }
    
    var emailError by remember { mutableStateOf(false) }
    var telefoneError by remember { mutableStateOf(false) }

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
                // Logo "PAS" no canto superior esquerdo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo PAS",
                    modifier = Modifier
                        .height(90.dp)
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
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Configurações",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }

                // Texto "Meu Perfil"
                Text(
                    text = "Meu Perfil",
                    fontSize = 30.sp,
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
                        icon = Icons.Filled.Person,
                        label = "Nome",
                        value = "Nicolas Silva de Almeida Santos"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = Icons.Filled.Info,
                        label = "CPF",
                        value = "123.456.789-00"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = Icons.Filled.LocationOn,
                        label = "Naturalidade",
                        value = "Barueri/SP"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = Icons.Filled.Star,
                        label = "Nascimento",
                        value = "10/10/2007"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DataItem(
                        icon = Icons.Filled.AccountCircle,
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

                    if (isEditing) {
                        DataItemEditable(
                            icon = Icons.Filled.Email,
                            label = "E-mail",
                            value = email,
                            onValueChange = { 
                                email = it
                                emailError = !it.contains("@")
                            },
                            isError = emailError,
                            errorMessage = "E-mail não identificado. Deve conter @"
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        DataItemEditable(
                            icon = Icons.Filled.Place,
                            label = "Endereço",
                            value = endereco,
                            onValueChange = { endereco = it },
                            isError = false,
                            errorMessage = null
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        DataItemEditable(
                            icon = Icons.Filled.Phone,
                            label = "Telefone",
                            value = telefone,
                            onValueChange = { 
                                telefone = it
                                telefoneError = it.replace(Regex("[^0-9]"), "").length != 10
                            },
                            isError = telefoneError,
                            errorMessage = "Número de telefone inválido. Deve ter exatamente 10 dígitos"
                        )
                    } else {
                        DataItem(
                            icon = Icons.Filled.Email,
                            label = "E-mail",
                            value = email
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        DataItem(
                            icon = Icons.Filled.Place,
                            label = "Endereço",
                            value = endereco
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        DataItem(
                            icon = Icons.Filled.Phone,
                            label = "Telefone",
                            value = telefone
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ====== BOTÕES EDITAR / SALVAR / CANCELAR ======
            if (isEditing) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    OutlinedButton(
                        onClick = { 
                            isEditing = false
                            email = "nicolasemail@email.com"
                            endereco = "R. Bananeira, 40"
                            telefone = "(11) 12345-6789"
                            emailError = false
                            telefoneError = false
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFF2196F3)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Cancelar",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Button(
                        onClick = { 
                            if (!emailError && !telefoneError) {
                                isEditing = false
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (emailError || telefoneError) Color(0xFFCCCCCC) else Color(0xFF4CAF50)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        enabled = !emailError && !telefoneError
                    ) {
                        Text(
                            text = "Salvar",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            } else {
                Button(
                    onClick = { 
                        isEditing = true
                        emailError = false
                        telefoneError = false
                    },
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
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

// ==================== COMPONENTE: DATA ITEM ====================
@Composable
fun DataItem(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = icon,
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

// ==================== COMPONENTE: DATA ITEM EDITÁVEL ====================
@Composable
fun DataItemEditable(
    icon: ImageVector, 
    label: String, 
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF1E4A7A),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color(0xFF888888)
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF1E4A7A)
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = if (isError) Color(0xFFDC2626) else Color(0xFF2196F3),
                    unfocusedBorderColor = if (isError) Color(0xFFDC2626) else Color(0xFFCCCCCC),
                    errorBorderColor = Color(0xFFDC2626)
                ),
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                isError = isError
            )
            
            if (isError && errorMessage != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = errorMessage,
                    fontSize = 12.sp,
                    color = Color(0xFFDC2626),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

