/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-08-20 04:58:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registadv_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/map.css\" />\r\n");
      out.write("    <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=806edb60b7778c1e58ea03b83f3bba5a\"></script>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<div id=\"frame\">\r\n");
      out.write("<div id=\"map\" style=\"border:1px solid #000;\"></div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("                var oSeoulCityPoint = new nhn.api.map.LatLng(37.4960464,126.9573001);\r\n");
      out.write("                var defaultLevel = 11;\r\n");
      out.write("        \t\tvar digitalSignageArray = new Array();\t/*장비 배열*/\r\n");
      out.write("        \t\tvar oMap = new nhn.api.map.Map(document.getElementById('map'), { \r\n");
      out.write("        \t\t\t\t\t\tpoint : oSeoulCityPoint,\r\n");
      out.write("        \t\t\t\t\t\tzoom : defaultLevel,\r\n");
      out.write("        \t\t\t\t\t\tenableWheelZoom : true,\r\n");
      out.write("        \t\t\t\t\t\tenableDragPan : true,\r\n");
      out.write("        \t\t\t\t\t\tenableDblClickZoom : false,\r\n");
      out.write("        \t\t\t\t\t\tmapMode : 0,\r\n");
      out.write("        \t\t\t\t\t\tactivateTrafficMap : false,\r\n");
      out.write("        \t\t\t\t\t\tactivateBicycleMap : false,\r\n");
      out.write("        \t\t\t\t\t\tminMaxLevel : [ 3, 14 ],\r\n");
      out.write("        \t\t\t\t\t\tsize : new nhn.api.map.Size(1000, 600)\t\t});\r\n");
      out.write("                var oSlider = new nhn.api.map.ZoomControl();\r\n");
      out.write("                oMap.addControl(oSlider);\r\n");
      out.write("                oSlider.setPosition({\r\n");
      out.write("                        top : 10,\r\n");
      out.write("                        left : 10\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                /*테마 버ㄴ*/\r\n");
      out.write("                var oMapTypeBtn = new nhn.api.map.MapTypeBtn();\r\n");
      out.write("                oMap.addControl(oMapTypeBtn);\r\n");
      out.write("                oMapTypeBtn.setPosition({\r\n");
      out.write("                        bottom : 10,\r\n");
      out.write("                        right : 80\r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("                var oSize = new nhn.api.map.Size(28, 37);\r\n");
      out.write("                var oOffset = new nhn.api.map.Size(14, 37);\r\n");
      out.write("                var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset);\r\n");
      out.write("\r\n");
      out.write("                /*정보 와드를 보여줌*/\r\n");
      out.write("                var oInfoWnd = new nhn.api.map.InfoWindow();\r\n");
      out.write("                oInfoWnd.setVisible(false);\r\n");
      out.write("                oMap.addOverlay(oInfoWnd);\r\n");
      out.write("\r\n");
      out.write("                oInfoWnd.setPosition({\r\n");
      out.write("                        top : 20,\r\n");
      out.write("                        left :20\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                var oLabel = new nhn.api.map.MarkerLabel(); // - 마커 라벨 선언.\r\n");
      out.write("                oMap.addOverlay(oLabel); // - 마커 라벨 지도에 추가. 기본은 라벨이 보이지 않는 상태로 추가됨.\r\n");
      out.write("\r\n");
      out.write("                oInfoWnd.attach('changeVisible', function(oCustomEvent) {\r\n");
      out.write("                        if (oCustomEvent.visible) {\r\n");
      out.write("                                oLabel.setVisible(false);\r\n");
      out.write("                        }\r\n");
      out.write("                });\r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("                oMap.attach('mouseenter', function(oCustomEvent) {\r\n");
      out.write("\r\n");
      out.write("                        var oTarget = oCustomEvent.target;\r\n");
      out.write("                        // 마커위에 마우스 올라간거면\r\n");
      out.write("                        if (oTarget instanceof nhn.api.map.Marker) {\r\n");
      out.write("                                var oMarker = oTarget;\r\n");
      out.write("                                oLabel.setVisible(true, oMarker); // - 특정 마커를 지정하여 해당 마커의 title을 보여준다.\r\n");
      out.write("                        }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                oMap.attach('mouseleave', function(oCustomEvent) {\r\n");
      out.write("\r\n");
      out.write("                        var oTarget = oCustomEvent.target;\r\n");
      out.write("                        // 마커위에서 마우스 나간거면\r\n");
      out.write("                        if (oTarget instanceof nhn.api.map.Marker) {\r\n");
      out.write("                                oLabel.setVisible(false);\r\n");
      out.write("                        }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                oMap.attach('click', function(oCustomEvent) {\r\n");
      out.write("                        var oPoint = oCustomEvent.point;\r\n");
      out.write("                        var oTarget = oCustomEvent.target;\r\n");
      out.write("                        oInfoWnd.setVisible(false);\r\n");
      out.write("                        // 마커 클릭하면\r\n");
      out.write("                        if (oTarget instanceof nhn.api.map.Marker) {\r\n");
      out.write("                                // 겹침 마커 클릭한거면\r\n");
      out.write("                                if (oCustomEvent.clickCoveredMarker) {\r\n");
      out.write("                                        return;\r\n");
      out.write("                                }\r\n");
      out.write("                                // - InfoWindow 에 들어갈 내용은 setContent 로 자유롭게 넣을 수 있습니다. 외부 css를 이용할 수 있으며, \r\n");
      out.write("                                // - 외부 css에 선언된 class를 이용하면 해당 class의 스타일을 바로 적용할 수 있습니다.\r\n");
      out.write("                                // - 단, DIV 의 position style 은 absolute 가 되면 안되며, \r\n");
      out.write("                                // - absolute 의 경우 autoPosition 이 동작하지 않습니다. \r\n");
      out.write("                                oInfoWnd.setContent('<DIV style=\"border-top:1px solid; border-bottom:2px groove black; border-left:1px solid; border-right:2px groove black;margin-bottom:1px;color:black;background-color:white; width:auto; height:auto;\">'+\r\n");
      out.write("                                        '<span style=\"color: #000000 !important;display: inline-block;font-size: 12px !important;font-weight: bold !important;letter-spacing: -1px !important;white-space: nowrap !important; padding: 2px 5px 2px 2px !important\">' + \r\n");
      out.write("                                        oTarget.getTitle()+\r\n");
      out.write("                                        '에 광고 등록 <br /> ' + \r\n");
      out.write("                                        '<form id=\"regist\" action=\"newADV\" method=\"post\">'+\r\n");
      out.write("\t\t\t\t\t\t\t\t'<input type=\"hidden\" id = \"signageid\" name=\"signageid\" value=\"'+oTarget.id+'\" />'+\r\n");
      out.write("\t\t\t\t\t\t\t\t'<input type=\"hidden\" id = \"signageName\" name=\"signageName\" value=\"'+oTarget.getTitle()+'\" />'+\r\n");
      out.write("\t\t\t\t\t\t\t\t'<input type=\"submit\" value=\"등록\"'+\r\n");
      out.write("\t\t\t\t\t\t\t\t'<span></div>');\r\n");
      out.write("                                oInfoWnd.setPoint(oTarget.getPoint());\r\n");
      out.write("                                oInfoWnd.setPosition({right : 15, top : 30});\r\n");
      out.write("                                oInfoWnd.setVisible(true);\r\n");
      out.write("                                oInfoWnd.autoPosition();\r\n");
      out.write("                                return;\r\n");
      out.write("                        }\r\n");
      out.write("                        var oMarker = new nhn.api.map.Marker(oIcon, { title : '마커 : ' + oPoint.toString() });\r\n");
      out.write("                        oMarker.setPoint(oPoint);\r\n");
      out.write("                        oMap.addOverlay(oMarker);\r\n");
      out.write("\r\n");
      out.write("                        var aPoints = oPolyline.getPoints(); // - 현재 폴리라인을 이루는 점을 가져와서 배열에 저장.\r\n");
      out.write("                        aPoints.push(oPoint); // - 추가하고자 하는 점을 추가하여 배열로 저장함.\r\n");
      out.write("                        oPolyline.setPoints(aPoints); // - 해당 폴리라인에 배열에 저장된 점을 추가함\r\n");
      out.write("                });\r\n");
      out.write("        \t\tvar digitalSignageAddfunc = function(map,ary){\r\n");
      out.write("        \t\t\tvar bound = map.getBound();\r\n");
      out.write("        \t\t\tvar x1 = bound[0].x;\r\n");
      out.write("        \t\t\tvar y1 = bound[0].y;\r\n");
      out.write("        \t\t\tvar x2 = bound[1].x;\r\n");
      out.write("        \t\t\tvar y2 = bound[1].y;\r\n");
      out.write("        \t\t\tjQuery.ajax({\r\n");
      out.write("        \t\t\ttype:\"POST\",\r\n");
      out.write("        \t\t\t/*사이트가 바뀜에 따라 주소를 변경해야 됨*/\r\n");
      out.write("        \t\t\turl:\"http://localhost:8080/monster-adv-website/mapping\",\r\n");
      out.write("        \t\t\t/*좌표에 해당하는 값을 전달함 이름 : value */\r\n");
      out.write("        \t\t\tdata:{x1:x1,y1:y1,x2:x2,y2:y2},\r\n");
      out.write("        \t\t\t/*json 타입으로 리턴 받음*/\r\n");
      out.write("        \t\t\tcontentType: \"application/x-www-form-urlencoded; charset=UTF-8\", \r\n");
      out.write("        \t\t\tdataType:\"json\",\r\n");
      out.write("        \t\t\tsuccess:function(data,testStatus,jqXHR){\r\n");
      out.write("        \t\t\t\tvar result = data.signageList;\r\n");
      out.write("        \t\t\t\tvar flag=0;\r\n");
      out.write("        \t\t\t\tfor(var i=0;i<data.signageList.length;i++){\r\n");
      out.write("        \t\t\t\t\tflag=0;\r\n");
      out.write("        \t\t\t\t\tfor(var j=0;j<ary.length;j++){\r\n");
      out.write("        \t\t\t\t\t\tif(ary[j].coordinate_x==result[i].coordinate_x&&ary[j].coordinate_y==result[i].coordinate_y)\r\n");
      out.write("        \t\t\t\t\t\t{\t\r\n");
      out.write("        \t\t\t\t\t\t\tflag=1;\r\n");
      out.write("        \t\t\t\t\t\t\tbreak;\r\n");
      out.write("        \t\t\t\t\t\t}\r\n");
      out.write("        \t\t\t\t\t}/*j loop end*/\r\n");
      out.write("\r\n");
      out.write("        \t\t\t\t\t/*flag가 1이면 지금 지도안에 기기를 저장하는 목록에 중복된 좌표가 존재한다는 것이므로 추가하지 아니한다.*/\r\n");
      out.write("        \t\t\t\t\tif(flag==1){\r\n");
      out.write("        \t\t\t\t\t\tflag=0;\t/*그러면 flag만 0으로 바꾼다.*/\r\n");
      out.write("        \t\t\t\t\t}else{\r\n");
      out.write("        \t\t\t\t\t\tary.push(result[i]);/*이전에 없는 것인 경우 push한다.*/\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\tvar oMarker = new nhn.api.map.Marker(oIcon, { title :result[i].name});\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\toMarker.id = result[i].id;//identifier 추가\r\n");
      out.write("        \t\t\t\t\t\toMarker.setPoint(new nhn.api.map.LatLng(result[i].coordinate_y,result[i].coordinate_x));\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("        \t\t\t\t\t\toMap.addOverlay(oMarker);\r\n");
      out.write("        \t\t\t\t\t}/*else end*/\r\n");
      out.write("        \t\t\t\t}/*i for문 end*/\r\n");
      out.write("\r\n");
      out.write("        \t\t\t},\r\n");
      out.write("        \t\t \terror: function(xhr,status,error){\r\n");
      out.write("        \t\t\t\talert(xhr);\r\n");
      out.write("        \t\t\t}\r\n");
      out.write("        \t\t\t});\r\n");
      out.write("        \t\t};\r\n");
      out.write("        \t\toMap.attach('dragend', function(oCustomEvent) {\r\n");
      out.write("        \t\t\tdigitalSignageAddfunc(oMap,digitalSignageArray);\r\n");
      out.write("        \t\t\t});\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("        </script>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
