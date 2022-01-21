package br.com.jersey.controller;
import br.com.jersey.bean.Mensagem;
import br.com.jersey.bean.Usuario;
import br.com.jersey.constants.Constantes;
import br.com.jersey.utils.Factory;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
public class ServiceControl {
    public static String HOST = "";
    public static String PORT = "";
    public static String hello() {
        Client client = Factory.getInstance();
        WebTarget webTarget = client.target("http://localhost:8084");
        WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_HELLO);
        Response response = resourceWebTarget.request(MediaType.TEXT_PLAIN_TYPE).get();
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        
        String output = response.readEntity(String.class);
        return output;
    }
    public static void addMessage(Mensagem msg) {
        Client client = Factory.getInstance();
        WebTarget webTarget = client.target("http://" + HOST +":"+ PORT + Constantes.RESOURCE_ROOT);
        WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_ADD_MESSAGEM);
        resourceWebTarget.request().put(Entity.entity(msg,MediaType.APPLICATION_XML),Response.class);
      
    }
    public static void addUser(Usuario user) {
        Client client = Factory.getInstance();
        WebTarget webTarget = client.target("http://" + HOST +":"+ PORT  + Constantes.RESOURCE_ROOT);
        WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_ADD_USER);
        resourceWebTarget.request().put(Entity.entity(user,MediaType.APPLICATION_XML),Response.class);
        
    }
    public static void dellUser(String user) {
        Client client = Factory.getInstance();
        WebTarget webTarget = client.target("http://" + HOST +":"+ PORT  + Constantes.RESOURCE_ROOT);
        WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_DELL_USER);
        resourceWebTarget.queryParam("user",user).request().delete();
    }
    public static List<Usuario> getUsers() {
        Client client = Factory.getInstance();
        WebTarget webTarget = client.target("http://" + HOST +":"+ PORT + Constantes.RESOURCE_ROOT);
        WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_GET_USERS);
        List<Usuario> usuarios =resourceWebTarget.request().get(new GenericType<List<Usuario>>(){});
        return usuarios;
    }
    public static List<Mensagem> getMessages() {
        Client client = Factory.getInstance();
        WebTarget webTarget = client.target("http://" + HOST +":"+ PORT + Constantes.RESOURCE_ROOT);
        WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_GET_MSG);
        List<Mensagem> msgs =resourceWebTarget.request().get(new GenericType<List<Mensagem>>(){});
        return msgs;
  
   }
   public static void removeAll() {
        Client client = Factory.getInstance();
        WebTarget webTarget = client.target("http://" + HOST +":"+ PORT + Constantes.RESOURCE_ROOT);
        WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_DELL_ALL);
        resourceWebTarget.request().delete();
       
   }
}