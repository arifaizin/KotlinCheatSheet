fun main() {

    //DECLARING VARIABLE

    //val vs var
    val myName: String = "Dico" // cannot be reassigned
    var myAge: Int = 7 // can be reassigned
    myAge++

    //type inference
    val oneMillion = 1_000_000 //Int → underscore for readable
    val weight = 60.2 //Double

    //built-in function
    println(myName.uppercase()) //convert to upper case
    println(oneMillion.toString()) //parse to String
    println(weight.plus(6)) //operator method

    //string template
    println("Number of char in $myName \nis ${myName.length}") //escaped string

    //nullable type
    val text: String? = null
    //safe call operator
    val textLength = text?.length ?: 0 //elvis operator
    
    //CONTROL FLOW

    //if statement
    val now = 7
    if (now > 7 && now <= 17) {
        println("Office already open")
    } else if (now == 7){
        println("Wait a minute")
    } else {
        println("Office is closed")
    }

    //when expression
    val officeStatus = when(now) {
        12, 15 -> "Rest time"
        in 8..17 -> "Office already open"
        7 -> "Wait a minute"
        is Int -> "Int"
        else -> "Office is closed"
    }
    println(officeStatus)

    //while --> Check before execute
    var x = 0
    while (x <= 5){
        println("While $x")
        x++
    }

    //do while --> Execute before check
    var y = 0
    do {
        println("Do While $x")
        y++
    } while (y <= 5)

    //for --> loop without counter
    for (i in 0..5){
        println("for $i")
    }
    for (i in 0 until 5){} //0 to 4
    for (i in 0..5 step 2){} //1,3,5
    for (i in 5 downTo 1){} //5 to 1

    repeat(5) {
        println("value is $it")
    }

    val array = arrayOf("A", "B", "C")
    for (element in array) {
        println(element)
    }
    array.forEach { element ->
        println(element)
    }

    //DATA CLASS
    val dataUser = DataUser("arif", 17)
    println(dataUser) //DataUser(name=arif, age=17)
    //set data
    dataUser.name = "faizin"
    dataUser.age = 24
    //get data
    val userName = dataUser.name
    val userAge = dataUser.age
    //destructuring declarations
    val (name,age) = dataUser
    println("My name is $name, I am $age years old")

    //COLLECTIONS
    // List: to store independent values ​​with index (may be the same)
    val integerList = mutableListOf(4, 2, 1, 5, 1, 2)// [4, 2, 1, 5, 1, 2]
    integerList[3] = 4 // [4, 2, 1, 4, 1, 2]

    // Set: to store unique values
    val integerSet = setOf(4, 2, 1, 5, 1, 2) // [4, 2, 1, 5]
    integerSet.filter { it % 2 == 0 } // 2, 4
    integerSet.map { it * 5 } //10, 20
    integerSet.sortedDescending() // 5, 4, 2, 1

    // Map: to save in key to value format, unique keys cannot be the same.
    val capital = mapOf(
        "Jakarta" to "Indonesia",
        "London" to "England",
        "New Delhi" to "India"
    )
    println(capital["Jakarta"]) //Indonesia

    //extension
    println(10000.formatRupiah) //Rp 10000
    println("Password".isMoreThan6Char()) //true

    //Lambda
    val message :(String) -> String = { name: String ->
        "Hello $name"
    }
    //higher prder function
    printMessage("Dicoding", message)
    //move the variable directly in function
    printMessage("Dicoding", { name: String ->
        "Hello $name"
    })
    //if lambda in the last parameter, we can move to outside parantheses
    printMessage("Dicoding") { name: String ->
        "Hello $name"
    }
    // function reference
    printMessage("Dicoding", ::welcomeMessage)



}

//Data Class 2
data class DataUser(var name : String, var age : Int)

//KOTLIN FUNCTION
private fun setUser(name: String, age: Int): String {
    return "Your name is $name, and you $age years old"
}

//named argument
val word = getWord(middle=" is ", last="Awesome")
//single expression, default argumeny
fun getWord(first: String = "Java", middle: String, last: String) = "$first $middle $last"

//Extension 2
val Int.formatRupiah: String
    get() = "Rp $this"

fun String.isMoreThan6Char(): Boolean {
    return this.length > 6
}

//Higher-order Function
fun printMessage(name: String, message: (String) -> String) {
    println(message(name))
}

fun welcomeMessage(name: String) = "Hello $name"

//Without DSL
val message = buildString()
fun buildString(): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append("Hello ")
    stringBuilder.append("from ")
    stringBuilder.append("lambda")
    return stringBuilder.toString()
}

//With DSL
val messageDSL = buildStringWithDSL {
    append("Hello ")
    append("from ")
    append("lambda")
}

fun buildStringWithDSL(action:StringBuilder.() ->Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.action()
    return stringBuilder.toString()
}




