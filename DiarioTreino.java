import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DiarioTreino implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Usuario> listaUsuarios;
    private List<Treino> historicoTreinos;
    private String dataInicio;

    public DiarioTreino(List<Usuario> listaUsuarios, List<Treino> historicoTreinos, String dataInicio) {
        this.listaUsuarios = listaUsuarios != null ? listaUsuarios : new ArrayList<>();
        this.historicoTreinos = historicoTreinos != null ? historicoTreinos : new ArrayList<>();
        this.dataInicio = dataInicio;
    }

    public DiarioTreino() {
        this(new ArrayList<>(), new ArrayList<>(), "");
    }

    public void registrarTreino(Usuario usuario, Treino treino) {
        if (usuario == null || treino == null) throw new AppException("Usuário ou treino nulo");
        usuario.adicionarTreino(treino);
        historicoTreinos.add(treino);
        System.out.println("Treino registrado para o usuário: " + usuario.getNome());
    }

    public List<Treino> buscarTreinoPorData(String data) {
        if (data == null || data.isEmpty()) {
            return Collections.emptyList();
        }
        return historicoTreinos.stream()
                .filter(t -> t.toString().contains(data))
                .collect(Collectors.toList());
    }

    public void gerarRelatorioSemanal(Usuario usuario) {
        if (usuario == null) {
            System.out.println("Usuário nulo.");
            return;
        }

        System.out.println("\n=== Relatório semanal de " + usuario.getNome() + " ===");

        List<Treino> treinos = usuario.getTreinos();
        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino registrado na semana.");
            return;
        }

        double totalVolume = 0;
        int totalTempo = 0;

        for (Treino t : treinos) {
            try {
                totalVolume += t.calcularCargaTotal();
            } catch (AppException ex) {
                System.out.println("Erro ao calcular volume do treino " + t.getNome() + ": " + ex.getMessage());
            }
            try {
                totalTempo += t.calcularTempoTotalSegundos();
            } catch (AppException ex) {
                System.out.println("Erro ao calcular tempo do treino " + t.getNome() + ": " + ex.getMessage());
            }
        }

        System.out.println("Treinos realizados: " + treinos.size());
        System.out.println("Volume total: " + totalVolume + " kg");
        System.out.println("Tempo total: " + (totalTempo / 60) + " min");
    }

    public void salvarDados() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dadosTreino.dat"))) {
            out.writeObject(listaUsuarios);
            out.writeObject(historicoTreinos);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarDados() {
        File f = new File("dadosTreino.dat");
        if (!f.exists()) {
            System.out.println("Arquivo de dados não encontrado: pulando carregamento.");
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            Object obj1 = in.readObject();
            Object obj2 = in.readObject();

            if (obj1 instanceof List) {
                try {
                    this.listaUsuarios = (List<Usuario>) obj1;
                } catch (ClassCastException ex) {
                    System.out.println("Formato inesperado para listaUsuarios no arquivo.");
                    this.listaUsuarios = new ArrayList<>();
                }
            } else {
                this.listaUsuarios = new ArrayList<>();
            }

            if (obj2 instanceof List) {
                try {
                    this.historicoTreinos = (List<Treino>) obj2;
                } catch (ClassCastException ex) {
                    System.out.println("Formato inesperado para historicoTreinos no arquivo.");
                    this.historicoTreinos = new ArrayList<>();
                }
            } else {
                this.historicoTreinos = new ArrayList<>();
            }

            System.out.println("Dados carregados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
            this.listaUsuarios = this.listaUsuarios != null ? this.listaUsuarios : new ArrayList<>();
            this.historicoTreinos = this.historicoTreinos != null ? this.historicoTreinos : new ArrayList<>();
        }
    }

    public List<Usuario> getListaUsuarios() { return listaUsuarios; }
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios != null ? listaUsuarios : new ArrayList<>();
    }

    public List<Treino> getHistoricoTreinos() { return historicoTreinos; }
    public void setHistoricoTreinos(List<Treino> historicoTreinos) {
        this.historicoTreinos = historicoTreinos != null ? historicoTreinos : new ArrayList<>();
    }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }
}
