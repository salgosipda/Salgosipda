#!/usr/bin/env python
# coding: utf-8

# ## 빈 주소가 없는 경우



import pandas as pd
import numpy as np
import json
import requests



#csv파일 불러오기
csvfile = pd.read_csv("temp.csv", encoding = "euc-kr")



#카카오API 사용해서 주소로 위도,경도 찾기

lats = list()
lons = list()


for address in csvfile['Address']: 
    #카카오API연결
    url = 'https://dapi.kakao.com/v2/local/search/address.json?query={}'.format(address)
    headers = {
        "Authorization": "KakaoAK 684d81b6e651af684b83edf223bdbe36"
    }
    #json결과저장
    result = requests.get(url, headers = headers).json()['documents']
    
    if len(result) != 0:
        #위도,경도저장
        lat = result[0]['y']
        lon = result[0]['x']

        lats.append(lat)
        lons.append(lon)

    else:
        #nan값저장
        lats.append(np.nan)
        lons.append(np.nan)
        
        
#csv에 위도,경도 리스트 합치기        
csvfile['Lat'] = lats
csvfile['Lon'] = lons



#새로운 csv 만들기
csvfile.to_csv("data.csv", index=False, encoding="euc-kr")





# ## 빈 주소가 있는 경우



import pandas as pd
import numpy as np
import json
import requests



#csv파일 불러오기
csvfile = pd.read_csv("temp.csv", encoding = "euc-kr")



#비어있는 도로명주소에 지번주소 삽입
null_address = csvfile[csvfile['도로명주소'].isnull()]
null_address['도로명주소'] = null_address['지번주소']

#삽입 후 기존 도로명주소와 합치기
all_address = csvfile[csvfile['도로명주소'].notnull()]
new_address = all_address.append(null_address)



#카카오API 사용해서 주소로 위도,경도 찾기

lats = list()
lons = list()


for address in new_address['도로명주소']:
    #카카오API연결
    url = 'https://dapi.kakao.com/v2/local/search/address.json?query={}'.format(address)
    headers = {
        "Authorization": "KakaoAK 684d81b6e651af684b83edf223bdbe36"
    }
    #json결과저장
    result = requests.get(url, headers = headers).json()['documents']
    
    if len(result) != 0:
        #위도,경도저장
        lat = result[0]['y']
        lon = result[0]['x']

        lats.append(lat)
        lons.append(lon)

    else:
        #nan값저장
        lats.append(np.nan)
        lons.append(np.nan)
        

#csv에 위도, 경도 리스트 합치기     
new_address['Lat'] = lats
new_address['Lon'] = lons



#새로운 csv 만들기
new_address.to_csv("data.csv", index=False, encoding="euc-kr")
