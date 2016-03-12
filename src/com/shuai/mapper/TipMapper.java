package com.shuai.mapper;

import com.shuaizhao.domain.Tip;

public interface TipMapper {
	public Tip findTipById(int id);
	public void insertTip(Tip tip);
}
