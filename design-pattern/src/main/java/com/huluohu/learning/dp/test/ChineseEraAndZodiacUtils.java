package com.huluohu.learning.dp.test;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/24
 * Time           :   10:43
 * Description    :
 */
public class ChineseEraAndZodiacUtils {
	//其实年份 甲子鼠年
	public static final int startYear = 1804;
	public static final  String[][] hsAndEb = { { "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸" },
			{ "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥" } };
	public static final String[] czs = { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪" };

	//计算给定年份与其实年份之间的差值
	public static int subtractYear(int year) {
		int jiaziYear = startYear;
		if (year < jiaziYear) {
			jiaziYear = jiaziYear - (60 + 60 * ((jiaziYear - year) / 60));//60年一个周期
		}
		return year - jiaziYear;
	}

	/**
	 * 获取该年的天干名称
	 **/
	public static String getTianGanName(int year) {
		String name = hsAndEb[0][subtractYear(year) % 10];
		return name;
	}

	/**
	 * 获取该年的地支名称
	 **/
	public static String getDiZhiName(int year) {
		String name = hsAndEb[1][subtractYear(year) % 12];
		return name;
	}

	/**
	 * 　获取该年的天干、地支名称
	 * 　@param year 年份
	 * 　@return
	 */
	public static String getTGDZName(int year) {
		String name = getTianGanName(year) + getDiZhiName(year);
		return name;
	}

	/**
	 * 获取该年的生肖名称
	 * @param year 年份
	 * @return
	 */
	public static String getShengXiaoName(int year) {
		String name = czs[subtractYear(year) % 12];
		return name;
	}

	/**
	 * 获取概念生肖的索引，从1开始，1-12
	 * @param year
	 * @return
	 */
	public  static int getShengXiaoIndex(int year){
		return subtractYear(year) % 12 + 1;
	}
}
