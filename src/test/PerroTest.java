package test;

import domain.Perro;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PerroTest {

    public static void main(String[] args) {
        Perro pandy=new Perro("pandy","callejero",2,"la calle",1L);
        Perro lanegra=new Perro("lanegra","mezcla",6,"allado",2L);
        Perro monchi=new Perro("monchi","puroperro",2,"cerca de la negra",3L);

        ArrayList<Perro> perros=new ArrayList<Perro>();
        perros.add(pandy);
        perros.add(lanegra);
        perros.add(monchi);

        try {
            FileOutputStream fil =new FileOutputStream("perros.log");
            ObjectOutputStream archivo=new ObjectOutputStream(fil);
            archivo.writeObject(perros);
            archivo.close();
            FileInputStream filIn=new FileInputStream("perros.log");
            ObjectInputStream archivoInput=new ObjectInputStream(filIn);
            ArrayList<Perro> lista;
            for (int i=0;i<3;i++){

                System.out.println("==========================================================");
                lista= (ArrayList<Perro>) archivoInput.readObject();
                for (Perro p:lista){
                    System.out.println(p.toString());

                }
            }
        archivoInput.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void perrosTest(){
        Perro pandy=new Perro("pandy","callejero",2,"la calle",1L);
        Perro lanegra=new Perro("lanegra","mezcla",6,"allado",2L);
        Perro monchi=new Perro("monchi","puroperro",2,"cerca de la negra",3L);

        ArrayList<Perro> perros=new ArrayList<Perro>();
        perros.add(pandy);
        perros.add(lanegra);
        perros.add(monchi);

       assertEquals(3,perros.size());
    }




}