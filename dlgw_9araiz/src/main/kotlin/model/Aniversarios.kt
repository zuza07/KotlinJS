package model

import utils.ff

class Aniversarios {
    var ID_ANIVERSARIO = 0
    var ID_CLIENTE = 0
    var ANI_EMPRESA = 0
    var ANI_ATIVO = ""
    var ANI_NOME = ""
    var ANI_DATA = ff.InicialDate
    var ANI_SETOR = ""
    var ANI_SEXO = ""
    var ANI_FONE = ""
    var ANI_RESIDENCIAL = ""
    var ANI_RAMAL = ""
    var ANI_EMAIL = ""
    var ANI_CELULAR = ""
    var ANI_ALTERNATIVO = ""
    var ANI_LOGON = ""
    var ANI_DTLOGON = ff.InicialDate
    var ANI_DTALTCAD = ff.InicialDate
    var ANI_USUALT = ""
    var ANI_PASS = ""
    var ANI_RECURSOS = ""

    var ANI_IDEMPRESA00 = 0
    var ANI_IDCLIENTE00 = 0
    var ANI_ID00 = 0
    var ANI_DELETE00 = ""
    var ANI__ANI = 0
    var CLI__NOME = ""
    var CLI_LIB00 = ""
    var ID_FUNCIONARIO00 = 0
    var ANI_LOGONANT00 = ""

    fun primaryKey(): String {
        return "ANI_ID00,ANI_IDCLIENTE00"
    }

//    class AniLogon {
//        var ID_ANIVERSARIO: Int? = null //deve sempre permitir o null
//        var ANI_LOGON: String = ""
//        var ANI_PASS: String = ""
//        var ID_CLIENTE: Int = 0
//        var ANI_EMPRESA: Int = 0
//        var ANI_NOME: String = ""
//        var ANI_EMAIL: String = ""
//        var CLI_LIB: String = ""
//
//        var ANI_IDEMPRESA00 = 0
//        var ANI_IDCLIENTE00 = 0
//        var ANI_ID00 = 0
//        var ID_FUNCIONARIO00 = 0
//    }


}