package br.com.fiap.resource;

import br.com.fiap.dto.UsuarioResponseDto;
import br.com.fiap.models.Usuario;
import br.com.fiap.service.UsuarioService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
public class UsuarioResource {
    private UsuarioService usuarioService = new UsuarioService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioResponseDto buscarId(@PathParam("id") int id){
        return usuarioService.buscarId(id);
    }
}
