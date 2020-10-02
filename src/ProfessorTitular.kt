class ProfessorTitular (nome: String?,
                        sobrenome:String?,
                        codigoProfessor:Int?,
                        tempCasa: Int,
                        especialidade: String) : Professor(nome,sobrenome, codigoProfessor, tempCasa) {

    var especialidade = especialidade
}