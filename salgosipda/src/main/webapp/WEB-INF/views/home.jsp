
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>


<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>사용자 맞춤형 부동산 추천</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">

    <script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
    <script type="text/javascript"
        src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=8oodi2do5k&submodules=geocoder"></script>

    <style>
    </style>
</head>


<body>

    <header>

        <div class="header">
            <div id="home"><a href="http://localhost:8080/salgosipda/" class="land">SALGO</a>
                <div class="search" style="">
                    <input id="address" type="text" placeholder="ex)성북구 삼선동" /> <input id="submit" type="button"
                        value="주소 검색" />
                </div>
            </div>



        </div>
    </header>
    <div id="filter" style="overflow: auto; width: 25%; float: left; -ms-overflow-style: none;">


        <br>
        <div class="filter-deal">
            <details open>
                <summary>거래방식</summary>
                <ul class="select_list_wrap">
                    <li class="select_item"><input type="checkbox" name="deal" id="deal1" class="checkbox_input"
                            value="전체" checked="checked"><label for="deal1" class="checkbox_label">전체</label></li>
                    <li class="select_item"><input type="checkbox" name="deal" id="deal2" class="checkbox_input"
                            value="전세"><label for="deal2" class="checkbox_label">전세</label></li>
                    <li class="select_item"><input type="checkbox" name="deal" id="deal3" class="checkbox_input"
                            value="월세"><label for="deal3" class="checkbox_label">월세</label></li>
                </ul>
            </details>
        </div>

        <hr width=80%>

        <div class="filter-price">
            <details>
                <summary>매매가/전세가/보증금</summary>
                <br>
                <div class="price_list_wrap">
                    <input type="radio" id="p1" name="price_list" class="hidden range_btn " value="0" /> <label
                        class="button-label" for="p1">
                        <h1>0</h1>
                    </label> <input type="radio" id="p2" name="price_list" class="hidden range_btn " value="300" />
                    <label class="button-label" for="p2">
                        <h1>300</h1>
                    </label>
                    <input type="radio" id="p3" name="price_list" class="hidden range_btn " value="500" /> <label
                        class="button-label" for="p3">
                        <h1>500</h1>
                    </label> <input type="radio" id="p4" name="price_list" class="hidden range_btn " value="1000" />
                    <label class="button-label" for="p4">
                        <h1>1천</h1>
                    </label>
                    <input type="radio" id="p5" name="price_list" class="hidden range_btn " value="2000" /> <label
                        class="button-label" for="p5">
                        <h1>2천</h1>
                    </label> <br> <input type="radio" id="p6" name="price_list" class="hidden range_btn "
                        value="3000" /> <label class="button-label" for="p6">
                        <h1>3천</h1>
                    </label>
                    <input type="radio" id="p7" name="price_list" class="hidden range_btn " value="5000" /> <label
                        class="button-label" for="p7">
                        <h1>5천</h1>
                    </label> <input type="radio" id="p8" name="price_list" class="hidden range_btn " value="7000" />
                    <label class="button-label" for="p8">
                        <h1>7천</h1>
                    </label>
                    <input type="radio" id="p9" name="price_list" class="hidden range_btn " value="8000" /> <label
                        class="button-label" for="p9">
                        <h1>8천</h1>
                    </label> <input type="radio" id="p10" name="price_list" class="hidden range_btn " value="10000" />
                    <label class="button-label" for="p10">
                        <h1>1억~</h1>
                    </label>




                </div>
                <div id="unit">
                    <label>단위:만원</label>
                </div>
            </details>

        </div>


        <hr width=80%>

        <div class="filter-monthly">
            <details>
                <summary>
                    월세
                    </h4>
                </summary>
                <br>
                <div class="price_wrap">
                    <input type="radio" id="w1" name="price_monthly_list" class="hidden range_btn " value="10" /> <label
                        class="button-label2" for="w1">
                        <h1>0</h1>
                    </label> <input type="radio" id="w2" name="price_monthly_list" class="hidden range_btn "
                        value="20" /> <label class="button-label2" for="w2">
                        <h1>20</h1>
                    </label> <input type="radio" id="w3" name="price_monthly_list" class="hidden range_btn "
                        value="30" /> <label class="button-label2" for="w3">
                        <h1>30</h1>
                    </label> <input type="radio" id="w4" name="price_monthly_list" class="hidden range_btn "
                        value="40" /> <label class="button-label2" for="w4">
                        <h1>40</h1>
                    </label> <input type="radio" id="w5" name="price_monthly_list" class="hidden range_btn "
                        value="50" /> <label class="button-label2" for="w5">
                        <h1>50</h1>
                    </label> <input type="radio" id="w6" name="price_monthly_list" class="hidden range_btn "
                        value="60" /> <label class="button-label2" for="w6">
                        <h1>60</h1>
                    </label> <br> <input type="radio" id="w7" name="price_monthly_list" class="hidden range_btn "
                        value="70" /> <label class="button-label2" for="w7">
                        <h1>70</h1>
                    </label> <input type="radio" id="w8" name="price_monthly_list" class="hidden range_btn "
                        value="80" /> <label class="button-label2" for="w8">
                        <h1>80</h1>
                    </label> <input type="radio" id="w9" name="price_monthly_list" class="hidden range_btn "
                        value="90" /> <label class="button-label2" for="w9">
                        <h1>90</h1>
                    </label> <input type="radio" id="w10" name="price_monthly_list" class="hidden range_btn "
                        value="100" /> <label class="button-label2" for="w10">
                        <h1>1백</h1>
                    </label> <input type="radio" id="w11" name="price_monthly_list" class="hidden range_btn "
                        value="200" /> <label class="button-label2" for="w11">
                        <h1>2백</h1>
                    </label> <input type="radio" id="w12" name="price_monthly_list" class="hidden range_btn "
                        value="300" /> <label class="button-label2" for="w12">
                        <h1>3백</h1>
                    </label>



                </div>
                <br>
                <div id="unit">
                    <label>단위:만원</label>
                </div>


            </details>

        </div>

        <hr width=80%>

        <div class="filter_width">
            <div>
                <details>
                    <summary>
                        관리비
                        </h4>
                    </summary>
                    <br>
                    <div class="size_list_wrap">
                        <input type="radio" id="m1" name="manage_price" class="hidden range_btn " value="50000" />
                        <label class="button-label3" for="m1">
                            <h1>5만</h1>
                        </label> <input type="radio" id="m2" name="manage_price" class="hidden range_btn "
                            value="100000" /> <label class="button-label3" for="m2">
                            <h1>10만</h1>
                        </label> <input type="radio" id="m3" name="manage_price" class="hidden range_btn "
                            value="150000" /> <label class="button-label3" for="m3">
                            <h1>15만</h1>
                        </label> <input type="radio" id="m4" name="manage_price" class="hidden range_btn "
                            value="200000" /> <label class="button-label3" for="m4">
                            <h1>20만</h1>
                        </label>



                    </div>

                    <br>

                </details>
            </div>

        </div>

        <hr width=80%>

        <div style="text-align: center;">
            <button type="button" class="mybutton" onclick='getDetailSearch()'>상세
                검색</button>
        </div>
        <br>
        <div style="text-align: center;">
            <button type="button" class="justviewlist" onclick='getDetailSearch()'>매물 목록 바로 보기</button>
        </div>
        <br> <br> <br>


    </div>


    <div id="map" style="width: 75%; height: 95%; float: right">

    </div>

    <div id="filterdetail" style="width: 25%; float: left">
        <div id="backbutton">
            <button type="button" id="searchexit" style="border: 0; background: transparent; cursor: pointer;">
                <img src="./resources/img/back.png">
            </button>
        </div>

        <div id="detailheader">
            <b>상세 필터</b> <img src="./resources/img/refresh.png" onclick="infraForm.reset(); refresh()" class="restore">
        </div>
        <br> <br>
        <p style="color:gray; font-size:10px; text-align:right;">* 가중치 적용 시 총 점수가 100점을 넘을 수 있음 </p>
        <form id="infraForm" method="POST">
            <div class="infra_container">
                <ul class="ks-cboxtags">
                    <li><input type="checkbox" name="infra" value="cvs" id="cvs"><label for="cvs">편의점
                            <button type="button" name="checkButton" id="starbutton1" disabled>
                                <img id="img" src="./resources/img/off1.png" onclick="toggleImg()">
                            </button>
                        </label></li>
                    <li><input type="checkbox" name="infra" value="laundry" id="laundry"><label for="laundry">세탁소
                            <button type="button" name="checkButton" id="starbutton2" disabled>
                                <img id="img2" src="./resources/img/off2.png" onclick="toggleImg2()">
                            </button>
                        </label></li>
                    <li><input type="checkbox" name="infra" value="safetybox" id="safetybox"><label
                            for="safetybox">여성안심택배함
                            <button type="button" name="checkButton" id="starbutton3" disabled>
                                <img id="img3" src="./resources/img/off3.png" onclick="toggleImg3()">
                            </button>
                        </label></li>
                    <li><input type="checkbox" name="infra" value="mart" id="mart"><label for="mart">마트
                            <button type="button" name="checkButton" id="starbutton4" disabled>
                                <img id="img4" src="./resources/img/off4.png" onclick="toggleImg4()">
                            </button>
                        </label></li>
                    <li><input type="checkbox" name="infra" value="subway" id="subway"><label for="subway">지하철
                            <button type="button" name="checkButton" id="starbutton5" disabled>
                                <img id="img5" src="./resources/img/off5.png" onclick="toggleImg5()">
                            </button>
                        </label></li>
                    <li><input type="checkbox" name="infra" value="bank" id="bank"><label for="bank">은행
                            <button type="button" name="checkButton" id="starbutton6" disabled>
                                <img id="img6" src="./resources/img/off6.png" onclick="toggleImg6()">
                            </button>
                        </label></li>

                    <li><input type="checkbox" name="infra" value="pharmacy" id="pharmacy"><label for="pharmacy">약국
                            <button type="button" name="checkButton" id="starbutton7" disabled>
                                <img id="img7" src="./resources/img/off7.png" onclick="toggleImg7()">
                            </button>
                        </label></li>

                    <li><input type="checkbox" name="infra" value="hospital" id="hospital"><label for="hospital">병원
                            <button type="button" name="checkButton" id="starbutton8" disabled>
                                <img id="img8" src="./resources/img/off8.png" onclick="toggleImg8()">
                            </button>
                        </label></li>


                    <li><input type="checkbox" name="infra" value="gym" id="gym"><label for="gym">헬스장
                            <button type="button" name="checkButton" id="starbutton9" disabled>
                                <img id="img9" src="./resources/img/off9.png" onclick="toggleImg9()">
                            </button>
                        </label></li>

                    <li><input type="checkbox" name="infra" value="crime" id="crime"><label for="crime">범죄율
                            <button type="button" name="checkButton" id="starbutton10" disabled>
                                <img id="img10" src="./resources/img/off10.png" onclick="toggleImg10()">
                            </button>
                        </label></li>


                </ul>

            </div>


            <p>
                <input type="button" class="findbutton" value="맞춤 매물 찾기">

                <br>

            </p>
        </form>

    </div>

    <div id="detailview" style="width: 25%; float: left"></div>
    <div id="estatelist" style="width: 25%; float: left">
        <div id="estatelistheader">
            <div id="backbutton">
                <button type="button" id="listexit" style="border: 0; background: transparent; cursor: pointer;">
                    <img src="./resources/img/back.png">
                </button>
            </div>
            <div id="listheader">
                <b>매물 목록</b>
                &nbsp &nbsp &nbsp
                <button type="button" class="basicbutton" onclick='getDetailSearch()'>기본검색</button>
                <button type="button" class="detailbutton" onclick='getDetailSearch()'>상세검색</button>

            </div>
            <br> <br>
        </div>
        <div id="eachestatelist"></div>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



    <script>
        function refresh() {
            var img = document.getElementById("img");
            img.src = "./resources/img/off1.png";
            var img2 = document.getElementById("img2");
            img2.src = "./resources/img/off2.png";
            var img3 = document.getElementById("img3");
            img3.src = "./resources/img/off3.png";
            var img4 = document.getElementById("img4");
            img4.src = "./resources/img/off4.png";
            var img5 = document.getElementById("img5");
            img5.src = "./resources/img/off5.png";
            var img6 = document.getElementById("img6");
            img6.src = "./resources/img/off6.png";
            var img7 = document.getElementById("img7");
            img7.src = "./resources/img/off7.png";
            var img8 = document.getElementById("img8");
            img8.src = "./resources/img/off8.png";
            var img9 = document.getElementById("img9");
            img9.src = "./resources/img/off9.png";
            var img10 = document.getElementById("img10");
            img10.src = "./resources/img/off10.png";
        }
        $(document)
            .ready(
                function () {

                    $('#detailview').hide();
                    $('#estatelist').hide();

                    //거래방식 체크박스 1가지만 선택할 수 있도록 설정
                    $('input[type="checkbox"][name="deal"]')
                        .click(
                            function () {

                                if ($(this).prop('checked')) {

                                    $(
                                        'input[type="checkbox"][name="deal"]')
                                        .prop('checked',
                                            false);

                                    $(this).prop('checked',
                                        true);

                                }

                            });

                    //매물 객체 배열
                    var estates = new Array();
                    var estateArr = new Array();
                    
                    //인프라 정보 변수
                    var cvsInfo = "";
                    var laundryInfo = "";
                    var martInfo = "";
                    var safetyboxInfo = "";
                    var subwayInfo = "";
                    var bankInfo = "";
                    var pharmacyInfo = "";
                    var hospitalInfo = "";
                    var gymInfo = "";
                    var crimeInfo = "";
                    
                    //인프라 선택시 가중치 변수
                    var cvsPoint = 0;
                    var laundryPoint = 0;
                    var martPoint = 0;
                    var subwayPoint = 0;
                    var safetyboxPoint = 0;
                    var infraCount = 0;
                    var bankPoint = 0;
                    var pharmacyPoint = 0;
                    var hospitalPoint = 0;
                    var gymPoint = 0;
                    var crimePoint = 0;

                    //매물 객체 생성자
                    var Estate = function (id, name, type, price,
                        address, longitude, latitude, area, floor,
                        sch_moving, construction_year, feature,
                        direction, parking, manage_cost,
                        manage_included, security, score,
                        estatename, callnum) {
                        this.id = id;
                        this.name = name;
                        this.type = type;
                        this.price = price;
                        this.address = address;
                        this.longitude = longitude;
                        this.latitude = latitude;
                        this.area = area;
                        this.floor = floor;
                        this.sch_moving = sch_moving;
                        this.construction_year = construction_year;
                        this.feature = feature;
                        this.direction = direction;
                        this.parking = parking;
                        this.manage_cost = manage_cost;
                        this.manage_included = manage_included;
                        this.security = security;
                        this.score = score;
                        this.estatename = estatename;
                        this.callnum = callnum;
                    }


                    //지도 생성
                    var map = new naver.maps.Map('map', {
                        zoom: 17,
                        center: new naver.maps.LatLng(37.5880552,
                            127.005787)
                    });

                    var projection = map.getProjection();

                    //주소 검색 기능
                    map.setCursor('pointer');
                    function searchCoordinateToAddress(latlng) {

                        naver.maps.Service
                            .reverseGeocode(
                                {
                                    coords: latlng,
                                    orders: [
                                        naver.maps.Service.OrderType.ADDR,
                                        naver.maps.Service.OrderType.ROAD_ADDR]
                                        .join(',')
                                },
                                function (status, response) {
                                    if (status === naver.maps.Service.Status.ERROR) {
                                        //return alert('Something Wrong!');
                                    }

                                    var items = response.v2.results, address = '', htmlAddresses = [];

                                    for (var i = 0, ii = items.length, item, addrType; i < ii; i++) {
                                        item = items[i];
                                        address = makeAddress(item)
                                            || '';
                                        addrType = item.name === 'roadaddr' ? '[도로명 주소]'
                                            : '[지번 주소]';

                                        htmlAddresses
                                            .push((i + 1)
                                                + '. '
                                                + addrType
                                                + ' '
                                                + address);
                                    }

                                });
                    }
					
                    function searchAddressToCoordinate(address) {
                        naver.maps.Service
                            .geocode(
                                {
                                    query: address
                                },
                                function (status, response) {
                                    if (status === naver.maps.Service.Status.ERROR) {
                                        //return alert('Something Wrong!');
                                    }

                                    if (response.v2.meta.totalCount === 0) {
                                        return alert('totalCount'
                                            + response.v2.meta.totalCount);
                                    }

                                    var htmlAddresses = [], item = response.v2.addresses[0], point = new naver.maps.Point(
                                        item.x, item.y);

                                    if (item.roadAddress) {
                                        htmlAddresses
                                            .push('[도로명 주소] '
                                                + item.roadAddress);
                                    }

                                    if (item.jibunAddress) {
                                        htmlAddresses
                                            .push('[지번 주소] '
                                                + item.jibunAddress);
                                    }

                                    if (item.englishAddress) {
                                        htmlAddresses
                                            .push('[영문명 주소] '
                                                + item.englishAddress);
                                    }

                                    map.setCenter(point);

                                });
                    }
					
                    function initGeocoder() {
                        if (!map.isStyleMapReady) {
                            return;
                        }

                        map.addListener('click', function (e) {
                            searchCoordinateToAddress(e.coord);
                        });

                        $('#address').on(
                            'keydown',
                            function (e) {
                                var keyCode = e.which;

                                if (keyCode === 13) { // Enter Key
                                    searchAddressToCoordinate($(
                                        '#address').val());
                                    $('#detailview').hide();
                                    $('#filter').show();
                                }
                            });

                        $('#submit').on(
                            'click',
                            function (e) {
                                e.preventDefault();

                                searchAddressToCoordinate($(
                                    '#address').val());

                                $('#detailview').hide();
                                $('#filter').show();

                            });

                        searchAddressToCoordinate('성북구');
                    }

                    function makeAddress(item) {
                        if (!item) {
                            return;
                        }

                        var name = item.name, region = item.region, land = item.land, isRoadAddress = name === 'roadaddr';

                        var sido = '', sigugun = '', dongmyun = '', ri = '', rest = '';

                        if (hasArea(region.area1)) {
                            sido = region.area1.name;
                        }

                        if (hasArea(region.area2)) {
                            sigugun = region.area2.name;
                        }

                        if (hasArea(region.area3)) {
                            dongmyun = region.area3.name;
                        }

                        if (hasArea(region.area4)) {
                            ri = region.area4.name;
                        }

                        if (land) {
                            if (hasData(land.number1)) {
                                if (hasData(land.type)
                                    && land.type === '2') {
                                    rest += '산';
                                }

                                rest += land.number1;

                                if (hasData(land.number2)) {
                                    rest += ('-' + land.number2);
                                }
                            }

                            if (isRoadAddress === true) {
                                if (checkLastString(dongmyun, '면')) {
                                    ri = land.name;
                                } else {
                                    dongmyun = land.name;
                                    ri = '';
                                }

                                if (hasAddition(land.addition0)) {
                                    rest += ' ' + land.addition0.value;
                                }
                            }
                        }

                        return [sido, sigugun, dongmyun, ri, rest]
                            .join(' ');
                    }

                    function hasArea(area) {
                        return !!(area && area.name && area.name !== '');
                    }

                    function hasData(data) {
                        return !!(data && data !== '');
                    }

                    function checkLastString(word, lastString) {
                        return new RegExp(lastString + '$').test(word);
                    }

                    function hasAddition(addition) {
                        return !!(addition && addition.value);
                    }

                    naver.maps.onJSContentLoaded = initGeocoder;
                    naver.maps.Event.once(map, 'init_stylemap',
                        initGeocoder);

                    //커스텀오버레이(매물점수표시) 관련 선언
                    var CustomOverlay = function (options) {
                        this._element = $()
                        this.setPosition(options.position);
                        this.setMap(options.map || null);
                    };

                    CustomOverlay.prototype = new naver.maps.OverlayView();
                    CustomOverlay.prototype.constructor = CustomOverlay;

                    CustomOverlay.prototype.setPosition = function (
                        position) {
                        this._position = position;
                        this.draw();
                    };

                    CustomOverlay.prototype.setElement = function (
                        element) {
                        this._element = element;
                        this.draw();
                    };

                    CustomOverlay.prototype.getPosition = function () {
                        return this._position;
                    };

                    CustomOverlay.prototype.onAdd = function () {
                        var overlayLayer = this.getPanes().overlayLayer;

                        this._element.appendTo(overlayLayer);
                    };

                    CustomOverlay.prototype.draw = function () {
                        if (!this.getMap()) {
                            return;
                        }

                        var projection = this.getProjection(), position = this
                            .getPosition(), pixelPosition = projection
                                .fromCoordToOffset(position);

                        this._element.css('left', pixelPosition.x);
                        this._element.css('top', pixelPosition.y);
                    };

                    CustomOverlay.prototype.onRemove = function () {
                        var overlayLayer = this.getPanes().overlayLayer;

                        this._element.remove();
                        this._element.off();
                    };

                    //마커 배열
                    var markerList = new Array();
                    //매물 정보창 배열
                    var infoList = new Array();
                    var infoWindows = new Array();

                    var estatelists = new Array();
					
                    //화면에 있는 모든 매물 제거
                    function clear(markerList, infoList) {
                        for (let i = 0; i < markerList.length; i++) {
                            markerList[i].setMap(null);
                            infoList[i].setMap(null);
                        }
                        markerList = new Array();
                        infoList = new Array();

                    }
					
                    //정보창 제거
                    function clearinfo(infoWindows) {
                        for (let i = 0; i < infoWindows.length; i++) {
                            infoWindows[i].setMap(null);

                        }
                        infoWindows = new Array();

                    }
					
                    //매물 리스트 초기화
                    function clearlist() {
                        var estatelist = "";
                        document.getElementById("eachestatelist").innerHTML = "";
                    }
					
                    //RestAPi사용을 위한 요청변수
                    var xmlhttp = new XMLHttpRequest();
					
                    //응답 유형에 따른 파싱 함수
                    xmlhttp.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            var dataType = this
                                .getResponseHeader("Data-Type");
                            var contentLength = this
                                .getResponseHeader("Content-Length");
                            if (dataType == "Estate") {
                                estateArr = JSON
                                    .parse(this.responseText);
                                estateBind(estateArr);
                            } else if (dataType == "Cvs"
                                && contentLength != "0") {
                                var availableCvs = this.responseText;
                                cvsBind(availableCvs);
                                //console.log(availableCvs);
                            } else if (dataType == "Laundry"
                                && contentLength != "0") {
                                var availableLaundry = this.responseText;
                                laundryBind(availableLaundry);
                                //console.log(availableLaundry);										
                            } else if (dataType == "Mart"
                                && contentLength != "0") {
                                var availableMart = this.responseText;
                                martBind(availableMart);
                                //console.log(availableMart);
                            } else if (dataType == "Safetybox"
                                && contentLength != "0") {
                                var availableSafetybox = this.responseText;
                                safetyboxBind(availableSafetybox);
                                //console.log(availableSafetybox);
                            } else if (dataType == "Subway"
                                && contentLength != "0") {
                                var availableSubway = this.responseText;
                                subwayBind(availableSubway);
                                //console.log(availableSubway);
                            } else if (dataType == "Bank"
                                && contentLength != "0") {
                                var availableBank = this.responseText;
                                bankBind(availableBank);
                                //console.log(availableBank);
                            } else if (dataType == "Pharmacy"
                                && contentLength != "0") {
                                var availablePharmacy = this.responseText;
                                pharmacyBind(availablePharmacy);
                                //console.log(availablePharmacy);
                            } else if (dataType == "Hospital"
                                && contentLength != "0") {
                                var availableHospital = this.responseText;
                                hospitalBind(availableHospital);
                                //console.log(availableHospital);
                            } else if (dataType == "Gym"
                                && contentLength != "0") {
                                var availableGym = this.responseText;
                                gymBind(availableGym);
                                //console.log(availableGym);
                            } else if (dataType == "Crime"
                                && contentLength != "0") {
                                var availableCrime = this.responseText;
                                crimeBind(availableCrime);
                                //console.log(availableCrime);
                            }
                        }
                    }

                    //매물 선택시 적용되어있는 인프라중 적합한 개체를 요청하는 함수
                    function getAvailableInfra(map, marker) {
                        var delay = 100;
                        if (cvsPoint > 0) {
                            setTimeout(function () {
                                getAvailableCvs(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (laundryPoint > 0) {
                            setTimeout(function () {
                                getAvailableLaundry(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (safetyboxPoint > 0) {
                            setTimeout(function () {
                                getAvailableSafetybox(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (martPoint > 0) {
                            setTimeout(function () {
                                getAvailableMart(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (subwayPoint > 0) {
                            setTimeout(function () {
                                getAvailableSubway(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (bankPoint > 0) {
                            setTimeout(function () {
                                getAvailableBank(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (pharmacyPoint > 0) {
                            setTimeout(function () {
                                getAvailablePharmacy(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (hospitalPoint > 0) {
                            setTimeout(function () {
                                getAvailableHospital(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (gymPoint > 0) {
                            setTimeout(function () {
                                getAvailableGym(map, marker);
                            }, delay);
                            delay += 50;
                        }
                        if (crimePoint > 0) {
                            setTimeout(function () {
                                getAvailableCrime(map, marker);
                            }, delay);
                            delay += 50;
                        }
                    }

                    //가중치 (별) 클릭 이벤트 리스너
                    $(document).ready(function () {
                        $("#img").click(function () {
                            var img = document.getElementById("img");

                            if (img.src.match("on1")) {
                                img.src = "./resources/img/off1.png";
                                if (cvsPoint > 0) {
                                    cvsPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on1.png";
                                if (cvsPoint > 0) {
                                    cvsPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img2").click(function () {
                            var img = document.getElementById("img2");

                            if (img.src.match("on2")) {
                                img.src = "./resources/img/off2.png";
                                if (laundryPoint > 0) {
                                    laundryPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on2.png";
                                if (laundryPoint > 0) {
                                    laundryPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img3").click(function () {
                            var img = document.getElementById("img3");

                            if (img.src.match("on3")) {
                                img.src = "./resources/img/off3.png";
                                if (safetyboxPoint > 0) {
                                    safetyboxPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on3.png";
                                if (safetyboxPoint > 0) {
                                    safetyboxPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img4").click(function () {
                            var img = document.getElementById("img4");

                            if (img.src.match("on4")) {
                                img.src = "./resources/img/off4.png";
                                if (martPoint > 0) {
                                    martboxPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on4.png";
                                if (martPoint > 0) {
                                    martboxPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img5").click(function () {
                            var img = document.getElementById("img5");

                            if (img.src.match("on5")) {
                                img.src = "./resources/img/off5.png";
                                if (subwayPoint > 0) {
                                    subwayPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on5.png";
                                if (subwayPoint > 0) {
                                    subwayPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img6").click(function () {
                            var img = document.getElementById("img6");

                            if (img.src.match("on6")) {
                                img.src = "./resources/img/off6.png";
                                if (bankPoint > 0) {
                                    bankPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on6.png";
                                if (bankPoint > 0) {
                                    bankPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img7").click(function () {
                            var img = document.getElementById("img7");

                            if (img.src.match("on7")) {
                                img.src = "./resources/img/off7.png";
                                if (pharmacyPoint > 0) {
                                    pharmacPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on7.png";
                                if (pharmacyPoint > 0) {
                                    pharmacPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img8").click(function () {
                            var img = document.getElementById("img8");

                            if (img.src.match("on8")) {
                                img.src = "./resources/img/off8.png";
                                if (hospitalPoint > 0) {
                                    hospitalPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on8.png";
                                if (hospitalPoint > 0) {
                                    hospitalPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img9").click(function () {
                            var img = document.getElementById("img9");

                            if (img.src.match("on9")) {
                                img.src = "./resources/img/off9.png";
                                if (gymPoint > 0) {
                                    gymPoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on9.png";
                                if (gymPoint > 0) {
                                    gymPoint = 3;
                                }
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#img10").click(function () {
                            var img = document.getElementById("img10");

                            if (img.src.match("on10")) {
                                img.src = "./resources/img/off10.png";
                                if (gymPoint > 0) {
                                    crimePoint = 2;
                                }
                            } else {
                                img.src = "./resources/img/on10.png";
                                if (gymPoint > 0) {
                                    crimePoint = 3;
                                }
                            }
                        });
                    });

                    //지도 화면 내부에 있는 매물 목록을 요청하는 함수
                    function getAvailableEstates(map) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "availableEstates/"
                            + map.getBounds().getMax().x
                            + "/"
                            + map.getBounds().getMax().y
                            + "/"
                            + map.getBounds().getMin().x
                            + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.send();
                    }
					
                    //선택한 인프라에 따라 점수가 부여된 매물 리스트를 요청하는 함수
                    function getEstateScore(map) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "estateScore";
                        xmlhttp.open("POST", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.setRequestHeader("X-HTTP-Method-Override", "GET");
                        xmlhttp.send(JSON.stringify({
                            "maxX": map.getBounds().getMax().x,
                            "maxY": map.getBounds().getMax().y,
                            "minX": map.getBounds().getMin().x,
                            "minY": map.getBounds().getMin().y,
                            "cvsPoint": cvsPoint,
                            "laundryPoint": laundryPoint,
                            "safetyboxPoint": safetyboxPoint,
                            "martPoint": martPoint,
                            "subwayPoint": subwayPoint,
                            "bankPoint": bankPoint,
                            "pharmacyPoint": pharmacyPoint,
                            "hospitalPoint": hospitalPoint,
                            "gymPoint": gymPoint,
                            "crimePoint": crimePoint
                        }));
                    }

                    //개별 인프라의 정보를 요청하는 함수
                    function getAvailableCvs(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "cvs/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailableLaundry(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "laundry/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailableSafetybox(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "safetybox/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailableMart(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "mart/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailableSubway(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "subway/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailableBank(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "bank/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailablePharmacy(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "pharmacy/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailableHospital(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "hospital/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailableGym(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + "gym/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + map.getBounds().getMax().x + "/"
                            + map.getBounds().getMax().y + "/"
                            + map.getBounds().getMin().x + "/"
                            + map.getBounds().getMin().y;
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }
                    function getAvailableCrime(map, marker) {
                        var url = "http://localhost:8080/salgosipda/"
                            + marker.getPosition().y + "/"
                            + marker.getPosition().x + "/"
                            + "crime"
                        xmlhttp.open("GET", url, true);
                        xmlhttp.setRequestHeader("Content-Type",
                            "application/json;charset=UTF-8");
                        xmlhttp.send();
                    }

                    //매물 응답에서 파싱된 JSON데이터를 통해 매물 객체 생성 함수
                    function estateBind(arr) {
                        arr.forEach(function (availableEstate) {
                            var availableEstate = new Estate(
                                availableEstate.id,
                                availableEstate.name,
                                availableEstate.type,
                                availableEstate.price,
                                availableEstate.address,
                                availableEstate.longitude,
                                availableEstate.latitude,
                                availableEstate.area,
                                availableEstate.floor,
                                availableEstate.sch_moving,
                                availableEstate.construction_year,
                                availableEstate.feature,
                                availableEstate.direction,
                                availableEstate.parking,
                                availableEstate.manage_cost,
                                availableEstate.manage_included,
                                availableEstate.security,
                                availableEstate.score,
                                availableEstate.estatename,
                                availableEstate.callnum);
                            estates.push(availableEstate);
                        });

                    }

					//인프라 요청 응답에서 파싱된 JSON 데이터를 통해 각각의 인프라 정보 표기 함수
                    function cvsBind(element) {
                        cvsInfo = "";
                        cvsInfo = element;
                        var cvsTitle = "<b>편의점</b><br>"
                        var cvsSpan = "<span>"
                            + cvsInfo
                            + "</span>";
                        $(".cvsinfo").before(cvsTitle);
                        $(".cvsinfo").empty();
                        $(".cvsinfo").prepend(cvsSpan);
                        $(".cvsinfo").after("<br>");

                    }

                    function laundryBind(element) {
                        laundryInfo = "";
                        laundryInfo = element;
                        var laundryTitle = "<b>세탁소</b><br>"
                        var laundrySpan = "<span>"
                            + laundryInfo
                            + "</span>";
                        $(".laundryinfo").before(laundryTitle);
                        $(".laundryinfo").empty();
                        $(".laundryinfo").prepend(laundrySpan);
                        $(".laundryinfo").after("<br>");

                    }
                    function martBind(element) {
                        martInfo = "";
                        martInfo = element;
                        //console.log(martInfo);								
                        var martTitle = "<b>마트</b><br>"
                        var martSpan = "<span>"
                            + martInfo
                            + "</span>";
                        $(".martinfo").before(martTitle);
                        $(".martinfo").empty();
                        $(".martinfo").prepend(martSpan);
                        $(".martinfo").after("<br>");

                    }
                    function safetyboxBind(element) {
                        safetyboxInfo = "";
                        safetyboxInfo = element;
                        //console.log(safetyboxInfo);								
                        var safetyboxTitle = "<b>여성안심택배함</b><br>"
                        var safetyboxSpan = "<span>"
                            + safetyboxInfo
                            + "</span>";
                        $(".safetyboxinfo").before(safetyboxTitle);
                        $(".safetyboxinfo").empty();
                        $(".safetyboxinfo").prepend(safetyboxSpan);
                        $(".safetyboxinfo").after("<br>");

                    }
                    function subwayBind(element) {
                        subwayInfo = "";
                        subwayInfo = element;
                        //console.log(cvsInfo);								
                        var subwayTitle = "<b>지하철</b><br>"
                        var subwaySpan = "<span>"
                            + subwayInfo
                            + "</span>";
                        $(".subwayinfo").before(subwayTitle);
                        $(".subwayinfo").empty();
                        $(".subwayinfo").prepend(subwaySpan);
                        $(".subwayinfo").after("<br>");

                    }
                    function bankBind(element) {
                        bankInfo = "";
                        bankInfo = element;
                        //console.log(bankInfo);								
                        var bankTitle = "<b>은행</b><br>"
                        var bankSpan = "<span>"
                            + bankInfo
                            + "</span>";
                        $(".bankinfo").before(bankTitle);
                        $(".bankinfo").empty();
                        $(".bankinfo").prepend(bankSpan);
                        $(".bankinfo").after("<br>");
                    }
                    function pharmacyBind(element) {
                        pharmacyInfo = "";
                        pharmacyInfo = element;
                        //console.log(pharmacyInfo);								
                        var pharmacyTitle = "<b>약국</b><br>"
                        var pharmacySpan = "<span>"
                            + pharmacyInfo
                            + "</span>";
                        $(".pharmacyinfo").before(pharmacyTitle);
                        $(".pharmacyinfo").empty();
                        $(".pharmacyinfo").prepend(pharmacySpan);
                        $(".pharmacyinfo").after("<br>");
                    }
                    function hospitalBind(element) {
                        hospitalInfo = "";
                        hospitalInfo = element;
                        //console.log(hospitalInfo);								
                        var hospitalTitle = "<b>병원</b><br>"
                        var hospitalSpan = "<span>"
                            + hospitalInfo
                            + "</span>";
                        $(".hospitalinfo").before(hospitalTitle);
                        $(".hospitalinfo").empty();
                        $(".hospitalinfo").prepend(hospitalSpan);
                        $(".hospitalinfo").after("<br>");
                    }
                    function gymBind(element) {
                        gymInfo = "";
                        gymInfo = element;
                        //console.log(gymInfo);								
                        var gymTitle = "<b>헬스장</b><br>"
                        var gymSpan = "<span>"
                            + gymInfo
                            + "</span>";
                        $(".gyminfo").before(gymTitle);
                        $(".gyminfo").empty();
                        $(".gyminfo").prepend(gymSpan);
                        $(".gyminfo").after("<br>");
                    }
                    function crimeBind(element) {
                        crimeInfo = "";
                        crimeInfo = element;
                        //console.log(gymInfo);								
                        var crimeTitle = "<b>범죄율</b><br>"
                        var crimeSpan = "<span>"
                            + crimeInfo
                            + "</span>";
                        $(".crimeinfo").before(crimeTitle);
                        $(".crimeinfo").empty();
                        $(".crimeinfo").prepend(crimeSpan);
                    }

					//매물 상세정보 표기
                    var detailviews = new Array();
                    function estateOverlay(markerList, infoList,
                        estates) {

                        //var detailview = "";
                        clearlist();
                        var estatelist = "";
                        var detailviews2 = new Array();
                        var markerList2 = new Array();
                        for (let i = 0; i < estates.length; i++) {

                            var x = Number(estates[i].longitude);
                            var y = Number(estates[i].latitude);

                            var marker = new naver.maps.Marker({
                                position: new naver.maps.Point(x, y),
                                map: map
                            });

                            markerList.push(marker);
                            markerList2.push(marker);

                            var overlay = new CustomOverlay(marker);

                            //최고점수를 가진 매물 표시

                            if (estates[i].score <= 40) {
                                overlay
                                    .setElement($('<div id="lowscore">'
                                        + '<span style="font-weight: bold;"> '
                                        + estates[i].score
                                        + ' </span>' + '</div>'));
                            } else if (estates[i].score <= 70) {
                                overlay
                                    .setElement($('<div id="middlescore">'
                                        + '<span style="font-weight: bold; "> '
                                        + estates[i].score
                                        + ' </span>' + '</div>'));
                            } else if (estates[i].score <= 100) {
                                overlay
                                    .setElement($('<div id="highscore">'
                                        + '<span style="font-weight: bold;"> '
                                        + estates[i].score
                                        + ' </span>' + '</div>'));
                            } else {
                                overlay
                                    .setElement($('<div id="bestscore">'
                                        + '<span style="font-weight: bold;"> '
                                        + estates[i].score
                                        + ' </span>' + '</div>'));
                            }
                            if (infraCount != 0) {
                                overlay.setMap(map);
                            }
							
                            //매물 리스트 표기
                            function showlist() {

                                if (marker.getMap() != null) {

                                    var estatelist = "";
                                    var arealistsplit = estates[i].area
                                        .split("/");
                                    var floorlistsplit = estates[i].floor
                                        .split("/");
                                    var addresslistsplit = estates[i].address
                                        .split(" ");

                                    estatelist += "<div id=\"eachestate" + i + "\">";

                                    estatelist += "<div id=\"eachestateimage\">";
                                    estatelist += '<img class=\"eachestateimg\" src="' + imgres + '" ></div>';

                                    estatelist += "<div id=\"eachestateinfo\">";

                                    estatelist += "<div id=\"bold\">";
                                    estatelist += estates[i].type
                                        + "&nbsp "
                                        + estates[i].price;


                                    estatelist += "</div>";


                                    if (infraCount > 0) {

                                        estatelist += "<div id=\"showscore\"";
                                        if (estates[i].score <= 40) {
                                            estatelist += "style=\" background-color:#ec8b8b\">";
                                        } else if (estates[i].score <= 70) {
                                            estatelist += "style=\" background-color:#FFED51\">";
                                        } else if (estates[i].score <= 100) {
                                            estatelist += "style=\" background-color:#67CCF5\">";
                                        } else {
                                            estatelist += "style=\" background-color:#93D236\">";
                                        }

                                        estatelist += +estates[i].score
                                            + "</div>";
                                    }



                                    estatelist += "<div id=\"floor\">";
                                    estatelist += arealistsplit[0]
                                        + "m2&nbsp "
                                        + floorlistsplit[0] + "층";
                                    estatelist += "<br>";
                                    estatelist += addresslistsplit[0]
                                        + "&nbsp"
                                        + addresslistsplit[1]
                                        + "&nbsp"
                                        + addresslistsplit[2];
                                    estatelist += "<br>";
                                    estatelist += "</div>";
                                    estatelist += "<div id=\"add\">";

                                    estatelist += estates[i].feature;

                                    estatelist += "</div>";
                                    estatelist += "</div>";

                                    estatelist += "</div>";

                                    document
                                        .getElementById("eachestatelist").innerHTML += estatelist;

                                    $(document)
                                        .on(
                                            "click",
                                            "#eachestate" + i,

                                            function () {
                                                //필터창 숨기고 상세정보창 보여주기

                                                $('#filter')
                                                    .hide();
                                                $(
                                                    '#filterdetail')
                                                    .hide();
                                                $('#estatelist')
                                                    .hide();

                                                document
                                                    .getElementById("detailview").innerHTML = detailviews2[i];

                                                $('#detailview')
                                                    .show();
                                                getAvailableInfra(
                                                    map,
                                                    markerList2[i]);
                                                //뒤로가기 클릭시 상세정보창 숨기고 필터창 표시
                                                $('#exit')
                                                    .click(
                                                        function () {
                                                            $(
                                                                '#detailview')
                                                                .hide();
                                                            $(
                                                                '#estatelist')
                                                                .hide();
                                                            $(
                                                                '#estatelist')
                                                                .show();
                                                        });
                                            });

                                    $(document)
                                        .on(
                                            "mouseover",
                                            "#eachestate" + i,
                                            function () {
                                                for (let j = 0; j < estates.length; j++) {
                                                    if (markerList2[j]
                                                        .getAnimation() !== null) {
                                                        markerList2[j]
                                                            .setAnimation(null);
                                                    }
                                                }
                                                if (marker
                                                    .getAnimation() !== null) {
                                                    marker
                                                        .setAnimation(null);
                                                } else {
                                                    markerList2[i]
                                                        .setAnimation(naver.maps.Animation.BOUNCE);
                                                }

                                            });

                                    $(document)
                                        .on(
                                            "click",
                                            "#eachestate" + i,
                                            function () {
                                                for (let j = 0; j < estates.length; j++) {
                                                    if (markerList2[j]
                                                        .getAnimation() !== null) {
                                                        markerList2[j]
                                                            .setAnimation(null);
                                                    }
                                                }
                                                if (marker
                                                    .getAnimation() !== null) {
                                                    marker
                                                        .setAnimation(null);
                                                } else {
                                                    markerList2[i]
                                                        .setAnimation(naver.maps.Animation.BOUNCE);
                                                }

                                            });

                                    estatelists.push(estatelist);
                                }
                            }

                            //기본 필터 선택

                            //필터에 맞지 않는 매물 삭제
                            function markerdelete(marker2, overlay2) {
                                marker2.setMap(null);
                                overlay2.setMap(null);


                            }

                            //관리비 필터
                            function manageprice(marker3, overlay3) {
                                var pricestring = estates[i].manage_cost;
                                var manageprice = pricestring.replace(
                                    ",", "");
                                manageprice = Number(manageprice);
                                if ($("#m1").is(":checked")) {
                                    if (manageprice > document
                                        .getElementById("m1").value) {
                                        markerdelete(marker3, overlay3);
                                    }

                                } else if ($("#m2").is(":checked")) {
                                    if (manageprice > document
                                        .getElementById("m2").value) {
                                        markerdelete(marker3, overlay3);
                                    }
                                } else if ($("#m3").is(":checked")) {
                                    if (manageprice > document
                                        .getElementById("m3").value) {
                                        markerdelete(marker3, overlay3);
                                    }
                                } else if ($("#m4").is(":checked")) {
                                    if (manageprice > document
                                        .getElementById("m4").value) {
                                        markerdelete(marker3, overlay3);
                                    }
                                }
                            }

                            //월세 필터
                            function monthlyprice(monthly2, marker4,
                                overlay4) {

                                if ($("#w1").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w1").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w2").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w2").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w3").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w3").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w4").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w4").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w5").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w5").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w6").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w6").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w7").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w7").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w8").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w8").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w9").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w9").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w10").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w10").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w11").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w11").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                } else if ($("#w12").is(":checked")) {

                                    if (monthly2 > document
                                        .getElementById("w12").value) {
                                        markerdelete(marker4, overlay4);
                                    }
                                }
                                manageprice(marker4, overlay4);

                            }

                            //보증금, 전세금 필터
                            function depositprice(deposit2, marker5,
                                overlay5) {
                                if ($("#p1").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p1").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                } else if ($("#p2").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p2").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                } else if ($("#p3").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p3").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                } else if ($("#p4").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p4").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                } else if ($("#p5").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p5").value) {
                                        markerdelete(marker5, overlay5);
                                    }
                                } else if ($("#p6").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p6").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                } else if ($("#p7").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p7").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                } else if ($("#p8").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p8").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                } else if ($("#p9").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p9").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                } else if ($("#p10").is(":checked")) {
                                    if (deposit2 > document
                                        .getElementById("p10").value) {
                                        markerdelete(marker5, overlay5);
                                    }

                                }
                            }

                            //필터 클릭

                            //전세 클릭
                            if ($("#deal2").is(":checked")) {
                                var pricestring = estates[i].price;
                                var deposit = pricestring.replace(",",
                                    "");
                                deposit = Number(deposit); //보증금

                                //월세인 매물 삭제
                                if (estates[i].type == '월세') {
                                    markerdelete(marker, overlay);

                                } else {

                                    depositprice(deposit, marker,
                                        overlay);
                                    manageprice(marker, overlay);
                                }

                            } else if ($("#deal3").is(":checked")) { //월세 클릭
                                var pricestring = estates[i].price;

                                var strArray = estates[i].price
                                    .split("/");

                                var deposit = strArray[0].replace(",",
                                    "");
                                var monthly = strArray[1];
                                deposit = Number(deposit); //보증금
                                monthly = Number(monthly); //월세

                                if (estates[i].type == '월세') { //월세인 매물 중 보증금, 월세가격 필터 적용
                                    depositprice(deposit, marker,
                                        overlay);
                                    monthlyprice(monthly, marker,
                                        overlay);

                                } else if (estates[i].type == '전세') { //전세인 매물 삭제
                                    markerdelete(marker, overlay);
                                }

                            } else { //디폴트 -> 전체
                                if (estates[i].type == '월세') { //
                                    var pricestring = estates[i].price;

                                    var strArray = estates[i].price
                                        .split("/");

                                    var deposit = strArray[0].replace(
                                        ",", "");
                                    var monthly = strArray[1];
                                    deposit = Number(deposit); //보증금
                                    monthly = Number(monthly); //월세

                                    depositprice(deposit, marker,
                                        overlay);
                                    monthlyprice(monthly, marker,
                                        overlay);

                                } else if (estates[i].type == '전세') {
                                    var pricestring = estates[i].price;
                                    var deposit = pricestring.replace(
                                        ",", "");
                                    deposit = Number(deposit); //보증금

                                    depositprice(deposit, marker,
                                        overlay);
                                    manageprice(marker, overlay);
                                }
                            }

                            //매물 간략 정보
                            var contentstring = ['<div style="width:150px;text-align:center;padding:10px;font-size:12px;"><b>'
                                + estates[i].name
                                + '<br>'
                                + estates[i].type
                                + estates[i].price

                                + '</b></div>'].join('');

                            //매물 간략 정보 
                            var infoWindow = new naver.maps.InfoWindow(
                                {
                                    content: contentstring,
                                    borderWidth: 2,
                                    borderColor: "#042E6E"

                                });

                            infoWindows.push(infoWindow);

                            infoList.push(overlay);

                            //매물 상세 정보 
                            var detailview = "";
                            var imgres = "./resources/img/"
                                + estates[i].id + ".jpg";
                            var areasplit = estates[i].area.split("공");

                            //뒤로가기 버튼
                            detailview += "<div id=\"backbutton\">";
                            detailview += "<button type=\"button\" id=\"exit\" style=\"border:0;background:transparent;cursor:pointer;\" >";
                            detailview += "<img  src=\"./resources/img/back.png\" ></button></div>";

                            detailview += "<div id=\"detailheader\"><b>매물 정보</b></div>";

                            detailview += "<br><br>";

                            //매물번호
                            detailview += "<div id=\"estatenumber\">매물 번호 ";
                            detailview += estates[i].id + "</div>";
                            //상세이미지
                            detailview += "<div id=\"detailimage\">";
                            detailview += '<img class=\"estateimg\" src="' + imgres + '" ></div>';

                            //가격, 관리비, 면적
                            detailview += "<div id=\"importinfo\">";
                            detailview += "<table class=\"iminfo\"><tr>";
                            detailview += "<th class=\"detailtype\" style=\"text-align: center;\">"
                                + estates[i].type + "</th>";
                            detailview += "<th class=\"detailmprice\" style=\"text-align: center;\">관리비</th>";
                            detailview += "<th class=\"detailarea\" style=\"border-right: none; text-align:center;\">공급/전용</th></tr>";
                            detailview += "<tr><td>" + estates[i].price
                                + "</td>";
                            detailview += "<td>"
                                + estates[i].manage_cost + "</td>";
                            detailview += "<td style=\"border-right: none;\">"
                                + areasplit[0]
                                + "(m²)"
                                + "</td></tr></table></div>";

                            detailview += "<br>";

                            //그 외 매물정보
                            detailview += "<div id=\"information\">매물 정보<br>";
                            detailview += "<table class=\"detailinformation\">"
                                + "<tr><th>층수</th>";
                            detailview += "<td>" + estates[i].floor
                                + "</td></tr>";
                            detailview += "<tr><th>사용승인일</th>";
                            detailview += "<td>"
                                + estates[i].construction_year
                                + "</td></tr>";
                            detailview += "<tr><th>방향</th>";
                            detailview += "<td>" + estates[i].direction
                                + "</td></tr>";
                            detailview += "<tr><th>주차가능여부</th>";
                            detailview += "<td>" + estates[i].parking
                                + "</td></tr>";
                            detailview += "<tr><th>관리비 포함 내역</th>";
                            detailview += "<td>"
                                + estates[i].manage_included
                                + "</td></tr>";
                            detailview += "<tr><th>보안시설</th>";
                            detailview += "<td>" + estates[i].security
                                + "</td></tr>";
                            detailview += "<tr><th>입주가능일</th>";
                            detailview += "<td>"
                                + estates[i].sch_moving
                                + "</td></tr></table></div>";

                            detailview += "<br>";

                            //매물특징
                            detailview += "<div id=\"feature\"><b>매물 특징</b><br>";
                            detailview += "<div class=\"detailfeature\">";
                            detailview += estates[i].feature
                                + "<br><br></div></div>";
                            detailview += "<br>";

                            detailview += "<div id=\"feature\"><b>부동산 정보</b><br>";
                            detailview += "<div class=\"detailfeature\">";
                            detailview += estates[i].estatename
                                + "&nbsp " + estates[i].callnum
                                + "<br><br></div></div>";
                            detailview += "<br>";

                            //가장 가까운 편의시설 정보
                            detailview += "<div id=\"cvs\" style=\"text-align:center\">";
                            detailview += "<div class=\"cvsinfo\" style=\"background-color:#F5F5F5;text-align:center\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"laundry\" style=\"text-align:center\">";
                            detailview += "<div class = \"laundryinfo\" style=\"background-color:#F5F5F5\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"safetybox\" style=\"text-align:center\">";
                            detailview += "<div class = \"safetyboxinfo\" style=\"background-color:#F5F5F5\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"mart\" style=\"text-align:center\">";
                            detailview += "<div class = \"martinfo\" style=\"background-color:#F5F5F5;text-align:center\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"subway\" style=\"text-align:center\">";
                            detailview += "<div class = \"subwayinfo\" style=\"background-color:#F5F5F5\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"bank\" style=\"text-align:center\">";
                            detailview += "<div class = \"bankinfo\" style=\"background-color:#F5F5F5\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"pharmacy\" style=\"text-align:center\">";
                            detailview += "<div class = \"pharmacyinfo\" style=\"background-color:#F5F5F5\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"hospital\" style=\"text-align:center\">";
                            detailview += "<div class = \"hospitalinfo\" style=\"background-color:#F5F5F5\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"gym\" style=\"text-align:center\">";
                            detailview += "<div class = \"gyminfo\" style=\"background-color:#F5F5F5\">";

                            detailview += "</div></div>";

                            detailview += "<div id=\"crime\" style=\"text-align:center\">";
                            detailview += "<div class = \"crimeinfo\" style=\"background-color:#F5F5F5\">";

                            detailview += "</div></div>";

                            detailview += "<br><br>";

                            detailviews.push(detailview);
                            detailviews2.push(detailview);

                            showlist();

                        }

                        for (var k = 0, kk = markerList.length; k < kk; k++) {

                            //마우스 오버 이벤트 리스너 등록
                            naver.maps.Event
                                .addListener(markerList[k],
                                    'mouseover',
                                    getMouseOverHandler(k));
                            //마우스 클릭 이벤트 리스너 등록
                            naver.maps.Event.addListener(markerList[k],
                                'click', getClickHandler(k));

                        }

                        //마우스 오버시 작은 상세창
                        function getMouseOverHandler(seq) {
                            return function (e) {
                                var marker = markerList[seq], infoWindow = infoWindows[seq];
                                //매물 상세정보창 
                                if (infoWindow.getMap()) {
                                    infoWindow.close();
                                } else {
                                    infoWindow.open(map, marker);
                                }

                            }
                        }

                        //마우스 클릭시 상세정보창 
                        function getClickHandler(seq) {
                            return function (e) {

                                var marker = markerList[seq], infoWindow = infoWindows[seq], detailview = detailviews[seq], estatelist = estatelists[seq];
                                getAvailableInfra(map, marker);

                                //필터창 숨기고 상세정보창 보여주기
                                $('#filter').hide();
                                $('#filterdetail').hide();
                                $('#estatelist').hide();

                                document.getElementById("detailview").innerHTML = detailview;

                                $('#detailview').show();

                                //뒤로가기 클릭시 상세정보창 숨기고 필터창 표시
                                $('#exit').click(function () {
                                    $('#detailview').hide();
                                    $('#estatelist').hide();
                                    $('#estatelist').show();
                                });

                                for (let j = 0; j < estates.length; j++) {
                                    if (markerList2[j].getAnimation() !== null) {
                                        markerList2[j]
                                            .setAnimation(null);
                                    }
                                }
                                if (marker.getAnimation() != null) {
                                    marker.setAnimation(null);
                                } else {
                                    marker
                                        .setAnimation(naver.maps.Animation.BOUNCE);
                                }

                            }
                        }

                    }

                    //인프라 checkbox 체크 여부
                    $(document).ready(function () {
                        $("#cvs").change(function () {
                            if ($("#cvs").is(":checked")) {
                                infraCount++;
                                cvsPoint = 2;
                            } else {
                                infraCount--;
                                cvsPoint = 0;
                            }
                        });
                    });
                    $(document).ready(function () {
                        $("#laundry").change(function () {
                            if ($("#laundry").is(":checked")) {
                                infraCount++;
                                laundryPoint = 2;
                            } else {
                                infraCount--;
                                laundryPoint = 0;
                            }
                        });
                    });
                    $(document).ready(function () {
                        $("#safetybox").change(function () {
                            if ($("#safetybox").is(":checked")) {
                                infraCount++;
                                safetyboxPoint = 2;
                            } else {
                                infraCount--;
                                safetyboxPoint = 0;
                            }
                        });
                    });
                    $(document).ready(function () {
                        $("#mart").change(function () {
                            if ($("#mart").is(":checked")) {
                                infraCount++;
                                martPoint = 2;
                            } else {
                                infraCount--;
                                martPoint = 0;
                            }
                        });
                    });
                    $(document).ready(function () {
                        $("#subway").change(function () {
                            if ($("#subway").is(":checked")) {
                                infraCount++;
                                subwayPoint = 2;
                            } else {
                                infraCount--;
                                subwayPoint = 0;
                            }
                        });
                    });

                    $(document).ready(function () {
                        $("#bank").change(function () {
                            if ($("#bank").is(":checked")) {
                                infraCount++;
                                bankPoint = 2;
                            } else {
                                infraCount--;
                                bankPoint = 0;
                            }
                        });
                    });
                    $(document).ready(function () {
                        $("#pharmacy").change(function () {
                            if ($("#pharmacy").is(":checked")) {
                                infraCount++;
                                pharmacyPoint = 2;
                            } else {
                                infraCount--;
                                pharmacyPoint = 0;
                            }
                        });
                    });
                    $(document).ready(function () {
                        $("#hospital").change(function () {
                            if ($("#hospital").is(":checked")) {
                                infraCount++;
                                hospitalPoint = 2;
                            } else {
                                infraCount--;
                                hospitalPoint = 0;
                            }
                        });
                    });
                    $(document).ready(function () {
                        $("#gym").change(function () {
                            if ($("#gym").is(":checked")) {
                                infraCount++;
                                gymPoint = 2;
                            } else {
                                infraCount--;
                                gymPoint = 0;
                            }
                        });
                    });
                    $(document).ready(function () {
                        $("#crime").change(function () {
                            if ($("#crime").is(":checked")) {
                                infraCount++;
                                crimePoint = 2;
                            } else {
                                infraCount--;
                                crimePoint = 0;
                            }
                        });
                    });

                    //지도에 표시되고있는 구역이 변할시 발동하는 이벤트 리스너
                    naver.maps.Event.addListener(map, "idle",
                        function () {
                            clearlist();
                            if (infraCount > 0) {
                                //console.log(infraCount);
                                if (map.zoom >= 17) {
                                    estates = new Array();
                                    getEstateScore(map);

                                    setTimeout(
                                        function () {
                                            clear(markerList,
                                                infoList);
                                            //console.log(estates.length);
                                            estateOverlay(
                                                markerList,
                                                infoList,
                                                estates);

                                        }, 200);

                                    //바운드를 넘어가면 보이지 않는다.
                                } else if (map.zoom < 17) {
                                    //줌 아웃을 하면 사라진다

                                    clear(markerList, infoList);
                                    clearinfo(infoWindows);
                                }
                            } else {
                                if (map.zoom >= 17) {
                                    estates = new Array();
                                    getAvailableEstates(map);

                                    setTimeout(
                                        function () {
                                            clear(markerList,
                                                infoList);
                                            //console.log(estates.length);
                                            estateOverlay(
                                                markerList,
                                                infoList,
                                                estates);
                                        }, 200);

                                    //바운드를 넘어가면 보이지 않는다.
                                } else if (map.zoom < 17) {
                                    //줌 아웃을 하면 사라진다

                                    clear(markerList, infoList);
                                    clearinfo(infoWindows);
                                }
                            }

                        });

                    //페이지 버튼의 이벤트 리스너
                    $('#filterdetail').hide();
                    $('.mybutton').click(function () {
                        $('#filter').hide();
                        $('#estatelist').hide();
                        $('#filterdetail').show();
                        return false;

                    });
                    $('.close').click(function () {
                        $('#filterdetail').hide();
                        $('#estatelist').hide();
                        $('#filter').show();
                    });
                    $('.basicbutton').click(function () {
                        $('#filterdetail').hide();
                        $('#estatelist').hide();
                        $('#filter').show();
                    });
                    $('.detailbutton').click(function () {
                        $('#filter').hide();
                        $('#estatelist').hide();
                        $('#filterdetail').show();
                    });
                    $('#searchexit').click(function () {
                        $('#filterdetail').hide();
                        $('#estatelist').hide();
                        $('#filter').show();
                    });
                    $('.findbutton').click(
                        function () {

                            $('#filterdetail').hide();
                            $('#filter').hide();
                            $('#estatelist').show();
                            if (map.zoom >= 17) {
                                estates = new Array();
                                getEstateScore(map);

                                setTimeout(function () {
                                    clear(markerList, infoList);
                                    estateOverlay(markerList,
                                        infoList, estates);

                                }, 200);
                            } else {
                                map.setZoom(17);
                                estates = new Array();
                                getEstateScore(map);

                                setTimeout(function () {
                                    clear(markerList, infoList);
                                    estateOverlay(markerList,
                                        infoList, estates);

                                }, 200);
                            }

                        });
                    $('.justviewlist').click(
                        function () {

                            $('#filterdetail').hide();
                            $('#filter').hide();
                            $('#estatelist').show();
                            if (map.zoom >= 17) {
                                estates = new Array();
                                getEstateScore(map);

                                setTimeout(function () {
                                    clear(markerList, infoList);
                                    estateOverlay(markerList,
                                        infoList, estates);

                                }, 200);
                            } else {
                                map.setZoom(17);
                                estates = new Array();
                                getEstateScore(map);

                                setTimeout(function () {
                                    clear(markerList, infoList);
                                    estateOverlay(markerList,
                                        infoList, estates);

                                }, 200);
                            }

                        });
                    $('#listexit').click(function () {
                        $('#filterdetail').hide();
                        $('#estatelist').hide();
                        $('#filter').show();
                    });
                });
    </script>
</body>
</html>