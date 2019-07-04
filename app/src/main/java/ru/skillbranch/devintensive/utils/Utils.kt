package ru.skillbranch.devintensive.utils

/**
 * @author iamserj
 * 29.06.2019 1:39
 */

object Utils {

    fun parseFullName(fullName:String?):Pair<String?, String?> {
        val parts:List<String>? = fullName?.split(" ")

        // TODO: fix from tests user2 and user3
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        //TODO("not implemented")

        //return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {
        //TODO("not implemented")
        return "asdf"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        //TODO("no implemented")
        return "A.S.D.F."
    }

}