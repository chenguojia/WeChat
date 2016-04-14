package com.cardvalue.cas.service.impl;

public class MerchantServiceImplProxy implements com.cardvalue.cas.service.impl.MerchantServiceImpl {
  private String _endpoint = null;
  private com.cardvalue.cas.service.impl.MerchantServiceImpl merchantServiceImpl = null;
  
  public MerchantServiceImplProxy() {
    _initMerchantServiceImplProxy();
  }
  
  public MerchantServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initMerchantServiceImplProxy();
  }
  
  private void _initMerchantServiceImplProxy() {
    try {
      merchantServiceImpl = (new com.cardvalue.cas.service.impl.MerchantServiceLocator()).getMerchantServiceImplPort();
      if (merchantServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)merchantServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)merchantServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (merchantServiceImpl != null)
      ((javax.xml.rpc.Stub)merchantServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cardvalue.cas.service.impl.MerchantServiceImpl getMerchantServiceImpl() {
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl;
  }
  
  public com.cardvalue.cas.service.impl.AddMidReturn addMidRequest(java.lang.String applicantId, java.lang.String midList) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.addMidRequest(applicantId, midList);
  }
  
  public com.cardvalue.cas.service.impl.CreateApplicantReturn createApplicant(java.lang.String channel, java.lang.String creditWay, java.lang.String corpName, java.lang.Boolean checkName, java.lang.String province, java.lang.String plannedAmt, java.lang.String plannedDays) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.createApplicant(channel, creditWay, corpName, checkName, province, plannedAmt, plannedDays);
  }
  
  public com.cardvalue.cas.service.impl.UpdateApplicantReturn updateApplicant(java.lang.String applicantId, java.lang.String channel, java.lang.String creditWay, java.lang.String corpName, java.lang.Boolean checkName, java.lang.String province, java.lang.String plannedAmt, java.lang.String plannedDays) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.updateApplicant(applicantId, channel, creditWay, corpName, checkName, province, plannedAmt, plannedDays);
  }
  
  public com.cardvalue.cas.service.impl.DeleteMidReturn deleteMidRequest(java.lang.String applicantId, java.lang.String midList) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.deleteMidRequest(applicantId, midList);
  }
  
  public com.cardvalue.cas.service.impl.AddOpenReturn addOpenRequest(java.lang.String applicantId, java.lang.String businessType, java.lang.String cityName, java.lang.String businessAreaClass, java.lang.String addressType, java.lang.String staffNumClass, java.lang.String educationClass, java.lang.String maritalStatus, java.lang.String hasChildren, java.lang.String localResidence, java.lang.String mccCode, java.lang.String storeProp, java.lang.String regName, java.lang.String bizName, java.lang.String bizScope) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.addOpenRequest(applicantId, businessType, cityName, businessAreaClass, addressType, staffNumClass, educationClass, maritalStatus, hasChildren, localResidence, mccCode, storeProp, regName, bizName, bizScope);
  }
  
  public com.cardvalue.cas.service.impl.DeleteOpenReturn deleteOpenRequest(java.lang.String applicantId) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.deleteOpenRequest(applicantId);
  }
  
  public com.cardvalue.cas.service.impl.DeleteBusinessReturn deleteBusiness(java.lang.String businessType, java.lang.String businessId) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.deleteBusiness(businessType, businessId);
  }
  
  public com.cardvalue.cas.service.impl.PosCreditCalculateReturn posCreditCalculate(java.lang.String mcc_code, java.lang.String pro_code, java.lang.String recencyR, java.lang.String averageA, java.lang.String frequencyF, java.lang.String monetaryM, java.lang.String perMonVolumeP, java.lang.String lastMonVolumeL, java.lang.String stableS, java.lang.String growthG, java.lang.String monthOfBiz, java.lang.String contMonth) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.posCreditCalculate(mcc_code, pro_code, recencyR, averageA, frequencyF, monetaryM, perMonVolumeP, lastMonVolumeL, stableS, growthG, monthOfBiz, contMonth);
  }
  
  public com.cardvalue.cas.service.impl.CreditResultReturn creditResult(java.lang.String applicantId) throws java.rmi.RemoteException{
    if (merchantServiceImpl == null)
      _initMerchantServiceImplProxy();
    return merchantServiceImpl.creditResult(applicantId);
  }
  
  
}