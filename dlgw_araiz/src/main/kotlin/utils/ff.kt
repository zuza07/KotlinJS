package utils

//import jquery.MouseClickEvent
import model.*
import org.w3c.dom.*
import org.w3c.dom.events.Event
import utils.ff.Companion.ffSonumero
import utils.ff.Companion.gsDesenvolvedor
import utils.ff.Companion.println0
import kotlin.browser.document
import kotlin.dom.addClass
import kotlin.dom.clear
import kotlin.dom.removeClass
import kotlin.js.Date

public class ff {
    public companion object {
        val lDiaMS: Long = 86400000 // dia em milisegundos

        var gsAcesso = "ok"
        val gsUniverso = "http://urlteste"
        var gsDom1 = ""
        var gsDom2 = ""
        var giEmpresa = 0
        var gsToken = ""
        var gsEmpSerie = ""
        var gsVersao = "133" //versão //versao
        var gsEmpVersao = "13.12.13" //versão
        var gsModelResult = ""
        var gsModelClick = ""
        var gsDesenvolvedor: String? = "" //define o ambiente P=PRODUÇÃO
        var gsTeclaEnter = ""
        var gsUrlLogon = ""
        var gsCamView = ""
        var gs_htmlDivModelConteudo = ""
        var gs_logonsis = ""
        var gs_logonfor = ""
        //var gsLocalOrigem = ""
        var goFUNCIONARIO = Funcionario()
        var goEMPRESA = Empresa()
        var goConfig = ArrayList<Padrao>()

        //var as_ = "\""
        public val InicialDate = Date("1900,01,01 03:03:03") // Date("01-01-1900")
        internal var gsNumero = "0123456789"
        //private var sMescla = "odd"


        fun ffVerTeclaEnter(sBrowser: String) {
            if (sBrowser.contains("Chrome")) {
                gsTeclaEnter = "13,"
            } else { //teoricamente firefox, ENTER, TAB
                gsTeclaEnter = "13,"
            }
        }

        fun ffVerEnterOuTab(sWhich: Int): Boolean {
            if (gsTeclaEnter.contains(sWhich.toString() + ",")) {
                return true
            } else {
                return false
            }
        }

        fun ffVsi(sNumero0: String?): Int {
            try {
                var sNumero = "0"
                if (sNumero0 != undefined) {
                    //console.log(sNumero0)
                    sNumero = sNumero0.toString()
                }
                //println("Zuza97" + sNumero)
                if (sNumero == null || sNumero.equals("") || sNumero.equals("null")) {
                    sNumero = "0"
                }
                return sNumero.toInt()

            } catch (e: Exception) {
                console.log("falha na conversao ffVsi" + e.message)
                return 0
            }
        }

        fun ffVss(_sTexto: String): String {

            try {
                //var sTexto: String = "$_sTexto".toString()
                var sTexto: String = _sTexto
                if (sTexto == null || "" == sTexto || "null" == sTexto || sTexto == "undefined" || _sTexto == undefined) {
                    sTexto = ""
                }
                return sTexto.toString()
            } catch (e: Exception) {
                println0("erro no ffVss de conteudo $_sTexto")
                return ""
            }
        }

        fun ffVsd(sNumero0: String?): Double {
            try {
                var sNumero: String = sNumero0.toString()
                if (sNumero == null || sNumero.equals("") || sNumero.equals("null")) {
                    sNumero = "0"
                }

                sNumero = sNumero.replace(",", ".")

                return sNumero.toDouble()

            } catch (e: Exception) {
                console.log("falha na conversao ffVsi" + e.message)
                return 0.0
            }
        }

        fun Double.format(digits: Int): String = this.asDynamic().toFixed(digits) // /(\d)(?=(\d{3})+\.)/g, '$1,');

        fun Double.formatD(digits: Int): Double = this.asDynamic().toFixed(digits) // /(\d)(?=(\d{3})+\.)/g, '$1,');

        fun Float.format(digits: Int): String = this.asDynamic().toFixed(digits)  //.replace(/(\d)(?=(\d{3})+\.)/g, '$1,');

        fun ffVsRel(sValor: String, Dig: Int): String {
            var sResult = "0,00"

            if (sValor != null) {
                var cValor = sValor.toDouble()

                //cValor.format(3)
                sResult = cValor.format(Dig).toString()

                sResult = sResult.replace(",", "$").replace(".", "#")
                sResult = sResult.replace("$", ".").replace("#", ",")
                //sResult = sResult.replace("$", ".").replace("#", ",")
                sResult = ffSeparadorMilhar(sResult)

            }
            return sResult
        } //teste novo servidor

        fun ffSeparador(Valor: String, Dig: Int): String {
            var sResult = ""
            var sDecimal = ""
            if ((Valor != null) && (Valor.length > 0)) {
                //separa as Strings o que é decimal do que é Inteiro
                if (Valor.indexOf(",") > 0) {
                    sResult = Valor.substring(0, Valor.indexOf(","))
                    sDecimal = Valor.substring(Valor.indexOf(","), Valor.length)
                } else {
                    sResult = Valor.substring(0, Valor.length)
                    sDecimal = ""
                }

                //sResult = ffEspelhar(sResult)
                var sMilhar = ""
                var sCont = ""
                var iSep = Dig
                var iCont = sResult.length - 1

                while (iCont >= 0) {
                    if (iSep > 0) {
                        sMilhar = sResult[iCont] + sMilhar
                        iSep -= 1
                        iCont -= 1
                    } else {
                        sMilhar = "." + sMilhar
                        iSep = Dig
                    }
                }
                //println(sMilhar)
                sResult = sMilhar + sDecimal
            }
            return sResult
        }

        fun ffSeparadorMilhar(Valor: String): String {
            return ffSeparador(Valor, 3)
        }

        /**
         * @return data formatada
         * [separador] "-" ou "/"
         */
//        fun ffNow_YYYYMMDD(separador: String): String {
//            var dtHoje = Date(Date.now())
//            var sDtHoje = "${dtHoje.getFullYear()}-${ff.ffZeroLeft((dtHoje.getMonth() + 1).toString(),2)}-${ff.ffZeroLeft(dtHoje.getDate().toString(),2)}"
//            if (separador.equals("/"))
//                sDtHoje = sDtHoje.replace("-","/")
//            return sDtHoje
//        }

        /**
         * @return ano e mes formatado
         * [separador] "-" ou "/"
         */
//        fun ffNow_YYYYMM(separador: String): String {
//            var dtHoje = Date(Date.now())
//            var sDtHoje = "${dtHoje.getFullYear()}-${ff.ffZeroLeft((dtHoje.getMonth() + 1).toString(),2)}"
//            if (separador.equals("/"))
//                sDtHoje = sDtHoje.replace("-","/")
//            return sDtHoje
//        }

        /**
         * @return ultimo dia do mes formatado
         * [separador] "-" ou "/"
         */
//        fun ffFimMes_YYYYMMDD(separador: String): String {
//            var dtProxMes = Date(Date.now().plus(lDiaMS.times(30)))
//            var dtFimMes = Date("${dtProxMes.getFullYear()},${ff.ffZeroLeft((dtProxMes.getMonth() + 1).toString(),2)},01")
//            dtFimMes = Date(dtFimMes.getTime().minus(lDiaMS).times(1))
//            var sDtFimMes = "${dtFimMes.getFullYear()}-${ff.ffZeroLeft((dtFimMes.getMonth() + 1).toString(),2)}-${ff.ffZeroLeft(dtFimMes.getDate().toString(),2)}"
//            if (separador.equals("/"))
//                sDtFimMes = sDtFimMes.replace("-","/")
//            return sDtFimMes
//        }

        fun jsAlert(sTexto: String) {
            //val sTeste:dynamic = js("alert($sTexto)"
            //sTeste = sTeste.replace("'","11")
            //js("""+'$sTeste'''+""")
        }

        fun println1(_valor: Any) {
            console.log(_valor)
        }

        fun ffPegaCampo(texto: String, identCampo: String): String {
            var identCampo = identCampo
            try {
                var i: Int
                var sResult = ""
                val iPosInicio = texto.indexOf(identCampo)// + texto.length();

                if (iPosInicio != -1) {
                    i = iPosInicio + 1
                    while (i < texto.length) {
                        //val teste = texto[i]
                        if (texto[i] == '|' || texto[i] == '\n') {
                            break
                        }
                        i++
                    }
                    sResult = texto.substring(iPosInicio, i)
                    //if (identCampo.indexOf("[|]") > 0) {
                    //identCampo = "[|]" + identCampo.substring(1, identCampo.length());
                    identCampo = identCampo.substring(0, identCampo.length)
                    sResult = sResult.replace(identCampo, "")
                }

                return sResult
            } catch (e: Exception) {
                println(e.message)
                return ""
            }
        }

        fun println0(_valor: Any) {

            //print("${Logon.AdmRet().FUNC_URLLOGON}")
            if (gsDesenvolvedor.equals("P")) {

            } else {
                console.log(_valor)
            }
        }

        fun ffSonumero(sTexto: String): String {
            var sResult = ""
            for (i in 0..sTexto.length - 1) {
                if (gsNumero.indexOf(sTexto.substring(i, i + 1)) != -1) {
                    sResult = sResult + sTexto.substring(i, i + 1)
                }
            }
            return sResult
        }

        fun ffUrlAbrir(sUrl: String, bNovaAba: Boolean) {
            //ffJavaScript("window.open=('${sUrl}','_blank');")
            //kotlin.run { "window.open=('${sUrl}','_blank');" }
            //run { "window.open=('${sUrl}','_blank');" }
            //val sTeste = "window.open=('${sUrl}','_blank');"
            //val sTeste = "window.location='${sUrl}';"
            var sTeste = ""
            if (bNovaAba) {
                sTeste = "window.open('${sUrl}');"
            } else {
                sTeste = "window.location='${sUrl}';"
            }
            ff.println0("executando ffUrlAbrir - $sTeste")

            //js("location.reload()")
            //run { sTeste }
            //run { "window.open=('${sUrl}','_blank');" }

            ffJavaScript(sTeste)
        }

        fun ffVerMes(iMes: Int): String {

            var sMes = ""
            when (iMes) {
                1 -> {
                    sMes = "JANEIRO"
                }
                2 -> {
                    sMes = "FEVEREIRO"
                }
                3 -> {
                    sMes = "MARÇO"
                }
                4 -> {
                    sMes = "ABRIL"
                }
                5 -> {
                    sMes = "MAIO"
                }
                6 -> {
                    sMes = "JUNHO"
                }
                7 -> {
                    sMes = "JULHO"
                }
                8 -> {
                    sMes = "AGOSTO"
                }
                9 -> {
                    sMes = "SETEMBRO"
                }
                10 -> {
                    sMes = "OUTUBRO"
                }
                11 -> {
                    sMes = "NOVEMBRO"
                }
                12 -> {
                    sMes = "DEZEMBRO"
                }
                else -> {
                    sMes = "FALHOU"
                }
            }
            return sMes
        }

        fun ffEdValida(componente: dynamic, iLimite: Int, sTipo: String = "") {

            var sTexto = componente.value.toString()
            //println0("ffEdValida $sTexto")
            if (sTipo.equals("")) {
                componente.value = sTexto.ffCopy(0, iLimite)
            } else if (componente.type.equals("number") || sTipo.equals("number")) {
                componente.value = ffSonumero(sTexto.ffCopy(0, iLimite))
            }
        }

        /*
        fun ffParse(sTexto: String, obj00: T): Any {
            return JSON.parse<Array<obj00>>(sTexto)
        }

         */

        //evento para registrar saídas de campos que necessita de formatação
        fun ffOnChangeGeral(): (Event) -> Unit {
            return {

                val input = it.currentTarget as HTMLInputElement
                val sNome = input.id.toLowerCase()
                println0("executando ffOnChangeGeral para $sNome")
                if (sNome.contains("cpf&") || sNome.contains("cnpj&")) {
                    input.value = input.value.ffFormatCnpj()
                } else if (sNome.contains("dt&") || sNome.contains("data&") || sNome.contains("periodo&")) {
                    input.value = input.value.ffDsBr()
                }
            }
        }


        fun ffConfigGravar(_tela: String, _conteudo: String) {

            println0("executando ffConfigGravar")
            println0(goConfig)
            val sTela = _tela.replace("_","")
            var bAchou = false;
            for (obj in goConfig) {
                if (obj.PAD_TELA.equals(sTela)) {
                    obj.PAD_CONTEUDO = _conteudo
                    bAchou = true
                }
            }
            if (!bAchou) {
                val obj = Padrao()
                obj.PAD_TELA = sTela
                obj.PAD_CONTEUDO = _conteudo
                goConfig.add(obj)
            }
        }

        fun ffConfigRecuperar(_tela: String): String {

            println0("executando ffConfigRecuperar")
            println0(goConfig)
            val sTela = _tela.replace("_","")
            var sReturn = ""
            for (obj in goConfig) {
                if (obj.PAD_TELA.equals(sTela)) {
                    sReturn = obj.PAD_CONTEUDO
                }
            }
            return sReturn
        }

        //retorna o valor mediante ao percentual ex: 110 * 12% = 13,2
        fun ffPercCalc(fValor: Double, fPercentual: Double): Double {
            try {
                if (fValor == "90".ffVsdo() && fPercentual == "1,65".ffVsdo())
                    ff.println0("edu")
                //val fResult = fValor.multiply(fPercentual).divide(BigDecimal("100"))
                val fResult = (fValor * fPercentual) / "100".ffVsdo()
                ff.println0("valor=$fValor percentual=$fPercentual result=$fResult")
                return fResult
            } catch (e: Exception) {
                ff.println0("ff.ffPercCalc " + e.message)
                return 0.0
            }

        }

        fun ffPositivo(_bgValor: Double): Double {

            var bgValor = _bgValor
            if (bgValor < 0.0)
                bgValor = bgValor * -1
            return bgValor
        }

        fun ffPerc(fTotal: Double, fValor: Double): Double {

            val fResult = fTotal - ffPercCalc(fTotal, fValor)
            return fResult
        }

        //soma ou subtrai de acordo com o sinal
        fun ffPercSS(fTotal: Double, fPercentual: Double): Double {

            var fResult = fTotal
            if (fPercentual > 0.0)
                fResult = ffPercSoma(fTotal, fPercentual)
            if (fPercentual < 0.0)
                fResult = ffPercSub(fTotal, fPercentual)

            return fResult
        }

        //soma o valor percentual no total ex: 120 + 10% = 132
        fun ffPercSoma(_fTotal: Double, _fPercentual: Double): Double {
            var fTotal = _fTotal
            var fPercentual = _fPercentual
            fTotal = ffPositivo(fTotal)
            fPercentual = ffPositivo(fPercentual)
            val fResult = fTotal + ffPercCalc(fTotal, fPercentual)
            return fResult
        }

        //subtrair o percentual do valor ex.: 120 - 10% = 12
        fun ffPercSub(_fTotal: Double, _fPercentual: Double): Double {
            var fTotal = _fTotal
            var fPercentual = _fPercentual
            //sempre vai alterar o valor para positivo
            fTotal = ffPositivo(fTotal)
            fPercentual = ffPositivo(fPercentual)
            val fResult = fTotal - ffPercCalc(fTotal, fPercentual)
            return fResult
        }

        //retorna o percentual 1 / 7.75 = 0.1290 * 100
        fun ffPercVer(_fTotal: Double, _fValor: Double): Double {
            var fTotal = _fTotal
            var fValor = _fValor
            fTotal = ffPositivo(fTotal)
            fValor = ffPositivo(fValor)

            var fTeste = 0.0
            fTeste = fValor.div(fTotal) * 100
            return fTeste.formatD(1)
        }

        //retorna o percentual ex: 1 - 1 / 7.75 = 0.871 * 100
        fun ffPercInver(_fTotal: Double, _fValor: Double): Double {
            var fTotal = _fTotal
            var fValor = _fValor
            fTotal = ffPositivo(fTotal)
            fValor = ffPositivo(fValor)

            var fTeste = 0.0
            fTeste = fValor * 100 / fTotal
            if (fTeste.compareTo(0.0) == 0) {
                fTeste = 100 - fTeste
            }
            return fTeste
        }

    } //**** fim do container

    fun ffPegaId(_texto: String): String {
        var sResult = ""
        if (!_texto.equals("")) {
            sResult = _texto.substring(0, _texto.indexOf("-"))
            println(sResult)
        }
        return sResult

    }

    fun consultarProduto(_produto: String, cb: (Produto) -> Unit) {
        var obj = Produto()
        Service().getProduto(_produto) { lprod ->
            obj = lprod.get(0)
            cb(obj)
        }
    }

    fun tbGridNovaLinha(tbPadrao: HTMLTableElement?, iColunas: Int, sLinha: String): HTMLTableRowElement {

        //println0("ZUZA$sLinha")
        //lançando os módulos no grid
        val tLinha = tbPadrao!!.insertRow(tbPadrao!!.rows.length)
        var texto = document.createTextNode("")

        for (i in 0..iColunas - 1) {
            val sCol = "|${i.toString().ffZeroLeft(2)}"
            var tCell = tLinha.insertCell(i)

            texto = document.createTextNode(sLinha.ffPegaCampo(sCol))
            tCell.appendChild(texto)
            texto.clear()
        }
        return tLinha
    }

    fun tbGridNovaLinha1(_tbPadrao: HTMLTableElement?, _iColunas: Int, _bModal: Boolean,
                         _sAtributosClass: String, _sLinha: String): HTMLTableRowElement {

        //println0("tbGridNovaLinha1 iniciando")
        var sAtributoClass = _sAtributosClass
        //println0("ZUZA$sLinha")
        //lançando os módulos no grid
        val tLinha = _tbPadrao!!.insertRow(_tbPadrao!!.rows.length)
        if (!_bModal)
            tLinha.onclick = { tLinha.setAttribute("data-dismiss", "modal") }
        else
            tLinha.onclick = { tLinha.setAttribute("data-toggle", "modal"); tLinha.setAttribute("data-target", "#htmlDivModal") }

        var texto = document.createTextNode("")
        for (i in 1.._iColunas) {
            val sCol = "|${i.toString().ffZeroLeft(2)}"
            var tCell = tLinha.insertCell(i - 1)
            if (i - 1 == 0) {
                //tCell.onclick = onClickCell(tLinha) as (Event) -> Unit
            }

            texto = document.createTextNode(_sLinha.ffPegaCampo(sCol))
            tCell.appendChild(texto)
            texto.clear()
        }

        if (_sLinha.ffPegaCampo("|00").equals("-"))
            sAtributoClass = "$sAtributoClass table-danger"
        if (_sLinha.ffPegaCampo("|00").equals("+"))
            sAtributoClass = "$sAtributoClass table-success"

        tLinha.setAttribute("class", sAtributoClass)
        return tLinha
    }
/*
    fun onClickCell(tLinha: HTMLElement): (MouseClickEvent) -> Unit {
        return {
            //println0("teste on clickCell ${it.which}")

            var sTeste = tLinha.getAttribute("class")!!.ffVss()
            if (sTeste.contains("selected")) {
                sTeste = sTeste.replace("selected", "")
                tLinha.setAttribute("class", "${sTeste.replace("t00-d00", "table-danger")
                        .replace("t00-s00", "table-success")}")
            } else {
                tLinha.setAttribute("class", "selected ${sTeste.replace("table-danger", "t00-d00")
                        .replace("table-success", "t00-s00")}")
            }

        }
    }

 */

    /*
        fun onInputViewKeyPressLinha(tLinha: HTMLElement): (KeyboardEvent) -> Unit {
            return {
                println0("teste keypress ${it.which} ${tLinha.innerText}")
                if (it.which == 32) {
                    var sTeste = tLinha.getAttribute("class")!!.ffVss()
                    if (sTeste.contains("selected")) {
                        sTeste = sTeste.replace("selected","")
                        tLinha.setAttribute("class", sTeste)
                    } else {
                        tLinha.setAttribute("class", "selected $sTeste")
                    }
                    //val input = it.currentTarget as HTMLInputElement
                    //input.value = ""
                }
            }
        }
    */

}

fun Double.ffDiv(_bdValor2: Double): Double {
    var bdValor1 = this
    var bdValor2 = _bdValor2
    try {
        bdValor1 = bdValor1
        bdValor2 = bdValor2

        return bdValor1.div(bdValor2)
    } catch (e: Exception) {
        return 0.0
    }
}

//****** extensions
fun Date.ffNull(): Boolean {
    if (this.equals(null))
        return true
    else if (this.equals(ff.InicialDate))
        return true
    else
        return false
}

fun Date.ffDsi(): Int {
    val sData = this.ffDdBr(2)
    //ff.println0("zuza" + sData)
    var sTeste = "20" + sData.ffCopy(7, 2) + sData.ffCopy(3, 4) + sData.ffCopy(1, 2)
    sTeste = sTeste.replace("/", "")
    return sTeste.toInt()
}

fun Date.ffDdb(): String {
    val dtHoje = this
    return "${dtHoje.getFullYear()}-${(dtHoje.getMonth() + 1).toString().ffZeroLeft(2)}-${dtHoje.getDate().toString().ffZeroLeft(2)}"
}

fun Date.ffDtUltDia(): Date {
    var dtFimMes = this
    dtFimMes = Date("${dtFimMes.getFullYear()}-${(dtFimMes.getMonth() + 1).toString().ffZeroLeft(2)}-15")
    var dtProxMes = Date(this.getTime().plus(ff.lDiaMS.times(30)))
    dtFimMes = Date("${dtProxMes.getFullYear()},${(dtProxMes.getMonth() + 1).toString().ffZeroLeft(2)},01")
    return Date(dtFimMes.getTime().minus(ff.lDiaMS).times(1))
}

fun Date.ffDtIniDia(): Date {
    var dtFimMes = this
    dtFimMes = Date("${dtFimMes.getFullYear()}-${(dtFimMes.getMonth() + 1).toString().ffZeroLeft(2)}-01")
//    return Date(dtFimMes.getTime().minus(ff.lDiaMS).times(1))
    return Date(dtFimMes.getTime().times(1))
}

fun Date.ffDdBr(_digAno: Int): String {
    var sResult = ""
    var aData = Date()
    var dtData: Date = Date(this.toString())
    var dtDataGMT = Date(dtData.getTime() + 21600000) // acrescenta 6 horas, pois o conversor considera o fuso GMT
    //ff.println0(dtDataGMT)
    var sAno = ""
    dtDataGMT.getTime()

    if (dtDataGMT != null) {
        var sDia = dtDataGMT.toDateString()

        //sDia = ffZeroLeft(dtData.getDay().toString(), 2) //não funciona
        //ff.println0("sDia ${sDia}")
        sDia = sDia.substring(8, 10).trim()
        var sMes = (dtDataGMT.getMonth() + 1).toString().ffZeroLeft(2)
        sAno = dtDataGMT.getFullYear().toString().ffVss()
        if (_digAno == 2) {
            sAno = sAno.substring(2)
        }

        if (_digAno == 0)
            sResult = "${sDia}/${sMes}"
        else
            sResult = "${sDia}/${sMes}/${sAno}"
    }
//    if (ffSonumero(sResult).length != 6 && ffSonumero(sResult).length != 8) {
//        sResult = ""
//    }
    return sResult
}

fun Date.compareNow(): Int {
    //var i = 0
    //val iData1 = ffVsi("${this.getFullYear()}${(this.getMonth() + 1).toString() }${this.getDate()}") algo
    //val iData2 = ffVsi("${data.getFullYear()}${data.getMonth() + 1}${data.getDate()}")
    ff.println0("executando compareNow")
    val iData1 = this.ffDsi()
    val iData2 = Date().ffDsi() //.ffDsi()
    ff.println0("compareNow result=${iData1.compareTo(iData2)} valoresgetDate=${Date()} valorthis=${this}")
    return iData1.compareTo(iData2)
}

fun Date.compare(data: Date): Int {
    //var i = 0
    //val iData1 = ffVsi("${this.getFullYear()}${(this.getMonth() + 1).toString() }${this.getDate()}") algo
    //val iData2 = ffVsi("${data.getFullYear()}${data.getMonth() + 1}${data.getDate()}")
    val iData1 = this.ffDsi()
    val iData2 = data.ffDsi()
    //ff.println0("zuza compare $iData1 com $iData2")
    return iData1.compareTo(iData2)
}

fun Date.ffCompare(data: Date): Double {
    val lDiaMS: Long = 86400000 // dia em milisegundos
    var lData1: Double = this.getTime()
    var lData2: Double = data.getTime()
    var lDiferenca = lData1.minus(lData2)
    return lDiferenca.div(lDiaMS)
}

fun Date.ffSoma(iDias: Int): Date {

    val lDiaMS: Long = 86400000 // dia em milisegundos
    val lPeriodo: Long = lDiaMS.times(iDias)
    ff.println0("ffSoma nova data long ${this.getTime().plus(lPeriodo)}")
    ff.println0("ffSoma nova data iso ${Date(this.getTime().plus(lPeriodo)).toISOString()}")
    return Date(this.getTime().plus(lPeriodo))
}

fun Date.ffDdd(): Date {
    return this ?: ff.InicialDate
}

//fun Date.ffDds_YYYYMMDD(separador: String): String {
//    var sRetorno = "${this.getFullYear()}-${ff.ffZeroLeft((this.getMonth() + 1).toString(),2)}-${ff.ffZeroLeft(this.getDate().toString(),2)}"
//    if (separador.equals("/"))
//        sRetorno = sRetorno.replace("-","/")
//    return sRetorno
//}

//Data do tipo String para o banco ex = 2019-08-07
fun String.ffDsbNAOUSAR(): Date {
    var sTeste = ""
    if (this.ffCopy(5, 1).equals("-")) {
        sTeste = "${this.ffCopy(1, 4)}-${this.ffCopy(6, 2)}-${this.ffCopy(9, 2)}"
    } else {
        sTeste = "${this.ffCopy(7, 2)}-${this.ffCopy(4, 2)}-${this.ffCopy(1, 2)}"
    }
    sTeste = sTeste.replace("-", ",")
    console.log("heuller123 $this $sTeste")
    return Date(sTeste)
}

fun String.ffDsd(): Date {

    var _sTexto = this
    /*
    if (_sTexto.equals("Da/00/N")) {
        _sTexto = ff.InicialDate.toString()
    }
    */

    ff.println0("zuza imprimir")
    ff.println0(_sTexto)
    if (_sTexto.equals("") || _sTexto.equals("Da/00/N") || _sTexto.equals("20N00Da"))
        _sTexto = ff.InicialDate.ffDdBr(4)
    ff.println0("executando String.ffDsd() $this _sTexto=$_sTexto")

    var sTeste = ""
    if (_sTexto.ffCopy(5, 1).equals("-")) {
        sTeste = _sTexto.ffCopy(1, 5) + _sTexto.ffCopy(6, 3) + _sTexto.ffCopy(9, 2)
    } else {
        sTeste = "20" + _sTexto.ffCopy(7, 2) + _sTexto.ffCopy(3, 4) + _sTexto.ffCopy(1, 2)
    }
    sTeste = sTeste.replace("/", ",")
    //console.log("zuza01234 $_sTexto $sTeste")
    return Date(sTeste)
}

fun String.ffDsBr(): String {
    var sResult = ""
    var sData = ff.ffSonumero(this)
    if (!sData.equals("") && !sData.equals("00")) {
        //if (sData != null) {
        //if (!sData.substring(2, 3).equals("/")) {
        //println(_data)

        var sData1 = ""
        if (sData.length == 6) {
            sData1 = sData.substring(0, 2) + "/" + sData.substring(2, 4) + "/20" + sData.substring(4, 6)
        } else if (sData.length == 8) {
            sData1 = sData.substring(0, 2) + "/" + sData.substring(2, 4) + "/" + sData.substring(4, 8)
        }
        sData = sData1
        //}

        sData = sData.substring(6, 10) + "/" + sData.substring(3, 5) + "/" + sData.substring(0, 2)
        //console.log("zuza99 ${sData}")
        var dData1 = Date(sData + " 00:00:01")
        //console.log("zuza101 ${dData1}")
        sResult = dData1.ffDdBr(2)
    }

    return sResult
}

fun String.ffCopy(_inicio: Int, _fim: Int): String {

    var sTexto = this
    var iInicio = _inicio
    var iFim = _fim

    try {
        if (iInicio > 0) {
            iInicio = iInicio - 1
            iFim = iFim + iInicio
        }

        return if (sTexto == "") {
            ""
        } else if (iFim > sTexto.length) {
            sTexto.substring(iInicio, sTexto.length)
        } else {
            sTexto.substring(iInicio, iFim!!)
        }

    } catch (e: Exception) {
        println(e)
        return ""
    }
}

fun String.ffDtInvDias(): String {
    var sTeste = this
    if (sTeste.length == 8)
        sTeste = this.ffCopy(4, 3) + this.ffCopy(1, 3) + this.ffCopy(7, 2)

    if (sTeste.length == 10)
        sTeste = this.ffCopy(4, 3) + this.ffCopy(1, 3) + this.ffCopy(9, 2)
    return sTeste
}

fun String.ffDtBR(iDigAno: Int = 0): String {
    var sTeste = this
    if (sTeste.length == 10)
        sTeste = this.ffCopy(1, 3) + this.ffCopy(4, 3) + this.ffCopy(9, 2)

    if (iDigAno == 4)
        sTeste = this.ffCopy(1, 3) + this.ffCopy(4, 3) + "20" + this.ffCopy(7, 2)
    return sTeste
}

fun String.ffVsRel(): String {
    return ff.ffVsRel(this, 0)
}

fun Int.ffViRel(): String {
    return ff.ffVsRel(this.toString(), 0)
}

fun Int.ffZeroLeft(_tam: Int): String {
    return this.toString().ffZeroLeft(_tam)
}

fun Double.ffVcRel(iDig0: Int? = 2): String {

    var iDig = 0
    if (iDig0 == null) {
        iDig = 2
    } else {
        iDig = iDig0
    }
    //return ff.ffVsRel(this.toString(), iDig).replace(",","#").replace(".", ",").replace("#",".")
    return ff.ffVsRel(this.toString(), iDig)
}

fun Double.ffVdo(): Double {

    //return ff.ffVsi(this.toString())
/*
    var sValor = this
    var dTeste = 0.0
    var sTeste0 = this ?: 0.0
    //var sTeste0 = jsTypeOf(sValor.ffVss())

    if (!sTeste0.equals(undefined) && !sTeste0.equals("undefined")) {
        dTeste = 0.0
    } else {
        dTeste = ff.ffVsd(sValor.toString())
    }
*/
    return this ?: 0.0
}

fun Nothing?.ffVss(): String {
    return "nothing"
}

fun String.ffVss(): String {

    var sTexto = this ?: ""
    //sTexto = jsTypeOf(sTexto)
    //ff.println0(sTexto)
    if (sTexto == null || "" == sTexto || "null" == sTexto || sTexto == "undefined") {
        sTexto = ""
    } else {
        var sTexto = "#$this"
        sTexto = sTexto.substring(0)
    }

    return sTexto
}

/*
fun String.ffAny(): String {

    var sValor = this
    var sTeste = ""
    var sTeste0 = jsTypeOf(sValor)

    if (!sTeste0.equals(undefined) && !sTeste0.equals("undefined")) {
        sTeste = ff.ffVss(this.toString())
    }
    return sTeste.toString()
}
*/

fun Any.ffVss(): String {

    //println0("aqui Any.ffVss() ${this.toString()}")
    var sValor = this
    var sTeste = ""
    var sTeste0 = jsTypeOf(sValor)

    if (!sTeste0.equals(undefined) && !sTeste0.equals("undefined")) {
        sTeste = ff.ffVss(this.toString())
    }
    return sTeste.toString()
}

/*
fun Any.ffVsi(): Int {

    //return ff.ffVsi(this.toString())
    var sValor = this
    var iTeste = 0
    var sTeste0 = jsTypeOf(sValor.ffVss())

    if (!sTeste0.equals(undefined) && !sTeste0.equals("undefined")) {
        iTeste = 0
    } else {
        iTeste = ff.ffVsi(sValor.toString())
    }
    return iTeste
}
*/

fun String.ffVsdo(): Double {

    //return ff.ffVsi(this.toString())
    var sValor = this
    var dTeste = 0.0
    var sTeste0 = this ?: 0.0
    //var sTeste0 = jsTypeOf(sValor.ffVss())

    if (!sTeste0.equals(undefined) && !sTeste0.equals("undefined")) {
        dTeste = 0.0
    } else {
        dTeste = ff.ffVsd(sValor.toString())
    }
    return dTeste
}

fun Any.ffVsd(): Date {

    var sValor = this
    var dTeste = ff.InicialDate
    var sTeste0 = jsTypeOf(sValor).ffVss()

    if (!sTeste0.equals(undefined) && !sTeste0.equals("undefined")) {

    } else {
        dTeste = sTeste0.ffDsd()
    }
    return dTeste
}

fun Int.ffVis(): String {
    try {
        var sTexto = ""
        if ((this != null) && (this != undefined))
            sTexto = this.toString()
        return sTexto
    } catch (e: Exception) {
        console.log("Erro ffvis ${e.message}")
        return ""
    }
}

fun Int.ffVii(): Int {
    return this ?: 0
}

fun Double.ffVcs(): String {
    try {
        var sTexto = ""
        if ((this != null) && (this != undefined))
            sTexto = this.toString()
        return sTexto
    } catch (e: Exception) {
        console.log("Erro ffvcs ${e.message}")
        return ""
    }
}

fun String.ffVsi(): Int {
    return ff.ffVsi(this)
}

fun String.ffVsc(): Double {
    var sTexto = "0.0"
    if (this.length > 0)
        sTexto = this
    return sTexto.toDouble()
}

fun ffJSGrid(sGrid: String, bMultiSelecao: Boolean) {
    // Heuller abr/19 // formata a tabela deixando com seletor de resultados e multi-selecao
    //var sTexto = "\$(document).ready(function(){\"use strict\";\$(\"#${sGrid}\").DataTable({keys:!0,language:{url:\"//cdn.datatables.net/plug-ins/1.10.19/i18n/Portuguese-Brasil.json\"},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}});var a=\$(\"#datatable-buttons\").DataTable({lengthChange:!1,buttons:[\"copy\",\"print\"],language:{paginate:{previous:\"<i class='mdi mdi-chevron-left'>\",next:\"<i class='mdi mdi-chevron-right'>\"}},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}});\$(\"#selection-datatable\").DataTable({select:{style:\"multi\"},language:{paginate:{previous:\"<i class='mdi mdi-chevron-left'>\",next:\"<i class='mdi mdi-chevron-right'>\"}},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}}),a.buttons().container().appendTo(\"#datatable-buttons_wrapper .col-md-6:eq(0)\")});"
    var sTexto = ""
    if (bMultiSelecao)
        sTexto = "\$(document).ready(function() {\"use strict\";\$('#${sGrid}').DataTable({keys: true,select: {style: 'multi'},\"language\": {url:\"//cdn.datatables.net/plug-ins/1.10.19/i18n/Portuguese-Brasil.json\",\"paginate\": {\"previous\": \"<i class='mdi mdi-chevron-left'>\",\"next\": \"<i class='mdi mdi-chevron-right'>\"}},\"drawCallback\": function () {\$('.dataTables_paginate > .pagination').addClass('pagination-rounded');}});"
    else
        sTexto = "\$(document).ready(function() {\"use strict\";\$('#${sGrid}').DataTable({keys: true,\"language\": {url:\"//cdn.datatables.net/plug-ins/1.10.19/i18n/Portuguese-Brasil.json\",\"paginate\": {\"previous\": \"<i class='mdi mdi-chevron-left'>\",\"next\": \"<i class='mdi mdi-chevron-right'>\"}},\"drawCallback\": function () {\$('.dataTables_paginate > .pagination').addClass('pagination-rounded');}});"
    eval(sTexto)
    println0(sTexto)
    //original
    //var sTexto = "\$(document).ready(function(){\"use strict\";\$(\"#rt076tbFuncionario\").DataTable({keys:!0,language:{url:\"//cdn.datatables.net/plug-ins/1.10.19/i18n/Portuguese-Brasil.json\"},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}});var a=\$(\"#datatable-buttons\").DataTable({lengthChange:!1,buttons:[\"copy\",\"print\"],language:{paginate:{previous:\"<i class='mdi mdi-chevron-left'>\",next:\"<i class='mdi mdi-chevron-right'>\"}},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}});\$(\"#selection-datatable\").DataTable({select:{style:\"multi\"},language:{paginate:{previous:\"<i class='mdi mdi-chevron-left'>\",next:\"<i class='mdi mdi-chevron-right'>\"}},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}}),a.buttons().container().appendTo(\"#datatable-buttons_wrapper .col-md-6:eq(0)\")});"
    //var sTexto = "\$(document).ready(function(){\"use strict\";\$(\"#rt066tbFuncionario\").DataTable({keys:!0,language:{paginate:{url:\"//cdn.datatables.net/plug-ins/1.10.19/i18n/Portuguese-Brasil.json\"}},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}});var a=\$(\"#datatable-buttons\").DataTable({lengthChange:!1,buttons:[\"copy\",\"print\"],language:{paginate:{previous:\"<i class='mdi mdi-chevron-left'>\",next:\"<i class='mdi mdi-chevron-right'>\"}},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}});\$(\"#selection-datatable\").DataTable({select:{style:\"multi\"},language:{paginate:{previous:\"<i class='mdi mdi-chevron-left'>\",next:\"<i class='mdi mdi-chevron-right'>\"}},drawCallback:function(){\$(\".dataTables_paginate > .pagination\").addClass(\"pagination-rounded\")}}),a.buttons().container().appendTo(\"#datatable-buttons_wrapper .col-md-6:eq(0)\")});"
}

fun ffGridPrepara(tabela: HTMLTableElement): HTMLTableElement {

    //println0("executando ffGridPrepara")
    ffJSAguarda("var table = \$('#${tabela.id}').DataTable();table.paging=false;table.destroy();") { }
    //ffJSExecute("var table = \$('#${tabela.id}').DataTable();table.paging=false;table.destroy();") //{ }
    val iRowCount = tabela.rows.length - 1
    ff.println0("rowCount " + iRowCount)
    for (i in iRowCount downTo 2) {
        tabela.deleteRow(i)
    }
    return tabela
}

fun ffJSGridConfig(sGrid: String, bMultiSelecao: Boolean, bBotoes: Boolean, bPesquisa: Boolean = true, iLength: Int = 10, callback: (String) -> Unit) {

/*
    l - length changing input control
    f - filtering input
    t - The table!
    i - Table information summary
    p - pagination control
    r - processing display element
*/

//    var sLength = "\"All\""
//    if (iLength > 0)

    val sLength = iLength.toString()
    var sDom = "lfrtip"
    //sem a pesquisa
    if (!bPesquisa)
        sDom = "lrtip"
    if (iLength == -1) {
        sDom = sDom.replace("i", "")
        sDom = sDom.replace("p", "")
    }
    sDom = "dom: \"$sDom\", iDisplayLength: $sLength"

    // Heuller abr/19 // formata a tabela deixando os botoes copiar e imprimir, multi-selecao
    //ffJSAguarda("var table = \$('#${sGrid}').DataTable();table.paging=false;table.destroy();") { _ok ->

    //eval("var table = \$('#${sGrid}').DataTable();table.paging=false;table.destroy();")
    console.log("teste de teste")
    var sTexto = ""
    if (bMultiSelecao)
        sTexto = "\$(document).ready(function() {\"use strict\";var table = \$('#${sGrid}').DataTable({$sDom,lengthChange: false,select: {style: 'multi'},buttons: ['copy', 'print'],\"language\": {'sSearch': 'Pesquisar',buttons: {'copy': 'Copiar','print': 'Imprimir'},\"paginate\": {\"previous\": \"<i class='mdi mdi-chevron-left'>\",\"next\": \"<i class='mdi mdi-chevron-right'>\"}},\"drawCallback\": function () {\$('.dataTables_paginate > .pagination').addClass('pagination-rounded');}});table.buttons().container().appendTo('#${sGrid}_wrapper .col-md-6:eq(0)');} );"
    else
        sTexto = "\$(document).ready(function() {\"use strict\";var table = \$('#${sGrid}').DataTable({$sDom,lengthChange: false,buttons: ['copy', 'print'],\"language\": {'sSearch': 'Pesquisar',buttons: {'copy': 'Copiar','print': 'Imprimir'},\"paginate\": {\"previous\": \"<i class='mdi mdi-chevron-left'>\",\"next\": \"<i class='mdi mdi-chevron-right'>\"}},\"drawCallback\": function () {\$('.dataTables_paginate > .pagination').addClass('pagination-rounded');}});table.buttons().container().appendTo('#${sGrid}_wrapper .col-md-6:eq(0)');} );"
    if (!bBotoes)
        sTexto = sTexto.replace("table.buttons().container().appendTo('#${sGrid}_wrapper .col-md-6:eq(0)');", "")


/*
    sTexto = "    \$(document).ready(function () {\n" +
            "        \"use strict\";\n" +
            "        var table = \$('#${sGrid}').DataTable({\n" +
            "            dom: \"lrtip\",\n" +
            "            iDisplayLength: 7,\n" +
            "            lengthChange: false, buttons: [],\n" +
            //"            lengthChange: false, false,\n" +
            "            \"language\": {\n" +
            //"                'sSearch': 'Pesquisar', buttons: {'copy': 'Copiar', 'print': 'Imprimir'},\n" +
            "                \"paginate\": {\n" +
            "                    \"previous\": \"<i class='mdi mdi-chevron-left'>\",\n" +
            "                    \"next\": \"<i class='mdi mdi-chevron-right'>\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"drawCallback\": function () {\n" +
            "                \$\n" +
            "                ('.dataTables_paginate > .pagination').addClass('pagination-rounded');\n" +
            "            }\n" +
            "        });\n" +
            //"        table.buttons().container().appendTo('#${sGrid}_wrapper .col-md-6:eq(0)');\n" +
            "    });\n"
*/



    eval(sTexto)
    //ffJSExecute(sTexto)
    callback("ok")
}

fun ffGridFilterRemove(tabela: HTMLTableElement): HTMLTableElement {

    ff.println0("passou pelo remove ${tabela.id}_filter")
    val div = document.getElementById("${tabela.id}_filter") as HTMLDivElement
    div.remove()
    return tabela
}


fun ffJS(sTexto: String) {
    println0(sTexto)
    eval(sTexto)
    //js(sTexto)
}

fun ffJavaScript(sTexto: String) {
    ff.println0("executando ffJavaScript Run")
    eval(sTexto)
    //js(sTexto)
}

fun ffJavaScriptLoad1(sTexto: String) {
    if (!gsDesenvolvedor.equals("P"))
        ff.println0("ffJavaLoad1 $sTexto")
    eval(sTexto)
}

fun ffJSAguarda(sTexto: String, cb: (String) -> Unit) {
    //eval(sTexto)
    println0("ffJSAguarda = $sTexto")
    val sValor = sTexto
    eval(sValor)
    cb("ok")
    //js(sTexto)
}

/*
fun sendQuery() {
    JQuery.get(JQueryAjaxSettings().apply {
        complete = { (xhr, data) ->
            window.alert("Request complete")
        }
    })
}
*/

fun ffJSExecute(sTexto: String) = js("$(sTexto)")

fun ffJSExecute1(sTexto: String) = js("console.log(\"imprimiu JSExecute\")")

//fun ffTestFunction(str: String, int: Int) = js("console.log(str + ' ' + int)")

fun ffTestFunction(str: String, int: Int) = js("'$(str)'")

fun ffSleep(milisegundos: Int) {
    ff.println0("inicio ffSleep ${Date().getTime()}")
    var i = Date().getTime() + milisegundos
    var pausa = 0
    while (i > Date().getTime()) {
        pausa++
    }
    ff.println0("fim ffSleep ${Date().getTime()}")
}

fun String.ffPegaCampo(identCampo: String): String {
    var identCampo = identCampo
    val texto = this
    try {
        var i: Int
        var sResult = ""
        val iPosInicio = texto.indexOf(identCampo)// + texto.length();

        if (iPosInicio != -1) {
            i = iPosInicio + 1
            while (i < texto.length) {
                //val teste = texto[i]
                if (texto[i] == '|' || texto[i] == '\n') {
                    break
                }
                i++
            }
            sResult = texto.substring(iPosInicio, i)
            //if (identCampo.indexOf("[|]") > 0) {
            //identCampo = "[|]" + identCampo.substring(1, identCampo.length());
            identCampo = identCampo.substring(0, identCampo.length)
            sResult = sResult.replace(identCampo, "")
        }

        return sResult.replace("undefined", "")
    } catch (e: Exception) {
        println(e.message)
        return ""
    }
}

fun String.ffPegaId(identCampo: String): String {
    return ffPegaId(identCampo)
}

fun String.ffPegaVirg(_bloco: Int): String {

    val bloco = _bloco.toString().ffZeroLeft(2)
    var texto = "," + this
    texto = texto.replace(",","|")
    texto = texto.ffMarcacao()
    //println0(texto)
    return texto.ffPegaCampo("|$bloco")
}

fun String.ffMarcacao(): String {

    var sTexto = ""
    var iCont = 0
    var _s = this
    if (!_s.ffCopy(1,1).equals("|"))
        _s = "|$_s"
    var i = 0
    while (i < _s.length) {
        val sLetra = _s[i]
        if (sLetra.equals('|')) {
            iCont ++
            sTexto = "$sTexto|${iCont.toString().ffZeroLeft(2)}"
        } else {
            sTexto = "$sTexto$sLetra"
        }
        i++
    }

    return sTexto
}

/*
fun ffappendChildPromessa(principal: HTMLDivElement, node: HTMLDivElement, cb: (String) -> Unit) {

    principal.appendChild(node)
    ffSleep(2000)
    cb("ok")
}
*/

fun String.ffSubstring(_tam: Int): String {
    return this.ffCopy(0, _tam)
}

fun String.ffZeroLeft(tam: Int): String {

    var sStr1 = this
    while (tam > sStr1.toString().length) {
        sStr1 = '0' + sStr1
    }
    sStr1 = sStr1.substring(0, tam)
    //console.log("${tam} ${sString} ${sStr1}")
    return sStr1
}

fun String.ffSoNumero(): String {
    //val sTexto = this
    return ffSonumero(this)
}

fun String.ffFormatCnpj(): String {
    var sReturn = ""
    //println0("mascara cpnj $this")
    val cnpjcpf = this.ffVss().ffSoNumero()
    if (!cnpjcpf.equals("")) {
        if (cnpjcpf.length == 14) {
            sReturn = "${cnpjcpf.ffCopy(1, 2)}.${cnpjcpf.ffCopy(3, 3)}.${cnpjcpf.ffCopy(6, 3)}" +
                    "/${cnpjcpf.ffCopy(9, 4)}-${cnpjcpf.ffCopy(13, 2)}"
        } else {
            sReturn = "${cnpjcpf.ffCopy(1, 3)}.${cnpjcpf.ffCopy(4, 3)}.${cnpjcpf.ffCopy(7, 3)}" +
                    "-${cnpjcpf.ffCopy(10, 2)}"
        }
    }
    return sReturn
}

fun ffPanelResult(obj: Any) {
    if (obj == null) {
        ff.println0("executando ffPanelResult objeto null")
    } else {
        ff.gsModelResult = JSON.stringify(obj)
        ff.println0("tipo=${ff.gsModelClick} objeto=${ff.gsModelResult}")
    }
}

fun List<Any>.deleteAny(oAny: Any, table1: HTMLTableElement?): ArrayList<Any> {

    if (table1 != null)
        table1!!.deleteRow(table1!!.ffItem(this, oAny))

    val lAny0 = this as ArrayList<Any>
    for (obj in lAny0) {
        if (obj == oAny) {
            lAny0.remove(obj)
        }
    }
    return lAny0
}

fun ffHTMLDivTab(sClasse: String, sTabAtiva: String) {
    //***** existe um padrão de nomes para o correto funcionamento exemplo da rt083.html
    //id="rt083_navComplemento"
    //id="rt083_divComplemento"

    val cl = sClasse
    val sNav = sTabAtiva
    var elementos = document.getElementsByClassName("nav-link")
    //ff.println0(elementos)
    for (i in elementos.length - 1 downTo 0 step 1) {
        val nav = document.getElementById(elementos[i]!!.id) as HTMLElement
        if (nav.id.contains("${cl}nav")) {
            //ff.println0(nav.id)
            nav.removeClass("active")
            val navdiv = document.getElementById(nav.id.replace("nav", "div")) as HTMLDivElement
            navdiv.removeClass("active")
            if (nav.id.equals(sNav)) {
                nav.addClass("active")
                navdiv.addClass("active")
            }
        }
    }
}

fun HTMLDivElement.modalClose() {
//    ffJavaScript("$(#${this.id}.close)")
//    ffJavaScript("$(#htmlDivModal.close)")
    this.setAttribute("class", "modal fade")
    this.setAttribute("aria-hidden", "true")
    this.attributes.removeNamedItem("aria-modal")
    //this.setAttribute("aria-modal", "false")


    //this.aria
    this.style.display = "none"
}

fun HTMLDivElement.ffAtivar(bAtivo: Boolean) {
    //val mDiv = document.getElementById("cardFuncionario")
    //desabilita os inputs
    ff.println0("executando ffEnabled = " + bAtivo.toString())

    val lInput = this.getElementsByTagName("input")
    for (obj in lInput.asList()) {
        if (bAtivo)
            obj.removeAttribute("disabled")
        else
            obj.setAttribute("disabled", "")
    }

    //desabilita os buttons
    val lButtons = this.getElementsByTagName("button")
    for (obj in lButtons.asList()) {
        if (bAtivo)
            obj.removeAttribute("disabled")
        else
            obj.setAttribute("disabled", "")
    }

    //desabilita os combos
    val lSelect = this.getElementsByTagName("select")
    for (obj in lSelect.asList()) {
        if (bAtivo)
            obj.removeAttribute("disabled")
        else
            obj.setAttribute("disabled", "")
    }
}

fun HTMLTableElement.ffDeleteRow(lAny: List<Any>, oAny: Any) {

    var iLinha = 0
    for (obj in lAny) {
        if (obj == oAny) {
            this.deleteRow(iLinha)
        }
        iLinha += 1
    }
}

fun HTMLTableElement.ffItem(lAny: List<Any>, oAny: Any): Int {

    var iLinha = 2
    for (obj in lAny) {
        if (obj == oAny) {
            break
        }
        iLinha += 1
    }
    return iLinha
}

fun HTMLSelectElement.enabled(tipo: Boolean) {
    this.disabled = !tipo
}

fun HTMLInputElement.enabled(tipo: Boolean) {
    this.disabled = !tipo
}

fun HTMLButtonElement.enabled(tipo: Boolean) {
    this.disabled = !tipo
}

