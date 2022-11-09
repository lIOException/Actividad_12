import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

public class AddressBook {

    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    private HashMap<String,String> addressBook = new HashMap<>();

    public AddressBook() {

    }


    private void save(HashMap<String, String> copy){
        addressBook = copy;
    }

    public void list(){
        System.out.println("====================================");
        System.out.println("          LISTA DE CONTACTOS        ");
        System.out.println("====================================");
        for (Map.Entry<String, String> entry : addressBook.entrySet()){
            System.out.println("{"+entry.getKey()+"}:{"+entry.getValue()+"}");
        }
    }

    public void create(){
        HashMap<String,String> copy = addressBook;

        String number = "";
        String name = "";
        String answer = "";

        try{
            System.out.println("====================================");
            System.out.println("        CREAR NUEVO CONTACTO        ");
            System.out.println("====================================");
            System.out.println("Escrbe el numero de telefono nuevo.");
            number = reader.readLine();
            System.out.println("Escribe el nombre del contacto nuevo.");
            name = reader.readLine();
            copy.put(number,name);
            do {
                try {
                    System.out.println("Guardar cambios?");
                    System.out.println("1 - Si");
                    System.out.println("2 - No");
                    answer = reader.readLine();
                }catch (IOException e){
                    System.out.println("Error en la entrada de los datos.\n" + e);
                }

            }while((answer.equals("1") || answer.equals("2"))?false:true);
            if (answer.equals("1")){
                save(copy);
            }
        }catch (IOException e){
            System.out.println("Error en la entrada de los datos.\n" + e);
        }
    }

    public void delete(){
        HashMap<String,String> copy = addressBook;
        String number = "";
        String answer = "";

        try {
            System.out.println("====================================");
            System.out.println("        ELIMINAR UN CONTACTO        ");
            System.out.println("====================================");
            System.out.println("Escrbe el numero de telefono a eliminar.");
            number = reader.readLine();
            String deletedContact = copy.remove(number);

            if (deletedContact == null) {
                System.out.println("No se encontro el contacto");
            } else {
                System.out.println("Se eliminara:");
                System.out.println("{"+number+"}:{"+deletedContact+"}");
                do {
                    try {
                        System.out.println("Guardar cambios?");
                        System.out.println("1 - Si");
                        System.out.println("2 - No");
                        answer = reader.readLine();
                    }catch (IOException e){
                        System.out.println("Error en la entrada de los datos.\n" + e);
                    }
                }while((answer.equals("1") || answer.equals("2"))?false:true);
                if (answer.equals("1")){
                    save(copy);
                }
            }
        }catch (IOException e){
            System.out.println("Error en la entrada de los datos.\n" + e);
        }
    }
}
