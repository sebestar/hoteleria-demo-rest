package cl.sebastian_alejandro.Hoteleria.App.service;

import cl.sebastian_alejandro.Hoteleria.App.entity.*;

import java.util.List;

public interface HoteleriaService {

    // ** crud pais *******************************************

    void savePais(String namePais);

    void savePaisConCiudadesYProvincias(Pais pais);

    List<Pais> getPaisCiudadesProvincias();

    Pais findPaisCiudadesProvinciasByIdPais(int idPais);

    void updatePais(Pais pais);

    void deletePaisCiudadesProvinciasByIdPais(int idPais);

    // ** crud Ciudad *******************************************

    void saveCiudad(String nameCiudad, int fkPais);

    void saveCiudadYProvincias(Ciudad ciudad) throws Exception;

    List<Ciudad> getCiudadesProvincias();

    Ciudad findCiudadesProvinciasByIdCiudad(int idCiudad);

    void updateCiudad(Ciudad ciudad);

    void deleteCiudadesProvinciasByIdCiudad(int idCiudad);

    // ** crud Provincia *******************************************

    void saveProvincia(Provincia provincia);

    List<Provincia> getProvincias();

    Provincia findProvinciasById(int idProvincia);

    void updateProvincia(Provincia provincia);

    void deleteProvinciaById(int idProvincia);

    // ** crud Habitacion *******************************************

    void saveHabitacion(Habitacion habitacion);

    List<Habitacion> getHabitacion();

    Habitacion findHabitacionById(int idHabitacion);

    void updateHabitacion(Habitacion habitacion);

    void deleteHabitacionById(int idHabitacion);

    // ** crud Huesped *******************************************

    void saveHuesped(Huesped huesped);

    List<Huesped> getHuesped();

    Huesped findHuespedById(int idHuesped);

    void updateHuesped(Huesped huesped);

    void deleteHuespedById(int idHuesped);

    // ** crud Ventas *******************************************

    void saveVenta(Venta venta) throws Exception;

    List<Venta> getVentas();

    Venta getVentaById(int idVenta);

    List<Venta> getVentasByIdHuesped(int idHuesped);

    List<Venta> getVentasByDniHuesped(String dniHuesped);

    void deleteVentaById(int idVenta);

    // ** crud Reserva *******************************************

    // Obtener todas las reservas
    List<Reserva> getReservas();

    Reserva getReservaById(int idReserva);

    void deleteReservaById(int idReserva);
}
