public class ExercicioCardio extends Exercicio {

    private int tempo; 
    private double metaDistancia; 

    public ExercicioCardio(String nome, int tempo, double metaDistancia) {
        
        setNome(nome);
        setGrupoMuscular("Cardio");
        setSeries(0);
        setRepeticoes(0);
        setCarga(0);
        
        this.tempo = tempo;
        this.metaDistancia = metaDistancia;
    }

    @Override
    public double calcularVolumeTotal() {
        
        return 0.0;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(toString());
        exibirTempoCardio();
        System.out.printf("Esforço (Intensidade): %.2f%n", calcularEsforco());
    }
    
   
    public double calcularEsforco() {
        if (tempo <= 0) {
            return 0.0;
        }
       
        return (this.metaDistancia / this.tempo) * 10.0;
    }

    
    public void exibirTempoCardio() {
        System.out.println("Tempo Alvo: " + this.tempo + " minutos");
    }

    @Override
    public String toString() {
        return "Cardio: " + getNome() +
               "\nDuração: " + tempo + " minutos" +
               "\nDistância: " + metaDistancia + " km";
    }

    

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        if (tempo >= 0) {
            this.tempo = tempo;
        }
    }

    public double getMetaDistancia() {
        return metaDistancia;
    }

    public void setMetaDistancia(double metaDistancia) {
        if (metaDistancia >= 0) {
            this.metaDistancia = metaDistancia;
        }
    }
}