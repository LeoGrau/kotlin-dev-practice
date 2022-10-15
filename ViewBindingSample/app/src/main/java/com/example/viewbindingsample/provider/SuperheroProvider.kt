package com.example.viewbindingsample.provider

import com.example.viewbindingsample.model.Superhero

class SuperheroProvider {
    companion object {
       var superheroList:List<Superhero> = listOf(
           Superhero("Spider-man"),
           Superhero("Superman"),
           Superhero("Daredevil"),
           Superhero("Hulk")
       )
    }
}