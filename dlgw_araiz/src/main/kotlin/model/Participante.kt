package model

import utils.ff

class Participante {

    var idParticipante = 0
    var partEmpresa = 0
    var partNome = ""
    var partEmail = ""
    var partAtivo = ""
    var partAceDt = ff.InicialDate
    var partCadDt = ff.InicialDate
    var partRamo: String? = null
    var partLogon = ""
    var partDtNasc = ff.InicialDate
    var partSexo = ""
    var partCelular = ""
    var partSenha = ""
    var partCliente = 0
    var partRepresentante = 0

}