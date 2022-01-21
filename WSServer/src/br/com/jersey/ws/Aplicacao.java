package br.com.jersey.ws;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class Aplicacao extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		System.out.println("iniciando aplicacoes");
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(WSControlador.class);
		return classes;
	}
}
