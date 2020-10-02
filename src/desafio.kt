fun main(){
    var teste = digitalHouseManager()
    var professorTitular1 = ProfessorTitular("Cesar", "sei la", 1, 10, "kotlin")
    var professorAdjunto1 = ProfessorAdjunto("mateus", "sei la", 2, 15,50)
    var curso1 = Curso(1,"matematica",professorTitular1,professorAdjunto1,50)
    var curso2 = Curso(2,"portugues",professorTitular1,professorAdjunto1,50)
    var aluno1 = Aluno("Juliana","Carvalho",1)

    try {
        teste.registrarCurso(curso1)
        teste.registrarCurso(curso2)
        teste.registrarProfessorAdjunto(professorAdjunto1)
        teste.registrarProfessorTitular(professorTitular1)
        teste.registrarAluno(aluno1)
        teste.matriculaAluno(1,1)
        teste.alocarProfessores(2,1,2)

    }catch (ex: Exception){
        println("ERRO NO SEU CADASTRO $ex")
    }
    try {

        teste.excluirCurso(1)
        teste.excluirProfessorAdjunto(3)
        teste.excluirProfessorTitular(4)
        teste.curso.excluirAluno(1)
        teste.alocarProfessores(1, 1, 2)
    }catch (ex: Exception){
        println("ERRO NA SUA EXCLUSÃO $ex")
    }

}
