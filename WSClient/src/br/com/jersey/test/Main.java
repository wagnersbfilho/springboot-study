package br.com.jersey.test;
import br.com.jersey.bean.Mensagem;
import br.com.jersey.bean.Usuario;
import br.com.jersey.controller.ServiceControl;
import java.util.List;


/*
 1-obtain an Client instance
 2-create a WebTarget pointing at a Web resource
 3-build a request
 4-submit a request to directly retrieve a response or get a prepared Invocation for later submission*/
public class Main {

    public static void main(String[] args) {
        try {
             ServiceControl.HOST="localhost";
             ServiceControl.PORT="8084";
           ServiceControl.removeAll();
           //System.out.printf(ServiceControl.hello());
             
            Mensagem msg = new Mensagem();
            msg.setUser("Carlos");
            msg.setMsg("Isto eh um teste");
           
            //ServiceControl.addMessage(msg);
            
            
            for(Usuario user : ServiceControl.getUsers())
            {
                System.out.println(user);
            }
            
            for(Mensagem msg2 : ServiceControl.getMessages())
            {
                System.out.println(msg2);
            }
            /*
            System.out.println(ServiceControl.hello());
            System.out.println("Criando mensagens");
            Message msg = new Message();
            msg.setUser("MSG");
            msg.setMsg("TESTE MSG");
            ServiceControl.addMenssagem(msg);
           
            Message msg2 = new Message();
            msg2.setUser("MSG2");
            msg2.setMsg("TESTE MSG2");
            ServiceControl.addMenssagem(msg2);
            
            Message msg3 = new Message();
            msg3.setUser("MSG3");
            msg3.setMsg("TESTE MSG3");
            ServiceControl.addMenssagem(msg3);
            
            Message msg4 = new Message();
            msg4.setUser("MSG4");
            msg4.setMsg("TESTE MSG4");
            ServiceControl.addMenssagem(msg4);
          
            System.out.println("Criando usuarios");
            
            ServiceControl.addUser(new Usuario("CARLOS"));
            ServiceControl.addUser(new Usuario("JOSE"));
            ServiceControl.addUser(new Usuario("PEDRO"));
            ServiceControl.addUser(new Usuario("JOAQUIM"));
            
            System.out.println("deletando usuarios");
            ServiceControl.dellUser("CARLOS");
            
            System.out.println("----------------------------------------------");
            List<Usuario> users = ServiceControl.getUsers();
            for(Usuario u : users)
                System.out.println("Usuario:"+ u.getNome());
           
            System.out.println("----------------------------------------------");
            List<Message> msgs = ServiceControl.getMensagens();
            for(Message m : msgs)
            {
                System.out.println("Usuario:"+ m.getUser());
                System.out.println("Texto:"+ m.getMsg());
            }
            System.out.println("--------FIM-------------------");
                    */
            
        } catch (Exception e) {

            e.printStackTrace();

        }

    }

   

}
