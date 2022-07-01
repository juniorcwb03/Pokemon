package application;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import resource.PokemonResource;

@ApplicationPath("/*")
public class RestAPI extends Application {
	
private Set<Object> singletons = new HashSet<Object>();

public RestAPI( ) throws Exception,SQLException{
	this.singletons.add(new PokemonResource());
}

@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
