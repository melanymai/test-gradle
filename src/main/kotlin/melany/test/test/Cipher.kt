package melany.test.test

class Cipher {

    fun cipher(character: Char, key: Int): Char {

        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        // if character is not in the alphabet return a space
        if (!alphabet.contains(character) || key < 0 || key > 26) {
            return ' '
        }

        val index = alphabet.indexOf(character)
        val newIndex = (index + key) % 26

        return alphabet[newIndex]
    }
}