package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * @author iamserj
 * 28.06.2019 23:45
 */


// 1.1. Create data class User with properties.
data class User (                        // PRIMARY constructor
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    val lastVisit:Date? = Date(),
    val isOnline:Boolean = false
){

    // SECONDARY constructor
    constructor(id:String, firstName:String?, lastName:String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id:String) : this(
        id = id,
        firstName = "John",
        lastName = "Doe"
    )

    init {
        println("Create User instance: first = $firstName, last = $lastName")
                //"${if(lastName==="Doe") "His name is $firstName $lastName" else "This is Mr. $firstName $lastName"}\n")
    }


    /*
    fun printMe():Unit {
        println("""
            id : $id
            ...
        """.trimIndent())
    }
     */
    fun printMe() = println("""
            id : $id
            firstName : $firstName
            lastName : $lastName
            avatar : $avatar
            rating : $rating
            respect : $respect
            lastVisit : $lastVisit
            isOnline : $isOnline
        """.trimIndent())



    // 1.2. Implement Factory pattern including method makeUser(fullName) where fullName argument is user's full name. Return User class instance.
    companion object Factory {
        private var lastId:Int = -1

        fun makeUser(fullName:String?) : User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }

    }



}

