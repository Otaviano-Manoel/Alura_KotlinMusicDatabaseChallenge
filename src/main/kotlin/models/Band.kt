package models

// Classe que representa uma banda
class Band(
    val name: String = "Name Band",
    val description: String = "Description Band",
    val id: Int = 0
) {
    override fun toString(): String {
        return "$name ($id)"
    }
}