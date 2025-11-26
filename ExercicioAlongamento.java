public class ExercicioAlongamento extends Exercicio {
    private int duracao;

    public ExercicioAlongamento(String nome, int duracao) {
        super(nome, "Alongamento", 0, 1, 1, 0);
        if (duracao <= 0) throw new AppException("A duração do alongamento deve ser maior que zero.");
        this.duracao = duracao;
    }

    public int getDuracao() { return duracao; }

    public void setDuracao(int duracao) {
        if (duracao > 0) this.duracao = duracao;
    }

    public double calcularEsforco() {
        double kcalPorMinuto = 3.0;
        return (duracao / 60.0) * kcalPorMinuto;
    }

    @Override
    public double calcularVolumeTotal() {
        return calcularEsforco();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(toString());
        System.out.println("Duração sugerida: " + duracao + " segundos");
        System.out.printf("Esforço estimado: %.2f kcal%n", calcularEsforco());
    }

    @Override
    public String toString() {
        return "Alongamento: " + getNome() +
               "\nDuração: " + duracao + " segundos";
    }

    @Override
    public int getTempoSegundos() {
        return duracao;
    }
}
