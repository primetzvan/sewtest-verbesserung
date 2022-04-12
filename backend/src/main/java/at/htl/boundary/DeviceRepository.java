package at.htl.boundary;

import at.htl.entity.Category;
import at.htl.entity.Device;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class DeviceRepository implements PanacheRepository<Device> {

  @Inject
  EntityManager em;

  @Inject
  CategoryRepository ctr;

  public Device save(Device device) {

    Category c = ctr.findById(device.getCategory().getAbbr());
    if(c == null){
      c = new Category(device.getCategory().getAbbr(), device.getCategory().getName());
      ctr.persist(c);
      device.setCategory(c);
    }

    return em.merge(device);
  }

}
