import utils.ff

//fun main(args: Array<String>) {
fun main() { //teste de inclusao 11/09/19
    console.log("Inicio do main para dlgw_araiz")
    if (ff.gsDesenvolvedor.equals("P"))
        console.log("Ambiente de produção ${ff.gsEmpVersao}")
    else
        console.log("Homologação teste ${ff.gsEmpVersao}")
}
