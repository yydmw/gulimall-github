package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author lzh
 * @email yydmw@yx.com
 * @date 2020-10-20 20:02:34
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
