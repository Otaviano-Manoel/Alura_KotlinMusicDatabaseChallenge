package Data

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

// Indica que a classe é uma entitdade do BD
@Entity
// Seta o nome da tabela a qual a classe pertence
@Table(name = "Bands")
// Classe da Entidade que sera salvo no BD
// Nenhuma de suas variaveis podem ser nulas.
class BandEntity(
    val name: String = "Name Band",
    val description: String = "Description Band",
    // Id indica a chave primaria
    // GenerateValue = faz o auto incremento no ID para não repetir.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}