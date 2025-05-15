package br.senai.sp.jandira.rick_morty.service

import br.senai.sp.jandira.rick_morty.model.Character
import br.senai.sp.jandira.rick_morty.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    // Colocar o metodo e o restante da URL
    @GET("character")
    //Criar um funcáo para devolver uma lista de personagens, fazendo uma chamada pelo Result
    fun listAll(): Call<Result>

    @GET("character/{id}")
    //Busca pelo ID retorna apenas um personagem
    //Path- serve para passar um atributo na hora da pesquisa
    fun findById(@Path("id") id: Int): Call<Character>
}