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
       try {
            if (treino == null) {
                throw new AppException("Erro: o treino não pode ser nulo.");
            }

            treinos.add(treino);
            System.out.println("Treino adicionado com sucesso.");

        } catch (AppException e) {
            System.out.println("Falha ao adicionar treino: " + e.getMessage());
        }
    }

    public Treino buscarTreino(String nomeTreino){
         try {
            if (nomeTreino == null || nomeTreino.isEmpty()) {
                throw new AppException("O nome do treino não pode ser vazio.");
            }

            for (Treino t : treinos) {
                if (t.getNome().equalsIgnoreCase(nomeTreino)) {
                    return t;
                }
            }

            throw new AppException("Treino não encontrado.");

        } catch (AppException e) {
            System.out.println("Erro ao buscar treino: " + e.getMessage());
            return null;
        }
    }



    public void exibirTreino(String nomeTreino){
         try {
            Treino t = buscarTreino(nomeTreino);

            if (t == null) {
                throw new AppException("Não foi possível exibir porque o treino não existe.");
            }

            t.exibirResumoTreino();

        } catch (AppException e) {
            System.out.println("Erro: " + e.getMessage());
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
