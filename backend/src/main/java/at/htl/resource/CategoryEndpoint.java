package at.htl.resource;

import at.htl.boundary.CategoryRepository;
import at.htl.entity.Category;
import at.htl.entity.Device;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@ApplicationScoped
@Transactional
@Path("/category")
public class CategoryEndpoint {

    @Inject
    CategoryRepository cr;

    @Context
    UriInfo info;

    @POST
    public Response create(Category category){

      cr.getEntityManager().merge(category);

      URI uri = info.getAbsolutePathBuilder().path(category.getAbbr()).build();

      return Response.created(uri).build();
    }

    @GET
    @Path("/{id}")
    public Category getAllSorted(@PathParam("id") String id){
        return (Category) cr.find("id = ?1", id).firstResult();
    }


}
