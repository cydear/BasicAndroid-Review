package com.basic.android.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-11-13 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public interface IpService {
    @GET("getIpInfo.php")
    Call<IpModel> getIpMsg(@Query("ip") String ip);
}
