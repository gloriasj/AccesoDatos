package modelDomain;
/*Objeto valor: no tiene identidad propia; atributos y son inmutables
* no es una entidad*/
class Direccion {
    private String direccion;
    private String ciudad;
    private int cp;

    public Direccion(String direccion, String ciudad, int cp){
        if ( direccion == null|| direccion.isBlank()){
            throw new IllegalArgumentException("La direccion no debe de estar vacia");
        }
        if ( ciudad == null ||ciudad.isBlank()){
            throw new IllegalArgumentException("La ciudad no debe de estar vacia");
        }
        this.direccion=direccion;
        this.ciudad=ciudad;
        this.cp=cp;
    }

    //Getters

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCp() {
        return cp;
    }
}
