enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Matrícula realizada: ${usuario.nome} está matriculado na formação $nome.")
    }
}

fun main() {
    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 60)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 120)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Web", 90)

    // Criação de uma formação
    val formacao = Formacao("Desenvolvedor Full Stack", listOf(conteudo1, conteudo2, conteudo3))

    // Criação de usuários
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    // Matrícula dos usuários na formação
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    // Exibição das informações
    println("Formação: ${formacao.nome}")
    println("Conteúdos Educacionais:")
    formacao.conteudos.forEach { conteudo ->
        println("- ${conteudo.nome} - Duração: ${conteudo.duracao} minutos")
    }
    println("Usuários Matriculados:")
    formacao.inscritos.forEach { usuario ->
        println("- ${usuario.nome}")
    }
}
