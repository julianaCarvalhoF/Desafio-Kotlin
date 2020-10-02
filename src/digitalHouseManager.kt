import java.time.LocalDateTime

class digitalHouseManager {
    var listaAlunos = mutableListOf<Aluno>()
    var listaProfessorAdjunto = mutableListOf<ProfessorAdjunto>()
    var listaProfessorTitular = mutableListOf<ProfessorTitular>()
    var listaCurso = mutableListOf<Curso>()
    var listaMatricula = mutableListOf<Matricula>()
    lateinit var curso: Curso
    lateinit var professorTitular : ProfessorTitular

    fun registrarCurso(curso: Curso?) {
        curso?.let {
            listaCurso.add(it) }
        println("-----------Registro de Curso-----------")
        println("Curso criado! DADOS DO CURSO:")
        println("Nome do Curso: ${curso?.nome}")
        println("Codigo do curso: ${curso?.cod}")
        println("Nome do Professor Adjunto: ${curso?.professorAdjunto?.nome}")
        println("Nome do Professor Titular: ${curso?.professorTitular?.nome}")
        println("Quantidade Maxima de Alunos: ${curso?.qtdMaximaAlunos}")
    }


    fun excluirCurso(cod: Int) { //com a ajuda do professor Eduardo eu fiz este excluir para que quando ele achar o parametro não precise passar por toda a lista
        var cursoEncontrado = false
        for (curso in listaCurso){
            if (curso.cod.equals(cod)) {
                listaCurso.remove(curso)
                cursoEncontrado = true
                println("-----------Dados da Exclusão do Curso-----------")
                println("Curso ${curso.nome} excluido!")
                println("Codigo: ${curso.cod}")
                break
            }
        }
        if (cursoEncontrado){

        } else {
            println("-----------Dados da Exclusão do Curso-----------")
            println("Curso não encontrado!")
        }

        //listaCurso.forEach{
        //   if (it.cod.equals(cod)) {
        //       listaCurso.removeAt(it.cod)
        //       println("Curso ${curso.nome} excluido!")
        //       println("Codigo: ${curso.cod} excluido!")
        //  } else {
        //      println("Esse curso não existe")
        //  }
        //}
    }

    fun registrarProfessorAdjunto(professorAdjunto: ProfessorAdjunto?){
        professorAdjunto?.let{
            listaProfessorAdjunto.add(it) }
        println("professor ${professorAdjunto?.nome} criado com sucesso!")

        }

    fun excluirProfessorAdjunto(cod: Int) {
        var professorEncontrado = false
        for (professorAdjunto in listaProfessorAdjunto) {
                if (professorAdjunto.codigoProfessor?.equals(cod)!!) {  //professor não conseguir fazer o tratamento com let pois o break para de funcionar :(
                    listaProfessorAdjunto.remove(professorAdjunto)
                    professorEncontrado = true
                    println("-----------Dados da Exclusão do Professor Adjunto-----------")
                    println("Nome: ${professorTitular.nome} ${professorTitular.sobrenome} ")
                    println("Codigo: ${professorAdjunto.codigoProfessor}")

                    break
            }
        }
        if (professorEncontrado){
        }
        else {
            println("-----------Dados da Exclusão do Professor Adjunto-----------")
            println("Professor não encontrado!")
        }
    }

    fun registrarProfessorTitular(professorTitular: ProfessorTitular){
        professorTitular?.let{
            listaProfessorTitular.add(it) }
        println("professor ${professorTitular?.nome} criado com sucesso!")

    }

    fun excluirProfessorTitular(cod: Int) {
        var professorTitularEncontrado = false
        for (professorTitular in listaProfessorTitular) {
            if (professorTitular.codigoProfessor?.equals(cod)!!) { //professor não conseguir fazer o tratamento com let pois o break para de funcionar :(
                listaProfessorTitular.remove(professorTitular)
                professorTitularEncontrado = true
                println("-----------Dados da Exclusão do Professor Titutlar-----------")
                println("Nome: ${professorTitular.nome} ${professorTitular.sobrenome} ")
                println("Codigo: ${professorTitular.codigoProfessor}")
                break
            }
        }
        if (professorTitularEncontrado){

        }
        else {
            println("-----------Dados da Exclusão do Professor Titular-----------")
            println("Professor não encontrado!")
        }
    }

    fun registrarAluno( aluno: Aluno){

        aluno?.let {
            listaAlunos?.add(it)
            println("-----------Dados do Aluno-----------")
            println("Codigo do Aluno: ${aluno.codigo}")
            println("Nome do Aluno: ${aluno.nome}")
            println("Sobrenome do Aluno: ${aluno.sobrenome}")
        }
    }

    fun matriculaAluno(codigoAluno: Int, codigoCurso:Int) {
        var (aluno) = listaAlunos.filter { it.codigo == codigoAluno}
        var (curso) = listaCurso.filter { it.cod == codigoCurso }

        if (curso.adicionarAluno(aluno)){
            var matricula = Matricula( aluno, curso, LocalDateTime.now())
            listaMatricula.add(matricula)
            println("------------------------------")
            println("Matricula feita com sucesso!!")
        }
        else {
        println("Matricula de Erro. Tente novamente")
    }
}

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        var (professorTitular) = listaProfessorTitular.filter { it.codigoProfessor == codigoProfessorAdjunto }
        var (professorAdjunto) = listaProfessorAdjunto.filter { it.codigoProfessor == codigoProfessorTitular }
        var (curso) = listaCurso.filter { it.cod == codigoCurso }

        curso.professorAdjunto = professorAdjunto
        curso.professorTitular = professorTitular
        println("------------------------------")
        println("Alocacao feita com sucesso!!")

    }
}

