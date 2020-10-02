class ProfessorAdjunto(nome: String?,
                       sobrenome:String?,
                       codigoProfessor:Int?,
                       tempCasa: Int,
                       qtdHorasMontoria:Int) : Professor(nome,sobrenome,codigoProfessor,tempCasa) {

    var qtdHorasMonitoria = qtdHorasMontoria
}