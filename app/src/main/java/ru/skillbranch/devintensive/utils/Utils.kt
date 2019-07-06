package ru.skillbranch.devintensive.utils

/**
 * @author iamserj
 * 29.06.2019 1:39
 */

object Utils {
    // 3. Implement method Utils.parseFullName(fullName) with argument containing full user name (null, empty string)
    // and returning a pair of values Pair(firstName, lastName)
    // If full name or a part of it is not parsable, return null null or "firstName" null
    // Examples:
    // Utils.parseFullName(null) // null null
    // Utils.parseFullName("") // null null
    // Utils.parseFullName(" ") // null null
    // Utils.parseFullName("John") // John null
    fun parseFullName(fullName:String?):Pair<String?, String?> {
        val parts = fullName?.trim()?.split(" ")
        val firstName = parts?.getOrNull(0)?.ifEmpty { null }
        val lastName = parts?.getOrNull(1)?.ifEmpty { null }
        // return Pair(firstName, lastName)
        // same as:
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