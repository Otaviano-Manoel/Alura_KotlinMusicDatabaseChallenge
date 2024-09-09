package Data

import extensions.ToEntity
import extensions.ToModel
import models.Record
import javax.persistence.EntityManager

// Classe para a manipulação da tabela "records".
// Herda do DAO que possui os metodos de manipulação
// manager = A Instancia da conexão com o DB.
class RecordDAO(manager: EntityManager): DAO<RecordEntity, Record>(manager, RecordEntity::class.java) {
    // Converte o modelo que é utilizado no codigo para a entidade do banco de dados
    override fun ToEntity(model: Record): RecordEntity {
        // Extensão da classe Record responsavel pela conversão
        return  model.ToEntity()
    }

    // Converte a entidade do banco de dados para o modelo utilizado no codigo.
    override fun ToModel(entity: RecordEntity): Record {
        // Extensão da classe RecordEntity responsavel pela conversão
        return entity.ToModel()
    }
}