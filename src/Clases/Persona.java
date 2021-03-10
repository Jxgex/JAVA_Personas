package Clases;

import java.util.Random;

public class Persona {
    /*Constante de la clase*/
    final private char Sexo_constante = 'H';
    final private int Final_Peso_Bajo = -1;
    final private int Final_Peso_Ideal = 0;
    final private int Final_Sobre_Peso = 1;
    /*Atributos de la clase*/
    private String Nombre = "";
    private int Edad = 0;
    private String NSS;
    private char Sexo = Sexo_constante;
    private float Peso = 0.0f;
    private float Altura = 0.0f;
    
    public Persona(){
        this.generarNSS();
    }
    public Persona(String Nombre, int Edad, char Sexo, float Peso, float Altura){
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Peso = Peso;
        this.Altura = Altura;
        this.generarNSS();
    }
    /* Métodos de la clase */
    public boolean esMayordeEdad(){
        return (this.Edad>=18)?true:false;
    }
    private boolean ComprobarSexo(char sexo){
        return (this.Sexo==sexo)?true:false;
    }
    @Override
    public String toString() {
        double altura;
        if(this.getAltura()>10){
            altura = (this.getAltura()/10);
        }
        else{
            altura = Math.round(this.getAltura()*100.0)/100.0;
        }
        return "El nombre de la persona es:"+this.getNombre()+"\n"+
            "Su edad es de: "+this.getEdad()+"\n"+
            "El sexo es: "+this.getSexo()+"\n"+
            "El peso es de: "+this.getPeso()+"\n"+
            "La altura es de: "+altura+"\n"+
            "El NSS es: "+this.getNSS().toUpperCase();
    }
    private void generarNSS (){
        String auxiliar = "";
        int interaccion;
        int codigo;
        int random;
        
        Random nss = new Random();
        
        for(interaccion = 0; interaccion<=7; interaccion++){
            random = (int) (Math.random()*2+1);
            if(random==1) auxiliar+=nss.nextInt(10);
            else{
                codigo = (int)Math.floor(Math.random()*(122 - 97)+97);
                auxiliar += (char)codigo;
            }
        }
        this.NSS = auxiliar;
    }
    public int calcularIMC (){
        int calculo;
        calculo = (this.getAltura()<10)? (int)(this.getPeso()/Math.pow(this.getAltura(), 2))
                :(int)(this.getPeso()/Math.pow(this.getAltura()/10, 2));
        int retorno = 0;
        switch(this.getSexo()){
            case 'H':
                if (calculo < 20) {
                    retorno = Final_Peso_Bajo;
                } else if (calculo == 20 || calculo <= 25) {
                    retorno = Final_Peso_Ideal;
                } else {
                    retorno = Final_Sobre_Peso;
                }
                break;
            case 'M':
                if (calculo < 19) {
                    return Final_Peso_Bajo;
                } else if (calculo == 19 || calculo <= 24) {

                } else {
                    return Final_Sobre_Peso;
                }
                break;
        }
        return retorno;
    }
    /* Sección de métodos para el accesoo a la información de la clase Getter, Setter*/
    public String getNombre() {
        return Nombre;
    }
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getNSS() {
        return NSS;
    }
    
    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
    }

    public double getAltura() {
        return Altura;
    }

    public void setAltura(float Altura) {
        this.Altura = Altura;
    }
}
