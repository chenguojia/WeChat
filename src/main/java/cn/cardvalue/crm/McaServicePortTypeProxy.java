package cn.cardvalue.crm;

public class McaServicePortTypeProxy implements cn.cardvalue.crm.McaServicePortType {
  private String _endpoint = null;
  private cn.cardvalue.crm.McaServicePortType mcaServicePortType = null;
  
  public McaServicePortTypeProxy() {
    _initMcaServicePortTypeProxy();
  }
  
  public McaServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initMcaServicePortTypeProxy();
  }
  
  private void _initMcaServicePortTypeProxy() {
    try {
      mcaServicePortType = (new cn.cardvalue.crm.McaServiceLocator()).getMcaServicePort();
      if (mcaServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mcaServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mcaServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mcaServicePortType != null)
      ((javax.xml.rpc.Stub)mcaServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.cardvalue.crm.McaServicePortType getMcaServicePortType() {
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType;
  }
  
  public cn.cardvalue.crm.ArrResponse soapValidateUser(cn.cardvalue.crm.ValidateUserRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapValidateUser(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapUpdateApp(cn.cardvalue.crm.SoapUpdateAppRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapUpdateApp(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapGetApp(cn.cardvalue.crm.SoapGetAppRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapGetApp(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapListMca(cn.cardvalue.crm.SoapListMcaRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapListMca(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapUpdateStatus(cn.cardvalue.crm.SoapUpdateStatusRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapUpdateStatus(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapRenewMca(cn.cardvalue.crm.SoapRenewMcaRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapRenewMca(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapAddApp(cn.cardvalue.crm.SoapAddAppRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapAddApp(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapAddDoc(cn.cardvalue.crm.SoapAddDocRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapAddDoc(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapListBill(cn.cardvalue.crm.SoapListBillRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapListBill(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapGetOauthToken(cn.cardvalue.crm.GetOauthTokenRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapGetOauthToken(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapListStatistics(cn.cardvalue.crm.SoapListStatisticsRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapListStatistics(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapAddAppWechat(cn.cardvalue.crm.SoapAddAppWechatRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapAddAppWechat(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapCheckExistingApp(cn.cardvalue.crm.SoapCheckExistingAppRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapCheckExistingApp(parameters);
  }
  
  public cn.cardvalue.crm.ArrResponse soapListCreditFileStatus(cn.cardvalue.crm.SoapListCreditFileStatusRequest parameters) throws java.rmi.RemoteException{
    if (mcaServicePortType == null)
      _initMcaServicePortTypeProxy();
    return mcaServicePortType.soapListCreditFileStatus(parameters);
  }
  
  
}