package cn.cardvalue.www;

public class CrmServicePortTypeProxy implements cn.cardvalue.www.CrmServicePortType {
  private String _endpoint = null;
  private cn.cardvalue.www.CrmServicePortType crmServicePortType = null;
  
  public CrmServicePortTypeProxy() {
    _initCrmServicePortTypeProxy();
  }
  
  public CrmServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCrmServicePortTypeProxy();
  }
  
  private void _initCrmServicePortTypeProxy() {
    try {
      crmServicePortType = (new cn.cardvalue.www.CrmServiceLocator()).getcrmServicePort();
      if (crmServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)crmServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)crmServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (crmServicePortType != null)
      ((javax.xml.rpc.Stub)crmServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.cardvalue.www.CrmServicePortType getCrmServicePortType() {
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType;
  }
  
  public cn.cardvalue.www.ArrResponse soapGetUser(cn.cardvalue.www.SoapGetUserRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetUser(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapPostUser(cn.cardvalue.www.SoapPostUserRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapPostUser(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapAddUser(cn.cardvalue.www.SoapAddUserRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapAddUser(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapSetPassword(cn.cardvalue.www.SoapSetPasswordRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapSetPassword(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapAuthenticate(cn.cardvalue.www.SoapAuthenticateRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapAuthenticate(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapAddLead(cn.cardvalue.www.SoapAddLeadRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapAddLead(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapPostLead(cn.cardvalue.www.SoapPostLeadRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapPostLead(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapGetLeadsNotes(cn.cardvalue.www.SoapGetLeadsNotesRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetLeadsNotes(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapGetWhiteList(cn.cardvalue.www.SoapGetWhiteListRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetWhiteList(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapGetLeadsCategory(cn.cardvalue.www.SoapGetLeadsCategoryRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetLeadsCategory(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapGetLeads(cn.cardvalue.www.SoapGetLeadsRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetLeads(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapGetActiveLeads(cn.cardvalue.www.SoapGetActiveLeadsRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetActiveLeads(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapGetAppsCategory(cn.cardvalue.www.SoapGetAppsCategoryRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetAppsCategory(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapGetApps(cn.cardvalue.www.SoapGetAppsRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetApps(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapGetAppStatus(cn.cardvalue.www.SoapGetAppStatusRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapGetAppStatus(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapUpdateTransactionDataByLeadId(cn.cardvalue.www.SoapUpdateTransactionDataByLeadId parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapUpdateTransactionDataByLeadId(parameters);
  }
  
  public cn.cardvalue.www.ArrResponse soapAddLeadCoupon(cn.cardvalue.www.SoapAddLeadCouponRequest parameters) throws java.rmi.RemoteException{
    if (crmServicePortType == null)
      _initCrmServicePortTypeProxy();
    return crmServicePortType.soapAddLeadCoupon(parameters);
  }
  
  
}