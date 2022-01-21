package br.com.jersey.ws;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import br.com.jersey.bean.Mensagem;
import br.com.jersey.bean.Usuario;
import br.com.jersey.util.Utilidades;

@Path("/WSControlador")
public class WSControlador {

	@GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
		System.out.println("Dizendo hello ...");
        return "Hello World!!! Isto eh um teste\n";    
    }
    @PUT
    @Path("/addMensagem")
    @Consumes("application/xml")
    public void addMensagem(Mensagem msg){
        Utilidades.add(msg);
        System.out.println("Adicionando mensagem:"+ msg.getMsg());
    }
    @PUT
    @Path("/addUsuario")
    @Consumes("application/xml")
    public void addUsuario(Usuario user){
        Utilidades.adicionaUsuario(user);
        //ADICIONA A MSG QUE O USUARIO ENTROU NA SALA
        Mensagem mens = new Mensagem();
        mens.setUser("");
        mens.setMsg(user.getNome() + " entrou na sala.");
        Utilidades.add(mens);
        System.out.println("Adicionando user:"+ user);
    }
    @GET
    @Path("/getUsuarios")
    @Produces("application/xml")
    public List<Usuario> getUsuarios(){
        System.out.println("getUsuarios chamado.");
        return Utilidades.getUsuarios();
  
    }
    @GET
    @Path("/getMensagens")
    @Produces("application/xml")
    public List<Mensagem> getMensagens(){
        System.out.println("getMensagens chamado.");
        return Utilidades.getMensagens();
  
    }
    @DELETE
    @Path("/delUsuario")
    @Consumes("text/plain")
    public void delUsuario(@QueryParam("user") String user){
        Utilidades.removeUsuario(user);
        Mensagem mens = new Mensagem();
        mens.setUser("");
        mens.setMsg(user + " saiu da sala.");
        Utilidades.add(mens);
        System.out.println("removendo user:"+ user);
    }
    @DELETE
    @Path("/delTodos")
    public void delTodos(){
        Utilidades.removeAll();
        System.out.println("removendo todas as msg e users");
    }    
}
