package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * Created by lxy on 2019/7/31.
 */
public class ResultVOUtil {

    public static ResultVO succes(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO succes(){
        return succes(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
