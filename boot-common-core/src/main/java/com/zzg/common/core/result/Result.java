package com.zzg.common.core.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.zzg.common.core.model.BaseEntity;


public class Result implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;
	
	//成功返回
		public static String RESULT_CODE_SUCCESS = "0";
		//异常返回
		public static String RESULT_CODE_ERROR = "500";
		//未登陆,通过url访问
		public static String RESULT_CODE_NOT_REGISTRY_SESSION= "-1";
		//无权限
		public static String RESULT_CODE_NOT_AUTHORIZED = "-2";
		//用户更新错误代码
		public static String RESULT_CODE_UPDATE_USER_ERROR ="-3";
		//查询参数为空
		public static String RESULT_CODE_QUERY_PARAM_EMPTY ="-4";
		
		//返回码
		protected String code;
		//返回提示信息
		protected String message;
		//返回数据
		protected Map<String, Object> data = new HashMap<String, Object>();
		
		public Result() {
			this.code = RESULT_CODE_SUCCESS;
			this.message = "success";
		}
		
		public static Result ok() {
			return new Result();
		}
		
		public static Result ok(String msg) {
			return ok(RESULT_CODE_SUCCESS, msg);
		}
		
		public static Result ok(String code, String msg) {
			Result r = new Result();
			r.code = code;
			r.message = msg;
			return r;
		}
		
		
		public static Result error(String msg) {
			return error(RESULT_CODE_ERROR, msg);
		}
		
		public static Result error(String code, String msg) {
			Result r = new Result();
			r.code = code;
			r.message = msg;
			return r;
		}
		/**
		 * 
		 * @Title: setData   
		 * @Description: 添加返回数据到默认 data 节点
		 * @param: @param obj
		 * @param: @return      
		 * @return: Result      
		 * @throws
		 */
		public Result setData(BaseEntity obj){
			data.put("data", obj);
			return this;
		}
		
		public Result setData(Map rs){
			data.putAll(rs);
			return this;
		}
		
		public Result setData(String name, Object value){
			data.put(name, value);
			return this;
		}
		
		public Result setSid(Long sid) {
			setData("sid", sid);
			return this;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Object getData() {
			return data;
		}


}
