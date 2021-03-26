package model

import kotlin.js.Date

open class aaGenericoEmp {

    var idGenEmpresa = ""
    var aaGenNome = ""
    var aaGenUrl = ""
    var aaDom2 = ""
    var G01__ID = ""
    var G02__VALUE = ""
    var G03__TEXT = ""
    //var G04__TEXT = ""
    //outros campos
    var mod00: String = ""

    var aaGenericoEmpMod: aaGenericoEmpMod? = null

    fun ini(G01: String, G02: String, G03: String): aaGenericoEmp {
        var obj = aaGenericoEmp()
        obj.G01__ID = G01
        obj.G02__VALUE = G02
        obj.G03__TEXT = G03
        return obj
    }

    fun iniMes(): List<aaGenericoEmp> {
        val lObj = ArrayList<aaGenericoEmp>()
        lObj.add(ini("01","01","JANEIRO"))
        lObj.add(ini("02","02","FEVEREIRO"))
        lObj.add(ini("03","03","MARÇO"))
        lObj.add(ini("04","04","ABRIL"))
        lObj.add(ini("05","05","MAIO"))
        lObj.add(ini("06","06","JUNHO"))
        lObj.add(ini("07","07","JULHO"))
        lObj.add(ini("08","08","AGOSTO"))
        lObj.add(ini("09","09","SETEMBRO"))
        lObj.add(ini("10","10","OUTUBRO"))
        lObj.add(ini("11","11","NOVEMBRO"))
        lObj.add(ini("12","12","DEZEMBRO"))
        return lObj.toList()
    }

    fun iniAno(): List<aaGenericoEmp> {
        val lObj = ArrayList<aaGenericoEmp>()
        var iAno = Date().getFullYear() - 5
        for (i in iAno + 10 downTo iAno step 1)
            lObj.add(ini(i.toString(), i.toString(), i.toString()))
        return lObj.toList()
    }

}