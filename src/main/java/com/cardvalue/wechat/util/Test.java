package com.cardvalue.wechat.util;

import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {
		double totalCreditLine = 1001812.12;
		DecimalFormat format = new DecimalFormat("0.0");
		String creditLineInString = format.format(totalCreditLine/10000);
		System.out.println(creditLineInString);
	}

}
