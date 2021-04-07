package model

import utils.ff
import kotlin.js.Date


open class Funcionario {

    var ID_FUNCIONARIO = 0
    var FUNC_NOME = ""
    var FUNC_FONE = "" //: String? = null
    var FUNC_DTNASC = ff.InicialDate //: Date? = null
    var FUNC_SENHA = "" //: String? = null
    var FUNC_FUNCAO = ""
    var FUNC_AVISO1 = "" //: String? = null
    var FUNC_AVISO2 = "" //: String? = null
    var FUNC_AVISO3 = "" //: String? = null
    // var FUNC_IDFTP = "" //: String? = null
    // var FUNC_HOTSYNC = "" //: String? = null
    // var FUNC_PATHFTP = "" //: String? = null
    // var FUNC_HOST = "" //: String? = null
    // var FUNC_CONTRASE: Int? = null
    var FUNC_EMAIL = "" //: String? = null
    // var FUNC_EMHOST = "" //: String? = null
    // var FUNC_EMUSERID = "" //: String? = null
    // var FUNC_EMADDRESS = "" //: String? = null
    // var FUNC_EMNAME = "" //: String? = null
    // var FUNC_PASSFTP = "" //: String? = null
    var FUNC_CODCLI = 0 //: Int? = null
    var FUNC_VLDESLOC = 0.0 //: Double? = null
    // var FUNC_PERCCOMISS: Double? = null
    var FUNC_RAMO: Int = 0
    var FUNC_EMPRESA = 0
    var FUNC_GERENTE: Int? = null
    var FUNC_SUPERVISOR: Int? = null
    // var FUNC_CODCOMISSAO: Int? = null
    var FUNC_MOBILE = "" //: String? = null
    var FUNC_SISONLINE = ""
    var FUNC_VERBACOEF = 0.0 //: Double? = null
    var FUNC_USUARIO = "" //: String? = null
    var FUNC_GPS = "" //: String? = null
    var FUNC_MOBVERSAO = "" //: String? = null
    // var FUNC_PLACA = "" //: String? = null
    var FUNC_PASTA: Int? = null
    var FUNC_OBSERVACAO = "" //: String? = null
    var FUNC_LOGON = ""

    //campos do frontend
    var FUNC_TRANSPDOM00 = ""

    var FUNC__DTSERVIDOR = ff.InicialDate
    var FUNC__NOMEGERENTE = ""
    var FUNC__NOMESUPERV = ""


    //outros campos
    var EMP_VERBACLI00 = 0
    var EMP_DESCMAX00 = 0
    var EMP_ACRESMAX00 = 0
    var EMP_VERBACOEF00 = 0
    var EMP_MOBVERSAO00 = ""
    var ID_CLIENTE00 = 0
    var IDPARTICIPANTE00 = 0
}