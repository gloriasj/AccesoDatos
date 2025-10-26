package modelDomain;
/*Objeto valor: no tiene identidad propia; atributos y son inmutables
* no es una entidad*/
public class Direccion {
    private String calle;
    private String ciudad;
    private int cp;

    public Direccion(String calle, String ciudad, int cp){
        if ( calle == null|| calle.isBlank()){
            throw new IllegalArgumentException("La calle no debe de estar vacia");
        }
        if ( ciudad == null ||ciudad.isBlank()){
            throw new IllegalArgumentException("La ciudad no debe de estar vacia");
        }
        this.calle=calle;
        this.ciudad=ciudad;
        this.cp=cp;
    }

    //Getters

    public String getDireccion() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCp() {
        return cp;
    }
}
