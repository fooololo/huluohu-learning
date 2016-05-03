package com.huluohu.learning.dp.test;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2015/12/23
 * Time           :   16:46
 * Description    :
 */
public class BabyStatus extends Status {
	private Long 		babyId;
	private String 		babyName;
	private Integer		babyGender;
	private String		birthday;

	public Long getBabyId() {
		return babyId;
	}

	public void setBabyId(Long babyId) {
		this.babyId = babyId;
	}

	public String getBabyName() {
		return babyName;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	public Integer getBabyGender() {
		return babyGender;
	}

	public void setBabyGender(Integer babyGender) {
		this.babyGender = babyGender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
