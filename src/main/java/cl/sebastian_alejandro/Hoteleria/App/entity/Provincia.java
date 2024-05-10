package cl.sebastian_alejandro.Hoteleria.App.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "provincia")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "provincia", nullable = false)
    private String provincia;
    @Column(name = "ciudad_id")
    private Integer ciudadId;

    public Provincia() {
    }

    public Provincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "id=" + id +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
