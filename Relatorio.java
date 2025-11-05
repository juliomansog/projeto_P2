import java.util.List;

public class Relatorio {

    private Usuario usuario;
    private List<Treino> listaTreinos;

    public Relatorio(Usuario usuario, List<Treino> listaTreinos) {
        this.usuario = usuario;
        this.listaTreinos = listaTreinos;
    }

    public void gerarRelatorioProgresso() {
        System.out.println("\n=== Relatório de Progresso ===");
        System.out.println("Usuário: " + usuario.getNome());

        double totalVolume = 0;
        for (Treino t : listaTreinos) {
            totalVolume += t.calcularCargaTotal();
        }

        System.out.println("Treinos realizados: " + listaTreinos.size());
        System.out.println("Volume total acumulado: " + totalVolume + " kg");
    }

    public void gerarRelatorioFrequencia() {
        System.out.println("\n=== Relatório de Frequência ===");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Número total de treinos: " + listaTreinos.size());
    }

    public void compararDatas(String data1, String data2) {
        System.out.println("\n=== Comparação entre " + data1 + " e " + data2 + " ===");

        List<Treino> d1 = listaTreinos.stream()
                .filter(t -> t.toString().contains(data1))
                .toList();

        List<Treino> d2 = listaTreinos.stream()
                .filter(t -> t.toString().contains(data2))
                .toList();

        double vol1 = d1.stream().mapToDouble(Treino::calcularCargaTotal).sum();
        double vol2 = d2.stream().mapToDouble(Treino::calcularCargaTotal).sum();

        System.out.println("Volume " + data1 + ": " + vol1 + " kg");
        System.out.println("Volume " + data2 + ": " + vol2 + " kg");

        if (vol1 > vol2) System.out.println("Melhor desempenho em " + data1);
        else if (vol2 > vol1) System.out.println("Melhor desempenho em " + data2);
        else System.out.println("Desempenho igual nos dois dias.");
    }
}
