package com.clases.gateway.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegistrarLoteDTO {

    @ApiModelProperty(value = "Lote ID", example = "1")
    String loteId;

    @ApiModelProperty(value = "Producto", example = "Fresas")
    String producto;

    @ApiModelProperty(value = "kg", example = "5000")
    String kg;

    @ApiModelProperty(value = "Origen", example = "Huelva")
    String origen;


}
