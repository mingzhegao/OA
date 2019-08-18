package com.turing.framework.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.turing.framework.util.BasicPage;

/**
 *@author 赵刚
 *@date 2016-11-1上午10:24:12
 *
 **/
@SuppressWarnings("serial")
public class PageTag2 extends TagSupport{
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

		strbuf.append("<style>");
		strbuf.append(".paginationzg {");
		strbuf.append("  display: inline-block;");
		strbuf.append("  border: 1px solid #CDCDCD;");
		strbuf.append("  border-radius: 3px; }");
		
		strbuf.append(".paginationzg a {");
		strbuf.append("  display: block;");
		strbuf.append("  float: left;");
		strbuf.append("  width: 40px;");
		strbuf.append("  height: 40px;");
		strbuf.append("  outline: none;");
		strbuf.append("  border-right: 1px solid #CDCDCD;");
		strbuf.append("  border-left: 1px solid #CDCDCD;");
		strbuf.append(" color: #555555;");
		strbuf.append("  vertical-align: middle;");
		strbuf.append("  text-align: center;");
		strbuf.append("  text-decoration: none;");
		strbuf.append("  font-weight: bold;");
		strbuf.append("  font-size: 25px;");
		strbuf.append(" font-family: Times, 'Times New Roman', Georgia, Palatino;");
		  /* ATTN: need a better font stack */
		strbuf.append("  background-color: #f3f3f3;");
		strbuf.append(" background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f3f3f3), color-stop(100%, lightgrey));");
		strbuf.append("  background-image: -webkit-linear-gradient(#f3f3f3, lightgrey);");
		strbuf.append(" background-image: linear-gradient(#f3f3f3, lightgrey); }");
		strbuf.append(" .paginationzg a:hover, .paginationzg a:focus, .paginationzg a:active {");
		strbuf.append("   background-color: #cecece;");
		strbuf.append("   background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #e4e4e4), color-stop(100%, #cecece));");
		strbuf.append("   background-image: -webkit-linear-gradient(#e4e4e4, #cecece);");
		strbuf.append("   background-image: linear-gradient(#e4e4e4, #cecece); }");
		strbuf.append(" .paginationzg a.disabled, .paginationzg a.disabled:hover, .paginationzg a.disabled:focus, .paginationzg a.disabled:active {");
		strbuf.append("   background-color: #f3f3f3;");
		strbuf.append("   background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f3f3f3), color-stop(100%, lightgrey));");
		strbuf.append("   background-image: -webkit-linear-gradient(#f3f3f3, lightgrey);");
		strbuf.append("   background-image: linear-gradient(#f3f3f3, lightgrey);");
		strbuf.append("   color: #A8A8A8;");
		strbuf.append("   cursor: default; }");
		
		strbuf.append(".paginationzg a:first-child {");
		strbuf.append("  border: none;");
		strbuf.append("  border-radius: 2px 0 0 2px; }");
		
		strbuf.append(".paginationzg a:last-child {");
		strbuf.append("  border: none;");
		strbuf.append("  border-radius: 0 2px 2px 0; }");
		
		strbuf.append(".paginationzg input {");
		strbuf.append("  float: left;");
		strbuf.append("  margin: 0;");
		strbuf.append("  padding: 0;");
		strbuf.append(" width: 220px;");
		strbuf.append("  height: 40px;");
		strbuf.append("  outline: none;");
		strbuf.append(" border: none;");
		strbuf.append("  vertical-align: middle;");
		strbuf.append(" text-align: center;");
		strbuf.append(" font-size: 25px;");
		strbuf.append("}");
		strbuf.append("</style>");
		strbuf.append("<div class=\"container text-center\">");
		strbuf.append("	<div class=\"paginationzg\">");
		strbuf.append("	    <a href=\""+path+uri+"?pageNo=1\" class=\"first\" >&laquo;</a>");
		strbuf.append("	    <a href=\""+path+uri+"?pageNo="+(pageNo<=1?1:pageNo-1)+"\" class=\"previous\" >&lsaquo;</a>");
		strbuf.append("	    <input id=\"page_zginput\" type=\"text\" value=\"Page "+pageNo+" of "+pageCount+"\" />");
		strbuf.append("	    <a href=\""+path+uri+"?pageNo="+(pageNo>pageCount?pageCount:pageNo+1)+"\" class=\"next\" >&rsaquo;</a>");
		strbuf.append("	    <a href=\""+path+uri+"?pageNo="+pageCount+"\" class=\"last\" >&raquo;</a>");
		strbuf.append("	</div>");
		strbuf.append("</div>");
		strbuf.append("<script type=\"text/javascript\">");
		strbuf.append("$(\"#page_zginput\").bind({");
		strbuf.append("	focus:function(){");
		strbuf.append("		$(this).val(\""+pageNo+"\");");
		strbuf.append("		$(this).select();");
		strbuf.append("	},");
		strbuf.append("	blur:function(){");
		strbuf.append("		$(this).val(\"Page "+pageNo+" of "+pageCount+"\");");
		strbuf.append("	},");
		strbuf.append("	keyup:function(e){");
		strbuf.append("		if(e.keyCode==13){");
		strbuf.append("			var ye = $(this).val();");
		strbuf.append("			console.info(ye);");
		strbuf.append("			if(!/^\\d+$/.test(ye)){");
		strbuf.append("				alert(\"输入正确的页码\");");
		strbuf.append("				return;");
		strbuf.append("			}");
		strbuf.append("			var end = parseInt( \""+pageCount+"\" );");
		strbuf.append("			if(ye < 1 || ye > end ){");
		strbuf.append("				alert(\"页码的范围应该在1到\"+end+\"之间\");");
		strbuf.append("				return;");
		strbuf.append("			}");
		strbuf.append("			location.href=\""+path+uri+"?pageNo=\"+ye+\"&_s=\"+Math.random();");
		strbuf.append("		}");
		strbuf.append("	}");
		strbuf.append("});");
		strbuf.append("</script>");

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
	public static void main(String[] args) {
		String uri = "bookinfo/query.action";
		System.out.println(uri.substring(0, 1).equals("/"));
	}
}
