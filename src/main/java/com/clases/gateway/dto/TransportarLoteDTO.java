package com.clases.gateway.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TransportarLoteDTO {


    @ApiModelProperty(value = "Lote ID", example = "1")
    String loteId;

    @ApiModelProperty(value = "Km recorridos", example = "5000")
    String km;

}
