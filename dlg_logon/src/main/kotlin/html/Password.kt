package html

//import kotlinx.browser.window
import kotlinx.html.dom.create
import kotlinx.html.id
import kotlinx.html.js.*
import model.Logon
import model.aaGenericoEmp
import org.w3c.dom.*
import org.w3c.dom.events.Event
import utils.*
import utils.ff.Companion.gsAcesso
import utils.ff.Companion.gsDesenvolvedor
import utils.ff.Companion.gsDom1
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Date

//class Password(var htmlDiv1: HTMLDivElement, var htmlDiv2: HTMLDivElement, var htmlDiv11: HTMLDivElement) {
class Password() {
    var inputVal: String = ""
    var txUsuario: HTMLInputElement? = null
    var txSenha: HTMLInputElement? = null
    //var linkTeste: HTMLAnchorElement? = null

    private var seAdmRet = document.create.select { id = "seAdmRet" } as HTMLSelectElement
    private var seEmpresa = document.create.select { id = "seEmpresa" } as HTMLSelectElement
    private var tbLista = document.create.table { id = "tbLista" } as HTMLTableElement
    private var btConectar = document.create.button { id = "btConectar" } as HTMLButtonElement
    private var btEntrar = document.create.button { id = "btEntrar" } as HTMLButtonElement
    private var divEntrar = document.create.div { id = "divEntrar" } as HTMLDivElement
    private var divDesenv = document.create.div { id = "divDesenv" } as HTMLDivElement
    private var divEmpresa = document.create.div { id = "divEmpresa" } as HTMLDivElement
    private var linkTeste = document.create.a { id = "linkTeste" } as HTMLAnchorElement
//    TODO

    fun onInput(): (Event) -> Unit {
        return {
            val input = it.currentTarget as HTMLInputElement
            inputVal = input.value
        }
    }

    fun onChange(): (Event) -> Unit {
        return {
            ff.println0("Informe o usuário")
        }
    }

    fun hello(): String {
        return "olá zuza"
    }

    fun show() {
        //storage.getAll() {
        println0("zuza chamando password")
        var teste = js("navigator.userAgent")
        //ff.ffVerTeclaEnter(teste)
        ff.println0("UserAgent $teste")
        ff.println0("ff.sCamView ${ff.gsCamView}")

//        ffJavaScript("Password.html")
        ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"${ff.gsCamView}Password.html\");")
        //passMapear01()
//        ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"kotlin/html/Password.html\");")
//        ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"lib/Password.html\");")
//        ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"resources/html/Password.html\");")
//        ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"main/resources/html/Password.html\");")
        //ff_1.ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"Password.html\");")
        //ff_1.ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"http://www.dlogica.com.br/\");")

        //ff_1.ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"resources/Password.html\");")
        //ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"Password.html\");")
    }

    fun start() {
        var sFalha = ""
        console.log("entrou no mapearObjetos Password")
        //console.log(document)
        try {
            btConectar = document.getElementById("btConectar") as HTMLButtonElement
            btConectar.onclick = { clickConectar() }

            txUsuario = document.getElementById("txUsuario") as HTMLInputElement
            txSenha = document.getElementById("txSenha") as HTMLInputElement

            if (ff.gsDesenvolvedor.equals("P") || ff.gsUrlLogon.contains("/hom/") || ff.gsUrlLogon.contains("/pro/")) {
                println("limpando campos de logon")
                txUsuario!!.value = ""
                txSenha!!.value = ""
            }
            val dTeste = Date
            ff.println0("conferindo InicialDate = ${ff.InicialDate} DataAtual = ${Date.toString()} DataInicialVariárvel = ${dTeste.toString()}")

            divEmpresa = document.getElementById("${divEmpresa.id}") as HTMLDivElement
            divEntrar = document.getElementById("${divEntrar.id}") as HTMLDivElement

            divDesenv = document.getElementById("${divDesenv.id}") as HTMLDivElement

            btEntrar = document.getElementById("${btEntrar.id}") as HTMLButtonElement
            btEntrar.onclick = { clickEntrar(aaGenericoEmp()) }

            seEmpresa = document.getElementById("${seEmpresa.id}") as HTMLSelectElement
            seAdmRet = document.getElementById("${seAdmRet.id}") as HTMLSelectElement
            linkTeste = document.getElementById("linkTeste") as HTMLAnchorElement
            tbLista = document.getElementById(tbLista.id) as HTMLTableElement

            if (ff.gsDesenvolvedor.equals("")) {
                divDesenv.style.display = "block"
            }

        } catch (e: Exception) {
            console.log("Falha no mapear $sFalha")
        }
    }

    fun clickConectar() {//block: DIV.() -> Unit) {

        window.alert("não implementado!")

        //ff_2().showIndex0()

        //ffJavaScriptLoad1("\$(\"#htmlDiv1\").load(\"html/Password.html\");")

        //ffJavaScript("window.location='$sUrl';")

        /*
        println("executa clickConectar")
        if (txUsuario!!.value.equals("")) {
            ff_1.msgAviso("Informe o usuário")
        } else if (txSenha!!.value.equals("")) {
            ff_1.msgAviso("Informe a senha")
        } else {
            if (!gsDesenvolvedor.equals("P")) {
                seAdmRet = document.getElementById("seAdmRet") as HTMLSelectElement
                gsDesenvolvedor = seAdmRet!!.value
            }
            gsAcesso = " falha"
            //println0("zuza teste")
            if (!gsDom1.equals("")) {
                println("entrou em novo dominio")
                viewEntrar()
            } else {

                Service().getLogon(txUsuario!!.value, txSenha!!.value) { b ->
                    if (gsAcesso.equals("ok")) {
                        txUsuario!!.disabled = true
                        txSenha!!.disabled = true
                        ff_1.msgAviso("")
                        viewEntrar()
                    } else {
                        ff_1.msgAviso("Status do acesso = ${gsAcesso}")
                    }
                }

                println0("tLista terminanado")
                //busca as multiplas empresas ao qual o usuário tem acesso
                Service().getLogonMulti(txUsuario!!.value, txSenha!!.value) { lEmp00 ->
                    println0("vai parar aqui")
                    println0(lEmp00)
                    if (gsAcesso.equals("ok") && lEmp00 != null) {
                        //ff.println0("tbLista chegou ao acesso")
                        //se o mod2 diferente de vazio entendo que tem mai de uma opção para logon
                        if (lEmp00.get(0).aaGenericoEmpMod!!.mod2.equals(""))
                            preenchetbLista(lEmp00)
                    } else {
                        ff_1.msgAviso("Logon multiplo = ${gsAcesso}")
                    }
                }
            }
        }

         */
    }

    //fun viewEntrar(lemp: List<Empresa>) {
    fun viewEntrar() {
        //ff.println0("zuza password.viewEntrar()")
        Service().getEmpresas(txUsuario!!.value, txSenha!!.value) { lemp ->

            for (obj in lemp) {
                seEmpresa.add(document.create.option { id = obj.ID_EMPRESA.toString(); value = obj.ID_EMPRESA.toString(); text(obj.EMP_NOME) })
            }
            divEntrar.style.display = "block"
        }
    }

    private fun tbListaLimpar() {
        if (tbLista.rows.length > 1) {
            for (i in tbLista!!.rows.length downTo 2 step 1) {
                tbLista!!.deleteRow(i - 1)
            }
        }
    }

    fun preenchetbLista(lemp: Array<aaGenericoEmp>) {

        println0("executa preenchetbLista")
        //var lemp = _lemp.toMutableList()

        println0(lemp)
        if (lemp.size > 0) {
            divEmpresa.style.display = "block"
        }
        println0("executa preenchetbLista 01 " + lemp.size)

        //ff.println0(lemp)
        //ff.println0("tbLista chegou ao preenchetbLista 0 ${lemp.size}")

        var lemp1 = ArrayList<aaGenericoEmp>()
        for (obj1 in lemp) {
            println0("executa preenchetbLista 02")

            //ff.println0("tbLista chegou ao preenchetbLista 1")
            var iMod = 0
            var sMod1: String = "A"

            //ff.println0(obj)
            while (!sMod1.equals("")) {
                println0("executa preenchetbLista 03")
                var obj = aaGenericoEmp()
                obj.idGenEmpresa = obj1.idGenEmpresa
                obj.G01__ID = obj1.G01__ID
                obj.aaGenNome = obj1.aaGenNome
                obj.aaGenUrl = obj1.aaGenUrl
                obj.aaDom2 = obj1.aaDom2
                obj.mod00 = "Teste"
                obj.aaGenericoEmpMod = obj1.aaGenericoEmpMod

                if (!gsDesenvolvedor.equals("P")) {
                    if (obj.aaGenNome.contains("GRANADO DISTRIBUIDORA")) {
                        obj.aaGenUrl = "http://dlogica.ddns.net:8080/AdmRet-1/res"
                    } else {
                        obj.aaGenUrl = "http://dlogica.ddns.net:8080/AdmRetSUPORTE/res"
                    }
                }
                println0("executa preenchetbLista 04 ${obj.aaGenUrl}")

                iMod = iMod + 1

                when (iMod) {
                    1 -> sMod1 = obj.aaGenericoEmpMod!!.mod1.ffVss()
                    2 -> sMod1 = obj.aaGenericoEmpMod!!.mod2.ffVss()
                    3 -> sMod1 = obj.aaGenericoEmpMod!!.mod3.ffVss()
                    4 -> sMod1 = obj.aaGenericoEmpMod!!.mod4.ffVss()
                    5 -> sMod1 = obj.aaGenericoEmpMod!!.mod5.ffVss()
                    6 -> sMod1 = obj.aaGenericoEmpMod!!.mod6.ffVss()
                    7 -> sMod1 = obj.aaGenericoEmpMod!!.mod7.ffVss()
                    else -> sMod1 = "RET"
                }

                //println0("inicio println0 $sMod1")
                //sMod1 = sMod1.ffVss()
                //println0("tLinha = ${obj.mod00} lenght = ${sMod1.length} valor = $sMod1")
                obj.mod00 = sMod1

//                if (iMod > 3) {
//                    println0("previu $iMod")
//                    sMod1 = ""
//                }
                if (!sMod1.equals("")) {
                    lemp1.add(obj)
                }
            }
        }

        //println("tLinha vai imprimir o lemp1")
        println0("lemp1 " + lemp1.size)
        for (obj1 in lemp1) {
            //para ambiente de teste de fabricantes muda a URL
            //var tLinha = ff().tbGridNovaLinha1(tbLista, 4, true, "",
            var tLinha = ff().tbGridNovaLinha(tbLista, 3,
                    "|00-" +
                            "|01${obj1.aaGenNome}" +
                            "|02${obj1.mod00}" +
                            "|03${obj1.aaGenUrl}")

            //ff.println0("tLinha ${obj1.mod00}")
            //tLinha.onclick = { clickEntrar(sMod) }
            println("invocando clickEntrar no Password ${obj1.aaGenUrl}")
            tLinha.onclick = { clickEntrar(obj1) }
            //ff.println0("tLinha1 $sMod")
        }
    }


    //fun clickEntrar(block: DIV.() -> Unit) {
    fun clickEntrar(preSet1: aaGenericoEmp) {
        var preSet = ""
        //ff.println0(preSet1!!)
        preSet = preSet1!!.mod00
        println("executando clickEntrar99 preset = ${preSet1!!.mod00}")

        println("gsDesenvolvedor $gsDesenvolvedor ${preSet}")

        gsAcesso = " falha"

        val oLog = Logon.AdmRet()
        oLog.EMPRESA2 = seEmpresa!!.value
        oLog.LOGON = txUsuario!!.value
        oLog.SENHA = txSenha!!.value

        //Service().postGen(oNota!!.asDynamic(), "${ff.gsDom1}/notas/016/qtvolumes") { objReturn ->
        //Service().postLogonAdm(oLog) { lista ->
        Service().postLogonAdmRet00(oLog!!.asDynamic(), "logon/004/funcionarioLogon") { lista ->

            println0(lista)
            val obj = lista
            obj.EMPRESA2 = oLog.EMPRESA2
            obj.LOGON = oLog.LOGON
            obj.SENHA = oLog.SENHA

            if (obj.OBS.equals("ok")) {
                ff.gsToken = obj.CHAVE
                //gsTela = ""
                obj.LOGON = oLog.LOGON
                var sUrl = js("document.URL").toString()
                obj.FUNC_URLLOGON = sUrl

                println("$sUrl")
                sUrl = sUrl.replace("/000", "/***")
                println("preset $preSet novamenteFF")
//                println(obj.FUNC_FUNCAO)

                if (preSet.equals("")) {
                    if (obj.FUNC_FUNCAO.equals("E") //externo dlgw_representante
                            || obj.FUNC_FUNCAO.equals("G") //gerente
                            || obj.FUNC_FUNCAO.equals("S")) { //supervisor
                        sUrl = sUrl.replace("/dlgw_logon", "/dlgw_representante")
                        preSet = "REP"
                    } else if (obj.FUNC_FUNCAO.equals("F")) { //funcionario dlgw_coletor
                        sUrl = sUrl.replace("/dlgw_logon", "/dlgw_coletor")
                        //sUrl = sUrl.replace("desenv.intellij.dlg.dlgw_logon~1", "desenv-intellij-dlg-dlgw_coletor~1")
                        preSet = "COL"
                    } else if (obj.FUNC_FUNCAO.equals("B")) {
                        sUrl = sUrl.replace("/dlgw_logon", "/dlgw_producao")
                        preSet = "PRO"
                    }
                } else {
                    sUrl = sUrl.replace("/dlgw_logon", "/dlgw_retaguarda")
                    //sUrl = sUrl.replace(".dlgw_logon", ".dlgw_retaguarda")
                }

                println("preset $preSet novamente01")
//                println("$sUrl")
                obj.FUNC_TRANSPDOM00 = ff.gsDom1.replace("/", "!")
                obj.GSDESENVOLVEDOR = ff.gsDesenvolvedor.toString().ffVss()
                obj.GSCANVIEW = ff.gsCamView
                obj.GSLOGONSIS = preSet
                //obj.emp

                //println0(ff.gsFuncao)
                var sTeste = JSON.stringify(obj).replace("\"", "%22").replace(" ", "$")
                //println0(obj)
                sUrl = sUrl.replace("$", "AdmRet") //não sei se faz diferença
                sUrl = sUrl + "?obj=${sTeste.toString()}"
                println("$sUrl")
                //println("teste zuza")
                if (sUrl.contains("localhost:") || (sUrl.contains("/hom/"))) {
                    sUrl = sUrl.replace("/***/", "/777/")
                    //println("teste zuza1")
                    //sUrl = sUrl.replace("/***/", "/${goEMPRESA.EMP_WEBVERSAO}/")
                    linkTeste!!.innerText = sUrl
                    linkTeste!!.href = sUrl
                } else {
                    sUrl = sUrl.replace("/***", "/${obj.EMPRESA!!.EMP_WEBVERSAO}")
                    if (sUrl.contains("/pro/"))
                        obj.GSDESENVOLVEDOR = "P"
                    ffJavaScript("window.location='$sUrl';")
                }

            } else {
                ff_1.msgAviso("Falha no logon, usuário não encontrado zuza")
            }

        }
    }
}

