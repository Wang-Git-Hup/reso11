
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加对标信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
     function commit() {
		  $.ajax({
			  type:"post",
			  url:"${pageContext.request.contextPath}/db/save",
			  data:$("#dataform").serialize(),
			  success:function (msg) {
                if(msg.map.statusCode == 200){
                    window.location.href="${pageContext.request.contextPath}/indexvalue-base.jsp";
				}else{
                    if(confirm("信息保存失败，您是否要离开当前页面?")){
                        window.location.href="${pageContext.request.contextPath}/indexvalue-base.jsp";
					}
				}
              }
		  });
     }
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
    当前位置:对标管理>>添加对标基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<div>



	<form action="javascript:;" id="dataform">

		<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;<font color="red">对标企业信息如下</font>&nbsp;</td>
			</tr>
			<tr >

				<td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="text" name="dacname" id="cname1"/>
				</td>

				<td align="right" bgcolor="#FAFAF1" height="22" >营业额：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="text" id="daturnover" name="targetmoney"/>
				</td>
			</tr>
			<tr >
				<td align="right" bgcolor="#FAFAF1" height="22">年份：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="date"  id="year1" name="datime"/>
				</td>
				<td align="right" bgcolor="#FAFAF1" height="22">主要业务：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					  <textarea rows="3" cols="18" id="maindo1" name="dabusiness"></textarea>
				</td>
			</tr>
			<tr >
				<td align="right" bgcolor="#FAFAF1" height="22" >优势：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<textarea rows="3" cols="18" id="good1" name="dasuperiority"></textarea>
				</td>
				<td align="right" bgcolor="#FAFAF1" height="22">劣势：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<textarea rows="3" cols="18" id="nogood1" name="dainforiority"></textarea>
				</td>
			</tr>
			<tr >
				<td align="right" bgcolor="#FAFAF1" height="22">行业地位：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="text" name="dasort" id="po1"/>
				</td>
				<td align="right" bgcolor="#FAFAF1" height="22">员工数量：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="text" name="empcount" id="count1"/>
				</td>
			</tr>
			<tr >
				<td align="right" bgcolor="#FAFAF1" height="22">创建时间：</td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="text" name="buildtime" id="build1"/>
				</td>
				<td align="right" bgcolor="#FAFAF1" height="22"></td>
				<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

				</td>
			</tr>

			<tr >
				<td align="right" bgcolor="#FAFAF1" >简单描述：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
					<textarea type="text" rows=15 cols=130 id="remark1" name="remark"></textarea>
				</td>
			</tr>
           <tr style="text-align: center">
			   <td colspan="4">
				    <button onclick="commit()">提交</button>
			   </td>
		   </tr>

		</table>
	</form>

</div>




<!-- 添加指标 -->




  

</body>
</html>