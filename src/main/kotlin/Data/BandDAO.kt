package Data

import extensions.ToEntity
import extensions.ToModel
import models.Band
import javax.persistence.EntityManager

// Classe para a manipulação da tabela "bands".
// Herda do DAO que possui os metodos de manipulação
// manager = A Instancia da conexão com o DB.
class BandDAO(manager: EntityManager): DAO<BandEntity, Band>(manager, BandEntity::class.java) {
    // Converte a entidade do banco de dados para o modelo utilizado no codigo.
    override fun ToEntity(model: Band): BandEntity {
        // Extensão da classe Band responsavel pela conversão
        return model.ToEntity()
    }

    // Converte o modelo que é utilizado no codigo para a entidade do banco de dados
    override fun ToModel(entity: BandEntity): Band {
        // Extensão da classe BandEntity responsavel pela conversão
        return entity.ToModel()
    }
}