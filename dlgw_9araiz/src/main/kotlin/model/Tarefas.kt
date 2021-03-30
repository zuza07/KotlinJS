package model

open class Tarefas {
    var ID_TAREFA = 0
    var TAR_EMPRESA = 0
    var TAR_MENSAGEM = ""

    fun construtor(TAREFA: Int, EMPRESA: Int, MENSAGEM: String): Tarefas {
        this.ID_TAREFA = TAREFA
        this.TAR_EMPRESA = EMPRESA
        this.TAR_MENSAGEM = MENSAGEM
        return this
    }
}