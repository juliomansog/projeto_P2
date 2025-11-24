public class ExercicioCardio extends Exercicio {

    private int tempo;
    private double metaDistancia;

      public ExercicioCardio(String nome, int tempo, double metaDistancia) throws AppException {
            if (nome == null || nome.trim().isEmpty()) {
                throw new AppException("O nome do exercício cardio não pode ser vazio.");
            }
            if (tempo <= 0) {
                throw new AppException("O tempo do exercício cardio deve ser maior que zero.");
        }
            if (metaDistancia < 0) {
                throw new AppException("A meta de distância não pode ser negativa.");
        }
        setNome(nome);
        setGrupoMuscular("Cardio");
        setSeries(1);
        setRepeticoes(1);
        setCarga(0); 
        this.tempo = tempo;
        this.metaDistancia = metaDistancia;
    }

    @Override
    public double calcularVolumeTotal() {
        return calcularEsforco();
    }

    @Override
    public int getTempoDescanso() {
        return 0;
    }

    public double calcularEsforco() {
        if (tempo <= 0) return 0.0;
        return (this.metaDistancia / this.tempo) * 10.0;
    }

    public int getTempoTotalSegundos() {
        return this.tempo * 60;
    }

    public void exibirTempoCardio() {
        System.out.println("Tempo Alvo: " + this.tempo + " minutos");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(toString());
        exibirTempoCardio();
        System.out.printf("Esforço (Intensidade): %.2f%n", calcularEsforco());
    }

    @Override
    public String toString() {
        return "Cardio: " + getNome() +
               "\nDuração: " + tempo + " minutos" +
               "\nDistância: " + metaDistancia + " km";
    }

    public int getTempo() { return tempo; }
    public void setTempo(int tempo) {
        if (tempo >= 0) this.tempo = tempo;
    }

    public double getMetaDistancia() { return metaDistancia; }
    public void setMetaDistancia(double metaDistancia) {
        if (metaDistancia >= 0) this.metaDistancia = metaDistancia;
    }
}
