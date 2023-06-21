package com.example.visitsacompose.common.feature.login

import android.content.Context
import android.media.tv.TvContract.Channels.Logo
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.visitsacompose.ui.theme.CustomGray
import com.example.visitsacompose.ui.theme.Primary
import com.example.visitsacompose.ui.theme.Secondary
import com.example.visitsacompose.ui.theme.Typography
import com.example.visitsacompose.common.feature.register.RegisterEvent
import com.example.visitsacompose.common.feature.register.RegisterViewModel

@Composable
fun Register(
    onRegisterClicked: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    if (state.error != null) {
        Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
    }

    if (state.status != null) {
        onRegisterClicked()
    }

    Column() {
        Row(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Sign Up",
                style = Typography.titleMedium,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Secondary,
                        unfocusedContainerColor = Secondary,
                        disabledContainerColor = Secondary,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(20.dp),
                    value = username,
                    onValueChange = { newText ->
                        username = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 22.dp),
                    placeholder = {
                        Text(
                            text = "Enter username",
                            color = CustomGray,
                            style = Typography.bodyMedium,
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    },
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Secondary,
                        unfocusedContainerColor = Secondary,
                        disabledContainerColor = Secondary,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(20.dp),
                    value = email,
                    onValueChange = { newText ->
                        email = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 22.dp),
                    placeholder = {
                        Text(
                            text = "Enter email",
                            color = CustomGray,
                            style = Typography.bodyMedium,
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    },
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Secondary,
                        unfocusedContainerColor = Secondary,
                        disabledContainerColor = Secondary,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(20.dp),
                    value = password,
                    onValueChange = { newText ->
                        password = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 22.dp),
                    placeholder = {
                        Text(
                            text = "Enter password",
                            color = CustomGray,
                            style = Typography.bodyMedium,
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    },
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.state.handleEvent(
                            RegisterEvent.RegisterUser(
                                username,
                                email,
                                password
                            )
                        )
                    },
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(Primary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Sign In",
                        modifier = Modifier
                            .padding()
                            .padding(vertical = 8.dp, horizontal = 16.dp),
                        style = Typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
