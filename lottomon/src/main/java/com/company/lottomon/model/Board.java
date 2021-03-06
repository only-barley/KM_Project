package com.company.lottomon.model;

import lombok.Data;

@Data
public class Board {
	//Get ResponseBody
	private int seq; //게시글 순번
	private String type; //게시글 종류
	private String title; //게시글 제목
	private String content; //게시글 내용
	private String name; //게시글 작성자
	private String show_yn; //게시글 표시 여부
	private String reg_dt; //게시글 등록일자
	private String update_dt; //게시글 수정일자
	private String priority; //게시글 우선순위

	private Integer comment; //댓글 수
	private String reg_dt_hms; //댓글 시간

	//Get RequestBody
	private Integer current_page; //현재 선택된 페이지
	private Integer post_num_base_cnt; //기본 게시글 페이징 수
	private Integer start_row_num; //페이징 시작 번호 수
	private String search_type; //검색 종류
	private String search_word; //검색어
	private String option; //게시글 옵션
	private String order_type; //정렬 종류

	//Set RequestBody
	private String user_id; //사용자 id
	private String role; //사용자 권한
	private String pv; //조회수 - default 값 : 0

	private String type_name; //게시글 카테고리명
}
