package net.punklan.glorfindeil.example

/**
 * Created by st020794 on 28.04.2017.
 */

fun main(args: Array<String>) {
    println("Hello, world!")
    val user = User(name = "Ivan",
            middleName = null, secondName = "Family2222")
    val user2 = User(name = "Name2",
            middleName = null, secondName = "Family21111")

    val task = Task(description = "desc", id = 12, user = user)
    println(task.user?.name)
    task.user?.secondName = "New secondName"
    println(task.user)

    val list: List<User> = listOf(user, user2)
    println("Name is ${task.user!!.name}")

    val task2 = Task(description = "desc", id = 12, user = null)

    println(task.user?.name?.takeLastTwo)
    // println(task2.user!!.name)
    println(list[0])


}

private val  String.takeLastTwo: String
    get() {
       return this.takeLast(2)
    }
