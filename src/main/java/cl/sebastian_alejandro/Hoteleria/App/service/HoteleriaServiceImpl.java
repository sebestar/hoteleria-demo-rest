package cl.sebastian_alejandro.Hoteleria.App.service;

import cl.sebastian_alejandro.Hoteleria.App.dao.HoteleriaDAO;
import cl.sebastian_alejandro.Hoteleria.App.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoteleriaServiceImpl implements HoteleriaService {

    private final HoteleriaDAO hoteleriaDAO;

    @Autowired
    public HoteleriaServiceImpl(HoteleriaDAO hoteleriaDAO) {
        this.hoteleriaDAO = hoteleriaDAO;
    }

    @Override
    public void savePais(String namePais) {
        hoteleriaDAO.savePais(namePais);
    }

    @Override
    public void savePaisConCiudadesYProvincias(Pais pais) {
        hoteleriaDAO.savePaisConCiudadesYProvincias(pais);
    }

    @Override
    public List<Pais> getPaisCiudadesProvincias() {
        return hoteleriaDAO.getPaisCiudadesProvincias();
    }

    @Override
    public Pais findPaisCiudadesProvinciasByIdPais(int idPais) {
        return hoteleriaDAO.findPaisCiudadesProvinciasByIdPais(idPais);
    }

    @Override
    public void updatePais(Pais pais) {
        hoteleriaDAO.updatePais(pais);
    }

    @Override
    public void deletePaisCiudadesProvinciasByIdPais(int idPais) {
        hoteleriaDAO.deletePaisCiudadesProvinciasByIdPais(idPais);
    }

    @Override
    public void saveCiudad(String nameCiudad, int fkPais) {
        hoteleriaDAO.saveCiudad(nameCiudad, fkPais);
    }

    @Override
    public void saveCiudadYProvincias(Ciudad ciudad) throws Exception {
        hoteleriaDAO.saveCiudadYProvincias(ciudad);
    }

    @Override
    public List<Ciudad> getCiudadesProvincias() {
        return hoteleriaDAO.getCiudadesProvincias();
    }

    @Override
    public Ciudad findCiudadesProvinciasByIdCiudad(int idCiudad) {
        return hoteleriaDAO.findCiudadesProvinciasByIdCiudad(idCiudad);
    }

    @Override
    public void updateCiudad(Ciudad ciudad) {
        hoteleriaDAO.updateCiudad(ciudad);
    }

    @Override
    public void deleteCiudadesProvinciasByIdCiudad(int idCiudad) {
        hoteleriaDAO.deleteCiudadesProvinciasByIdCiudad(idCiudad);
    }

    @Override
    public void saveProvincia(Provincia provincia) {
        hoteleriaDAO.saveProvincia(provincia);
    }

    @Override
    public List<Provincia> getProvincias() {
        return hoteleriaDAO.getProvincias();
    }

    @Override
    public Provincia findProvinciasById(int idProvincia) {
        return hoteleriaDAO.findProvinciasById(idProvincia);
    }

    @Override
    public void updateProvincia(Provincia provincia) {
        hoteleriaDAO.updateProvincia(provincia);
    }

    @Override
    public void deleteProvinciaById(int idProvincia) {
        hoteleriaDAO.deleteProvinciaById(idProvincia);
    }

    @Override
    public void saveHabitacion(Habitacion habitacion) {
        hoteleriaDAO.saveHabitacion(habitacion);
    }

    @Override
    public List<Habitacion> getHabitacion() {
        return hoteleriaDAO.getHabitacion();
    }

    @Override
    public Habitacion findHabitacionById(int idHabitacion) {
        return hoteleriaDAO.findHabitacionById(idHabitacion);
    }

    @Override
    public void updateHabitacion(Habitacion habitacion) {
        hoteleriaDAO.updateHabitacion(habitacion);
    }

    @Override
    public void deleteHabitacionById(int idHabitacion) {
        hoteleriaDAO.deleteHabitacionById(idHabitacion);
    }

    @Override
    public void saveHuesped(Huesped huesped) {
        hoteleriaDAO.saveHuesped(huesped);
    }

    @Override
    public List<Huesped> getHuesped() {
        return hoteleriaDAO.getHuesped();
    }

    @Override
    public Huesped findHuespedById(int idHuesped) {
        return hoteleriaDAO.findHuespedById(idHuesped);
    }

    @Override
    public void updateHuesped(Huesped huesped) {
        hoteleriaDAO.updateHuesped(huesped);
    }

    @Override
    public void deleteHuespedById(int idHuesped) {
        hoteleriaDAO.deleteHuespedById(idHuesped);
    }

    @Override
    public void saveVenta(Venta venta) throws Exception {
        hoteleriaDAO.saveVenta(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return hoteleriaDAO.getVentas();
    }

    @Override
    public Venta getVentaById(int idVenta) {
        return hoteleriaDAO.getVentaById(idVenta);
    }

    @Override
    public List<Venta> getVentasByIdHuesped(int idHuesped) {
        return hoteleriaDAO.getVentasByIdHuesped(idHuesped);
    }

    @Override
    public List<Venta> getVentasByDniHuesped(String dniHuesped) {
        return hoteleriaDAO.getVentasByDniHuesped(dniHuesped);
    }

    @Override
    public void deleteVentaById(int idVenta) {
        hoteleriaDAO.deleteVentaById(idVenta);
    }

    @Override
    public List<Reserva> getReservas() {
        return hoteleriaDAO.getReservas();
    }

    @Override
    public Reserva getReservaById(int idReserva) {
        return hoteleriaDAO.getReservaById(idReserva);
    }

    @Override
    public void deleteReservaById(int idReserva) {
        hoteleriaDAO.deleteReservaById(idReserva);
    }
}
