package com.hotel.dao;

import com.hotel.pojo.Userkf;

public interface RecordUser {
	//���û���¼���������Ϣ  ��:t_RecordUser
        Userkf  AddRecordUser(Userkf user);
        //֧����Ǯ
        int  pay(String name) ;
        
        //�����������ݿ�
        void updata(String name,int b);
}
