package com.clases.gateway.service;

import com.clases.gateway.dto.ResponseDTO;
import com.clases.gateway.repository.FabricGatewayOrg2;
import com.clases.gateway.utils.Constants;
import com.clases.gateway.repository.FabricGateway;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.hyperledger.fabric.client.Contract;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoteService {

    public final FabricGateway fabricGateway;
    public final FabricGatewayOrg2 fabricGatewayOrg2;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ResponseDTO registrarLote(final String loteID, final String producto, final String kg,
                                   final String origen) {

        ResponseDTO response = new ResponseDTO();

        try (var gateway = fabricGateway.createConnection().connect()) {
            var network = gateway.getNetwork(Constants.CHANNEL_NAME);

            // Get the smart contract from the network.
            Contract contract = network.getContract(Constants.CHAINCODE_LOTE_NAME);
            byte[] result = contract.submitTransaction("registrarLote", loteID, producto, kg, origen);

            response.setCode("0");
            response.setData(prettyJson(result));
        } catch (Exception e) {
            response.setCode("1");
            response.setData(e.getMessage());
        }

        return response;
    }

    public ResponseDTO imprimirLote(final String loteID) {

        ResponseDTO response = new ResponseDTO();

        try (var gateway = fabricGateway.createConnection().connect()) {
            var network = gateway.getNetwork(Constants.CHANNEL_NAME);

            // Get the smart contract from the network.
            Contract contract = network.getContract(Constants.CHAINCODE_LOTE_NAME);
            byte[] result  = contract.submitTransaction("imprimirLote", loteID);

            response.setCode("0");
            response.setData(prettyJson(result));
        } catch (Exception e) {
            response.setCode("1");
            response.setData(e.getMessage());
        }

        return response;
    }

    public ResponseDTO loteVendido(final String loteId) {

        ResponseDTO response = new ResponseDTO();

        try (var gateway = fabricGateway.createConnection().connect()) {
            var network = gateway.getNetwork(Constants.CHANNEL_NAME);

            // Get the smart contract from the network.
            Contract contract = network.getContract(Constants.CHAINCODE_LOTE_NAME);
            contract.submitTransaction("loteVendido", loteId);

            response.setCode("0");
            response.setData("Lote vendido");
        } catch (Exception e) {
            response.setCode("1");
            response.setData(e.getMessage());
        }

        return response;
    }

    public ResponseDTO transportarLote(final String loteId, final String km) {

        ResponseDTO response = new ResponseDTO();

        try (var gateway = fabricGatewayOrg2.createConnection().connect()) {
            var network = gateway.getNetwork(Constants.CHANNEL_NAME);

            // Get the smart contract from the network.
            Contract contract = network.getContract(Constants.CHAINCODE_LOTE_NAME);
            byte[] result = contract.submitTransaction("transportarLote", loteId, km);

            response.setCode("0");
            response.setData(prettyJson(result));
        } catch (Exception e) {
            response.setCode("1");
            response.setData(e.getMessage());
        }

        return response;
    }
    public ResponseDTO venderLote(final String loteId, final String precioKg){
      ResponseDTO response = new ResponseDTO();

      try (var gateway = fabricGateway.createConnection().connect()) {
        var network= gateway.getNetwork(Constants.CHANNEL_NAME);

        Contract contract = network.getContract(Constants.CHAINCODE_LOTE_NAME);
        byte[] result = contract.submitTransaction("venderLote", loteId, precioKg);

        response.setCode("0");
        response.setData(prettyJson(result));

      } catch(Exception e) {
        response.setCode("1");
        response.setData(e.getMessage());
      }

      return response;
    }

    public ResponseDTO listarLotes() {

        ResponseDTO response = new ResponseDTO();

        try (var gateway = fabricGateway.createConnection().connect()) {
            var network = gateway.getNetwork(Constants.CHANNEL_NAME);

            // Get the smart contract from the network.
            Contract contract = network.getContract(Constants.CHAINCODE_LOTE_NAME);
            byte[] result  = contract.submitTransaction("listarLotes");

            response.setCode("0");
            log.info("Byte: {}", result);
            log.info("StringByte in UTF8: {} ", new String(result, StandardCharsets.UTF_8));
            log.info("parsedJson: {}", JsonParser.parseString(new String(result, StandardCharsets.UTF_8)));
            log.info("gson to Json: {} ", gson.toJson(JsonParser.parseString(new String(result, StandardCharsets.UTF_8))));
            
            response.setData(prettyJson(result));
        } catch (Exception e) {
            response.setCode("1");
            response.setData(e.getMessage());
        }

        return response;
    }

    private String prettyJson(final byte[] json) {
        return prettyJson(new String(json, StandardCharsets.UTF_8));
    }

    private String prettyJson(final String json) {
      try {
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);
        var parsedJson = JsonParser.parseReader(reader);
        return gson.toJson(parsedJson);
      } catch (JsonSyntaxException e) {
        System.err.println("Malformed JSON: " + e.getMessage());
        return "Malformed JSON: " + e.getMessage();
      }
        /*
        var parsedJson = JsonParser.parseString(json);
        return gson.toJson(parsedJson);*/
    }


}
