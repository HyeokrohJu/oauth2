/**
 * <pre>
 * 1. 프로젝트명 : restful
 * 2. 패키지명(또는 디렉토리 경로) : com.hrpj.core.utils
 * 3. 파일명 : Utils.java
 * 4. 작성일 : 2017. 6. 27. 오후 6:27:50
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.hrpj.core.utils;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.h2.value.CaseInsensitiveMap;

/**
 * <pre>
 * 1. 패키지명 : com.hrpj.core.utils
 * 2. 타입명 : Utils.java
 * 3. 작성일 : 2017. 6. 28. 오후 11:13:49
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   : Utils
 * </pre>
 */
public class Utils {
	private static final String MONEY_PATTERN = "#,##0"; // 금액 포맷.

	/**
	 * 생성자.
	 */
	private Utils() {

	}

	/**
	 * 패턴 형식으로 숫자를 포맷하여 문자열을 얻는다.<br>
	 * java.text.NumberFormat을 사용하고 있으니 보다 상세한 내용은 <a href=
	 * "http://java.sun.com/javase/6/docs/api/java/text/NumberFormat.html">java.text.NumberFormat.format(long)</a>을
	 * 참조하세요.
	 *
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static String formatNumber(long value, String pattern) {
		NumberFormat numberFormat = new DecimalFormat(pattern);
		return numberFormat.format(value);
	}

	/**
	 * 패턴 형식으로 숫자를 포맷하여 문자열을 얻는다.<br>
	 * java.text.NumberFormat을 사용하고 있으니 보다 상세한 내용은 <a href=
	 * "http://java.sun.com/javase/6/docs/api/java/text/NumberFormat.html">java.text.NumberFormat.format(double)</a>을
	 * 참조하세요.
	 *
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static String formatNumber(double value, String pattern) {
		NumberFormat numberFormat = new DecimalFormat(pattern);
		return numberFormat.format(value);
	}

	/**
	 * 패턴 형식으로 숫자를 포맷하여 문자열을 얻는다.<br>
	 * java.text.NumberFormat을 사용하고 있으니 보다 상세한 내용은 <a href=
	 * "http://java.sun.com/javase/6/docs/api/java/text/NumberFormat.html">java.text.NumberFormat.format(Object)</a>을
	 * 참조하세요.
	 *
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static String formatNumber(Number value, String pattern) {
		NumberFormat numberFormat = new DecimalFormat(pattern);
		return numberFormat.format(value);
	}

	/**
	 * 주어진 숫자를 금액 포맷하여 문자열을 얻는다.
	 *
	 * @param value
	 * @return
	 */
	public static String formatMoney(long value) {
		return formatNumber(value, MONEY_PATTERN);
	}

	/**
	 * 주어진 숫자를 금액 포맷하여 문자열을 얻는다.
	 *
	 * @param value
	 * @return
	 */
	public static String formatMoney(int value) {
		return formatNumber(value, MONEY_PATTERN);
	}

	/**
	 * 주어진 숫자를 금액 포맷하여 문자열을 얻는다.
	 *
	 * @param value
	 * @return
	 */
	public static String formatMoney(Number value) {
		return formatNumber(value, MONEY_PATTERN);
	}

	/**
	 * 패턴 형식의 문자열을 파싱하여 Number 객체를 얻는다.<br>
	 * java.text.NumberFormat을 사용하고 있으니 보다 상세한 내용은 <a href=
	 * "http://java.sun.com/javase/6/docs/api/java/text/NumberFormat.html">java.text.NumberFormat.parse(String)</a>을
	 * 참조하세요.
	 *
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static Number parseNumber(String value, String pattern) {
		try {
			NumberFormat numberFormat = new DecimalFormat(pattern);
			return numberFormat.parse(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 패턴 형식으로 일시를 포맷하여 문자열을 얻는다.<br>
	 * java.text.DateFormat을 사용하고 있으니 보다 상세한 내용은 <a href=
	 * "http://java.sun.com/javase/6/docs/api/java/text/DateFormat.html">java.text.DateFormat.format(java.util.Date)</a>을
	 * 참조하세요.
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 패턴 형식으로 일시를 포맷하여 문자열을 얻는다.<br>
	 * java.text.DateFormat을 사용하고 있으니 보다 상세한 내용은 <a href=
	 * "http://java.sun.com/javase/6/docs/api/java/text/DateFormat.html">java.text.DateFormat.format(java.util.Date)</a>을
	 * 참조하세요.
	 *
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static String formatDate(long time, String pattern) {
		return formatDate(new Date(time), pattern);
	}

	/**
	 * 문자열의 일시를 패턴 형식으로 파싱하여 java.util.Date 객체를 얻는다.<br>
	 * java.text.DateFormat을 사용하고 있으니 보다 상세한 내용은 <a href=
	 * "http://java.sun.com/javase/6/docs/api/java/text/DateFormat.html">java.text.DateFormat.parse(java.lang.String)</a>을
	 * 참조하세요.
	 *
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String value, String pattern) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.parse(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 문자열의 일시를 패턴 형식으로 파싱하여 java.sql.Timestamp 객체를 얻는다.<br>
	 *
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static Timestamp parseTimestamp(String value, String pattern) {
		Date date = parseDate(value, pattern);
		return new Timestamp(date.getTime());
	}

	/**
	 * 현재 시간의 java.sql.Timestamp를 얻는다.
	 *
	 * @return
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 현재 시간의 java.util.Date 를 얻는다.
	 *
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 계산할 일자값으로 date를 얻는다. 일자값이 음수이면 과거 date를 얻고, 일자값이 양수이면 미래값을 얻는다.
	 *
	 * @param value
	 *            계산할 일자값.
	 * @return
	 */
	public static Date getDate(long value) {
		long dates = value * 24L * 60L * 60L * 1000L;
		return new Date(System.currentTimeMillis() + dates);
	}

	/**
	 * 호스트 명을 얻는다.
	 * 
	 * @return
	 */
	public static String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * Null 체크
	 * 
	 * @return
	 */
	public static boolean isNull(String obj) {
		if (obj == null || obj.equals("") || obj.equals("null") || obj.equals("undefined")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Null 체크
	 * 
	 * @return
	 */
	public static boolean isNull(Object obj) {
		if (obj == null || obj.equals("") || obj.equals("null") || obj.equals("undefined")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Map에 대한 초기값 설정
	 * 
	 * @return
	 */
	public static String getDefaultString(String obj, String defaultValue) {
		String resultValue = obj;
		if (isNull(obj)) {
			resultValue = defaultValue;
		}
		return resultValue;
	}

	/**
	 * 목록에 대한 건수 가져오기
	 * 
	 * @return
	 */
	public static int getTotalCntForList(List<CaseInsensitiveMap<?>> list) {
		int count = 0;
		if (list != null && list.size() > 0) {
			CaseInsensitiveMap<?> item = (CaseInsensitiveMap<?>) list.get(0);
			BigDecimal bd = (BigDecimal) item.get("totalcnt");
			count = bd.intValue();
		}
		return count;
	}

	/**
	 * Map에 대한 초기값 설정
	 * 
	 * @return
	 */
	public static String getDefaultSetValueFromMap(Map<String, Object> obj, String key, String defaultValue) {
		String resultValue = "";
		if (obj != null) {
			resultValue = (String) obj.get(key);
		}
		if (resultValue == null || resultValue.length() == 0) {
			resultValue = defaultValue;
		}
		return resultValue;
	}

	/**
	 * Object에 대한 초기값 설정
	 * 
	 * @return
	 */
	public static String getDefaultSetValueFromObject(Object obj, String defaultValue) {
		String resultValue = "";
		if (obj != null) {
			if (obj instanceof Long) {
				resultValue = ((Long) obj).toString();
			} else if (obj instanceof Integer) {
				resultValue = ((Integer) obj).toString();
			} else if (obj instanceof String) {
				resultValue = (String) obj;
			}
		}
		if (resultValue == null || resultValue.length() == 0) {
			resultValue = defaultValue;
		}
		return resultValue;
	}

	/**
	 * Map에 대한 초기값 설정
	 * 
	 * @return
	 */
	public static int getDefaultSetValueFromMap(Map<String, Object> obj, String key, int defaultValue) {
		Integer resultValue = 0;
		if (obj != null) {
			resultValue = (Integer) obj.get(key);
		}
		if (resultValue == null) {
			resultValue = defaultValue;
		}
		return resultValue.intValue();
	}

	/**
	 * Map에 대한 초기값 설정
	 * 
	 * @return
	 */
	public static long getDefaultSetValueFromMap(Map<String, Object> obj, String key, long defaultValue) {
		Long resultValue = new Long(0);
		if (obj != null) {
			resultValue = (Long) obj.get(key);
		}
		if (resultValue == null) {
			resultValue = defaultValue;
		}
		return resultValue.longValue();
	}

	/**
	 * 날짜 형식 변경
	 * 
	 * @param dt
	 * @param defPattern
	 * @param nwPattern
	 * @return
	 */
	public static String dateStyle(String dt, String defPattern, String nwPattern) {
		String retVal = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(defPattern);
			SimpleDateFormat refSdf = new SimpleDateFormat(nwPattern);
			Date d = sdf.parse(dt);
			Calendar ca = Calendar.getInstance();
			ca.setTime(d);

			retVal = refSdf.format(ca.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

	/**
	 * Date -> Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getDateToTimestamp(Date dt) {
		Timestamp tTime = new Timestamp(dt.getTime());

		return tTime;
	}

	/**
	 * String -> Timestamp 2009-03-20 10:20:30.0; // 형식을 지켜야 함
	 * 
	 * @return
	 */
	public static Timestamp getStringToTimestamp(String dtStr) {
		Timestamp tTime = Timestamp.valueOf(dtStr + ".0");

		return tTime;
	}

	/**
	 * <pre>
	 * 1. 함수명 : toUTF8
	 * 2. 작성일 : 2016. 11. 9. 오전 11:08:25
	 * 3. 작성자 : Goodcen R&D
	 * 4. 설명   : String UTF-8 변환
	 * </pre>
	 * 
	 * @param s
	 * @return
	 */
	public static String toUTF8(String s) {
		String result = "";
		try {
			result = new String(s.getBytes("8859_1"), "UTF-8"); // UTF8로 변환
		} catch (Exception e) {
			result = "";
		}
		return result;
	}

	/**
	 * 
	 * <pre>
	 * 1. 함수명 : toUTF8
	 * 2. 작성일 : 2017. 1. 18. 오후 7:05:12
	 * 3. 작성자 : Goodcen R&D
	 * 4. 설명   : userAgent 체크
	 * </pre>
	 * 
	 * @param s
	 * @return Y : 모바일, N : 웹
	 */
	public static String mobileCheck(String userAgent) {
		String result = "";

		String[] mobileos = { "Mobile", "iPhone", "iPod", "Android", "BlackBerry", "Windows CE", "Nokia", "Webos", "Opera Mini", "SonyEricsson",
				"Opera Mobi", "IEMobile" };

		int j = -1;
		int check = 0;
		if (userAgent != null && !userAgent.equals("")) {
			for (int i = 0; i < mobileos.length; i++) {
				j = userAgent.indexOf(mobileos[i]);
				if (j > -1) {
					check++;
				}
			}
		}

		if (check > 0) {
			result = "Y";
		} else {
			result = "N";
		}
		return result;
	}
}
