package html

//import jquery.MouseClickEvent

//import jquery.MouseClickEvent
import services.ControllerLogon
import utils.*
import kotlin.js.Date

public class ff_1 {
    public companion object {
        //inline fun String.format(vararg args: Any?): String
        fun msgAviso(sTexto: String) {
            if (sTexto.ffCopy(1, 4).equals("Erro")) {
                ControllerLogon().mensagem("bg-danger", sTexto)
            } else {
                ControllerLogon().mensagem("bg-warning", sTexto)
            }
        }

//        fun ffJavaScriptLoad1(sTexto: String) {
//            if (!ff.gsDesenvolvedor.equals("P"))
//                ff.println0("ffJavaLoad1 $sTexto")
//            eval(sTexto)
//        }

    }
}

fun println0(_valor: Any) {
    if (ff.gsDesenvolvedor.equals("P")) {

    } else {
        console.log(_valor)
    }
}

fun ffSleep(milisegundos: Int) {
    ff.println0("inicio ffSleep ${Date().getTime()}")
    var i = Date().getTime() + milisegundos
    var pausa = 0
    while (i > Date().getTime()) {
        pausa++
    }
    ff.println0("fim ffSleep ${Date().getTime()}")
}


/*
fun tbGridNovaLinha2(_tbPadrao: HTMLTableElement?, _iColunas: Int, _bModal: Boolean,
                     _sAtributosClass: String, _sLinha: String): HTMLTableRowElement {

    //println0("tbGridNovaLinha1 iniciando")
    var sAtributoClass = _sAtributosClass
    //println0("ZUZA$sLinha")
    //lançando os módulos no grid
    val tLinha = _tbPadrao!!.insertRow(_tbPadrao!!.rows.length)
    if (_bModal)
        tLinha.ondblclick = { tLinha.setAttribute("data-dismiss", "modal") }

    var texto = document.createTextNode("")
    for (i in 1.._iColunas) {
        val sCol = "|${i.toString().ffZeroLeft(2)}"
        val sConteudo = _sLinha.ffPegaCampo(sCol)
        if (sConteudo.contains("_act_")) {
            var tCell = tLinha.insertCell(i - 1)
            tCell.addClass("table-action dlg-padding0")

            if (sConteudo.contains("_alt")) {
                val nodeButtonEdit = document.create.a(classes = "action-icon") { i("mdi mdi-pencil") }
                tCell.append(nodeButtonEdit)
                tCell.onclick = onClickCell0("E") as (Event) -> Unit
            }

            if (sConteudo.contains("_del")) {
                val nodeButtonDelete = document.create.a(classes = "action-icon") { i("mdi mdi-delete") }
                tCell.append(nodeButtonDelete)
                tCell.onclick = onClickCell0("D") as (Event) -> Unit
            }
            //tCell.removeClass("table-action")
            //tCell.removeClass("dlg-padding0")
        } else {
            var tCell = tLinha.insertCell(i - 1)
            if (i - 1 == 0) {
                tCell.onclick = onClickLinha0(tLinha) as (Event) -> Unit
            }
            texto = document.createTextNode(sConteudo)
            tCell.appendChild(texto)
            texto.clear()
        }
    }

    if (_sLinha.ffPegaCampo("|00").equals("-"))
        sAtributoClass = "$sAtributoClass table-danger"
    if (_sLinha.ffPegaCampo("|00").equals("+"))
        sAtributoClass = "$sAtributoClass table-success"

    tLinha.setAttribute("class", sAtributoClass)
    return tLinha
}

 */
/*
fun onClickLinha0(tLinha: HTMLElement): (MouseClickEvent) -> Unit {
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

fun onClickCell0(sTipo: String): (MouseClickEvent) -> Unit {
    return {
        ff.println0("executando onClickCell0")
        ff.gsModelClick = sTipo
//        return {

/*
            var sTeste = tLinha.getAttribute("class")!!.ffVss()
            if (sTeste.contains("selected")) {
                sTeste = sTeste.replace("selected", "")
                tLinha.setAttribute("class", "${sTeste.replace("t00-d00", "table-danger")
                        .replace("t00-s00", "table-success")}")
            } else {
                tLinha.setAttribute("class", "selected ${sTeste.replace("table-danger", "t00-d00")
                        .replace("table-success", "t00-s00")}")
            }
*/


    }
}

 */
