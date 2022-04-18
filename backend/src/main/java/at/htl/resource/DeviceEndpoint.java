package at.htl.resource;

import at.htl.boundary.CategoryRepository;
import at.htl.boundary.DeviceRepository;
import at.htl.entity.DTODevice;
import at.htl.entity.Device;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;

@ApplicationScoped
@Transactional
@Path("/device")
public class DeviceEndpoint {

  @Inject
  DeviceRepository dvr;

  @Inject
  CategoryRepository ct;

  @Context
  UriInfo info;

  @GET
  public List<Device> getAll() {
    return dvr.find("belongsTo = null").stream().collect(Collectors.toList());

  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllSorted(@PathParam("id") long id) {
    return Response.ok(dvr.find("id = ?1", id).firstResult()).build();
    //return dvr.find("id = ?1", id).firstResult();
  }

  @GET
  @Path("/tree")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllSorted() {
    List<DTODevice> ret = new ArrayList();
    List<Device> l = new ArrayList();

    List<Device> devices = dvr.listAll();
    for (Device d : devices) {
      JSONObject obj = new JSONObject();
      l.addAll(findAllNodes(devices, d));
      obj.put("components", l);
      ret.add(new DTODevice(d, obj));
    }
    return Response.ok(ret.toString()).build();

  }

  private List<Device> findAllNodes(List<Device> devices, Device d) {

    List<Device> l = new ArrayList();

    for (Device s : devices) {
      if (s.getBelongsTo() == d) {
        l.add(s);
        findAllNodes(devices, s);
      }
    }

    return l;

  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(Device device) {

    device = dvr.save(device);

    URI uri = info.getAbsolutePathBuilder().path(device.getId().toString()).build();
    return Response.created(uri).build();
  }


  @GET
  @Path("/components/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllComponents(@PathParam("id") long id) {
    return Response.ok(dvr.find("belongsTo.id = ?1", id).list()).build();
  }

}
