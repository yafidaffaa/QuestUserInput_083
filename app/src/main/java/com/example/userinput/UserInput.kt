package com.example.userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun UserInput(
    modifier: Modifier = Modifier
) {
    var name by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("laki-laki", "perempuan")

    var confirName by rememberSaveable { mutableStateOf("") }
    var confirmEmail by remember { mutableStateOf("") }
    var confirmAlamat by remember { mutableStateOf("") }
    var confirmNoHP by remember { mutableStateOf("") }
    var confirmSelectedGender by remember { mutableStateOf("") }

    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp)
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            placeholder = { Text("Masukan Nama")},
            label = { Text("Nama")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        )

        Row {
            jenisKelamin.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    RadioButton(selected = selectedGender==item, onClick = {
                        selectedGender = item
                    })
                    Text(text = item)
                }
            }
        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukan email")},
            label = { Text("Email")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        )
        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukan alamat")},
            label = { Text("alamat")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        )
        OutlinedTextField(
            value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukan no HP")},
            label = { Text("no HP")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        )

        Button(onClick = {
            confirName = name
            confirmEmail = email
            confirmAlamat = alamat
            confirmNoHP = noHP
            confirmSelectedGender = selectedGender
        }) {
            Text(text = "Save")
        }

        Card(modifier.size(height = 200.dp, width = 300.dp)) {
            cardSection(judulParam = "Nama", isiParam = confirName)
            cardSection(judulParam = "Jenis Kelamin", isiParam = confirmSelectedGender)
            cardSection(judulParam = "Alamat", isiParam = confirmAlamat)
            cardSection(judulParam = "No HP", isiParam = confirmNoHP)
            cardSection(judulParam = "Email", isiParam = confirmEmail)

        }


    }
}

@Composable
fun cardSection(judulParam: String, isiParam: String) {
    Column (horizontalAlignment = Alignment.Start) {


        Row (modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start

        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f).padding(start = 10.dp))
            Text(text = ":", modifier = Modifier.weight(0.2f).padding(start = 10.dp))
            Text(text = isiParam, modifier = Modifier.weight(2f).padding(start = 10.dp))
        }
    }
}
