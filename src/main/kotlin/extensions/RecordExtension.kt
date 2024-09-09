package extensions

import Data.RecordEntity
import models.Record

// Transforma o Record no tipo RecordEntity que é utilizado no banco de dados.
fun Record.ToEntity(): RecordEntity{
    return RecordEntity(this.title, this.band.ToEntity(), this.id)
}
// Transforma o RecordEntity no tipo Record que é utilizado no codigo.
fun RecordEntity.ToModel(): Record{
    return Record(this.title, this.band.ToModel(), this.id)
}