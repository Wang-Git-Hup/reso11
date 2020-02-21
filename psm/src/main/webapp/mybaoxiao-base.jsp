<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>附件管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
	<script>
		$(function () {
				$.ajax({
                    type:'GET',
                    url:'${pageContext.request.contextPath}/bao/getMyBao',
					success:function (rs) {
                        $(rs).each(function(index,item){
                            var status= item.bxstatus;
                            //0 未审批  1  驳回  2  审批已付款
                            var  info = "";
                            var  mydo= "<a href=''>查看详情</a>"
                            if(status==0){
                                info="未审批";
                                mydo+="| <a href='${pageContext.request.contextPath}/mybaoxiao-edit.jsp?bxid="+item.bxid+"'>编辑</a>";
                            }
                            if(status==1){
                                info="已驳回";
                                mydo+="| <a href='${pageContext.request.contextPath}/mybaoxiao-edit.jsp?bxid="+item.bxid+"'>编辑</a> ";
                            }
                            if(status==2){
                                info="审批完成";
                                mydo+="| <a href='${pageContext.request.contextPath}/mybaoxiao-edit.jsp?bxid=${bs.bxid}'>打印</a> ";
                            }
                            // 将毫秒值转换成日期
                            var newDate = new Date(item.bxtime);
                            var time = newDate.getFullYear()+"-"+(newDate.getMonth()+1)+"-"+newDate.getDate();
                            var tr ="<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                                "\t<td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"101\" class=\"np\"></td>\n" +
                                "\t<td>"+item.bxid+"</td>\n" +
                                "\t<td>"+item.totalmoney+"</td>\n" +
                                "\t<td align=\"center\">"+time+"</td>\n" +
                                "\t<td>"+item.bxremark+"</td>\n" +
                                "\t<td>"+info+"</td>\n" +
                                "\t<td>"+mydo+"</td>\n" +
                                "</tr>";
                            //添加到指定行后面
                            $("#ttr").before(tr);
                        });
                    }
				})
        })

	</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:个人报销管理>>报销列表
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='mybaoxiao-add.jsp';" value='添加报销' />
 </td>
 </tr>
</table>
</td>
</tr>
	<form id="form4" name='form4' action='${pageContext.request.contextPath}/bx/list' method='get'>
		<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
			<tr bgcolor='#EEF4EA'>
				<td background='skin/images/wbg.gif' align='center'>
					<table border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td width='90' align='center'>搜索条件：</td>
							<td width='160'>
								<select name='search_cid' style='width:150px'>
									<option value='0'>选择类型...</option>
									<option value='1'>未审批</option>
									<option value='2'>审批通过</option>
									<option value='3'>驳回</option>
									<option value='4'>审批并付款</option>
								</select>
							</td>
							<td width='70'>
								关键字：
							</td>
							<td width='160'>
								<input type='text' name='search_keyword' style='width:120px' />
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;<input name="imageField" onclick="submitForm4()" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</table>


<!--  内容列表   -->
<form name="form2">

<table width="98%"  cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;附件列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="20%">编号</td>
	<td width="6%">总金额</td>
	<td width="10%">使用时间</td>
	<td width="40%">备注信息</td>
	<td width="10%">审批状态</td>
	<td width="10%">操作</td>
</tr>

<tr align="right" bgcolor="#EEF4EA" id="ttr">
	<td height="36" colspan="12" align="center">
		<a href="${pageContext.request.contextPath}/bx/list?pageNum=1">首页</a>
		<a href="${pageContext.request.contextPath}/bx/list?pageNum=${pageInfo.prePage}">上一页</a>
		<c:forEach items="${pageInfo.navigatepageNums}" var="pagenum">
			<c:if test="${pageInfo.pageNum == pagenum}">
				[<a style="color: #6c9e47" href="#">${pagenum}</a>]
			</c:if>
			<c:if test="${pageInfo.pageNum != pagenum}">
				<a href="${pageContext.request.contextPath}/bx/list?pageNum=${pagenum}">${pagenum}</a>
			</c:if>
		</c:forEach>
		<a href="${pageContext.request.contextPath}/bx/list?pageNum=${pageInfo.pageNum+1}">下一页</a>
		<a href="${pageContext.request.contextPath}/bx/list?pageNum=${pageInfo.navigateLastPage}">末页</a>
	</td>
</tr>
</table>

</form>
  

</body>
</html>