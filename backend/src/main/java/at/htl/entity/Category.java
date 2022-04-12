package at.htl.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "INV_CATEGORY")
public class Category extends PanacheEntityBase {

    @Id
    @Column(name = "CAT_ABBR", length = 20)
    private String abbr;

    @Column(name = "CAT_NAME", length = 100)
    private String name;

    public Category(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }

    public Category() {
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  @Override
  public String toString() {
    return "Category{" +
      "abbr='" + abbr + '\'' +
      ", name='" + name + '\'' +
      '}';
  }
}
