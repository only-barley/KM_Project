package com.company.lottomon.common;

public class Constant {
	public enum ServiceResult {
        SUCCESS, 
        FAIL,
        DUPLICATE,
        NOT_FOUND,
        LEAVE,
        INVALID_TOKEN,
        NOT_MATCHE,
        INVALID_PARAM,
        BAD_REQUEST,
        UNAUTHORIZED,
        MAMS_ERROR,
        ALREADY_DATA
    }

	public enum LoginResult {
		SUCCESS,
		NOT_FOUND,
		LEAVE,
		DORMANT,
		BENNED,
		NOT_MATCHE,
		LOGIN_ERROR
	}
	
	public enum boardCodeType {
		BULLETIN("01"),				// 자유게시판
		WINPRAYER("02"),			// 당첨기원
		DEBATEROOM("03"),  			// 토론방
		THEFIRSTSTORY("04"),		// 당첨자이야기
		NOTICE("11"),				// 공지사항
		MATTERSFORINQUIRY("12");	// 1:1문의하기
		boardCodeType(String type) {
			this.type = type;
		}
		private String type;
		public String getTypeValue() {
			return this.type;
		}
	}

	public static String boardCodeTypeName(String boardType) {
		switch (boardType){
			case "01": return "자유게시판";
			case "02": return "당첨기원게시판";
			case "03": return "토론방";
			case "04": return "1등당첨자이야기";
			case "11": return "공지사항";
			case "12": return "1:1문의하기";
			default: return "기타";
		}
	}

	public static String boardCodeTypeGroupName(String boardType) {
		switch (boardType){
			case "01":
			case "02":
			case "03":
			case "04":
				return "커뮤니티";
			case "11":
			case "12":
				return "고객센터";
			default: return "기타";
		}
	}

	public enum membershipCode{
		RECOMMEND("01", "추천"),		// 자유게시판
		FIXEDTERM_DISCOUNT("02", "기간제할인"),  		// 토론방
		EVENT_DISCOUNT("03", "이벤트 할인"),		//
		BONUS("04", "보너스 조합");
		membershipCode(String type, String title) {
			this.type = type;
			this.title = title;
		}
		private String type;
		private String title;
		public String getTypeValue() {
			return this.type;
		}
		public String getTitleValue() {
			return this.title;
		}
	}
}
