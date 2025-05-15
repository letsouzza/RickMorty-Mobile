package br.senai.sp.jandira.rick_morty.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.rick_morty.model.Character
import coil.compose.AsyncImage

@Composable
fun CharacterCard(

    name: String = "Nome do personagem",
    specie: String = "Espécie do personagem",
    status: String = "Status do personagem",
    image: String = "URL da imagem"

) {
    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .height(100.dp),
        border = BorderStroke(2.dp, Color(0xFF6733CC)),
        colors = CardDefaults.cardColors(Color(0xaaFFFFFF))
    ){
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(85.dp),
                colors = CardDefaults.cardColors(Color.Magenta),
                shape = CircleShape
            ){
                AsyncImage(
                    model = image,
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = name)
                Text(text = specie)
                Text(text = status)
            }
        }
    }
}

@Preview
@Composable
private fun CharacterCardPreview() {
    CharacterCard()
}