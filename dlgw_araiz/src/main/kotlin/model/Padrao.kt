package model

import utils.ff


open class Padrao {

    var PAD_CODIGO = 0
    var PAD_SITUAC = ""

    var PAD_TELA = ""
    var PAD_CONTEUDO = ""

    fun ini(CODIGO: Int, SITUAC: String): Padrao {

        this.PAD_CODIGO = CODIGO
        this.PAD_SITUAC = SITUAC

        return this
    }
}

