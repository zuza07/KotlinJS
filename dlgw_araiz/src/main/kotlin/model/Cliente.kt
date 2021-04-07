package model

import utils.ff
import kotlin.js.Date

class Cliente {

    var ID_CLIENTE = 0
    var CLI_NOME = ""
    var CLI_FANT = ""
    var CLI_RUA = ""
    var CLI_NUMERO = ""
    var CLI_COMPL = ""
    var CLI_BAIRRO = ""
    var CLI_CID = ""
    var CLI_UF = ""
    var CLI_CEP = ""
    var CLI_CXPOSTAL = ""
    var CLI_PAIS = ""
    var CLI_DTUCOMP: Date? = null
    var CLI_DTINCL: Date? = null
    var CLI_DTNASC: Date? = null
    var CLI_USUALT = ""
    var CLI_IE = ""
    var CLI_CNPJ = ""
    var CLI_CPF = ""
    var CLI_OBS = ""
    var CLI_REFER = ""
    var CLI_REFER2 = ""
    var CLI_REFER3 = ""
    var CLI_LIB = ""
    var CLI_WEBSITE = ""
    var CLI_ACEITATMK = ""
    var CLI_FPAG = 0
    var CLI_COND = 0
    var CLI_FPGFIXA = ""
    var CLI_TRANSP = 0
    var CLI_ENTRUA = ""
    var CLI_ENTCOMPL = ""
    var CLI_ENTBAIRRO = ""
    var CLI_ENTCID = ""
    var CLI_ENTUF = ""
    var CLI_ENTCEP = ""
    var CLI_ENTPTOREF = ""
    var CLI_COBRUA = ""
    var CLI_COBCOMPL = ""
    var CLI_COBBAIRRO = ""
    var CLI_COBCID = ""
    var CLI_COBUF = ""
    var CLI_COBCEP = ""
    var CLI_RAMO = 0
    var CLI_CLASSIFIC = 0
    var CLI_REGIAO = 0
    var CLI_RPA = ""
    var CLI_RPADESC = 0.0
    var CLI_HORENTR = ""
    var CLI_HORVEND = ""
    var CLI_MEDIA: Int? = null
    var CLI_VENDAACUM = ""
    var CLI_CREDLIB = ""
    var CLI_DTLIB: Date? = null
    var CLI_LIMITE = 0.0
    var CLI_USUCAD = ""
    var CLI_LOGIN1 = ""
    var CLI_SENHA1 = ""
    var CLI_NOME1 = ""
    var CLI_LOGIN2 = ""
    var CLI_SENHA2 = ""
    var CLI_NOME2 = ""
    var CLI_ENTSEG = ""
    var CLI_ENTTER = ""
    var CLI_ENTQUA = ""
    var CLI_ENTQUI = ""
    var CLI_ENTSEX = ""
    var CLI_ENTSAB = ""
    var CLI_TAXACOBR = ""
    var CLI_PERCCOMISS = 0.0
    var CLI_CLIFOR = ""
    var CLI_DIASENTR = 0
    var CLI_PRAZOPAG = 0
    var CLI_TPFRETE = ""
    var CLI_TPCOMPRA = ""
    var CLI_ACEITATROCA = ""
    var CLI_CONSVAREJO = ""
    var CLI_IDMMN = 0
    var CLI_IDMMNPAI = 0
    var CLI_ORDEMENTR = 0
    var CLI_EMPRESA = 0
    var CLI_SUFRAMA = ""
    var CLI_DTUPED: Date = ff.InicialDate
    var CLI_REDE: Int? = null
    var CLI_PRODDIASVENC = 0
    var CLI_CLIENTEANT = ""
    var CLI_OBSNOTA = ""
    var CLI_CPGINDICE = ""
    var CLI_OBSOUTRAS = ""
    var CLI_CODCONTABIL = ""
    var CLI_ESTCONTROLE = ""
    var CLI_DTALTCAD: Date? = null
    var CLI_CLIENTECANAL: Int? = null
    var CLI_CNAEPER = 0.0
    var CLI_IDESTRANGEIRO = ""
    var CLI_DIASFECHA = ""
    var CLI_COBDIAS = 0
    var CLI_BANDEIRA = 0
    var CLI_DTCONSULTA: Date? = null
    var CLI_ESTATIVO = ""
    var CLI_AUTONOTA = ""
    var CLI_LONGITUDE = ""
    var CLI_LATITUDE = ""
    var CLI_LOCALOBR = ""
    var CLI_PRECOTAB = 0
    var CLI_FREQVISITA = ""
    var CLI_IDFABRIC = 0
    var CLI_FORONLINE = ""

    //outros campos
    var REG_DESCR00 = ""
    var CLASS_DESCR00 = ""
    var RAMO_DESCR00 = ""
    var REDE_DESCR00 = ""
    var CLICAN_DESCR00 = ""
    var PRETAB_DESCRICAO00 = ""
    var CLI_FONE00 = ""
    var PESQ_TIPO00 = "" //indica o tipo da pesquisa (A=ambos, C=cliente, F=fornecedoes)

}