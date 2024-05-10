package cl.sebastian_alejandro.Hoteleria.App.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pais", nullable = false)
    private String pais;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private List<Ciudad> ciudades;

    public Pais() {
    }

    public Pais(String pais) {
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    // metodo conveniente

    public void addCiudad(Ciudad ciudad) {
        if (ciudades == null) {
            ciudades = new ArrayList<>();
        }
        ciudades.add(ciudad);
    }

    public Pais clon() {
        Pais clonPais = new Pais();
        clonPais.setId(this.getId());
        clonPais.setPais(this.getPais());
        List<Ciudad> ciudades = (this.getCiudades() == null) ? new ArrayList<>() : this.getCiudades();
        clonPais.setCiudades(ciudades);
        return clonPais;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                '}';
    }
}
