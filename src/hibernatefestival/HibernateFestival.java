/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatefestival;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author JuanPablo
 */
public class HibernateFestival {

    
    public static void main(String[] args) {
        
        //CONFIGURACION DE CONEXION CON BD
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();
        ////////////////////////////////////////////////////
        
    
        //VARIABLES
        Boolean quedarse = true; //para el bucle while
        int opcion = 0; //opcion elegida
        Scanner sc = new Scanner(System.in);
        
        Query query;
        /////////////////
        
       
        
        /*/////////////EJEMPLO TRAER, MODIFICAR Y BORRAR
        Cancion can = (Cancion) ses.load(Cancion.class, 1 );
        System.out.println(can.getTitulo());
        System.out.println(can.getRuta());
        //le cambio la ruta
        can.setRuta("www.pepelurutaaa");
        ses.save(can);
        //e imprimo de nuevo
        System.out.println(can.getTitulo());
        System.out.println(can.getRuta());
        
        para borrar, haces la busqueda y pones ses.save(objetoAborrar)
        /*//////////////////////////////////////////////////////
        
        
        
        
        
        /*  POR SI TENGO KE METERLOS OTRA VEZ
        Cantante c1 = new Cantante("Enrique Bunbury", true);
        ses.save(c1);
        
        Cantante c2 = new Cantante("Paul McCartney", true);
        ses.save(c2);
        
        Guitarra g1 = new Guitarra("Santi Campillo", true);
        ses.save(g1);
        
        Guitarra g2 = new Guitarra("Santana", true);
        ses.save(g2);
        
        Festival f1 = new Festival("Zaidin Festival", "Granada", true);
        ses.save(f1);
        
        Festival f2 = new Festival("SOS Festival", "Murcia", true);
        ses.save(f2);
        
        
        Grupo g1 = new Grupo("SpanishGroup", 1, 1, true);
        ses.save(g1);
        
        Grupo g2 = new Grupo("InternationalGroup", 2, 2, true);
        ses.save(g2);
        
        
        Cartel c1 = new Cartel(1, 1, true);
        ses.save(c1);
        */
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Bienvenido al gestor de grupos y festivales de música!!");
        
        do{
            
            System.out.println("\nQue desea realizar?");
            System.out.println("\t1 para ver LISTA de CANTANTES");
            System.out.println("\t2 para insertar/modificar/eliminar CANTANTE\n");
            System.out.println("\t3 para ver LISTA de GUITARRAS");
            System.out.println("\t4 para insertar/modificar/eliminar GUITARRA\n");
            System.out.println("\t5 para ver LISTA de GRUPOS");
            System.out.println("\t6 para insertar/modificar/eliminar GRUPOS\n");
            System.out.println("\t7 para ver LISTA de FESTIVALES");
            System.out.println("\t8 para insertar/modificar/eliminar FESTIVAL\n");
            System.out.println("\t9 para ver LISTA de CARTELES DE FESTIVALES");
            System.out.println("\t10 para insertar o eliminar un grupo de un CARTEL DE FESTIVAL\n");   
            System.out.println("\t11 para GUARDAR y SALIR");
            opcion = sc.nextInt();
            
            switch(opcion){
                
                case 1:
 
                    mostrarCantantes(ses);
  
                    break;
                 
                case 2:
                    
                    System.out.println("\nQue desea realizar?\nPulse 1 para insertar nuevo\nPulse 2 para modificar\nPulse 3 para eliminar");
                    opcion = sc.nextInt();
                    
                    if(opcion == 1){
                        sc.nextLine();
                        System.out.println("Introduce el nombre del cantante: ");
                        String nombre = sc.nextLine();
                        Cantante can = new Cantante(nombre, true);
                        ses.save(can);
                        System.out.println("\n\tNuevo cantante añadido correctamente");
                    }
                    
                    
                    if(opcion == 2){
                        
                        System.out.println("Te mostramos los cantantes: ");
                        mostrarCantantes(ses);
                        
                        Boolean encontrado = false;
                        sc.nextLine();
                        System.out.println("Introduzca el ID del cantante que desea modificar: ");
                        int id = sc.nextInt();
                        //PRIMERO HAGO UNA BUSQUEDA DE ESE CANTANTE
                        if(ses.createQuery("SELECT p FROM Cantante p WHERE id=" + id).uniqueResult() != null){
                            Cantante can = (Cantante) ses.createQuery("SELECT p FROM Cantante p WHERE id=" + id).uniqueResult();
                            //Y LUEGO LO MODIFICO
                            sc.nextLine(); //sino no furula
                            System.out.println("Introduzca el nuevo nombre del cantante: ");
                            String nombre = sc.nextLine();
                            can.setNombre(nombre);
                            ses.save(can);
                            System.out.println("\n\tCantante modificado corectamente");
                            encontrado = true;
                        }
                        
                        
                        if(!encontrado){
                            System.out.println("\n\tCantante no encontrado");
                        }
                    }
                    
                    
                    
                    if(opcion == 3){
                        
                        System.out.println("Te mostramos los cantantes: ");
                        mostrarCantantes(ses);
                        
                        Boolean encontrado = false;
                        sc.nextLine();
                        System.out.println("Introduzca el ID del cantante que desea eliminar: ");
                        int id = sc.nextInt();
                        //PRIMERO HAGO UNA BUSQUEDA DE ESE CANTANTE
                        if(ses.createQuery("SELECT p FROM Cantante p WHERE id=" + id).uniqueResult() != null){
                            Cantante can = (Cantante) ses.createQuery("SELECT p FROM Cantante p WHERE id=" + id).uniqueResult();
                            //Y LUEGO LO BORRO, QUE EN REALIDAD NO SE BORRA, SE CAMBIA A FALSE
                            can.setVisible(false);
                            ses.save(can);
                            System.out.println("\n\tCantante eliminado corectamente");
                            encontrado = true;
                        }
                        
                        
                        if(!encontrado){
                            System.out.println("\n\tCantante no encontrado");
                        }
                    }
                    
                    break;
                
                case 3:
                    
                    mostrarGuitarras(ses);
                    
                    break;
                 
                case 4:
                    
                    System.out.println("\nQue desea realizar?\nPulse 1 para insertar nuevo\nPulse 2 para modificar\nPulse 3 para eliminar");
                    opcion = sc.nextInt();
                    
                    if(opcion == 1){
                        sc.nextLine();
                        System.out.println("Introduce el nombre del guitarra: ");
                        String nombre = sc.nextLine();
                        Guitarra gui = new Guitarra(nombre, true);
                        ses.save(gui);
                        System.out.println("\n\tNuevo guitarra añadido correctamente");
                    }
                    
                    
                    if(opcion == 2){
                        
                        System.out.println("Te mostramos los guitarras: ");
                        mostrarGuitarras(ses);
                        
                        Boolean encontrado = false;
                        sc.nextLine();
                        System.out.println("Introduzca el ID del guitarra que desea modificar: ");
                        int id = sc.nextInt();
                        //PRIMERO HAGO UNA BUSQUEDA DE ESE GUITARRA
                        if(ses.createQuery("SELECT p FROM Guitarra p WHERE id=" + id).uniqueResult() != null){
                            Guitarra gui = (Guitarra) ses.createQuery("SELECT p FROM Guitarra p WHERE id=" + id).uniqueResult();
                            //Y LUEGO LO MODIFICO
                            sc.nextLine(); //sino no furula
                            System.out.println("Introduzca el nuevo nombre del guitarra: ");
                            String nombre = sc.nextLine();
                            gui.setNombre(nombre);
                            ses.save(gui);
                            System.out.println("\n\tGuitarra modificado corectamente");
                            encontrado = true;
                        }
                        
                        
                        if(!encontrado){
                            System.out.println("\n\tGuitarra no encontrado");
                        }
                    }
                    
                    
                    
                    if(opcion == 3){
                        
                        System.out.println("Te mostramos los guitarras: ");
                        mostrarGuitarras(ses);
                        
                        Boolean encontrado = false;
                        sc.nextLine();
                        System.out.println("Introduzca el ID del guitarra que desea eliminar: ");
                        int id = sc.nextInt();
                        //PRIMERO HAGO UNA BUSQUEDA DE ESE GUITARRA
                        if(ses.createQuery("SELECT p FROM Guitarra p WHERE id=" + id).uniqueResult() != null){
                            Guitarra gui = (Guitarra) ses.createQuery("SELECT p FROM Guitarra p WHERE id=" + id).uniqueResult();
                            //Y LUEGO LO BORRO, QUE EN REALIDAD NO SE BORRA, SE CAMBIA A FALSE
                            gui.setVisible(false);
                            ses.save(gui);
                            System.out.println("\n\tGuitarra eliminado corectamente");
                            encontrado = true;
                        }
                        
                        
                        if(!encontrado){
                            System.out.println("\n\tGuitarra no encontrado");
                        }
                    }
                    
                    break;
                    
                case 5:
                    
                    mostrarGrupos(ses);
                    
                    break;
                    
                case 6:
                    
                    System.out.println("\nQue desea realizar?\nPulse 1 para insertar nuevo\nPulse 2 para modificar\nPulse 3 para eliminar");
                    opcion = sc.nextInt();
                    
                    if(opcion == 1){
                        sc.nextLine();
                        System.out.println("Introduce el nombre del grupo: ");
                        String nombre = sc.nextLine();
                        System.out.println("\nTe muestro los guitarras: ");
                        mostrarGuitarras(ses);
                        System.out.println("Introduce el ID del guitarra seleccionado para el grupo:");
                        int guitarra = sc.nextInt();
                        sc.nextLine();//básica
                        
                        System.out.println("\nTe muestro los cantantes: ");
                        mostrarCantantes(ses);
                        System.out.println("Introduce el ID del cantante seleccionado para el grupo:");
                        int cantante = sc.nextInt();
                        sc.nextLine();//básica
                        
                        Grupo gru = new Grupo(nombre, guitarra, cantante, true);
                        ses.save(gru);
                        System.out.println("\n\tNuevo grupo añadido correctamente");
                    }
                    
                    
                    if(opcion == 2){
                        
                        System.out.println("Te mostramos los grupos: ");
                        mostrarGrupos(ses);
                        
                        Boolean encontrado = false;
                        sc.nextLine();
                        System.out.println("Introduzca el ID del grupo que desea modificar: ");
                        int id = sc.nextInt();
                        //PRIMERO HAGO UNA BUSQUEDA DE ESE GRUPO
                        if(ses.createQuery("SELECT p FROM Grupo p WHERE id=" + id).uniqueResult() != null){
                            Grupo gru = (Grupo) ses.createQuery("SELECT p FROM Grupo p WHERE id=" + id).uniqueResult();
                            //Y LUEGO LO MODIFICO
                            sc.nextLine(); //sino no furula
                            System.out.println("Introduzca el nuevo nombre del grupo: ");
                            String nombre = sc.nextLine();
                            System.out.println("\nTe muestro los guitarras: ");
                            mostrarGuitarras(ses);
                            System.out.println("Introduce el ID del guitarra seleccionado para el grupo:");
                            int guitarra = sc.nextInt();
                            sc.nextLine();//básica

                            System.out.println("\nTe muestro los cantantes: ");
                            mostrarCantantes(ses);
                            System.out.println("Introduce el ID del cantante seleccionado para el grupo:");
                            int cantante = sc.nextInt();
                            sc.nextLine();//básica
                            
                            gru.setNombre(nombre);
                            gru.setGuitarraId(guitarra);
                            gru.setCantanteId(cantante);
                            ses.save(gru);
                            System.out.println("\n\tGrupo modificado corectamente");
                            encontrado = true;
                        }
                        
                        
                        if(!encontrado){
                            System.out.println("\n\tGrupo no encontrado");
                        }
                    }
                    
                    
                    
                    if(opcion == 3){
                        
                        System.out.println("Te mostramos los grupos: ");
                        mostrarGrupos(ses);
                        
                        Boolean encontrado = false;
                        sc.nextLine();
                        System.out.println("Introduzca el ID del grupo que desea eliminar: ");
                        int id = sc.nextInt();
                        //PRIMERO HAGO UNA BUSQUEDA DE ESE GRUPO
                        if(ses.createQuery("SELECT p FROM Grupo p WHERE id=" + id).uniqueResult() != null){
                            Grupo gru = (Grupo) ses.createQuery("SELECT p FROM Grupo p WHERE id=" + id).uniqueResult();
                            //Y LUEGO LO BORRO, QUE EN REALIDAD NO SE BORRA, SE CAMBIA A FALSE
                            gru.setVisible(false);
                            ses.save(gru);
                            System.out.println("\n\tGrupo eliminado corectamente");
                            encontrado = true;
                        }
                        
                        
                        if(!encontrado){
                            System.out.println("\n\tGrupo no encontrado");
                        }
                    }
                    
                    break;
                    
                case 7:
                    
                    mostrarFestivales(ses);
                    
                    break;
                    
                case 8:
                    
                    System.out.println("\nQue desea realizar?\nPulse 1 para insertar nuevo\nPulse 2 para modificar\nPulse 3 para eliminar");
                    opcion = sc.nextInt();
                    
                    if(opcion == 1){
                        sc.nextLine();
                        System.out.println("Introduce el nombre del festival: ");
                        String nombre = sc.nextLine();
                        System.out.println("Introduce la ciudad donde se realiza: ");
                        String ciudad = sc.nextLine();
                        Festival fes = new Festival(nombre, ciudad, true);
                        ses.save(fes);
                        System.out.println("\n\tNuevo festival añadido correctamente");
                    }
                    
                    
                    if(opcion == 2){
                        
                        System.out.println("Te mostramos los festivales: ");
                        mostrarFestivales(ses);
                        
                        Boolean encontrado = false;
                        sc.nextLine();
                        System.out.println("Introduzca el ID del festival que desea modificar: ");
                        int id = sc.nextInt();
                        //PRIMERO HAGO UNA BUSQUEDA DE ESE FESTIVAL
                        if(ses.createQuery("SELECT p FROM Festival p WHERE id=" + id).uniqueResult() != null){
                            Festival fes = (Festival) ses.createQuery("SELECT p FROM Festival p WHERE id=" + id).uniqueResult();
                            //Y LUEGO LO MODIFICO
                            sc.nextLine(); //sino no furula
                            System.out.println("Introduzca el nuevo nombre del festival: ");
                            String nombre = sc.nextLine();
                            System.out.println("Introduzca la nueva ciudad del festival: ");
                            String ciudad = sc.nextLine();
                            fes.setNombre(nombre);
                            fes.setCiudad(ciudad);
                            ses.save(fes);
                            System.out.println("\n\tFestival modificado corectamente");
                            encontrado = true;
                        }
                        
                        
                        if(!encontrado){
                            System.out.println("\n\tFestival no encontrado");
                        }
                    }
                    
                    
                    
                    if(opcion == 3){
                        
                        System.out.println("Te mostramos los festivales: ");
                        mostrarFestivales(ses);
                        
                        Boolean encontrado = false;
                        sc.nextLine();
                        System.out.println("Introduzca el ID del festival que desea eliminar: ");
                        int id = sc.nextInt();
                        //PRIMERO HAGO UNA BUSQUEDA DE ESE FESTIVAL 
                        if(ses.createQuery("SELECT p FROM Festival p WHERE id=" + id).uniqueResult() != null){
                            Festival fes = (Festival) ses.createQuery("SELECT p FROM Festival p WHERE id=" + id).uniqueResult();
                            //Y LUEGO LO BORRO, QUE EN REALIDAD NO SE BORRA, SE CAMBIA A FALSE
                            fes.setVisible(false);
                            ses.save(fes);
                            System.out.println("\n\tFestival eliminado corectamente");
                            encontrado = true;
                        }
                        
                        
                        if(!encontrado){
                            System.out.println("\n\tFestival no encontrado");
                        }
                    }
                    
                    break;
                
                case 9:
                    
                    mostrarCarteles(ses);
                    
                    break;
                    
                case 10:
                    
                    System.out.println("\nQue desea realizar?\nPulse 1 para insertar grupo en cartel de festival\nPulse 2 para eliminar del cartel");
                    opcion = sc.nextInt();
                    
                    if(opcion == 1){
                        sc.nextLine();
                        System.out.println("Te mostramos los festivales: ");
                        mostrarFestivales(ses);
                        System.out.println("Introduce el id del festival: ");
                        int idFestival = sc.nextInt();
                        sc.nextLine();
                        System.out.println("\nTe muestro los grupos: ");
                        mostrarGrupos(ses);
                        System.out.println("Introduce el ID del grupo seleccionado para añadir en el cartel del festival:");
                        int idGrupo = sc.nextInt();
                        sc.nextLine();//básica
     
                        Cartel car = new Cartel(idFestival, idGrupo, true);
                        ses.save(car);
                        System.out.println("\n\tNuevo grupo añadido al cartel del festival correctamente");
                    }
                    
                    if(opcion == 2){
                        sc.nextLine();
                        System.out.println("Te mostramos los festivales: ");
                        mostrarFestivales(ses);
                        System.out.println("Introduce el id del festival de donde vamos a eliminar grupo: ");
                        int idFestival = sc.nextInt();
                        sc.nextLine();
                        System.out.println("\nTe muestro los grupos: ");
                        mostrarGrupos(ses);
                        System.out.println("Introduce el ID del grupo para borrar del cartel del festival:");
                        int idGrupo = sc.nextInt();
                        sc.nextLine();//básica
     
                        if(ses.createQuery("SELECT p FROM Cartel p WHERE festival=" + idFestival + "AND grupo=" + idGrupo).uniqueResult() != null){
                            Cartel car = (Cartel) ses.createQuery("SELECT p FROM Cartel p WHERE festival=" + idFestival + "AND grupo=" + idGrupo).uniqueResult();
                            car.setVisible(false);
                            ses.save(car);
                        }
                        System.out.println("\n\tGrupo borrado del cartel del festival correctamente");
                    }
                    
                    
                    break;
                     
                case 11:
                    
                    
                    tx.commit();
                    ses.close();
                    
                    System.out.println("Hasta pronto!");
                    quedarse = false;
                    
                    break;
                    
                default:
                    System.out.println("No has introducido una opción valida, prueba otra vez.");
                    break;
                    
               
            }
            
            
            
        }while(quedarse);
        
        
        System.exit(0);
        
    }
    
    public static void mostrarCantantes(Session ses){
        Query query = ses.createQuery("FROM Cantante");
        List<Cantante> cantantes = query.list();

        System.out.println("\t\t___________________________________\n");
        for(int i=0; i< cantantes.size();i++){
            if(cantantes.get(i).isVisible() == true){
                System.out.println("\t\tCantante Id: " + cantantes.get(i).getId());
                System.out.println("\t\tNombre: " + cantantes.get(i).getNombre() + "\n");
            }
        }
        System.out.println("\t\t___________________________________");
    }
    
    public static void mostrarGuitarras(Session ses){
        Query query = ses.createQuery("FROM Guitarra");
        List<Guitarra> guitarras = query.list();

        System.out.println("\t\t___________________________________\n");
        for(int i=0; i<guitarras.size();i++){
            if(guitarras.get(i).isVisible() == true){
                System.out.println("\t\tGuitarra Id: " + guitarras.get(i).getId());
                System.out.println("\t\tNombre: " + guitarras.get(i).getNombre() + "\n");
            }
        }
        System.out.println("\t\t___________________________________");
    }
    
    public static void mostrarFestivales(Session ses){
        Query query = ses.createQuery("FROM Festival");
        List<Festival> festivales = query.list();

        System.out.println("\t\t___________________________________\n");
        for(int i=0; i<festivales.size();i++){
            if(festivales.get(i).isVisible() == true){
                System.out.println("\t\tFestival Id: " + festivales.get(i).getId());
                System.out.println("\t\tNombre: " + festivales.get(i).getNombre());
                System.out.println("\t\tCiudad: " + festivales.get(i).getCiudad() + "\n");
            }
        }
        System.out.println("\t\t___________________________________");
    }
    
    public static void mostrarGrupos(Session ses){
        Query query = ses.createQuery("FROM Grupo");
        List<Grupo> grupos = query.list();

        System.out.println("\t\t___________________________________\n");
        for(int i=0; i< grupos.size();i++){
            if(grupos.get(i).isVisible() == true){
                System.out.println("\t\tGrupo Id: " + grupos.get(i).getId());
                System.out.println("\t\tNombre: " + grupos.get(i).getNombre());
                //TENGO QUE HACER OTRA CONSULTA AKI PARA SACAR EL NOMBRE DE LOS COMPONENTES DEL GRUPO
                Cantante can = (Cantante) ses.createQuery("SELECT p FROM Cantante p WHERE id=" + grupos.get(i).getCantanteId()).uniqueResult();
                Guitarra gui = (Guitarra) ses.createQuery("SELECT p FROM Guitarra p WHERE id=" + grupos.get(i).getGuitarraId()).uniqueResult();
                /////////////////////////////////////////////////////////////////////////
                System.out.println("\t\tCantante: " + can.getNombre());
                System.out.println("\t\tGuitarra: " + gui.getNombre() + "\n");
                //////AKI PARA QUE MUESTRE EN LOS FESTIVALES EN LOS QUE ESTÁN
                if(ses.createQuery("FROM Cartel WHERE grupo=" + grupos.get(i).getId()) != null){
                    Query querys = ses.createQuery("FROM Cartel WHERE grupo=" + grupos.get(i).getId());
                    List<Cartel> enCartel = querys.list();
                    System.out.println("\t\t\tFestivales en los que aparece: ");
                    for(int j = 0;j<enCartel.size();j++){
                        //OTRA CONSULTA PARA TRAERME EL NOMBRE DEL FESTIVAL
                        Festival fes = (Festival) ses.createQuery("SELECT p FROM Festival p WHERE id=" + enCartel.get(j).getFestival()).uniqueResult();
                        System.out.println("\t\t\t\t - " + fes.getNombre());
                    }
                    System.out.println("\n");
                }
                /////////////////////////////////////////////////////////////
            }
        }
        System.out.println("\t\t___________________________________");
    }
    
    public static void mostrarCarteles(Session ses){
        Query query = ses.createQuery("FROM Cartel");
        List<Cartel> carteles = query.list();

        ArrayList<Integer> arrayFestivales = new ArrayList();

        System.out.println("\t\t___________________________________\n");
        for(int i=0; i<carteles.size();i++){
 
            if(carteles.get(i).isVisible() == true && ( noRepetirCartel(carteles.get(i).getFestival(), arrayFestivales) )){
                //System.out.println("\t\tCartel Id: " + carteles.get(i).getId());
                //HACER BUSQUEDA DE FESTIVAL POR ID PARA MOSTRARLO
                Festival fes = (Festival) ses.createQuery("SELECT p FROM Festival p WHERE id=" + carteles.get(i).getFestival()).uniqueResult();
                //////////////////////////////////////////////////
                System.out.println("\t\tFestival: " + fes.getNombre());  
                System.out.println("\t\tCiudad: " + fes.getCiudad()); 
                System.out.println("\t\tGrupos invitados: " );
                mostrarGruposInvitados(ses, fes.getId());
            }   
            
            
        }   
                    
        System.out.println("\t\t___________________________________");
    
    }
    
    public static void mostrarGruposInvitados(Session ses, int idFestival){
        
        ArrayList<Integer> arrayGrupos = new ArrayList();
        
        Query query = ses.createQuery("SELECT p FROM Cartel p WHERE festival=" + idFestival);
        List<Cartel> carteles = query.list();
        for(int i=0;i<carteles.size();i++){
            int grupo = carteles.get(i).getGrupo();
            //OTRA QUERY PARA CON EL ID DEL GRUPO, KE ME DE EL NOMBRE
            Grupo gru = (Grupo) ses.createQuery("SELECT p FROM Grupo p WHERE id=" + grupo).uniqueResult();
            if(gru.isVisible() && (noRepetirGrupo(gru.getId(), arrayGrupos)) ){
                System.out.println("\t\t\t -" + gru.getNombre());
            }
            
        }
        System.out.println("\n");
    }
    
    public static Boolean noRepetirCartel(int fest, ArrayList<Integer> arrayFestivales){
        
        Boolean booleano = false;
        
        //COMPRUEBO QUE NO ESTÁ EL FESTIVAL EN LA LISTA DE YA MOSTRADOS
        for(int i=0;i<arrayFestivales.size();i++){
            booleano = arrayFestivales.get(i) != fest;
        }

        arrayFestivales.add(fest); //añado el festival que se está tratando
 
        return booleano;
    }
    
    public static Boolean noRepetirGrupo(int grupo, ArrayList<Integer> arrayGrupos){
        
        Boolean noExiste = true;
        
        if(arrayGrupos.isEmpty()){
            arrayGrupos.add(grupo); //añado el festival que se está tratando
        }else{
            //COMPRUEBO QUE NO ESTÁ EL GRUPO EN LA LISTA DE YA MOSTRADOS
            for(int i=0;i<arrayGrupos.size();i++){
                //booleano = arrayGrupos.get(i) != grupo;
                if(arrayGrupos.get(i) == grupo)
                    noExiste = false; 
            }

        }
        
        if(noExiste){
            arrayGrupos.add(grupo); //añado el festival que se está tratando
        }
        
 
        return noExiste;
    }
   
}
