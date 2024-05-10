package cl.sebastian_alejandro.Hoteleria.App.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    private Date fechaTermino;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.PERSIST,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "detalle_reserva",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "venta_id"))
    private List<Venta> ventas;

    public Reserva() {
    }

    public Reserva(Date fechaInicio, Date fechaTermino) {
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    // funciones convenientes
    public void addVenta(Venta venta) {
        ventas.add(venta);
    }


    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaTermino=" + fechaTermino +
                '}';
    }
}
