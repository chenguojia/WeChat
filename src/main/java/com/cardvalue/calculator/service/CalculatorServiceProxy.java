package com.cardvalue.calculator.service;

public class CalculatorServiceProxy implements com.cardvalue.calculator.service.CalculatorService_PortType {
  private String _endpoint = null;
  private com.cardvalue.calculator.service.CalculatorService_PortType calculatorService_PortType = null;
  
  public CalculatorServiceProxy() {
    _initCalculatorServiceProxy();
  }
  
  public CalculatorServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculatorServiceProxy();
  }
  
  private void _initCalculatorServiceProxy() {
    try {
      calculatorService_PortType = (new com.cardvalue.calculator.service.CalculatorService_ServiceLocator()).getCalculatorServiceSOAP();
      if (calculatorService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculatorService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculatorService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculatorService_PortType != null)
      ((javax.xml.rpc.Stub)calculatorService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cardvalue.calculator.service.CalculatorService_PortType getCalculatorService_PortType() {
    if (calculatorService_PortType == null)
      _initCalculatorServiceProxy();
    return calculatorService_PortType;
  }
  
  public com.cardvalue.calculator.service.CalculateResponse calculate(com.cardvalue.calculator.service.CalculateRequest parameters) throws java.rmi.RemoteException{
    if (calculatorService_PortType == null)
      _initCalculatorServiceProxy();
    return calculatorService_PortType.calculate(parameters);
  }
  
  
}