public class RoboHelice extends RoboAereo{
/*a ideia é de algo parecido com um drone ou helicóptero, como eles se inclinam para se locomver só
 * podem se mover na direção x e y após atingirem uma altura mínima
 */
    private int altitudeMin;

    public RoboHelice(String n, String d, int x, int y, int alt, int altMax, int altMin){
        super(n, d, x, y, alt, altMax);
        altitudeMin = altMin;
    }
    
    public void mover(int deltaX, int deltaY){
        if (getAltitude() >= altitudeMin) {
            setPosX(getPosX()+deltaX);
            setPosY(getPosY()+deltaY);
        }else{
            System.out.println("Sem altura suficiente para movimentar, altura atual: "+getAltitude()+" altura necessária: "+altitudeMin);
        }
    }

    public int getAltitudeMin() {
        return altitudeMin;
    }

    public void setAltitudeMin(int altitudeMin) {
        this.altitudeMin = altitudeMin;
    }
}
