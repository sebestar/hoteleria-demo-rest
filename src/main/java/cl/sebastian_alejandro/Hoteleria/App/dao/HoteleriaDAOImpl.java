package cl.sebastian_alejandro.Hoteleria.App.dao;

import cl.sebastian_alejandro.Hoteleria.App.commons.HoteleriaNotFoundException;
import cl.sebastian_alejandro.Hoteleria.App.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cl.sebastian_alejandro.Hoteleria.App.commons.HoteleriaUtil.calcularValorReserva;

@Repository
public class HoteleriaDAOImpl implements HoteleriaDAO {

    EntityManager entityManager;

    @Autowired
    public HoteleriaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void savePais(String namePais) {
        Pais paisNew = new Pais();
        paisNew.setId(0);
        paisNew.setPais(namePais);
        paisNew.setCiudades(new ArrayList<>());
        entityManager.merge(paisNew);
    }

    @Override
    @Transactional
    public void savePaisConCiudadesYProvincias(Pais pais) {
        int sizeCiudades = pais.getCiudades().size();
        Pais paisBd = pais.clon();
        paisBd.setId(0);
        paisBd.setCiudades(new ArrayList<>());
        paisBd = entityManager.merge(paisBd);
        for (int i = 0; i < sizeCiudades; i++) {
            Ciudad ciudad = pais.getCiudades().get(i);
            int sizeProvincias = ciudad.getProvincias().size();
            Ciudad ciudadBd = ciudad.clon();
            ciudadBd.setId(0);
            ciudadBd.setPaisId(paisBd.getId());
            ciudadBd.setProvincias(new ArrayList<>());
            ciudadBd = entityManager.merge(ciudadBd);

            for (int j = 0; j < sizeProvincias; j++) {
                Provincia provincia = ciudad.getProvincias().get(j);
                provincia.setId(0);
                provincia.setCiudadId(ciudadBd.getId());
                entityManager.merge(provincia);
            }
        }
    }

    @Override
    public List<Pais> getPaisCiudadesProvincias() {
        TypedQuery<Pais> query = entityManager.createQuery("FROM Pais", Pais.class);
        return query.getResultList();
    }

    @Override
    public Pais findPaisCiudadesProvinciasByIdPais(int idPais) {
        return entityManager.find(Pais.class, idPais);
    }

    @Override
    @Transactional
    public void updatePais(Pais pais) {
        Query query = entityManager.createQuery(
                "UPDATE Pais SET pais = :paisName WHERE id = :idPais");
        query.setParameter("paisName", pais.getPais());
        query.setParameter("idPais", pais.getId());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deletePaisCiudadesProvinciasByIdPais(int idPais) {
        Pais pais = entityManager.find(Pais.class, idPais);
        if (pais == null || pais.getId() <= 0) {
            throw new HoteleriaNotFoundException("Pais no encontrado con id: " + idPais);
        }
        entityManager.remove(pais);
    }

    @Override
    @Transactional
    public void saveCiudad(String nameCiudad, int fkPais) {
        Ciudad ciudadNew = new Ciudad();
        ciudadNew.setId(0);
        ciudadNew.setCiudad(nameCiudad);
        ciudadNew.setPaisId(fkPais);
        ciudadNew.setProvincias(new ArrayList<>());
        entityManager.merge(ciudadNew);
    }

    @Override
    @Transactional
    public void saveCiudadYProvincias(Ciudad ciudad) throws Exception {
        ciudad.setId(0);
        entityManager.merge(ciudad);
    }

    @Override
    public List<Ciudad> getCiudadesProvincias() {
        TypedQuery<Ciudad> query = entityManager.createQuery("FROM Ciudad", Ciudad.class);
        return query.getResultList();
    }

    @Override
    public Ciudad findCiudadesProvinciasByIdCiudad(int idCiudad) {
        return entityManager.find(Ciudad.class, idCiudad);
    }

    @Override
    @Transactional
    public void updateCiudad(Ciudad ciudad) {
        Query query = entityManager.createQuery(
                "UPDATE Ciudad SET ciudad = :ciudadName WHERE id = :idCiudad");
        query.setParameter("ciudadName", ciudad.getCiudad());
        query.setParameter("idCiudad", ciudad.getId());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteCiudadesProvinciasByIdCiudad(int idCiudad) {
        Ciudad ciudad = entityManager.find(Ciudad.class, idCiudad);
        if (ciudad == null || ciudad.getId() <= 0) {
            throw new HoteleriaNotFoundException("Ciudad no encontrado con id: " + idCiudad);
        }
        entityManager.remove(ciudad);
    }

    @Override
    @Transactional
    public void saveProvincia(Provincia provincia) {
        provincia.setId(0);
        entityManager.merge(provincia);
    }

    @Override
    public List<Provincia> getProvincias() {
        TypedQuery<Provincia> query = entityManager.createQuery("FROM Provincia", Provincia.class);
        return query.getResultList();
    }

    @Override
    public Provincia findProvinciasById(int idProvincia) {
        return entityManager.find(Provincia.class, idProvincia);
    }

    @Override
    @Transactional
    public void updateProvincia(Provincia provincia) {
        entityManager.merge(provincia);

    }

    @Override
    @Transactional
    public void deleteProvinciaById(int idProvincia) {
        Provincia provincia = entityManager.find(Provincia.class, idProvincia);
        if (provincia == null || provincia.getId() <= 0) {
            throw new HoteleriaNotFoundException("No encontrado provincia con id: " + idProvincia);
        }
        entityManager.remove(provincia);
    }

    @Override
    @Transactional
    public void saveHabitacion(Habitacion habitacion) {
        habitacion.setId(0);
        entityManager.merge(habitacion);
    }

    @Override
    public List<Habitacion> getHabitacion() {
        TypedQuery<Habitacion> query = entityManager.createQuery("From Habitacion", Habitacion.class);
        return query.getResultList();
    }

    @Override
    public Habitacion findHabitacionById(int idHabitacion) {
        return entityManager.find(Habitacion.class, idHabitacion);
    }

    @Override
    @Transactional
    public void updateHabitacion(Habitacion habitacion) {
        entityManager.merge(habitacion);
    }

    @Override
    @Transactional
    public void deleteHabitacionById(int idHabitacion) {
        Habitacion habitacion = entityManager.find(Habitacion.class, idHabitacion);
        if (habitacion == null || habitacion.getId() <= 0) {
            throw new HoteleriaNotFoundException("no encontrada habitacion con id: " + idHabitacion);
        }
        entityManager.remove(habitacion);
    }

    @Override
    @Transactional
    public void saveHuesped(Huesped huesped) {
        huesped.setId(0);
        entityManager.merge(huesped);
    }

    @Override
    public List<Huesped> getHuesped() {
        TypedQuery<Huesped> query = entityManager.createQuery("FROM Huesped", Huesped.class);
        return query.getResultList();
    }

    @Override
    public Huesped findHuespedById(int idHuesped) {
        return entityManager.find(Huesped.class, idHuesped);
    }

    @Override
    @Transactional
    public void updateHuesped(Huesped huesped) {
        entityManager.merge(huesped);
    }

    @Override
    @Transactional
    public void deleteHuespedById(int idHuesped) {
        Huesped huesped = entityManager.find(Huesped.class, idHuesped);
        if (huesped == null || huesped.getId() <= 0) {
            throw new HoteleriaNotFoundException("No encontrado Huesped con id: " + idHuesped);
        }
        entityManager.remove(huesped);
    }

    @Override
    @Transactional
    public void saveVenta(Venta venta) throws Exception {
        if (venta == null) {
            throw new Exception("Debe ingresar una venta valida.");
        }
        if (venta.getReservas() == null || venta.getReservas().isEmpty()) {
            throw new Exception("La venta debe tener reservas.");
        }
        Huesped huesped = entityManager.find(Huesped.class, venta.getHuesped().getId());
        if (huesped == null || huesped.getId() <= 0) {
            throw new HoteleriaNotFoundException("No se encontró Huesped con id " + venta.getHuesped().getId() + ".");
        }

        venta.setId(0);
        venta.setFecha(new Date());
        venta.setValor("0");
        for (Reserva reserva : venta.getReservas()) {
            reserva.setId(0);
            if (reserva.getHabitacion() == null || reserva.getHabitacion().getId() <=0) {
                throw new Exception("Debe asociar una habitacion a cada reserva");
            }
            Habitacion habitacion = entityManager.find(Habitacion.class, reserva.getHabitacion().getId());
            if (habitacion == null || habitacion.getId() <=0) {
                throw new HoteleriaNotFoundException("No se encontro habitación con id " + reserva.getHabitacion().getId());
            }
            BigDecimal valorReserva = calcularValorReserva(habitacion.getValorDia(),
                    reserva.getFechaInicio(), reserva.getFechaTermino());
            venta.setValor(String.valueOf(valorReserva.add(new BigDecimal(venta.getValor()))));
        }
        entityManager.merge(venta);
    }

    @Override
    public List<Venta> getVentas() {
        TypedQuery<Venta> query = entityManager.createQuery(
                "select v from Venta v " +
                        "JOIN FETCH v.reservas", Venta.class);
        List<Venta> ventas = query.getResultList();
        if (ventas == null || ventas.isEmpty()) {
            throw new HoteleriaNotFoundException("No existen ventas");
        }
        for (Venta venta : ventas) {
            for (Reserva reserva : venta.getReservas()) {
                reserva.setVentas(new ArrayList<>());
            }
        }
        return ventas;
    }

    @Override
    public Venta getVentaById(int idVenta) {
        Venta venta = entityManager.find(Venta.class, idVenta);
        if (venta == null || venta.getId() <= 0) {
            throw new HoteleriaNotFoundException("Venta no encontrada con id" + idVenta);
        }
        for (Reserva reserva : venta.getReservas()) {
            reserva.setVentas(new ArrayList<>());
        }
        return venta;
    }

    @Override
    public List<Venta> getVentasByIdHuesped(int idHuesped) {
        TypedQuery<Venta> query = entityManager.createQuery(
                "select v from Venta v " +
                        "JOIN FETCH huesped h " +
                        "where h.id = :data", Venta.class);
        query.setParameter("data", idHuesped);
        List<Venta> ventas = query.getResultList();
        if (ventas == null || ventas.isEmpty()) {
            throw new HoteleriaNotFoundException("No se encontraron ventas para huesped id " + idHuesped);
        }
        for (Venta venta : ventas) {
            for (Reserva reserva : venta.getReservas()) {
                reserva.setVentas(new ArrayList<>());
            }
        }
        return ventas;
    }

    @Override
    public List<Venta> getVentasByDniHuesped(String dniHuesped) {
        TypedQuery<Venta> query = entityManager.createQuery(
                "select v from Venta v " +
                        "JOIN FETCH huesped h " +
                        "where h.dni = :dni", Venta.class);
        query.setParameter("dni", dniHuesped);
        List<Venta> ventas = query.getResultList();
        if (ventas == null || ventas.isEmpty()) {
            throw new HoteleriaNotFoundException("No se encontraron ventas para huesped dni " + dniHuesped);
        }
        for (Venta venta : ventas) {
            for (Reserva reserva : venta.getReservas()) {
                reserva.setVentas(new ArrayList<>());
            }
        }
        return ventas;
    }

    @Override
    @Transactional
    public void deleteVentaById(int idVenta) {
        Venta venta = entityManager.find(Venta.class, idVenta);
        if (venta == null || venta.getId() <= 0) {
            throw new HoteleriaNotFoundException("No se encontro Venta con id " + idVenta);
        }
        entityManager.remove(venta);
    }

    @Override
    public List<Reserva> getReservas() {
        TypedQuery<Reserva> query = entityManager.createQuery(
                "SELECT r FROM Reserva r " +
                        "JOIN FETCH r.ventas", Reserva.class);
        List<Reserva> reservas = query.getResultList();
        if (reservas == null || reservas.isEmpty()) {
            throw new HoteleriaNotFoundException("No se encontraron reservas");
        }
        for (Reserva reserva : reservas) {
            for (Venta venta : reserva.getVentas()) {
                venta.setReservas(new ArrayList<>());
            }
        }
        return reservas;
    }

    @Override
    public Reserva getReservaById(int idReserva) {
        Reserva reserva = entityManager.find(Reserva.class, idReserva);
        if (reserva == null || reserva.getId() <= 0) {
            throw new HoteleriaNotFoundException("No se encontro reserva con id " + idReserva);
        }
        for (Venta venta : reserva.getVentas()) {
            venta.setReservas(new ArrayList<>());
        }
        return reserva;
    }

    @Override
    @Transactional
    public void deleteReservaById(int idReserva) {
        Reserva reserva = entityManager.find(Reserva.class, idReserva);
        if (reserva == null || reserva.getId() <= 0) {
            throw new HoteleriaNotFoundException("No se encontro reserva con id " + idReserva);
        }
        entityManager.remove(reserva);
    }
}
