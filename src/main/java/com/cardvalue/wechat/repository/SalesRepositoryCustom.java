package com.cardvalue.wechat.repository;

import java.util.List;

import com.cardvalue.wechat.dto.ActiveRateDTO;
import com.cardvalue.wechat.dto.LabelValueTO;
import com.cardvalue.wechat.dto.LoginSalesInBranchTO;
import com.cardvalue.wechat.dto.SalesInfo;
import com.cardvalue.wechat.dto.SalesLoginTO;
import com.cardvalue.wechat.dto.SalesPointSummaryDTO;
import com.cardvalue.wechat.dto.SalesUnLoginTO;
import com.cardvalue.wechat.dto.SaveSalesDTO;
import com.cardvalue.wechat.model.Sales;

public interface SalesRepositoryCustom {
	
	public List<SalesLoginTO> findLoggedSales();
	
	public List<SalesUnLoginTO> findNotLoggedSales();
	
	public List<LoginSalesInBranchTO> findLoggedSalesInBranch();
	
	public List<LabelValueTO> findLoggedSalesInLoginDate();

	public List<ActiveRateDTO> findActiveRate();

	public Sales saveSales(SaveSalesDTO dto, Sales s);
	
	public SalesInfo getSalesInfo(int salesId);
	
	public List<SalesPointSummaryDTO> getSalesPointSummary();

	public Sales saveSales(SaveSalesDTO dto);
}
