package Data

import javax.persistence.EntityManager

// Classe abstrata DAO para manipulação de entidades do banco de dados.
// TEntity representa a entidade persistida no banco de dados.
// TModel representa o modelo de domínio usado no código.
abstract class DAO<TEntity, TModel>(
    // O EntityManager é utilizado para interagir com o banco de dados.
    val manager: EntityManager,
    // O entityType armazena o tipo da entidade correspondente à classe TEntity.
    protected val entityType: Class<TEntity>) {

    // Método abstrato que converte um modelo (TModel) para uma entidade (TEntity).
    abstract fun ToEntity(model: TModel): TEntity

    // Método abstrato que converte uma entidade (TEntity) para um modelo (TModel).
    abstract fun ToModel(entity: TEntity): TModel

    // Método para adicionar uma nova entidade no banco de dados a partir de um modelo (TModel).
    open fun Add(model: TModel){
        // Converte o modelo em uma entidade.
        val entity = ToEntity(model)
        // Inicia uma transação para persistir a entidade no banco de dados.
        manager.transaction.begin()
        manager.persist(entity)
        // Finaliza a transação, confirmando as alterações.
        manager.transaction.commit()
    }

    // Método que recupera uma entidade do banco de dados pelo seu ID e a converte para um modelo (TModel).
    open fun RecoveredBy(id: Int): TModel{
        val entity = RecoveredEntityById(id)
        // Converte para um modelo
        return ToModel(entity)
    }

    // Metodo que faz a query de busca e retorna a entidade.
    private fun RecoveredEntityById(id: Int): TEntity{
        // Cria uma consulta JPQL para buscar a entidade com o ID especificado.
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        // Obtém a entidade.
        return query.singleResult
    }

    // Método que remove uma entidade do banco de dados pelo seu ID.
    open fun Delete(id: Int){
        val entity = RecoveredEntityById(id)
        // Inicia uma transação para remover a entidade.
        manager.transaction.begin()
        manager.remove(entity)
        // Finaliza a transação, confirmando a remoção.
        manager.transaction.commit()
    }

    // Método que retorna uma lista de modelos (TModel) correspondentes a todas as entidades do tipo TEntity no banco.
    open fun GetList(): List<TModel>{
        // Cria uma consulta JPQL para obter todas as entidades do tipo especificado (entityType).
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        // Mapeia as entidades retornadas para seus respectivos modelos e retorna a lista.
        return query.resultList.map { entity -> ToModel(entity) }
    }
}