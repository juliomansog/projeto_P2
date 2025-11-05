public class Main {
    public static void main(String[] args) {

        DiarioTreino diario = new DiarioTreino();

        Usuario usuario = new Usuario(
                "Victor",
                25,
                75.0,
                1.78,
                "Hipertrofia",
                "Nenhuma limitação."
        );

        Treino treinoA = new Treino("Treino A - 10/01/2025");
        Treino treinoB = new Treino("Treino B - 12/01/2025");

        treinoA.adicionarExercicio(new ExercicioCardio("Esteira", 20, 3));
        treinoA.adicionarExercicio(new ExercicioAlongamento("Alongamento Geral", 120));
        treinoA.adicionarExercicio(new Exercicio("Supino", "Peito", 60, 10, 4, 90) {
            @Override
            public double calcularVolumeTotal() {
                return getCarga() * getRepeticoes() * getSeries();
            }
        });

        treinoB.adicionarExercicio(new ExercicioCardio("Bicicleta", 15, 4));
        treinoB.adicionarExercicio(new ExercicioAlongamento("Alongamento Pernas", 90));
        treinoB.adicionarExercicio(new Exercicio("Agachamento Livre", "Pernas", 80, 8, 4, 120) {
            @Override
            public double calcularVolumeTotal() {
                return getCarga() * getRepeticoes() * getSeries();
            }
        });

        diario.registrarTreino(usuario, treinoA);
        diario.registrarTreino(usuario, treinoB);

        System.out.println("\n=== Dados do Usuário ===");
        System.out.println(usuario);

        System.out.println("\n=== Resumo dos Treinos ===");
        usuario.exibirTreino("Treino A - 10/01/2025");
        usuario.exibirTreino("Treino B - 12/01/2025");

        Relatorio relatorio = new Relatorio(usuario, usuario.getTreinos());
        relatorio.gerarRelatorioProgresso();
        relatorio.gerarRelatorioFrequencia();
        relatorio.compararDatas("10/01/2025", "12/01/2025");

        diario.salvarDados();
        diario.carregarDados();
    }
}