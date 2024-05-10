package cl.sebastian_alejandro.Hoteleria.App.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ciudad", nullable = false)
    private String ciudad;
    @Column(name = "pais_id")
    private Integer paisId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_id")
    private List<Provincia> provincias;

    public Ciudad() {
    }

    public Ciudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    // metodo conveniente

    public void addProvincia(Provincia provincia) {
        if (provincias == null) {
            provincias = new ArrayList<>();
        }
        provincias.add(provincia);
    }

    public Ciudad clon() {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(this.getId());
        ciudad.setCiudad(this.getCiudad());
        ciudad.setPaisId(this.getPaisId());
        List<Provincia> provincias = this.getProvincias() == null ? new ArrayList<>() : this.getProvincias();
        ciudad.setProvincias(provincias);
        return ciudad;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", ciudad='" + ciudad + '\'' +
                ", paisId=" + paisId +
                '}';
    }
}
