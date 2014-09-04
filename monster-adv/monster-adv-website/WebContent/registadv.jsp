<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/map.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=806edb60b7778c1e58ea03b83f3bba5a"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	
<div id="frame">
<div id="map" style="border:1px solid #000;"></div>
<script type="text/javascript">
                var oSeoulCityPoint = new nhn.api.map.LatLng(37.4960464,126.9573001);
                var defaultLevel = 11;
        		var digitalSignageArray = new Array();	/*장비 배열*/
        		var oMap = new nhn.api.map.Map(document.getElementById('map'), { 
        						point : oSeoulCityPoint,
        						zoom : defaultLevel,
        						enableWheelZoom : true,
        						enableDragPan : true,
        						enableDblClickZoom : false,
        						mapMode : 0,
        						activateTrafficMap : false,
        						activateBicycleMap : false,
        						minMaxLevel : [ 3, 14 ],
        						size : new nhn.api.map.Size(1000, 600)		});
                var oSlider = new nhn.api.map.ZoomControl();
                oMap.addControl(oSlider);
                oSlider.setPosition({
                        top : 10,
                        left : 10
                });

                /*테마 버ㄴ*/
                var oMapTypeBtn = new nhn.api.map.MapTypeBtn();
                oMap.addControl(oMapTypeBtn);
                oMapTypeBtn.setPosition({
                        bottom : 10,
                        right : 80
                });
                
                var oSize = new nhn.api.map.Size(28, 37);
                var oOffset = new nhn.api.map.Size(14, 37);
                var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset);

                /*정보 와드를 보여줌*/
                var oInfoWnd = new nhn.api.map.InfoWindow();
                oInfoWnd.setVisible(false);
                oMap.addOverlay(oInfoWnd);

                oInfoWnd.setPosition({
                        top : 20,
                        left :20
                });

                
                var oLabel = new nhn.api.map.MarkerLabel(); // - 마커 라벨 선언.
                oMap.addOverlay(oLabel); // - 마커 라벨 지도에 추가. 기본은 라벨이 보이지 않는 상태로 추가됨.

                oInfoWnd.attach('changeVisible', function(oCustomEvent) {
                        if (oCustomEvent.visible) {
                                oLabel.setVisible(false);
                        }
                });
                

                oMap.attach('mouseenter', function(oCustomEvent) {

                        var oTarget = oCustomEvent.target;
                        // 마커위에 마우스 올라간거면
                        if (oTarget instanceof nhn.api.map.Marker) {
                                var oMarker = oTarget;
                                oLabel.setVisible(true, oMarker); // - 특정 마커를 지정하여 해당 마커의 title을 보여준다.
                        }
                });

                oMap.attach('mouseleave', function(oCustomEvent) {

                        var oTarget = oCustomEvent.target;
                        // 마커위에서 마우스 나간거면
                        if (oTarget instanceof nhn.api.map.Marker) {
                                oLabel.setVisible(false);
                        }
                });

                
                oMap.attach('click', function(oCustomEvent) {
                        var oPoint = oCustomEvent.point;
                        var oTarget = oCustomEvent.target;
                        oInfoWnd.setVisible(false);
                        // 마커 클릭하면
                        if (oTarget instanceof nhn.api.map.Marker) {
                                // 겹침 마커 클릭한거면
                                if (oCustomEvent.clickCoveredMarker) {
                                        return;
                                }
                                // - InfoWindow 에 들어갈 내용은 setContent 로 자유롭게 넣을 수 있습니다. 외부 css를 이용할 수 있으며, 
                                // - 외부 css에 선언된 class를 이용하면 해당 class의 스타일을 바로 적용할 수 있습니다.
                                // - 단, DIV 의 position style 은 absolute 가 되면 안되며, 
                                // - absolute 의 경우 autoPosition 이 동작하지 않습니다. 
                                oInfoWnd.setContent('<DIV style="border-top:1px solid; border-bottom:2px groove black; border-left:1px solid; border-right:2px groove black;margin-bottom:1px;color:black;background-color:white; width:auto; height:auto;">'+
                                        '<span style="color: #000000 !important;display: inline-block;font-size: 12px !important;font-weight: bold !important;letter-spacing: -1px !important;white-space: nowrap !important; padding: 2px 5px 2px 2px !important">' + 
                                        oTarget.getTitle()+
                                        '에 광고 등록 <br /> ' + 
                                        '<form id="regist" action="newADV" method="post">'+
								'<input type="hidden" id = "signageid" name="signageid" value="'+oTarget.id+'" />'+
								'<input type="hidden" id = "signageName" name="signageName" value="'+oTarget.getTitle()+'" />'+
								'<input type="submit" value="등록"'+
								'<span></div>');
                                oInfoWnd.setPoint(oTarget.getPoint());
                                oInfoWnd.setPosition({right : 15, top : 30});
                                oInfoWnd.setVisible(true);
                                oInfoWnd.autoPosition();
                                return;
                        }
                        var oMarker = new nhn.api.map.Marker(oIcon, { title : '마커 : ' + oPoint.toString() });
                        oMarker.setPoint(oPoint);
                        oMap.addOverlay(oMarker);

                        var aPoints = oPolyline.getPoints(); // - 현재 폴리라인을 이루는 점을 가져와서 배열에 저장.
                        aPoints.push(oPoint); // - 추가하고자 하는 점을 추가하여 배열로 저장함.
                        oPolyline.setPoints(aPoints); // - 해당 폴리라인에 배열에 저장된 점을 추가함
                });
        		var digitalSignageAddfunc = function(map,ary){
        			var bound = map.getBound();
        			var x1 = bound[0].x;
        			var y1 = bound[0].y;
        			var x2 = bound[1].x;
        			var y2 = bound[1].y;
        			jQuery.ajax({
        			type:"POST",
        			/*사이트가 바뀜에 따라 주소를 변경해야 됨*/
        			url:"http://localhost:8080/monster-adv-website/mapping",
        			/*좌표에 해당하는 값을 전달함 이름 : value */
        			data:{x1:x1,y1:y1,x2:x2,y2:y2},
        			/*json 타입으로 리턴 받음*/
        			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        			dataType:"json",
        			success:function(data,testStatus,jqXHR){
        				var result = data.signageList;
        				var flag=0;
        				for(var i=0;i<data.signageList.length;i++){
        					flag=0;
        					for(var j=0;j<ary.length;j++){
        						if(ary[j].coordinate_x==result[i].coordinate_x&&ary[j].coordinate_y==result[i].coordinate_y)
        						{	
        							flag=1;
        							break;
        						}
        					}/*j loop end*/

        					/*flag가 1이면 지금 지도안에 기기를 저장하는 목록에 중복된 좌표가 존재한다는 것이므로 추가하지 아니한다.*/
        					if(flag==1){
        						flag=0;	/*그러면 flag만 0으로 바꾼다.*/
        					}else{
        						ary.push(result[i]);/*이전에 없는 것인 경우 push한다.*/
        						
        						
        						
        						var oMarker = new nhn.api.map.Marker(oIcon, { title :result[i].name});				
        						oMarker.id = result[i].id;//identifier 추가
        						oMarker.setPoint(new nhn.api.map.LatLng(result[i].coordinate_y,result[i].coordinate_x));													
        						oMap.addOverlay(oMarker);
        					}/*else end*/
        				}/*i for문 end*/

        			},
        		 	error: function(xhr,status,error){
        				alert(xhr);
        			}
        			});
        		};
        		oMap.attach('dragend', function(oCustomEvent) {
        			digitalSignageAddfunc(oMap,digitalSignageArray);
        			});

                
        </script>
		</div>

</body>
</html>