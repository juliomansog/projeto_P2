import java.util.ArrayList;

public class Treino {
    private String nome;
    private ArrayList<Exercicio> exercicios = new ArrayList<>();

    public Treino(String nome) {
        this.nome = nome;
    }

  
    public String getNome() { return nome; }
    public ArrayList<Exercicio> getExercicios() { return exercicios; }

    public void setNome(String nome) { this.nome = nome; }

  
    public void adicionarExercicio(Exercicio exercicio) {
          try {
            if (exercicio == null) {
                throw new AppException("Erro: o exercício não pode ser nulo.");
            }

            exercicios.add(exercicio);
            System.out.println("Exercício adicionado com sucesso!");

        } catch (AppException e) {
            System.out.println("Falha ao adicionar exercício: " + e.getMessage());
        }
    }
    public boolean removerExercicio(String nome) {
         try {
            if (nomeExercicio == null || nomeExercicio.isEmpty()) {
                throw new AppException("O nome do exercício não pode ser vazio.");
            }

            boolean removido = exercicios.removeIf(e -> e.getNome().equalsIgnoreCase(nomeExercicio));

            if (!removido) {
                throw new AppException("Exercício não encontrado para remoção.");
            }

            return true;

        } catch (AppException e) {
            System.out.println("Erro ao remover exercício: " + e.getMessage());
            return false;
        }
    }

       

    public double calcularCargaTotal() {
        try {
            if (exercicios.isEmpty()) {
                throw new AppException("Nenhum exercício cadastrado para calcular a carga.");
            }

            double total = 0;
            for (Exercicio e : exercicios) {
                total += e.calcularVolumeTotal();
            }
            return total;

        } catch (AppException e) {
            System.out.println("Erro ao calcular carga total: " + e.getMessage());
            return 0;
        }
    }

    
    public int calcularTempoTotalSegundos() {
        try{
            if (exercicio.isEmpty(){
                throw new AppException("nenhum exercicio cadastrado para calcúlo do tempo");
            }
            int total = 0;
            for (Exercicio e : exercicios) {
                total += e.getTempoSegundos() * e.getSeries();
            }
            return total;
        }catch (AppException e) {
            System.out.println("Erro ao calcúlar tempo total" + e.getMessage());
            return 0 ;
        }
    }

 
    public void exibirResumoTreino() {
        try{
            if (exercicios.isEmpty()) {
                throw new AppExcepption("não é possível exibir resumo : nenhum exercicio cadastrado.");
            }
             System.out.println("Treino: " + nome);
             for (Exercicio e : exercicios) {
                System.out.println("\n------------------");
                e.exibirDetalhes();
            }

            System.out.println("\nVolume total : " + calcularCargaTotal() + " kg");

            int tempo = calcularTempoTotalSegundos();
            System.out.println("Tempo total : " + tempo + " s (" + (tempo / 60) + " min " + (tempo % 60) + " s)");

        } catch (AppException e) {
            System.out.println("Erro ao exibir o resumo do treino: " + e.getMessage());
        }
    }

    @override 
    public String toString() {
        return "Treino: " + nome + " | Exercícios: " + exercicios.size();
    }
}




