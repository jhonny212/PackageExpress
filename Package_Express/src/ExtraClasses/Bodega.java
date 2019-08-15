package ExtraClasses;


public class Bodega {
  private Paquete paquete;

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    public Bodega(Paquete paquete){
    this.paquete=paquete;
    }
    
}
