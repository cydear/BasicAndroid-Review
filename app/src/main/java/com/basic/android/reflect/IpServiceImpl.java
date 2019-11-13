package com.basic.android.reflect;

import com.basic.android.http.IpModel;
import com.basic.android.http.IpService;

import retrofit2.Call;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-11-13 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class IpServiceImpl implements IpService {
    @Override
    public Call<IpModel> getIpMsg(String ip) {
        return null;
    }
}
