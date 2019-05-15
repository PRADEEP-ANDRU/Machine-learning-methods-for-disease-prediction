<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHRONIC KIDNEY DISEASE PREDICTION</title>
</head>
<body background="ckdpic.jpg">
<h3 align="center">CHRONIC KIDNEY DISEASE PREDICTION</h3>
<fieldset  style="width:80%;">
<form action="Ckdprdct" method="post">

<div style="float:left; margin-right:20px;">
SPECIFIC GRAVITY :&emsp;&emsp;&ensp;<input type="text" name="sg"><br><br>
PUS CELL  :  &ensp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <select name="pc">
<option>Normal</option>
<option>Abnormal</option>
</select><br><br>
PACKED CELL VOLUME  :  <input type="text" name="pcv"><br><br>
HYPERTENSION : &emsp;&emsp;&emsp;&ensp; <select name="ht">
<option>Yes</option>
<option>No</option>
</select><br><br>
APETITE : &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<select name="ap">
<option>Good</option>
<option>Poor</option>
</select><br><br><br>
<input type="submit" value="PREDICT">
</div>

<div style=" float:center; margin-left:30px; margin-top:20px;"> 
ALBINUM :&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;<input type="text" name="ab"><br><br>
HEMOGLOBIN:&emsp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; <input type="text" name="hg"><br><br>
RED BLOOD CELL :&emsp;&ensp;&ensp; <input type="text" name="rbc"><br><br>
DIABETES MELLITUS :&ensp; <select name="dm">
<option>Yes</option>
<option>No</option>
</select><br><br>
PEDAL EDEMA :&emsp;&emsp;&emsp;&ensp; <select name="pe">
<option>Yes</option>
<option>No</option>
</select><br><br>
</div>
</form>
</fieldset>
<div>
<h3 style="color: red;">RESULTS</h3>
<h4 style="color: darkslategrey"> <% if(request.getAttribute("res")=="CKD") out.println("Patient is PRONE to Chronic Kidney Disease"); 
	else if(request.getAttribute("res")=="NCKD") out.println("Patient is NOT prone to Chronic Kidney Disease");
	else out.println("NO RESULT");
%> 
</h4>
<fieldset>
SPECIFIC GRAVITY : &emsp;&emsp; <span style="color: darkblue;">
<% if(request.getAttribute("sg")=="0") out.println("LOW");
   else if(request.getAttribute("sg")=="1") out.println("NORMAL");
   else if(request.getAttribute("sg")=="2") out.println("HIGH");
   else out.println("-");
%>
</span></br></br>
ALBINUM : &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp; <span style="color: darkblue;">
<% if(request.getAttribute("al")=="0") out.println("LOW");
   else if(request.getAttribute("al")=="1") out.println("NORMAL");
   else if(request.getAttribute("al")=="2") out.println("HIGH");
   else out.println(" -");
%>
</span></br></br>
HEMOGLOBIN : &emsp;&emsp;&emsp;&emsp;&ensp; <span style="color: darkblue;">
<% if(request.getAttribute("hg")=="0") out.println("LOW");
   else if(request.getAttribute("hg")=="1") out.println("NORMAL");
   else if(request.getAttribute("hg")=="2") out.println("HIGH");
   else out.println("-");
%>
</span></br></br>
PACKED CELL VOLUME:&ensp;<span style="color: darkblue;">
<% if(request.getAttribute("pcv")=="0") out.println("LOW");
   else if(request.getAttribute("pcv")=="1") out.println("NORMAL");
   else if(request.getAttribute("pcv")=="2") out.println("HIGH");
   else out.println("-");
%>
</span></br></br>
RED BLOOD CELL :&emsp;&emsp;&ensp;&ensp;<span style="color: darkblue;">
<% if(request.getAttribute("rbc")=="0") out.println("LOW");
   else if(request.getAttribute("rbc")=="1") out.println("NORMAL");
   else if(request.getAttribute("rbc")=="2") out.println("HIGH");
   else out.println("-");
%>
</span></br></br>

</fieldset>
</div>
</body>
</html>