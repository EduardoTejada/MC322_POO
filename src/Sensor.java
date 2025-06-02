public abstract class Sensor {
    private double raio;

    Sensor(double r){
        this.raio = r;
    }

    public abstract void monitorar(Ambiente amb);

    public void acionarSensores(Ambiente amb){ //Adaptado par ainterface
        this.monitorar(amb);
    }
    

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
