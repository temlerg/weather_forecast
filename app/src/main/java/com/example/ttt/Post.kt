package com.example.ttt


class Post {
    class Codebeautify {
        // Setter Methods
        // Getter Methods
        var cod: String? = null
        var message = 0f
        var cnt = 40
        var list = ArrayList<Any>()
        var city: City? = null

    }

    class City {
        // Setter Methods
        // Getter Methods
        var id = 0f
        var name: String? = null
        var coord: Coord? = null
        var country: String? = null
        var population = 0f
        var timezone = 0f
        var sunrise = 0f
        var sunset = 0f

    }

    class Coord {
        // Setter Methods
        // Getter Methods
        var lat = 0f
        var lon = 0f

    }

}