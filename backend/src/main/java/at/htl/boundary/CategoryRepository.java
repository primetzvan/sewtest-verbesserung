package at.htl.boundary;

import at.htl.entity.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryRepository implements PanacheRepositoryBase<Category,String> {
}
