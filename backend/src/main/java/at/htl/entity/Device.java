package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

//TODO: Sequenz umgesetzt
@Entity
@Table(name = "INV_DEVICE")
@SequenceGenerator(
  name = "deviceSeq",
  sequenceName = "deviceSeq",
  allocationSize = 1,
  initialValue = 1012
)
public class Device extends PanacheEntityBase {

    @Id
    @Column(name = "DEV_ID")
    @GeneratedValue(generator = "deviceSeq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DEV_BRAND", length = 100)
    private String brand;

    @Column(name = "DEV_DESCR")
    private String description;

    @Column(name = "DEV_SHORT_NAME", length = 50)
    private String shortName;

    @Column(name = "DEV_TYPE", length = 100)
    private String type;

    private String inventoryNo;

    @ManyToOne
    @JoinColumn(name = "DEV_DEV_ID")
    private Device belongsTo;

    @ManyToOne
    @JoinColumn(name = "DEV_CAT_ABBR", columnDefinition = "varchar(20)")
    private Category category;

    public Device(Long id, String brand,
                  String description, String shortName,
                  String type, String inventoryNo,
                  Device belongsTo, Category category) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.shortName = shortName;
        this.type = type;
        this.inventoryNo = inventoryNo;
        this.belongsTo = belongsTo;
        this.category = category;
    }

    public Device() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Device getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Device belongsTo) {
        this.belongsTo = belongsTo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

  @Override
  public String toString() {
    return "Device{" +
      "id=" + id +
      ", brand='" + brand + '\'' +
      ", description='" + description + '\'' +
      ", shortName='" + shortName + '\'' +
      ", type='" + type + '\'' +
      ", inventoryNo='" + inventoryNo + '\'' +
      ", belongsTo=" + belongsTo +
      ", category=" + category +
      '}';
  }
}
