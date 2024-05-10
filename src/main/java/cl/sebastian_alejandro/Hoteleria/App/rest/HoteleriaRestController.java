package cl.sebastian_alejandro.Hoteleria.App.rest;

import cl.sebastian_alejandro.Hoteleria.App.entity.*;
import cl.sebastian_alejandro.Hoteleria.App.service.HoteleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HoteleriaRestController {

    HoteleriaService hoteleriaService;

    @Autowired
    public HoteleriaRestController(HoteleriaService hoteleriaService) {
        this.hoteleriaService = hoteleriaService;
    }

    /**
     * API PAISES
     */

    @GetMapping("/paises")
    public List<Pais> getPaisCiudadesProvincias() {
        return hoteleriaService.getPaisCiudadesProvincias();
    }

    @GetMapping("/paises/{idPais}")
    public Pais findPaisCiudadesProvinciasByIdPais(@PathVariable Integer idPais) {
        return hoteleriaService.findPaisCiudadesProvinciasByIdPais(idPais);
    }

    @PostMapping("/paises/{namePais}")
    public void updatePais(@PathVariable String namePais) {
        hoteleriaService.savePais(namePais);
    }

    @PostMapping("/paises")
    public void savePaisConCiudadesYProvincias(@RequestBody Pais pais) {
        hoteleriaService.savePaisConCiudadesYProvincias(pais);
    }

    @PutMapping("/paises")
    public void updatePais(@RequestBody Pais pais) {
        hoteleriaService.updatePais(pais);
    }

    @DeleteMapping("/paises/{idPais}")
    public void deletePaisCiudadesProvinciasByIdPais(@PathVariable Integer idPais) {
        hoteleriaService.deletePaisCiudadesProvinciasByIdPais(idPais);
    }

    /**
     * API CIUDADES
     */

    @GetMapping("/ciudades")
    public List<Ciudad> getCiudadesProvincias() {
        return hoteleriaService.getCiudadesProvincias();
    }

    @GetMapping("/ciudades/{idCiudad}")
    public Ciudad findCiudadesProvinciasByIdCiudad(@PathVariable Integer idCiudad) {
        return hoteleriaService.findCiudadesProvinciasByIdCiudad(idCiudad);
    }

    @PostMapping("/ciudades/{nameCiudad}/{fkPais}")
    public void saveCiudad(@PathVariable String nameCiudad, @PathVariable Integer fkPais) {
        hoteleriaService.saveCiudad(nameCiudad, fkPais);
    }

    @PostMapping("/ciudades")
    public void saveCiudadYProvincias(@RequestBody Ciudad ciudad) throws Exception {
        hoteleriaService.saveCiudadYProvincias(ciudad);
    }

    @PutMapping("/ciudades")
    public void updateCiudad(@RequestBody Ciudad ciudad) {
        hoteleriaService.updateCiudad(ciudad);
    }

    @DeleteMapping("/ciudades/{idCiudad}")
    public void deleteCiudadesProvinciasByIdCiudad(@PathVariable Integer idCiudad) {
        hoteleriaService.deleteCiudadesProvinciasByIdCiudad(idCiudad);
    }

    /**
     * API PROVINCIAS
     */

    @GetMapping("/provincias")
    public List<Provincia> getProvincias() {
        return hoteleriaService.getProvincias();
    }

    @GetMapping("/provincias/{idProvincia}")
    public Provincia findProvinciaById(@PathVariable Integer idProvincia) {
        return hoteleriaService.findProvinciasById(idProvincia);
    }

    @PostMapping("/provincias")
    public void saveProvincia(@RequestBody Provincia provincia) {
        hoteleriaService.saveProvincia(provincia);
    }

    @PutMapping("/provincias")
    public void updateProvincia(@RequestBody Provincia provincia) {
        hoteleriaService.updateProvincia(provincia);
    }

    @DeleteMapping("/provincias/{idCiudad}")
    public void deleteProvinciaById(@PathVariable Integer idProvincia) {
        hoteleriaService.deleteProvinciaById(idProvincia);
    }

    /**
     * API HABITACION
     */

    @GetMapping("/habitaciones")
    public List<Habitacion> getHabitacion() {
        return hoteleriaService.getHabitacion();
    }

    @GetMapping("/habitaciones/{idHabitacion}")
    public Habitacion findHabitacionById(@PathVariable Integer idHabitacion) {
        return hoteleriaService.findHabitacionById(idHabitacion);
    }

    @PostMapping("/habitaciones")
    public void saveHabitacion(@RequestBody Habitacion habitacion) {
        hoteleriaService.saveHabitacion(habitacion);
    }

    @PutMapping("/habitaciones")
    public void updateHabitacion(@RequestBody Habitacion habitacion) {
        hoteleriaService.updateHabitacion(habitacion);
    }

    @DeleteMapping("/habitaciones/{idHabitacion}")
    public void deleteHabitacionById(@PathVariable Integer idHabitacion) {
        hoteleriaService.deleteHabitacionById(idHabitacion);
    }

    /**
     * API HUESPED
     */

    @GetMapping("/huespedes")
    public List<Huesped> getHuesped() {
        return hoteleriaService.getHuesped();
    }

    @GetMapping("/huespedes/{idHuesped}")
    public Huesped findHuespedById(@PathVariable Integer idHuesped) {
        return hoteleriaService.findHuespedById(idHuesped);
    }

    @PostMapping("/huespedes")
    public void saveHuesped(@RequestBody Huesped huesped) {
        hoteleriaService.saveHuesped(huesped);
    }

    @PutMapping("/huespedes")
    public void updateHuesped(@RequestBody Huesped huesped) {
        hoteleriaService.updateHuesped(huesped);
    }

    @DeleteMapping("/huespedes/{idHuesped}")
    public void deleteHuespedById(@PathVariable Integer idHuesped) {
        hoteleriaService.deleteHuespedById(idHuesped);
    }

    /**
     * API VENTAS
     */

    @PostMapping("/ventas")
    public void saveVentas(@RequestBody Venta venta) throws Exception {
        hoteleriaService.saveVenta(venta);
    }

    @GetMapping("/ventas")
    public List<Venta> ventas() {
        return hoteleriaService.getVentas();
    }

    @GetMapping("/ventas/id/{idVenta}")
    public Venta ventaById(@PathVariable int idVenta) {
        return hoteleriaService.getVentaById(idVenta);
    }

    @GetMapping("/ventas/idhu/{idHuesped}")
    public List<Venta> ventaByIdHuesped(@PathVariable int idHuesped) {
        return hoteleriaService.getVentasByIdHuesped(idHuesped);
    }

    @GetMapping("/ventas/dnihu/{dniHuesped}")
    public List<Venta> ventaByDniHuesped(@PathVariable String dniHuesped) {
        return hoteleriaService.getVentasByDniHuesped(dniHuesped);
    }

    @DeleteMapping("/ventas/{idVenta}")
    public void deleteVentaById(@PathVariable int idVenta) {
        hoteleriaService.deleteVentaById(idVenta);
    }

    /**
     * API RESERVAS
     */

    @GetMapping("/reservas")
    public List<Reserva> reservas() {
        return hoteleriaService.getReservas();
    }

    @GetMapping("/reservas/{idReserva}")
    public Reserva getReservaById(@PathVariable int idReserva) {
        return hoteleriaService.getReservaById(idReserva);
    }

    @DeleteMapping("/reservas/{idReserva}")
    public void deleteReserva(@PathVariable Integer idReserva) {
        hoteleriaService.deleteReservaById(idReserva);
    }
}
