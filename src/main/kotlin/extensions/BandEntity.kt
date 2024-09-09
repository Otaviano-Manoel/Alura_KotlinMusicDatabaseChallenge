package extensions

import Data.BandEntity
import models.Band

// Transforma o Band no tipo BandEntity que é utilizado no banco de dados.
fun Band.ToEntity(): BandEntity{
    return BandEntity(this.name, this.description, this.id)
}

// Transforma o BandEntity no tipo Band que é utilizado no codigo.
fun BandEntity.ToModel(): Band{
    return Band(this.name, this.description, this.id)
}