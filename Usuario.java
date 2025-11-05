import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String objetivo;
    private String anotacoes;
    private int idade;
    private double peso;
    private double altura;

    private ArrayList<Treino> treinos = new ArrayList<>();

    public Usuario(String nome, int idade, double peso, double altura, String objetivo, String anotacoes) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.objetivo = objetivo;
        this.anotacoes = anotacoes;
    }

    // Getters
    public String getNome(){ return nome; }
    public String getObjetivo(){ return objetivo; }
    public int getIdade(){ return idade; }
    public double getPeso(){ return peso; }
    public double getAltura(){ return altura; }
    public String getAnotacoes(){ return anotacoes; }
    public ArrayList<Treino> getTreinos(){ return treinos; }

    // Setters
    public void setNome(String nome){ this.nome = nome; }
    public void setObjetivo(String objetivo){ this.objetivo = objetivo; }
    public void setIdade(int idade){ this.idade = idade; }
    public void setPeso(double peso){ this.peso = peso; }
    public void setAltura(double altura){ this.altura = altura; }
    public void setAnotacoes(String anotacoes){ this.anotacoes = anotacoes; }

    // Métodos
    public void adicionarTreino(Treino treino){
        if (treino != null) {
            treinos.add(treino);
        }
    }

    public Treino buscarTreino(String nomeTreino){
        for (Treino t : treinos) {
            if (t.getNome().equalsIgnoreCase(nomeTreino)) {
                return t;
            }
        }
        return null;
    }

    public void exibirTreino(String nomeTreino){
        Treino t = buscarTreino(nomeTreino);

        if (t != null){
            t.exibirResumoTreino();
        } else {
            System.out.println("Treino não encontrado.");
        }
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                "\nObjetivo: " + objetivo +
                "\nIdade: " + idade +
                "\nPeso: " + peso +
                "\nAltura: " + altura +
                "\nTreinos cadastrados: " + treinos.size() +
                "\nAnotações: " + anotacoes;
    }
}
