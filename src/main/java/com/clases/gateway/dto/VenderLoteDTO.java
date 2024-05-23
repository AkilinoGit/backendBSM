package com.clases.gateway.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VenderLoteDTO {
  @ApiModelProperty(value = "Lote ID", example = "1")
  String loteId;

  @ApiModelProperty(value = "Precio venta", example = "1,21")
  String precioKg;

}
