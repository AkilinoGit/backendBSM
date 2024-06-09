package com.clases.gateway.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class Constants {

  private Constants(){}


  public static final String MSP_ID_ORG1 = "Org1MSP";
  public static final String CHANNEL_NAME = "mychannel";
  public static final String CHAINCODE_LOTE_NAME = "chaincode";
  //ORGANIZATION 1
  // Path to crypto materials.
  public static final Path CRYPTO_PATH_ORG1 = Paths.get("./organizations/peerOrganizations/org1.example.com");
  // Path to user certificate.
  public static final Path CERT_PATH_ORG1 = CRYPTO_PATH_ORG1.resolve(Paths.get("users/User1@org1.example.com/msp/signcerts/cert.pem"));
  // Path to user private key directory.
  public static final Path KEY_DIR_PATH_ORG1 = CRYPTO_PATH_ORG1.resolve(Paths.get("users/User1@org1.example.com/msp/keystore"));
  // Path to peer tls certificate.
  public static final Path TLS_CERT_PATH_ORG1 = CRYPTO_PATH_ORG1.resolve(Paths.get("peers/peer0.org1.example.com/tls/ca.crt"));
  // Gateway peer end point.
  public static final String PEER_ENDPOINT_ORG1 = "localhost:7051";
  public static final String OVERRIDE_AUTH_ORG1 = "peer0.org1.example.com";

  //ORGANIZATION 2
  public static final String MSP_ID_ORG2 = "Org2MSP";;
  public static final Path CRYPTO_PATH_ORG2 = Paths.get("./organizations/peerOrganizations/org2.example.com");
  public static final Path KEY_DIR_PATH_ORG2 = CRYPTO_PATH_ORG2.resolve(Paths.get("users/User1@org2.example.com/msp/keystore"));;
  public static final Path CERT_PATH_ORG2 = CRYPTO_PATH_ORG2.resolve(Paths.get("users/User1@org2.example.com/msp/signcerts/cert.pem"));;
  public static final Path TLS_CERT_PATH_ORG2 = CRYPTO_PATH_ORG2.resolve(Paths.get("peers/peer0.org2.example.com/tls/ca.crt"));

  public static final String PEER_ENDPOINT_ORG2 = "localhost:9051";
  public static final String OVERRIDE_AUTH_ORG2 = "peer0.org2.example.com";;

  //ORGANIZATION 3
  public static final String MSP_ID_ORG3 = "Org3MSP";;
  public static final Path CRYPTO_PATH_ORG3 = Paths.get("./organizations/peerOrganizations/org3.example.com");
  public static final Path KEY_DIR_PATH_ORG3 = CRYPTO_PATH_ORG3.resolve(Paths.get("users/User1@org3.example.com/msp/keystore"));;
  public static final Path CERT_PATH_ORG3 = CRYPTO_PATH_ORG3.resolve(Paths.get("users/User1@org3.example.com/msp/signcerts/User1@org3.example.com-cert.pem"));;
  public static final Path TLS_CERT_PATH_ORG3 = CRYPTO_PATH_ORG3.resolve(Paths.get("peers/peer0.org3.example.com/tls/ca.crt"));

  public static final String PEER_ENDPOINT_ORG3 = "localhost:11051";
  public static final String OVERRIDE_AUTH_ORG3 = "peer0.org3.example.com";

}
