package net.punklan.glorfindeil.example

/**
 * Created by st020794 on 28.04.2017.
 */
data class User(
        val name: String, var secondName: String, val middleName: String?)

data class Task(val description: String?, val id: Long, var user : User?)