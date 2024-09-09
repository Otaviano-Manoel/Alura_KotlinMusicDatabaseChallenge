package Data

import models.Band
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToOne

// Indica que a classe é uma entitdade do BD
@Entity
// Seta o nome da tabela a qual a classe pertence
@Table(name = "records")
class RecordEntity(
    val title: String = "Title Record",
    // Indica que varios albuns podem ter uma banda.
    @ManyToOne
    val band: BandEntity = BandEntity(),
    // Id indica a chave primaria
    // GenerateValue = faz o auto incremento no ID para não repetir.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}