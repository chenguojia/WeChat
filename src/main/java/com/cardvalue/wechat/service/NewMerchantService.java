package com.cardvalue.wechat.service;

import com.cardvalue.wechat.dto.*;
import com.cardvalue.wechat.util.RestfulResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface NewMerchantService {

    public NewMerchantUserModel enter(String code, HttpSession session, HttpServletRequest request);

    public List getVerifyQuestion(String creditId,String mid);

    public RestfulResult verifyQuestionAnswer(List<VerifyQuestionModel> questions, String questionIds, String questionAnswers);

    public RestfulResult bind(BindDTO dto, HttpSession session, HttpServletRequest request);

    public RestfulResult forgetPassword(ForgetPasswordDTO dto, HttpSession session);

    public RestfulResult login(LoginDTO dto, HttpSession session, HttpServletRequest request);

    public RestfulResult logout(HttpSession session);

    public RestfulResult updatePassword(UpdatePasswordDTO dto);

    public NewMerchantUserModel getMerchantUserById(String merchantUserId);

    public RestfulResult accredit(String type, String merchantId, String applicationId, String mobilePhone, String ip, String openId, String deviceNumber, String gps, String agent);

    public ApplicationModel getApplicationById(String applicationId);

    public RestfulResult posLimit(PosLimitDTO dto, HttpSession session);

    public RestfulResult basicLimit(BasicLimitDTO dto,NewMerchantUserModel newMerchantUserModel, HttpSession session);

    public List queryApplications(String merchantId);

    public RestfulResult createApplication(String merchantId, HttpSession session);

    public List queryConfirmlists(String applicationId);

    public List queryUploadFileMain(String merchantId, boolean isPending);

    public List queryUploadFileChildModel(String merchantId, String groupName);

    public RestfulResult updateMerchantUser(String merchantUserId, Map parameter, HttpSession session);

    public RestfulResult updateMerchantUserlatitudeAndLongitude(String openId, Map parameter);

    public RestfulResult updateApplication(String applicationId, Map parameter);

    public List getCashdvancesAppById(String appId);

    public RestfulResult addFile(String baoliId);

    public List queryProvinces();

    public List queryCitys(String provinceId);

    public List queryIndustrys();

    public List queryIndustryDetails(String industryId, String merchantId);

    public RestfulResult  getCredits(String creditId);

    public List queryPosCreditsMids(String creditId);

    public PosMidModel queryCheckFailMid(List<PosMidModel> list);

    public PosMidModel queryProcessingMid(List<PosMidModel> list);

    public PosMidModel queryMakingQuestionsMid(List<PosMidModel> list);

    public RestfulResult updateCreditCheckQuestions(String creditId, String mid, Map parameter);

    public RestfulResult juxinliLimit(JuxinliLimitDTO dto,NewMerchantUserModel newMerchantUserModel,HttpSession session);


}
