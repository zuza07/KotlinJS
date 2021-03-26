package model

class Produtofcp {
    var ID_FCP = 0
    var PFCP_UF = ""
    var PFCP_NCM = ""
    var PFCP_INDICE = 0.0

    fun construtor(FCP: Int, UF: String, NCM: String, INDICE: Double): Produtofcp {
        this.ID_FCP = FCP
        this.PFCP_UF = UF
        this.PFCP_NCM = NCM
        this.PFCP_INDICE = INDICE
        return this
    }
}