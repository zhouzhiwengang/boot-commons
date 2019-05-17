package com.zzg.common.core.tree;

import java.util.ArrayList;
import java.util.List;

import com.zzg.common.core.model.BaseEntity;

public class TreeBuilder {
	// 树节点
		List<TreeBuilder.Node> nodes = new ArrayList<TreeBuilder.Node>();
		

		public TreeBuilder(List<TreeBuilder.Node> nodes) {
			super();
			this.nodes = nodes;
		}
		
		// 树形构建方法
		public List<Node> buildTree(){
			// 构造树型结构
			List<Node> tree = new ArrayList<Node>();
			List<Node> rootNodes = getRootNodes();
			for(Node root : rootNodes){
				// 查询子节点
				buildChildNodes(root);
				tree.add(root);
			}
			return tree;
		}
		/**
		 * 
		 * @Title: buildChildNodes   
		 * @Description: 查询指定Node 的子类   
		 * @param: @param node      
		 * @return: void      
		 * @throws
		 */
		public void buildChildNodes(Node node){
			List<Node> childern = getChildNodes(node);
			if(!childern.isEmpty()){
				for(Node child : childern){
					buildChildNodes(child); // 循环嵌套调用
				}
				// 设置子类
				node.setChild(childern);
			}
		}
		
		/**
		 * 
		 * @Title: getChildNodes   
		 * @Description: 获取父类的子节点
		 * @param: @param node
		 * @param: @return      
		 * @return: List<Node>      
		 * @throws
		 */
		public List<Node> getChildNodes(Node parentNode){
			List<Node> childNodes = new ArrayList<Node>();
			for(Node n : nodes){
				if(parentNode.getSid().equals(n.getParentId())){
					childNodes.add(n);
				}
			}
			return childNodes;
		}
		
		/**
		 * 
		 * @Title: isRoot   
		 * @Description: 判断Node 是否为根节点   
		 * @param: @param node
		 * @param: @return      
		 * @return: boolean      
		 * @throws
		 */
		public boolean isRoot(Node node){
			boolean flag = true;
			for(Node n : nodes){
				if(node.getParentId().equals(n.getSid())){
					flag = false;
					break; //终止for 循环，此node 不是根节点
				}
			}
			return flag;
		}
		
		/**
		 * 
		 * @Title: getRootNodes   
		 * @Description: 获取指定集合所有根节点   
		 * @param: @return      
		 * @return: List<Node>      
		 * @throws
		 */
		public List<Node> getRootNodes(){
			List<Node> roots = new ArrayList<Node>();
			for(Node node : nodes){
				if(isRoot(node)){
					roots.add(node);
				}
			}
			return roots;
		}

		/**
		 * 
		 * @ClassName: Node
		 * @Description: 树节点数据
		 * @author: 世纪伟图 -zzg
		 * @date: 2019年3月15日 上午10:18:27
		 * 
		 * @Copyright: 2019 www.digipower.cn
		 *             注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
		 */
		public static class Node {
			private String sid;
			private String parentId;
			private String path;
			private Integer depth;
			private List<Node> child;
			
			// 抽象对象的定义
			private BaseEntity form;
			private Object to;
			
			
			// 构造函数
			public Node() {
				super();
			}

			public Node(String sid, String parentId, String path, Integer depth) {
				super();
				this.sid = sid;
				this.parentId = parentId;
				this.path = path;
				this.depth = depth;
			}

			// set 和 get
			public String getSid() {
				return sid;
			}

			public void setSid(String sid) {
				this.sid = sid;
			}

			public String getParentId() {
				return parentId;
			}

			public void setParentId(String parentId) {
				this.parentId = parentId;
			}

			public String getPath() {
				return path;
			}

			public void setPath(String path) {
				this.path = path;
			}

			public Integer getDepth() {
				return depth;
			}

			public void setDepth(Integer depth) {
				this.depth = depth;
			}

			public List<Node> getChild() {
				return child;
			}

			public void setChild(List<Node> child) {
				this.child = child;
			}

			public BaseEntity getForm() {
				return form;
			}

			public void setForm(BaseEntity form) {
				this.form = form;
			}

			public Object getTo() {
				return to;
			}

			public void setTo(Object to) {
				this.to = to;
			}
			
			

			
			

		}

}
