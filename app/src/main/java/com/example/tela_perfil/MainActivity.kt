package com.example.tela_perfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tela_perfil.ui.theme.Tela_perfilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tela_perfilTheme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "perfil") {
        composable("perfil") {
            PerfilScreen(navController)
        }
        composable("configuracoes") {
            ConfiguracoesScreen(navController)
        }
    }
}

// ==================== COMPONENTE: BOTTOM NAVIGATION ====================
@Composable
fun BottomNavigationBar(navController: NavHostController, currentScreen: String) {
    NavigationBar(
        containerColor = Color(0xFF2196F3),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Início", tint = Color.White) },
            label = { Text("Início", color = Color.White, fontSize = 12.sp) },
            selected = currentScreen == "inicio",
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color(0xFF1976D2)
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = "Mapa",
                    tint = Color.White
                )
            },
            label = { Text("Mapa", color = Color.White, fontSize = 12.sp) },
            selected = currentScreen == "mapa",
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color(0xFF1976D2)
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil", tint = Color.White) },
            label = { Text("Perfil", color = Color.White, fontSize = 12.sp) },
            selected = currentScreen == "perfil",
            onClick = { navController.navigate("perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color(0xFF1976D2)
            )
        )
    }
}

// ==================== PREVIEWS ====================
@Preview(showBackground = true, name = "Tela Perfil")
@Composable
fun PerfilScreenPreview() {
    Tela_perfilTheme {
        val navController = rememberNavController()
        PerfilScreen(navController)
    }
}

@Preview(showBackground = true, name = "Tela Configurações")
@Composable
fun ConfiguracoesScreenPreview() {
    Tela_perfilTheme {
        val navController = rememberNavController()
        ConfiguracoesScreen(navController)
    }
}
