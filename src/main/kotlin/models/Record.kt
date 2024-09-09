package models

// Classe que representa um album
class Record(
    val title: String = "Title Record",
    // Banda a qual o album pertence.
    val band: Band = Band(),
    val id: Int = 0
) {
    override fun toString(): String {
        return "$title ($id) - $band"
    }
}