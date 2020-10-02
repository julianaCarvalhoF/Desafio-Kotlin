class Curso(cod: Int, nome: String?, professorTitular: ProfessorTitular, professorAdjunto: ProfessorAdjunto, qtdMaximaAlunos: Int){

    var cod = cod
    var nome = nome
    var professorTitular = professorTitular
    var professorAdjunto = professorAdjunto
    var qtdMaximaAlunos = qtdMaximaAlunos
    var listaMatriculaAluno = mutableListOf<Aluno>()

    fun adicionarAluno( aluno: Aluno): Boolean {
        var quantidadeAluno = listaMatriculaAluno.size
        this.qtdMaximaAlunos?.let {
            if (it > quantidadeAluno) {
                listaMatriculaAluno.add(aluno)
                return true
            }
        }
        return false
    }
    fun excluirAluno(cod: Int) { //com a ajuda do professor Eduardo eu fiz este excluir para que quando ele achar o parametro não precise passar por toda a lista
        var alunoEncontrado = false
        for (aluno in listaMatriculaAluno) {
            if (aluno.codigo?.equals(cod)!!) { //professor não conseguir fazer o tratamento com let pois o break para de funcionar :(
                listaMatriculaAluno.remove(aluno)
                alunoEncontrado = true
                println("-----------Dados da Exclusão do Aluno-----------")
                println("Aluno ${aluno.nome} ${aluno.sobrenome} excluido!")
                println("Codigo: ${aluno.codigo}")
                break
            }
        }
        if (alunoEncontrado) {

        } else {
            println("-----------Dados da Exclusão do Aluno-----------")
            println("Aluno não encontrado!")
        }
    }
}