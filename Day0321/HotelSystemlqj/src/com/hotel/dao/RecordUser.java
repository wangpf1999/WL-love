package com.hotel.dao;

import com.hotel.pojo.Userkf;

public interface RecordUser {
	//像用户记录表中添加信息  表:t_RecordUser
        Userkf  AddRecordUser(Userkf user);
        //支付价钱
        int  pay(String name) ;
        
        //付款后更改数据库
        void updata(String name,int b);
}
