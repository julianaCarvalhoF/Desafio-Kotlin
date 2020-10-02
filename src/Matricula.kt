import java.time.LocalDateTime

class Matricula(aluno:Aluno, curso: Curso, dataMatricula: LocalDateTime = LocalDateTime.now()){
    var aluno = aluno
    var curso = curso
    var dataMatricula = dataMatricula

}
