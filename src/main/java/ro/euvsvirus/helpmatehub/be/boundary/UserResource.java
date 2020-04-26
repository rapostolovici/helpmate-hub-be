package ro.euvsvirus.helpmatehub.be.boundary;


import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.panache.common.Sort;
import ro.euvsvirus.helpmatehub.be.model.UserCategory;
import ro.euvsvirus.helpmatehub.be.model.entity.User;


@Path("/api/users")
public class UserResource {

    @Path("/categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserCategory> getUserCategories() {
        return Arrays.asList(UserCategory.values());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return User.listAll(Sort.by("firstName"));
    }

//    @GET
//    @Path("{id}")
//    public User getSingle(@PathParam Long id) {
//        User entity = User.findById(id);
//        if (entity == null) {
//            throw new WebApplicationException("User with id of " + id + " does not exist.", 404);
//        }
//        return entity;
//    }

    @POST
    @Transactional
    public Response createUser(User user) {
        user.persist();
        return Response.ok(user).status(201).build();
    }
}
