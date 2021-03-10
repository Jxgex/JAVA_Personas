package Clases;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);
        String nombre;
        int edad;
        char sexo;
        float altura;
        float peso;
        int peso_comprobante;
        boolean mayordeedad;
        
        System.out.println("Bienvenido");
        System.out.println("Ingresa el nombre");
        nombre = lector.nextLine();
        System.out.println("Ingresa la edad");
        edad = lector.nextInt();
        do{
            System.out.println("Ingresa el sexo M.- Mujer, H.- Hombre");
            sexo = lector.next().charAt(0);
        }while(sexo!='M'&&sexo!='H');
        System.out.println("Ingresa el peso");
        peso = lector.nextFloat();
        System.out.println("Ingresa la altura");
        altura = lector.nextFloat();
        Persona persona = new Persona(nombre,edad,sexo,peso,altura);
        peso_comprobante = persona.calcularIMC();
        switch(peso_comprobante){
            case -1:
                System.out.println("Bajo de peso");
                break;
            case 0:
                System.out.println("Peso correcto");
                break;
            case 1:
                System.out.println("Sobre peso");
                break;
        }
        mayordeedad = persona.esMayordeEdad();
        if(mayordeedad){
            System.out.println("Es mayor de edad");
        }
        else{
            System.out.println("No es mayor de edad");
        }
        System.out.println(persona.toString());
    }
    
}
