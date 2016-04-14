package com.cardvalue.support.ws;

public class AroundMerchWSServiceProxy implements com.cardvalue.support.ws.AroundMerchWSService {
  private String _endpoint = null;
  private com.cardvalue.support.ws.AroundMerchWSService aroundMerchWSService = null;
  
  public AroundMerchWSServiceProxy() {
    _initAroundMerchWSServiceProxy();
  }
  
  public AroundMerchWSServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAroundMerchWSServiceProxy();
  }
  
  private void _initAroundMerchWSServiceProxy() {
    try {
      aroundMerchWSService = (new com.cardvalue.support.ws.impl.AroundMerchWSServiceImplServiceLocator()).getAroundMerchWSServiceImplPort();
      if (aroundMerchWSService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aroundMerchWSService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aroundMerchWSService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aroundMerchWSService != null)
      ((javax.xml.rpc.Stub)aroundMerchWSService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cardvalue.support.ws.AroundMerchWSService getAroundMerchWSService() {
    if (aroundMerchWSService == null)
      _initAroundMerchWSServiceProxy();
    return aroundMerchWSService;
  }
  
  public com.cardvalue.support.ws.AroundMerch[] getAroundMerchInfo(com.cardvalue.support.ws.WsSearchAroundMerchRequest request, com.cardvalue.support.ws.SingleSort[] sorts) throws java.rmi.RemoteException{
    if (aroundMerchWSService == null)
      _initAroundMerchWSServiceProxy();
    return aroundMerchWSService.getAroundMerchInfo(request, sorts);
  }
  
  public int getAroundMerchCount(double lat, double lng, int range, java.lang.String pId) throws java.rmi.RemoteException{
    if (aroundMerchWSService == null)
      _initAroundMerchWSServiceProxy();
    return aroundMerchWSService.getAroundMerchCount(lat, lng, range, pId);
  }
  
  public com.cardvalue.support.ws.MerchCredit[] getMerchLmtInfoByMerNo(java.lang.String merNo, java.lang.String pId) throws java.rmi.RemoteException{
    if (aroundMerchWSService == null)
      _initAroundMerchWSServiceProxy();
    return aroundMerchWSService.getMerchLmtInfoByMerNo(merNo, pId);
  }
  
  
}