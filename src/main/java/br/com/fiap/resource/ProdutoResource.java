package br.com.fiap.resource;

import br.com.fiap.models.Produto;
import br.com.fiap.service.ProdutoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@Path("/produtos")
public class ProdutoResource {

    private ProdutoService produtoService = new ProdutoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar(){
        return produtoService.listar();
    }

    @GET //buscar um dado no banco e devolver pro navegador
    @Path("/{id}") //toda vez que tiver um get, ele vai nesse id (que muda)
    @Produces(MediaType.APPLICATION_JSON) //como vai tratar a informação, ou seja, mostra como um JSON
    public Produto buscarPorId(@PathParam("id") int id){
        return produtoService.buscarPorId(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //Response retorna o código 201 create
    //Uri é o endereço (https:/blabla

    //Context cria um novo caminho/endereço com as novas informações ('tipo produtos/x' -> novo json)
    public Response cadastrar(Produto produto, @Context UriInfo uriInfo){
        produtoService.cadastrar(produto); //insere no banco de dados
        UriBuilder builder = uriInfo.getAbsolutePathBuilder(); //cria o novo caminho -> produtos/
        builder.path(Integer.toString(produto.getCodigo())); //adicionando o produto produtos/6
        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(Produto produto,@PathParam("id") int id){
        Produto produtoBd = produtoService.buscarPorId(id);
        if(produtoBd.getCodigo() == produto.getCodigo()){
            produtoService.atualizar(produto);
            return Response.ok().build(); //retorna que foi atualizado com sucesso
        }

        return Response.noContent().build(); //"não encontrei bb"
    }

    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") int id){
        produtoService.excluir(id);
    }
}
