package br.senai.sp.jandira.rick_morty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.rick_morty.R
import br.senai.sp.jandira.rick_morty.model.Character
import br.senai.sp.jandira.rick_morty.model.Result
import br.senai.sp.jandira.rick_morty.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Home(modifier: Modifier = Modifier){

    // Variável que guarda a lista de personagens delvovidos pela API
    var characterList = remember {
        mutableStateOf(listOf<Character>())
    }

    // Obter um Retrofit Factory
    var callCharacter = RetrofitFactory()
        .getCharacterService()
        .listAll()

    // Enviar a requisição
    // enqueue- enviar
    // Retorna um Result
    callCharacter.enqueue(object : Callback<Result>{
        override fun onResponse(p0: Call<Result>, response: Response<Result>) {
            characterList.value = response.body()!!.results
        }

        override fun onFailure(p0: Call<Result>, response: Throwable) {
            TODO("Not yet implemented")
        }

    })

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painterResource(R.drawable.rick_morty),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0x99000000))
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Rick & Morty",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Character List",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                // For if para criar os cards, no entanto não se utiliza pois ela sobrecarrega, cria todos de uma vez, deixando o sistema pessado
//                for(i in 1..5){
//                    CharacterCard()
//                }

                // Column preguiçosa agiliza a criação, e cria os itens só quando rolar a tela
                LazyColumn {
                    items(characterList.value){
                        CharacterCard(
                            name = it.name,
                            status = it.status,
                            specie = it.species,
                            image = it.image
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomePreview(){
    Home()
}