package kr.ac.hansung.service;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.EstateDao;
import kr.ac.hansung.model.Estate;

@Service
public class EstateService {
	@Autowired
	private EstateDao estateDao;

	//웹페이지에서 매물을 크롤링 하는 메소드
	public void insert() throws IOException, ParseException {

		Estate estate = new Estate();

		for (int j = 1; j <= 9; j++) { // ������ �� ����
			ArrayList<Element> elements = new ArrayList<>();
			ArrayList<String> id = new ArrayList();
			String nl = "";
			String pl = "";
			String il = "";
			String il2 = "";
			String tl = "";
			String al = "";
			String xl = "";
			String yl = "";
			String fl = "";
			String ml = "";
			String arl = "";
			String imgl = "";
			String yrl = "";
			String fal = "";
			String dl = "";
			String prl = "";
			String cl = "";
			String mal = "";
			String sl = "";
			String detailURL = "";
			String spl[];
			String areal[];
			BufferedImage img = null;

			// �Ź� ���?
			String EstateURL_1 = "http://land.mk.co.kr/memul/list.php?bubcode=1129000000&mgroup=G&bdiv=A&page=";
			String EstateURL_2 = String.valueOf(j);
			String EstateURL = EstateURL_1 + EstateURL_2;
			// System.out.println(EstateURL);

			Document doc = Jsoup.connect(EstateURL).get();

			Elements elem = doc.select("#SY > div > div > div.MaemulListContent > div.MaemulList > table > tbody ");
			// ���̵� ���?
			Elements idlist = elem.select("td.AlignLeft.Name > div > a:nth-child(1)");
			// �Ź� Ÿ��
			Elements tylist = elem.select("tr:nth-child(2n-1) >td:nth-child(1) > div");
			// ����
			Elements arlist = elem.select("tr:nth-child(2n-1) >td.Number.ScaleType > div");
			// �Ź� ����
			Elements pricelist = elem.select("strong");

			for (Element e : elem.select("td:nth-child(6) > div > strong")) {
				elements.add(e);
			}

			for (int i = 0; i < elements.size(); i++) {
				il = idlist.get(i).attr("href");
				spl = il.split("'");
				id.add(spl[1]);
			}

			// �Ź� �� ����
			String EstateURL2 = "http://land.mk.co.kr/memul/detail.php?bubcode=1129000000&mgroup=G&mclass=G01&bdiv=A&mseq=";

			for (int i = 0; i < elements.size(); i++) {
				try {
					il2 = id.get(i);
					tl = tylist.get(i).text(); // ����
					pl = pricelist.get(i).text(); // ����
					arl = arlist.get(i).text(); // ���� -----> ������ ���� �ʿ�(���� ����)
					arl = arl.replace(" ", "");
					areal = arl.split("��");

					estate.setId(il2);
					estate.setType(tl);
					estate.setPrice(pl);
					estate.setArea(areal[0]);

					detailURL = EstateURL2 + il2; // url �Ķ����? ���ڵ�
					Document doc2 = Jsoup.connect(detailURL).get();

					// �̹���
					Elements imglist = doc2.select(".imgListLi2> a > img");
					if (imglist != null) {

						imgl = imglist.attr("src");
						System.out.println(imgl);
						URL imgUrl = new URL(imgl);

						img = ImageIO.read(imgUrl);

						FileOutputStream out = new FileOutputStream(
								"C:\\dev\\capstone\\salgosipda\\src\\main\\webapp\\resources\\img\\" + il2
								+ ".jpg");

						// ImageIO.write(������ �̹���, ������ Ȯ����, ������ ��ġ)
						ImageIO.write(img, "jpg", out);
					} else {
						/*
						 * URL imgUrl = new
						 * URL("C:\\dev\\workspace\\salgosipda_capstone (2)\\salgosipda_capstone\\src\\main\\img\\no_image.jpeg"
						 * ); img = ImageIO.read(imgUrl); FileOutputStream out = new FileOutputStream(
						 * "C:\\dev\\workspace\\salgosipda_capstone (2)\\salgosipda_capstone\\src\\main\\img\\" + il2 + "
						 * .jpg"); ImageIO.write(img, "jpg", out);
						 */
					}
					// �ǹ� �ּ�
					Elements addresslist = doc2.select("#detailMapTitle > h3");
					al = addresslist.text();
					estate.setAddress(al);

					// �ּ�->����, �浵
					String jj = getKakaoApiFromAddress(al);
					String[] xy = jj.split(",");
					estate.setLongitude(xy[0]);
					estate.setLatitude(xy[1]);

					// �ǹ� �̸�
					Elements namelist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContent > div.DetailInfo > div > div.InfoSection > div.AddressZone > div.AddressInfo.AddressInfo2 > h2");
					nl = namelist.text();
					estate.setName(nl);

					// ��
					Elements floorlist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContent > div.DetailInfo > div > div.DetailView > div > table > tbody > tr:nth-child(1) > td:nth-child(2) > div");
					fl = floorlist.text();
					estate.setFloor(fl);
					// ���ְ�����------->������ ���� ����
					Elements movinglist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContent > div.DetailInfo > div > div.DetailView > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > div");
					ml = movinglist.text();
					ml = ml.replace(" ", "");
					estate.setSch_moving(ml);
					// �����?(��������)
					Elements yearlist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContent > div.DetailInfo > div > div.DetailView > div > table > tbody > tr:nth-child(2) > td:nth-child(4) > div");
					yrl = yearlist.text();
					estate.setConstruction_year(yrl);
					// Ư¡
					Elements fealist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContent > div.DetailInfo > div > div.DetailView > div > table > tbody > tr:nth-child(3) > td > div");
					fal = fealist.text();
					estate.setFeature(fal);

					// ����(����/����)------>������ ���� ����
					Elements directlist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContainer > div.InfoArea.InfoArea2.First > div > div.SaleDetail > div > table > tbody > tr:nth-child(1) > td > div");
					dl = directlist.text();
					dl = dl.replace(" ", "");
					estate.setDirection(dl);
					// �������ɿ���
					Elements parklist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContainer > div.InfoArea.InfoArea2.First > div > div.SaleDetail > div > table > tbody > tr:nth-child(2) > td > div");
					prl = parklist.text();
					estate.setParking(prl);
					// ����հ�����?
					Elements costlist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContainer > div.InfoArea.InfoArea2.First > div > div.SaleDetail > div > table > tbody > tr:nth-child(3) > td > div");
					cl = costlist.text();
					estate.setManage_cost(cl);
					// ���������Գ���
					Elements manlist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContainer > div.InfoArea.InfoArea2.First > div > div.SaleDetail > div > table > tbody > tr:nth-child(4) > td > div");
					mal = manlist.text();
					estate.setManage_included(mal);
					// ���Ƚü�------>������ ���� ����
					Elements seclist = doc2.select(
							"#SY > div > div.ListContainer > div.DetailContainer > div.InfoArea.InfoArea2.First > div > div.DivDetail > div > table > tbody > tr:nth-child(8) > td > div");
					sl = seclist.text();
					sl = sl.replace(" ", "");
					estate.setSecurity(sl);

					estateDao.insert(estate); // DB ����

				} catch (Exception e) {
					i++;
				}
			}
		}

	}

	//DB에서 부동산 매물 정보를 조회하는 메소드
	public List<Estate> getCurrent() {
		return estateDao.getEstate();
	}

	//부동산 매물 상세정보를 조회하는 메소드
	public List<Estate> getDetail(Estate estate) {
		return estateDao.getEstateDetail(estate);
	}
	
	//위도와 경도를 이용하여 해당하는 부동산매물을 찾는 메소드
	public Estate getEstateByLatLon(String latitude, String longitude) {
		List<Estate> estates = this.getCurrent();
		for(Estate estate : estates) {
			if(estate.getLatitude().equals(latitude) && estate.getLongitude().equals(longitude)) {
				return estate;
			}
		}
		return null;
	}
	
	//카카오 API를 이용하여 매물의 주소를 위도와 경도로 변환하는 메소드
	public String getKakaoApiFromAddress(String roadFullAddr) throws ParseException {
		String apiKey = "9297b7f2d4352d7538cfea5c8f4f0126";
		String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
		String jsonString = null;
		String jj = null;
		try {
			roadFullAddr = URLEncoder.encode(roadFullAddr, "UTF-8");

			String addr = apiUrl + "?query=" + roadFullAddr;

			URL url = new URL(addr);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);

			BufferedReader rd = null;
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuffer docJson = new StringBuffer();

			String line;

			while ((line = rd.readLine()) != null) {
				docJson.append(line);
			}

			jsonString = docJson.toString();

			JSONParser parser = new JSONParser();
			JSONObject jsonObject;
			JSONObject jsonObject2;
			JSONArray jsonArray;
			String x = "";
			String y = "";

			jsonObject = (JSONObject) parser.parse(jsonString);
			jsonArray = (JSONArray) jsonObject.get("documents");
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonObject2 = (JSONObject) jsonArray.get(i);
				if (null != jsonObject2.get("x")) {
					x = (String) jsonObject2.get("x").toString();
				}
				if (null != jsonObject2.get("y")) {
					y = (String) jsonObject2.get("y").toString();
				}

			}

			jj = x + "," + y;

			rd.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jj;
	}
	
	//사용자 화면안에 존재하는 매물 리스트를 반환하는 메소드
	public ArrayList<Estate> getAvailableEstates(double maxX, double maxY, double minX, double minY){
		List<Estate> estates = this.getCurrent();
		ArrayList<Estate> availableEstates = new ArrayList<Estate>();

		for (Estate estate : estates) {
			if (Double.parseDouble(estate.getLongitude()) < maxX && Double.parseDouble(estate.getLatitude()) < maxY
					&& Double.parseDouble(estate.getLongitude()) > minX
					&& Double.parseDouble(estate.getLatitude()) > minY) {
				availableEstates.add(estate);
			}
		}
		return availableEstates;
	}

}
