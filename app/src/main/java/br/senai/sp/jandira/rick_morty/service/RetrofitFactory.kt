package br.senai.sp.jandira.rick_morty.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "https://rickandmortyapi.com/api/"

    // Chama o Retrofict
    // Builder: o construtor do retrofit ele precisa receber a URL
    // Precisa adicionar um conversor( para converter o JSON para um objeto Kotlin
    private val RETROFIT_FACTORY = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCharacterService() : CharacterService{
        return RETROFIT_FACTORY
            .create(CharacterService::class.java)
        // Criar o serviço
    }
}