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
        try{
            if (nome == null || nome.trim().isEmpty())
                throw new AppException("nome não pode ser vazio");
            if (idade <= 0)
                throw new AppException("idade deve ser maior que zero");
            if (peso <= 0)
                throw new AppException("peso deve ser maior que zero");
            if (altura <= 0)
                throw new AppException("Altyra deve ser maior que zero");
    
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.objetivo = objetivo;
        this.anotacoes = anotacoes;
        }catch (AppException e) {
            System.out.println("Erro ao criar usúario"+ e.getMessage());
        }
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
    public void setNome(String nome){
        try {
            if (nome == null || nome.trim().isEmpty())
                throw new AppException("Nome inválido");
            this.nome = nome; 
        }catch (AppException e) {
            System.out.println("Erro: + e.getMessage());
        }
    }
    public void setObjetivo(String objetivo){  
        this.objetivo = objetivo; 
    }
    public void setIdade(int idade){ 
        try{
            if (idade <= 0)
                throw new AppException("idade não pode ser negativa");
            this.idade = idade; 
        }catch{(AppException e) {
            System.out.println("Erro: " +  e.getMessage());
        }
    }
    public void setPeso(double peso)
        try {
            if (peso <= 0)
                throw new AppException("Peso inválido.");
            this.peso = peso;

        } catch (AppException e){
            System.out.println("Erro: " + e.getMessage());
        }
    } 
      
    public void setAltura(double altura){
        try {
            if (altura <= 0)
                throw new AppException("Altura inválida.");
            this.altura = altura;

        } catch (AppException e){
            System.out.println("Erro: " + e.getMessage());
        }
    } 
    public void setAnotacoes(String anotacoes){ this.anotacoes = anotacoes; }

    // Métodos
    public void adicionarTreino(Treino treino){
        try{
            if (treino != null) 
                throw new AppException("treino não pode ser nulo");
            treinos.add(treino);
        }catch(AppException e){
             System.out.println("Erro ao adicionar treino: " + e.getMessage());
        }
    }

    public Treino buscarTreino(String nomeTreino){
       try {
            if (nomeTreino == null || nomeTreino.trim().isEmpty())
                throw new AppException("Nome do treino inválido.");

            for (Treino t : treinos) {
                if (t.getNome().equalsIgnoreCase(nomeTreino)) {
                    return t;
                }
            }

            throw new AppException("Treino não encontrado.");

        } catch (AppException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void exibirTreino(String nomeTreino){
        try{
            Treino t = buscarTreino(nomeTreino);

            if (t != null)
                throw new AppException("Erro: treino não existe.");
            t.exibirResumoTreino();
        } catch(AppException e) {
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
