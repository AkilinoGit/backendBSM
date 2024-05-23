package com.clases.gateway.controller;

import com.clases.gateway.dto.*;
import com.clases.gateway.service.LoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/lote")
@RequiredArgsConstructor
public class LoteController {

    private final LoteService loteService;

    @PostMapping(path = "/registrarLote")
    public ResponseDTO registrarLote(@RequestBody RegistrarLoteDTO dto) {
        return loteService.registrarLote(dto.getLoteId(), dto.getProducto(), dto.getKg(), dto.getOrigen());}

    @PutMapping(path = "/transportarLote")
    public ResponseDTO transportarLote(@RequestBody TransportarLoteDTO dto) {
    return loteService.transportarLote(dto.getLoteId(), dto.getKm());}

    @PutMapping(path = "/venderLote")
    public ResponseDTO venderLote(@RequestBody VenderLoteDTO dto){
      return loteService.venderLote(dto.getLoteId(), dto.getPrecioKg());}

    @DeleteMapping(path = "/loteVendido")
    public ResponseDTO loteVendido(@RequestParam String loteId) {
      return loteService.loteVendido(loteId);}

    @GetMapping(path = "/imprimirLote")
    public ResponseDTO imprimirLote(@RequestParam String loteId) {
        return loteService.imprimirLote(loteId);}

  @GetMapping(path = "/listarLotes")
  public ResponseDTO listarLotes(){
      return loteService.listarLotes();
  }
}
