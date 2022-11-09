import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        AddressBook addressBook = new AddressBook();
        Boolean keepMenu = true;

        do {
            System.out.println("====================================");
            System.out.println("               AGENDA               ");
            System.out.println("====================================");
            String answer = "";
            do {
                try {
                    System.out.println("1 - Mostrar lista");
                    System.out.println("2 - Crear nuevo contacto");
                    System.out.println("3 - Eliminar un contacto");
                    answer = reader.readLine();
                    switch (answer){
                        case "1": addressBook.list(); break;
                        case "2": addressBook.create(); break;
                        case "3": addressBook.delete(); break;
                        default: answer = "0";
                    }
                }catch (IOException e){
                    System.out.println("Error en la entrada de los datos.\n" + e);
                }
            }while(answer.equals("0"));

            do {
                try {
                    System.out.println("1 - Regresar a menu");
                    System.out.println("2 - Salir");
                    answer = reader.readLine();
                    switch (answer){
                        case "1": break;
                        case "2": keepMenu = false; break;
                        default: answer = "0";
                    }
                }catch (IOException e){
                    System.out.println("Error en la entrada de los datos.\n" + e);
                }
            }while (answer.equals("0"));
        }while (keepMenu);
    }
}