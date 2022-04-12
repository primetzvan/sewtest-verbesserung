package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "INV_EVENT")
public class Event extends PanacheEntityBase {

    @Id
    @Column(name = "EV_ID")
    private Long id;

    @Column(name = "EV_DESCR")
    private String description;

    @Column(name = "EV_EVENT_TYPE")
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "DEVICE_ID")
    private Device device;

    @Column(name = "EV_CREATE_DATE")
    private LocalDate createDate;


    public Event(String description, EventType eventType, Device device, LocalDate createDate) {
        this.description = description;
        this.eventType = eventType;
        this.device = device;
        this.createDate = createDate;
    }

    public Event() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
