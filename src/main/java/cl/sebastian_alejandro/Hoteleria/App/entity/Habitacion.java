package cl.sebastian_alejandro.Hoteleria.App.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ubicacion", unique = true, nullable = false)
    private String ubicacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estrellas")
    private String estrellas;
    @Column(name = "cant_camas")
    private Integer cantCamas;
    @Column(name = "jacuzzi")
    private Boolean jacuzzi;
    @Column(name = "living")
    private Boolean living;
    @Column(name = "cuarto_juegos")
    private Boolean cuartoJuegos;
    @Column(name = "valor_dia")
    private String valorDia;
    @Transient
    private String valorHoraEstimado;


    public Habitacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }

    public Integer getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(Integer cantCamas) {
        this.cantCamas = cantCamas;
    }

    public Boolean getJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(Boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public Boolean getLiving() {
        return living;
    }

    public void setLiving(Boolean living) {
        this.living = living;
    }

    public Boolean getCuartoJuegos() {
        return cuartoJuegos;
    }

    public void setCuartoJuegos(Boolean cuartoJuegos) {
        this.cuartoJuegos = cuartoJuegos;
    }

    public String getValorDia() {
        return valorDia;
    }

    public void setValorDia(String valorDia) {
        this.valorDia = valorDia;
    }

    public String getValorHoraEstimado() {
        if (valorHoraEstimado == null && valorDia != null) {
            BigDecimal valor = BigDecimal.valueOf(Long.parseLong(valorDia));
            valor = valor.divide(new BigDecimal(24), 2, RoundingMode.CEILING);
            valorHoraEstimado = String.valueOf(valor);
            return valorHoraEstimado;
        } else if (valorHoraEstimado != null) {
            return valorHoraEstimado;
        }
        return null;
    }

    public void setValorHoraEstimado(String valorHoraEstimado) {
        this.valorHoraEstimado = valorHoraEstimado;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estrellas='" + estrellas + '\'' +
                ", cantCamas=" + cantCamas +
                ", jacuzzi=" + jacuzzi +
                ", living=" + living +
                ", cuartoJuegos=" + cuartoJuegos +
                ", valorDia='" + valorDia + '\'' +
                '}';
    }
}
