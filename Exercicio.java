public abstract class Exercicio implements java.io.Serializable {
    private String nome;
    private String grupoMuscular;
    private double carga;
    private int repeticoes;
    private int series;
    private int tempoDescanso;

    public Exercicio() {}

    public Exercicio(String nome, String grupoMuscular, double carga, int repeticoes, int series, int tempoDescanso) {
        if (nome == null || nome.trim().isEmpty()) throw new AppException("O nome não pode ser vazio.");
        if (grupoMuscular == null || grupoMuscular.trim().isEmpty()) throw new AppException("O grupo muscular não pode ser vazio.");
        if (carga < 0) throw new AppException("A carga não pode ser negativa.");
        if (repeticoes < 0) throw new AppException("O número de repetições não pode ser negativo.");
        if (series < 0) throw new AppException("O número de séries não pode ser negativo.");
        if (tempoDescanso < 0) throw new AppException("O tempo de descanso não pode ser negativo.");

        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.carga = carga;
        this.repeticoes = repeticoes;
        this.series = series;
        this.tempoDescanso = tempoDescanso;
    }

    public String getNome() { return nome; }
    public String getGrupoMuscular() { return grupoMuscular; }
    public double getCarga() { return carga; }
    public int getRepeticoes() { return repeticoes; }
    public int getSeries() { return series; }
    public int getTempoDescanso() { return tempoDescanso; }

    public void setNome(String nome) { this.nome = nome; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }
    public void setCarga(double carga) { this.carga = carga; }
    public void setRepeticoes(int repeticoes) { this.repeticoes = repeticoes; }
    public void setSeries(int series) { this.series = series; }
    public void setTempoDescanso(int tempoDescanso) { this.tempoDescanso = tempoDescanso; }

    public abstract double calcularVolumeTotal();

    public void exibirDetalhes() {
        System.out.println(toString());
    }

    public int getTempoSegundos() {
        return tempoDescanso;
    }

    @Override
    public String toString() {
        return "Exercício: " + nome +
               "\nGrupo Muscular: " + grupoMuscular +
               "\nSéries: " + series +
               "\nRepetições: " + repeticoes +
               "\nCarga: " + carga + "kg" +
               "\nDescanso: " + tempoDescanso + "s";
    }
}
