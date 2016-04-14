

/**
 * SettleService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.cardvalue.bofeiran.service;

    /*
     *  SettleService java interface
     */

    public interface SettleService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getPerformanceByUserNumberAndMonth0
                
         */

         
                     public com.cardvalue.bofeiran.service.GetPerformanceByUserNumberAndMonthResponse getPerformanceByUserNumberAndMonth(

                        com.cardvalue.bofeiran.service.GetPerformanceByUserNumberAndMonth getPerformanceByUserNumberAndMonth0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPerformanceByUserNumberAndMonth0
            
          */
        public void startgetPerformanceByUserNumberAndMonth(

            com.cardvalue.bofeiran.service.GetPerformanceByUserNumberAndMonth getPerformanceByUserNumberAndMonth0,

            final com.cardvalue.bofeiran.service.SettleServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    