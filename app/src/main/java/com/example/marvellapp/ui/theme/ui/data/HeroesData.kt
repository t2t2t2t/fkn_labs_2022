package com.example.marvel_app_android.ui.data

data class Hero(
    val image: String,
    val name: String,
    val description: String,

    )

object HeroesData {
    val heros = listOf(
        Hero(
            "https://github.com/t2t2t2t/HeroImage/blob/main/doctor_strange.jpg?raw=true"
            ,
            "Doctor strange",
            "You Have To Be The One Holding The Knife"

        ),
        Hero(
            "https://github.com/t2t2t2t/HeroImage/blob/main/deadpool.png?raw=true",
            "Deadpool",
            "A Fourth Wall Break Inside A Fourth Wall Break?"

        ),
        Hero(
            "https://github.com/t2t2t2t/HeroImage/blob/main/spider_man.jpg?raw=true",
            "Spider man",
            "No matter what I do, no matter how hard I try, the ones I love will always be the ones who pay."

        ),

           Hero(
               "https://github.com/t2t2t2t/HeroImage/blob/main/iron_man.png?raw=true",
               "Iron man",
               "The Truth is… I am Iron Man."

           ),



            Hero(
                "https://github.com/t2t2t2t/HeroImage/blob/main/thor.jpg?raw=true",
                "Thor",
                "I am Thor, son of Odin!"

            ),
        Hero(
            "https://github.com/t2t2t2t/HeroImage/blob/main/black%20widow.jpg?raw=true",
            "Black widow",
            "Eyes on the road"

        ),
        Hero(
            "https://github.com/t2t2t2t/HeroImage/blob/main/Rocket.jpg?raw=true",
            "Rocket Raccoon",
            "I live for the simple things… like how much this is gonna hurt."

        ),


    )

}