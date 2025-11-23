package com.example.iniciorapido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.iniciorapido.ui.theme.InicioRapidoTheme
import android.content.Intent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InicioRapidoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaInicio(
                        modifier = Modifier.padding(innerPadding),
                        onHomeClick = {
                            startActivity(Intent(this, HomeActivity::class.java))
                        },
                        onWorkClick = {
                            startActivity(Intent(this, WorkActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaInicio(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onWorkClick: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "¿A donde quieres dirigirte?",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(20.dp))

                // 🔵 Botón principal (ya existente)
                Button(onClick = { /* Aquí puedes poner otra navegación */ }) {
                    Text("Página Principal")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 🟢 Botón Home
                Button(onClick = onHomeClick) {
                    Text("Home")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 🔴 Botón Work
                Button(onClick = onWorkClick) {
                    Text("Work")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    InicioRapidoTheme {
        PantallaInicio()
    }
}
