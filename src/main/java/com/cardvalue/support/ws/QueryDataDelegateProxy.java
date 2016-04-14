package com.cardvalue.support.ws;

public class QueryDataDelegateProxy implements com.cardvalue.support.ws.QueryDataDelegate {
  private String _endpoint = null;
  private com.cardvalue.support.ws.QueryDataDelegate queryDataDelegate = null;
  
  public QueryDataDelegateProxy() {
    _initQueryDataDelegateProxy();
  }
  
  public QueryDataDelegateProxy(String endpoint) {
    _endpoint = endpoint;
    _initQueryDataDelegateProxy();
  }
  
  private void _initQueryDataDelegateProxy() {
    try {
      queryDataDelegate = (new com.cardvalue.support.ws.impl.QueryDataServiceLocator()).getQueryDataPort();
      if (queryDataDelegate != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)queryDataDelegate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)queryDataDelegate)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (queryDataDelegate != null)
      ((javax.xml.rpc.Stub)queryDataDelegate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cardvalue.support.ws.QueryDataDelegate getQueryDataDelegate() {
    if (queryDataDelegate == null)
      _initQueryDataDelegateProxy();
    return queryDataDelegate;
  }
  
  public java.lang.String queryMoney(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, int arg5) throws java.rmi.RemoteException{
    if (queryDataDelegate == null)
      _initQueryDataDelegateProxy();
    return queryDataDelegate.queryMoney(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public java.lang.String queryPos(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, int arg5) throws java.rmi.RemoteException{
    if (queryDataDelegate == null)
      _initQueryDataDelegateProxy();
    return queryDataDelegate.queryPos(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public java.lang.String queryBaoli(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, int arg5) throws java.rmi.RemoteException{
    if (queryDataDelegate == null)
      _initQueryDataDelegateProxy();
    return queryDataDelegate.queryBaoli(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public java.lang.String queryCashadvIdByMid(java.lang.String arg0) throws java.rmi.RemoteException{
    if (queryDataDelegate == null)
      _initQueryDataDelegateProxy();
    return queryDataDelegate.queryCashadvIdByMid(arg0);
  }
  
  
}