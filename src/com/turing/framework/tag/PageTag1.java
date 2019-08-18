package com.turing.framework.tag;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.turing.framework.util.BasicPage;


/**
 *@author 赵刚
 *@date 2016-10-31下午3:30:22
 *
 **/
@SuppressWarnings("serial")
public class PageTag1 extends TagSupport {
	/**
	 * 控制器传给页面的分页对象名
	 */
	private String pageName;
	/**
	 * 查询分页数据的请求路径
	 */
	private String uri;

	@Override
	public int doStartTag() throws JspException {
		//获取web资源
		HttpServletRequest request = (HttpServletRequest)super.pageContext.getRequest();
		JspWriter out = super.pageContext.getOut();
		//得到分页对象
		BasicPage page = (BasicPage)request.getAttribute(pageName);
		//获取分页属性
		int pageNo = page.getPageNo();
		int rowCount = page.getRowCount();
		int pageCount = page.getPageCount();
		//获取项目名
		String path = request.getContextPath();
		//判断uri的前面有没有"/"，如果没有则加一个"/"
		if(uri.substring(0, 1).equals("/") == false  ){
			uri = "/"+uri;
		}
		//封装页面标签
		StringBuffer strbuf=new StringBuffer();
		strbuf.append("");

		strbuf.append("<ul class=\"pagination\">");
		strbuf.append("<li><a href=\""+path+uri+"?pageNo=1\">&laquo;</a></li>");
		
		strbuf.append("<li><a href=\""+path+uri+"?pageNo="+(pageNo<=1?1:pageNo-1)+"\">上一页</a></li>");
		strbuf.append("<li><a href=\""+path+uri+"?pageNo="+(pageNo>=pageCount?pageCount:pageNo+1)+"\">下 一页</a></li>");
		 
		strbuf.append("<li><a href=\""+path+uri+"?pageNo="+pageCount+"\">&raquo;</a></li>");
		strbuf.append("<li><a href=\"#\">pages:"+pageNo+"/"+pageCount+" rows:"+rowCount+"</a></li>");
		strbuf.append("</ul>");

		try {
			out.print(strbuf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
