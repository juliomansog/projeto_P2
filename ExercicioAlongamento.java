public class ExercicioAlongamento extends Exercicio {

    private int duracao;

   public ExercicioAlongamento(String nome, int duracao) throws AppException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new AppException("O nome do alongamento não pode ser vazio.");
        }
        if (duracao <= 0) {
            throw new AppException("A duração do alongamento deve ser maior que zero.");
        }
        setNome(nome);
        setSeries(1);
        setRepeticoes(1);
        setCarga(0);           
        setTempoDescanso(0);   
        setGrupoMuscular("Alongamento"); 
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

    public void exibirTempo() {
        System.out.println("Alongamento: " + getNome());
        System.out.println("Duração sugerida: " + duracao + " segundos");
    }

    @Override
    public double calcularVolumeTotal() {
        return calcularEsforco();
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(toString());
        exibirTempo();
        System.out.printf("Esforço estimado: %.2f kcal%n", calcularEsforco());
    }

    @Override
    public String toString() {
        return "Alongamento: " + getNome() +
               "\nDuração: " + duracao + " segundos";
    }
}
